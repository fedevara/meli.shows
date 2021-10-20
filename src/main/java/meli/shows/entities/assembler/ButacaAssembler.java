package meli.shows.entities.assembler;

import meli.shows.entities.Butaca;
import meli.shows.entities.dto.ButacaDTO;
import org.modelmapper.ModelMapper;

public class ButacaAssembler {

    public static ButacaDTO assemble(Butaca butaca) {

        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(butaca, ButacaDTO.class);

    }

    public static Butaca assemble(ButacaDTO butacaDto) {

        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(butacaDto, Butaca.class);

    }


}
