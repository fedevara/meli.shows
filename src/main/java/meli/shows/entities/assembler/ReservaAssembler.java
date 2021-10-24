package meli.shows.entities.assembler;

import meli.shows.controllers.request.ReservaRequest;
import meli.shows.entities.Reserva;
import meli.shows.entities.dto.ReservaDTO;
import org.modelmapper.ModelMapper;

public class ReservaAssembler {

    public static ReservaDTO assemble(Reserva reserva) {

        if (reserva != null) {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(reserva, ReservaDTO.class);
        }
        return null;
    }

    public static Reserva assemble(ReservaDTO reservadTO) {

        if (reservadTO != null) {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(reservadTO, Reserva.class);
        }
        return null;
    }

    public static ReservaDTO assemble(ReservaRequest reserva) {

        if (reserva != null) {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(reserva, ReservaDTO.class);
        }
        return null;
    }

}
