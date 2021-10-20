package meli.shows.entities.assembler;

import meli.shows.entities.Funcion;
import meli.shows.entities.Seccion;
import meli.shows.entities.Show;
import meli.shows.entities.dto.FuncionDTO;
import meli.shows.entities.dto.SeccionDTO;
import meli.shows.entities.dto.ShowDTO;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShowAssembler {

    public static ShowDTO assemble(Show show) {

        ModelMapper modelMapper = new ModelMapper();
        ShowDTO showDto = modelMapper.map(show, ShowDTO.class);

        showDto.setFunciones(convertirFuncionesSetToList(show.getFunciones()));
        showDto.setSecciones(convertirSeccionesSetToList(show.getSecciones()));

        return showDto;

    }

    public static Show assemble(ShowDTO showDto) {

        ModelMapper modelMapper = new ModelMapper();
        Show show = modelMapper.map(showDto, Show.class);

        show.setFunciones(convertirFuncionesListToSet(showDto.getFunciones()));
        show.setSecciones(convertirSeccionesListToSet(showDto.getSecciones()));

        return show;

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

    private static List<SeccionDTO> convertirSeccionesSetToList(Set<Seccion> secciones) {

        List<SeccionDTO> seccionlist = new ArrayList<>();

        if(secciones!=null) {
            for (Seccion seccion : secciones) {
                seccionlist.add(SeccionAssembler.assemble(seccion));
            }
        }

        return seccionlist;

    }

    private static Set<Seccion> convertirSeccionesListToSet(List<SeccionDTO> secciones) {

        Set<Seccion> seccionlist = new HashSet<>();

        if(secciones!=null) {
            for (SeccionDTO seccion : secciones) {
                seccionlist.add(SeccionAssembler.assemble(seccion));
            }
        }

        return seccionlist;

    }

}
