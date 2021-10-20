package meli.shows.entities.assembler;

import meli.shows.controllers.request.ReservaRequest;
import meli.shows.entities.Reserva;
import meli.shows.entities.dto.ReservaDTO;
import org.modelmapper.ModelMapper;

public class ReservaAssembler {

    public static ReservaDTO assemble(Reserva reserva) {

        ModelMapper modelMapper = new ModelMapper();
        ReservaDTO reservaDTO = modelMapper.map(reserva, ReservaDTO.class);

        return reservaDTO;

    }

    public static Reserva assemble(ReservaDTO reservadTO) {

        ModelMapper modelMapper = new ModelMapper();
        Reserva reserva = modelMapper.map(reservadTO, Reserva.class);

        return reserva;

    }

    public static ReservaDTO assemble(ReservaRequest reserva) {

        ModelMapper modelMapper = new ModelMapper();
        ReservaDTO reservaDTO = modelMapper.map(reserva, ReservaDTO.class);

        return reservaDTO;

    }

}
