package meli.shows.entities.assembler;

import meli.shows.entities.Butaca;
import meli.shows.entities.dto.ButacaDTO;

public class ButacaAssembler {

    public static ButacaDTO assemble(Butaca butaca) {

        ButacaDTO butacaDTO = new ButacaDTO();
        butacaDTO.setId(butaca.getId());
        butacaDTO.setFila(butaca.getFila());
        butacaDTO.setPosicion(butaca.getPosicion());

        return butacaDTO;

    }
}
