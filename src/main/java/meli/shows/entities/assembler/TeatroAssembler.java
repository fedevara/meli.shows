package meli.shows.entities.assembler;

import lombok.experimental.Accessors;
import meli.shows.entities.Sala;
import meli.shows.entities.Show;
import meli.shows.entities.Teatro;
import meli.shows.entities.dto.SalaDTO;
import meli.shows.entities.dto.ShowDTO;
import meli.shows.entities.dto.TeatroDTO;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Accessors(chain = true)
public class TeatroAssembler {

    public static TeatroDTO assemble(Teatro teatro) {

        ModelMapper modelMapper = new ModelMapper();
        TeatroDTO teatroDto = modelMapper.map(teatro, TeatroDTO.class);

        teatroDto.setSalas(convertirSalaSetToList(teatro.getSalas()));
        teatroDto.setShows(convertirShowSetToList(teatro.getShows()));

        return teatroDto;

    }

    public static Teatro assemble(TeatroDTO teatroDto) {

        ModelMapper modelMapper = new ModelMapper();
        Teatro teatro = modelMapper.map(teatroDto, Teatro.class);

        teatro.setSalas(convertirSalaListToSet(teatroDto.getSalas()));
        teatro.setShows(convertirShowListToSet(teatroDto.getShows()));

        return teatro;

    }

    private static List<ShowDTO> convertirShowSetToList(Set<Show> shows) {

        List<ShowDTO> showlist = new ArrayList<>();

        if (shows != null) {
            for (Show show : shows) {
                showlist.add(ShowAssembler.assemble(show));
            }
        }

        return showlist;

    }

    private static Set<Show> convertirShowListToSet(List<ShowDTO> shows) {

        Set<Show> showSet = new HashSet<>();

        if (shows != null) {
            for (ShowDTO showDto : shows) {
                showSet.add(ShowAssembler.assemble(showDto));
            }
        }

        return showSet;

    }

    private static List<SalaDTO> convertirSalaSetToList(Set<Sala> salas) {

        List<SalaDTO> salalist = new ArrayList<>();

        if (salas != null) {
            for (Sala sala : salas) {
                salalist.add(SalaAssembler.assemble(sala));
            }
        }

        return salalist;

    }

    private static Set<Sala> convertirSalaListToSet(List<SalaDTO> salas) {

        Set<Sala> salaSet = new HashSet<>();

        if (salas != null) {
            for (SalaDTO salaDto : salas) {
                salaSet.add(SalaAssembler.assemble(salaDto));
            }
        }

        return salaSet;

    }

}
