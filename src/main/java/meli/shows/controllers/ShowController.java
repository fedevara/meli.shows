package meli.shows.controllers;

import meli.shows.controllers.request.ReservaRequest;
import meli.shows.controllers.response.FuncionButacasResponse;
import meli.shows.entities.assembler.ButacaAssembler;
import meli.shows.entities.assembler.FuncionAssembler;
import meli.shows.entities.assembler.ReservaAssembler;
import meli.shows.entities.dto.ButacaDTO;
import meli.shows.entities.dto.FuncionDTO;
import meli.shows.entities.dto.ReservaDTO;
import meli.shows.entities.dto.ShowDTO;
import meli.shows.services.ButacaService;
import meli.shows.services.FuncionService;
import meli.shows.services.ReservaService;
import meli.shows.services.ShowService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shows")
@CrossOrigin("*")
public class ShowController {

    private final static Logger logger = Logger.getLogger("Show Controller");

    @Autowired
    ShowService showService;
    @Autowired
    ReservaService reservaService;
    @Autowired
    ButacaService butacaService;
    @Autowired
    FuncionService funcionService;

    @GetMapping("/buscar-shows")
    public ResponseEntity<List<ShowDTO>> getAll() {
        logger.debug("Búsqueda de todos los Shows");
        return ResponseEntity.ok(showService.getAll());
    }

    @GetMapping("/listar-butacas-disponibles")
    public ResponseEntity<FuncionButacasResponse> getAll(@RequestParam(value="funcion_id") Long idFuncion, @RequestParam(value="show_id") Long idShow) {
        logger.debug("Búsqueda del show: " + idFuncion + ", funcion: " + idFuncion);
        FuncionButacasResponse funcionButacasResponse = showService.getShowInfo(idFuncion, idShow);
        funcionButacasResponse.setButacas(butacaService.getButacasLibresFuncion(idFuncion));
        return ResponseEntity.ok(funcionButacasResponse);
    }

    @PostMapping("/reservar-butaca")
    public ResponseEntity<ReservaDTO> registrar(@RequestBody ReservaRequest reservaReq) {
        logger.debug("Registrando nueva reserva");

        ButacaDTO butacaDto = ButacaAssembler.assemble(butacaService.getById(reservaReq.getButaca()).get());
        FuncionDTO funcionDto = FuncionAssembler.assemble(funcionService.getById(reservaReq.getFuncion()).get());
        ReservaDTO reservaDto = ReservaAssembler.assemble(reservaReq);

        reservaDto.setButaca(butacaDto);
        reservaDto.setFuncion(funcionDto);

        reservaDto = reservaService.registrar(reservaDto);

        return new ResponseEntity<>(reservaDto, HttpStatus.CREATED);

    }

}
