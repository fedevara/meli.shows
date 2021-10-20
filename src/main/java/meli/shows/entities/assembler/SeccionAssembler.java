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

        ModelMapper modelMapper = new ModelMapper();
        SeccionDTO seccionDTO = modelMapper.map(seccion, SeccionDTO.class);

        seccionDTO.setButacas(convertirButacasSetToList(seccion.getButacas()));

        return seccionDTO;

    }

    public static Seccion assemble(SeccionDTO seccionDto) {

        ModelMapper modelMapper = new ModelMapper();
        Seccion seccion = modelMapper.map(seccionDto, Seccion.class);

        seccion.setButacas(convertirButacasListToSet(seccionDto.getButacas()));

        return seccion;

    }

    private static List<ButacaDTO> convertirButacasSetToList(Set<Butaca> butacas) {

        List<ButacaDTO> butacaList = new ArrayList<>();

        if(butacas!=null) {
            for (Butaca butaca : butacas) {
                butacaList.add(ButacaAssembler.assemble(butaca));
            }
        }

        return butacaList;

    }

    private static Set<Butaca> convertirButacasListToSet(List<ButacaDTO> butacas) {

        Set<Butaca> butacaSet = new HashSet<>();

        for (ButacaDTO butacaDto : butacas) {
            butacaSet.add(ButacaAssembler.assemble(butacaDto));
        }

        return butacaSet;

    }

}
