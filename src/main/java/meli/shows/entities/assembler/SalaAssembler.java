package meli.shows.entities.assembler;

import meli.shows.entities.Butaca;
import meli.shows.entities.Funcion;
import meli.shows.entities.Sala;
import meli.shows.entities.dto.ButacaDTO;
import meli.shows.entities.dto.FuncionDTO;
import meli.shows.entities.dto.SalaDTO;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SalaAssembler {

    public static SalaDTO assemble(Sala sala) {

        ModelMapper modelMapper = new ModelMapper();
        SalaDTO salaDTO = modelMapper.map(sala, SalaDTO.class);

        salaDTO.setFunciones(convertirFuncionesSetToList(sala.getFunciones()));
        salaDTO.setButacas(convertirButacasSetToList(sala.getButacas()));

        return salaDTO;

    }

    public static Sala assemble(SalaDTO salaDto) {

        ModelMapper modelMapper = new ModelMapper();
        Sala sala = modelMapper.map(salaDto, Sala.class);

        sala.setFunciones(convertirFuncionesListToSet(salaDto.getFunciones()));
        sala.setButacas(convertirButacasListToSet(salaDto.getButacas()));

        return sala;

    }

    private static List<FuncionDTO> convertirFuncionesSetToList(Set<Funcion> funciones) {

        List<FuncionDTO> funcionlist = new ArrayList<>();

        if(funciones!=null) {
            for (Funcion funcion : funciones) {
                funcionlist.add(FuncionAssembler.assemble(funcion));
            }
        }

        return funcionlist;

    }

    private static Set<Funcion> convertirFuncionesListToSet(List<FuncionDTO> funciones) {

        Set<Funcion> funcionlist = new HashSet<>();

        if(funciones!=null) {
            for (FuncionDTO funcionDto : funciones) {
                funcionlist.add(FuncionAssembler.assemble(funcionDto));
            }
        }

        return funcionlist;

    }

    private static List<ButacaDTO> convertirButacasSetToList(Set<Butaca> butacas) {

        List<ButacaDTO> butacalist = new ArrayList<>();

        if(butacas!=null) {
            for (Butaca butaca : butacas) {
                butacalist.add(ButacaAssembler.assemble(butaca));
            }
        }

        return butacalist;

    }

    private static Set<Butaca> convertirButacasListToSet(List<ButacaDTO> butacas) {

        Set<Butaca> butacaSet = new HashSet<>();

        if(butacas!=null) {
            for (ButacaDTO butacaDto : butacas) {
                butacaSet.add(ButacaAssembler.assemble(butacaDto));
            }
        }

        return butacaSet;

    }

}
