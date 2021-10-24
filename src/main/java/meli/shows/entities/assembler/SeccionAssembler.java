package meli.shows.entities.assembler;

import meli.shows.entities.Butaca;
import meli.shows.entities.Seccion;
import meli.shows.entities.dto.ButacaDTO;
import meli.shows.entities.dto.SeccionDTO;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SeccionAssembler {

    public static SeccionDTO assemble(Seccion seccion) {

        if (seccion != null) {
            ModelMapper modelMapper = new ModelMapper();
            SeccionDTO seccionDTO = modelMapper.map(seccion, SeccionDTO.class);

            seccionDTO.setButacas(convertirButacasSetToList(seccion.getButacas()));

            return seccionDTO;
        }
        return null;
    }

    public static Seccion assemble(SeccionDTO seccionDto) {

        if (seccionDto != null) {
            ModelMapper modelMapper = new ModelMapper();
            Seccion seccion = modelMapper.map(seccionDto, Seccion.class);

            seccion.setButacas(convertirButacasListToSet(seccionDto.getButacas()));

            return seccion;
        }
        return null;
    }

    private static List<ButacaDTO> convertirButacasSetToList(Set<Butaca> butacas) {

        List<ButacaDTO> butacaList = new ArrayList<>();

        if (butacas != null && !butacas.isEmpty()) {
            for (Butaca butaca : butacas) {
                butacaList.add(ButacaAssembler.assemble(butaca));
            }
        }
        return butacaList;
    }

    private static Set<Butaca> convertirButacasListToSet(List<ButacaDTO> butacas) {

        Set<Butaca> butacaSet = new HashSet<>();

        if (butacas != null && !butacas.isEmpty()) {
            for (ButacaDTO butacaDto : butacas) {
                butacaSet.add(ButacaAssembler.assemble(butacaDto));
            }
        }
        return butacaSet;
    }

}
