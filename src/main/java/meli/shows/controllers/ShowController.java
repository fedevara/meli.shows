package meli.shows.controllers;

import meli.shows.controllers.request.AdvanceSearchRequest;
import meli.shows.controllers.request.ReservaRequest;
import meli.shows.controllers.response.FuncionButacasResponse;
import meli.shows.entities.assembler.ButacaAssembler;
import meli.shows.entities.assembler.FuncionAssembler;
import meli.shows.entities.assembler.ReservaAssembler;
import meli.shows.entities.dto.ButacaDTO;
import meli.shows.entities.dto.FuncionDTO;
import meli.shows.entities.dto.ReservaDTO;
import meli.shows.entities.dto.ShowDTO;
import meli.shows.entities.exception.RangoFechaException;
import meli.shows.entities.exception.RangoPrecioException;
import meli.shows.entities.exception.ReservaAlreadyExistException;
import meli.shows.services.ButacaService;
import meli.shows.services.FuncionService;
import meli.shows.services.ReservaService;
import meli.shows.services.ShowService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.PositiveOrZero;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/shows")
@CrossOrigin("*")
public class ShowController {

    private final static Logger logger = Logger.getLogger("Show Controller");
    private static final String FORMAT_DATE = "YYYY-MM-DD";

    @Autowired
    ShowService showService;
    @Autowired
    ReservaService reservaService;
    @Autowired
    ButacaService butacaService;
    @Autowired
    FuncionService funcionService;

    @GetMapping("/listar-shows")
    public ResponseEntity<List<ShowDTO>> getAll() {
        logger.debug("Búsqueda de todos los Shows");
        return ResponseEntity.ok(showService.getAll());
    }

    @GetMapping("/busqueda-avanzada-shows")
    public ResponseEntity<Object> getAdvancedAll(@RequestParam(required = false, value = "nombre") String nombre,
                                                 @RequestParam(required = false, value = "categoria") String categoria,
                                                 @RequestParam(required = false, value = "fechaInicio") @DateTimeFormat(pattern = FORMAT_DATE) String fechaInicio,
                                                 @RequestParam(required = false, value = "fechaFin") @DateTimeFormat(pattern = FORMAT_DATE) String fechaFin,
                                                 @RequestParam(required = false, value = "precioMinimo") @PositiveOrZero Double precioMinimo,
                                                 @RequestParam(required = false, value = "precioMaximo") @PositiveOrZero Double precioMaximo,
                                                 @RequestParam(required = false, value = "orden") String orden,
                                                 @RequestParam(required = false, value = "direccion") String direccion) {
        logger.debug("Búsqueda de todos los Shows");
        try {
            //TODO este manejo de errores deberia estar en una clase Handler
            if (fechaFin != null && fechaInicio != null && !fechaFin.isEmpty() && !fechaInicio.isEmpty()) {
                if (Date.valueOf(fechaFin).compareTo(Date.valueOf(fechaInicio)) < 0) {
                    throw new RangoFechaException();
                }
            }
            if (precioMaximo != null && precioMinimo != null) {
                if (Double.valueOf(precioMaximo).compareTo(Double.valueOf(precioMinimo)) < 0) {
                    throw new RangoPrecioException();
                }
            }
        } catch (RangoFechaException e) {
            return new ResponseEntity<>(e.getCustomMessage(), HttpStatus.BAD_REQUEST);
        } catch (RangoPrecioException e) {
            return new ResponseEntity<>(e.getCustomMessage(), HttpStatus.BAD_REQUEST);
        }

        AdvanceSearchRequest request = new AdvanceSearchRequest(nombre, categoria, fechaInicio, fechaFin, orden, direccion, precioMinimo, precioMaximo);
        return ResponseEntity.ok(showService.getAdvancedAll(request));
    }

    @GetMapping("/listar-butacas-disponibles")
    public ResponseEntity<FuncionButacasResponse> getAll(@RequestParam(value = "funcion_id") Long idFuncion,
                                                         @RequestParam(value = "show_id") Long idShow) {
        logger.debug("Búsqueda del show: " + idFuncion + ", funcion: " + idFuncion);
        FuncionButacasResponse funcionButacasResponse = showService.getShowInfo(idFuncion, idShow);
        funcionButacasResponse.setButacas(butacaService.getButacasLibresFuncion(idFuncion));
        return ResponseEntity.ok(funcionButacasResponse);
    }

    @PostMapping("/reservar-butaca")
    public ResponseEntity<Object> registrar(@RequestBody ReservaRequest reservaReq) {
        try {
            logger.debug("Registrando nueva reserva");

            ButacaDTO butacaDto = ButacaAssembler.assemble(butacaService.getById(reservaReq.getButaca()).get());
            FuncionDTO funcionDto = FuncionAssembler.assemble(funcionService.getById(reservaReq.getFuncion()).get());
            ReservaDTO reservaDto = ReservaAssembler.assemble(reservaReq);

            reservaDto.setButaca(butacaDto);
            reservaDto.setFuncion(funcionDto);

            reservaDto = reservaService.registrar(reservaDto);
            return new ResponseEntity<>(reservaDto, HttpStatus.CREATED);
        } catch (ReservaAlreadyExistException e) {
            return new ResponseEntity<>(e.getCustomMessage(), HttpStatus.CONFLICT);
        }
    }

}
