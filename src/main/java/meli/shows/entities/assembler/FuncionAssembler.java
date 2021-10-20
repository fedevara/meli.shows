package meli.shows.entities.assembler;

import meli.shows.entities.Funcion;
import meli.shows.entities.dto.FuncionDTO;
import org.modelmapper.ModelMapper;

public class FuncionAssembler {

    public static FuncionDTO assemble(Funcion funcion) {

        ModelMapper modelMapper = new ModelMapper();
        FuncionDTO funcionDTO = modelMapper.map(funcion, FuncionDTO.class);

        return funcionDTO;

    }

    public static Funcion assemble(FuncionDTO funcionDto) {

        if (funcionDto != null) {
            ModelMapper modelMapper = new ModelMapper();
            Funcion funcion = modelMapper.map(funcionDto, Funcion.class);

            return funcion;
        }
        return null;
    }

}
