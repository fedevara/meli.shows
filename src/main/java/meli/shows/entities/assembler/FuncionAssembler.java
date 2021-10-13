package meli.shows.entities.assembler;

import meli.shows.entities.Funcion;
import meli.shows.entities.dto.FuncionDTO;

public class FuncionAssembler {

    public static FuncionDTO assemble(Funcion funcion) {

        FuncionDTO funcionDTO = new FuncionDTO();
        funcionDTO.setId(funcion.getId());
        funcionDTO.setDiaHorario(funcion.getDiaHorario());

        return funcionDTO;

    }

}
