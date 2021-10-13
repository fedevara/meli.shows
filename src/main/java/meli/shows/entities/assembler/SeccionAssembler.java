package meli.shows.entities.assembler;

import meli.shows.entities.Butaca;
import meli.shows.entities.Seccion;
import meli.shows.entities.dto.ButacaDTO;
import meli.shows.entities.dto.SeccionDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SeccionAssembler {

    public static SeccionDTO assemble(Seccion seccion) {

        SeccionDTO seccionDTO = new SeccionDTO();
        seccionDTO.setId(seccion.getId());
        seccionDTO.setPrecio(seccion.getPrecio());
        seccionDTO.setButacas(convertirButacas(seccion.getButacas()));

        return seccionDTO;

    }

    private static List<ButacaDTO> convertirButacas(Set<Butaca> butacas) {

        List<ButacaDTO> butacalist = new ArrayList<>();

        for (Butaca butaca : butacas) {
            butacalist.add(ButacaAssembler.assemble(butaca));
        }

        return butacalist;

    }

}
