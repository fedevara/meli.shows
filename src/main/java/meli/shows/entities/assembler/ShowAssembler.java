package meli.shows.entities.assembler;

import meli.shows.entities.Funcion;
import meli.shows.entities.Seccion;
import meli.shows.entities.Show;
import meli.shows.entities.dto.FuncionDTO;
import meli.shows.entities.dto.SeccionDTO;
import meli.shows.entities.dto.ShowDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ShowAssembler {

    public static ShowDTO assemble(Show show) {

        ShowDTO ShowDTO = new ShowDTO();
        ShowDTO.setId(show.getId());
        ShowDTO.setNombre(show.getNombre());
        ShowDTO.setCategoria(show.getCategoria());
        ShowDTO.setDuracion(show.getDuracion());
        ShowDTO.setFunciones(convertirFunciones(show.getFunciones()));
        ShowDTO.setSecciones(convertirSecciones(show.getSecciones()));

        return ShowDTO;

    }

    private static List<FuncionDTO> convertirFunciones(Set<Funcion> funciones) {

        List<FuncionDTO> funcionlist = new ArrayList<>();

        for (Funcion funcion : funciones) {
            funcionlist.add(FuncionAssembler.assemble(funcion));
        }

        return funcionlist;

    }

    private static List<SeccionDTO> convertirSecciones(Set<Seccion> secciones) {

        List<SeccionDTO> seccionlist = new ArrayList<>();

        for (Seccion seccion : secciones) {
            seccionlist.add(SeccionAssembler.assemble(seccion));
        }

        return seccionlist;

    }

}
