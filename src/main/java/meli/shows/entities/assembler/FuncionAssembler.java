package meli.shows.entities.assembler;

import meli.shows.entities.Funcion;
import meli.shows.entities.dto.FuncionDTO;
import org.modelmapper.ModelMapper;

public class FuncionAssembler {

    public static FuncionDTO assemble(Funcion funcion) {

        if (funcion != null) {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(funcion, FuncionDTO.class);
        }
        return null;
    }

    public static Funcion assemble(FuncionDTO funcionDto) {

        if (funcionDto != null) {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(funcionDto, Funcion.class);
        }
        return null;
    }

}
