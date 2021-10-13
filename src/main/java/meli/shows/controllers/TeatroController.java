package meli.shows.controllers;

import meli.shows.entities.Teatro;
import meli.shows.entities.dto.TeatroDTO;
import meli.shows.services.TeatroService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teatros")
@CrossOrigin("*")
public class TeatroController {

    private final static Logger logger = Logger.getLogger("Teatro Controller");
    @Autowired
    TeatroService teatroService;

    @GetMapping("/buscarTodos")
    public ResponseEntity<List<TeatroDTO>> getAll() {
        logger.debug("Búsqueda de todos los teatros");
        return ResponseEntity.ok(teatroService.getAll());
    }

    @PostMapping("/registrar")
    public ResponseEntity<Object> registrar(@RequestBody TeatroDTO teatro) {
        logger.debug("Registrando nuevo teatro");
        teatroService.registrar(teatro);
        return ResponseEntity.ok().build();
    }

}
