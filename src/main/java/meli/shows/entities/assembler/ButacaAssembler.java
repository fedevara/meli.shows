package meli.shows.entities.assembler;

import meli.shows.entities.Butaca;
import meli.shows.entities.dto.ButacaDTO;
import org.modelmapper.ModelMapper;

public class ButacaAssembler {

    public static ButacaDTO assemble(Butaca butaca) {

        if (butaca != null) {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(butaca, ButacaDTO.class);
        }
        return null;
    }

    public static Butaca assemble(ButacaDTO butacaDto) {

        if (butacaDto != null) {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(butacaDto, Butaca.class);
        }
        return null;
    }

}
