package meli.shows.entities.assembler;

import lombok.experimental.Accessors;
import meli.shows.entities.Sala;
import meli.shows.entities.Show;
import meli.shows.entities.Teatro;
import meli.shows.entities.dto.SalaDTO;
import meli.shows.entities.dto.ShowDTO;
import meli.shows.entities.dto.TeatroDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Accessors(chain = true)
public class TeatroAssembler {

    public static TeatroDTO assemble(Teatro teatro) {

        TeatroDTO teatroDTO = new TeatroDTO();
        teatroDTO.setId(teatro.getId());
        teatroDTO.setNombre(teatro.getNombre());
        teatroDTO.setSalas(convertirSala(teatro.getSalas()));
        teatroDTO.setShows(convertirShow(teatro.getShows()));

        return teatroDTO;

    }

    private static List<ShowDTO> convertirShow(Set<Show> shows) {

        List<ShowDTO> showlist = new ArrayList<>();

        for (Show show : shows) {
            showlist.add(ShowAssembler.assemble(show));
        }

        return showlist;

    }

    private static List<SalaDTO> convertirSala(Set<Sala> salas) {

        List<SalaDTO> salalist = new ArrayList<>();

        for (Sala sala : salas) {
            salalist.add(SalaAssembler.assemble(sala));
        }

        return salalist;

    }

}
