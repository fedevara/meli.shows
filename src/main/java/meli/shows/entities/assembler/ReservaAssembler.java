package meli.shows.entities.assembler;

import meli.shows.entities.Reserva;
import meli.shows.entities.dto.ButacaDTO;
import meli.shows.entities.dto.ReservaDTO;

public class ReservaAssembler {

    public static ReservaDTO assemble(Reserva reserva) {

        ReservaDTO reservaDTO = new ReservaDTO();
        reservaDTO.setId(reserva.getId());
        reservaDTO.setNombre(reserva.getNombre());
        reservaDTO.setDocumento(reserva.getDocumento());
        reservaDTO.setButaca(ButacaAssembler.assemble(reserva.getButaca()));
        reservaDTO.setPrecio(reserva.getPrecio());

        return reservaDTO;

    }

}
