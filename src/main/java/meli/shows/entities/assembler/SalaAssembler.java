package meli.shows.entities.assembler;

import meli.shows.entities.Butaca;
import meli.shows.entities.Funcion;
import meli.shows.entities.Sala;
import meli.shows.entities.dto.ButacaDTO;
import meli.shows.entities.dto.FuncionDTO;
import meli.shows.entities.dto.SalaDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SalaAssembler {

    public static SalaDTO assemble(Sala sala) {

        SalaDTO salaDTO = new SalaDTO();
        salaDTO.setId(sala.getId());
        salaDTO.setFunciones(convertirFunciones(sala.getFunciones()));
        salaDTO.setButacas(convertirButacas(sala.getButacas()));

        return salaDTO;

    }

    private static List<FuncionDTO> convertirFunciones(Set<Funcion> funciones) {

        List<FuncionDTO> funcionlist = new ArrayList<>();

        for (Funcion funcion : funciones) {
            funcionlist.add(FuncionAssembler.assemble(funcion));
        }

        return funcionlist;

    }

    private static List<ButacaDTO> convertirButacas(Set<Butaca> butacas) {

        List<ButacaDTO> butacalist = new ArrayList<>();

        for (Butaca butaca : butacas) {
            butacalist.add(ButacaAssembler.assemble(butaca));
        }

        return butacalist;

    }

}
