package meli.shows.services.impl;

import meli.shows.controllers.response.FuncionButacasResponse;
import meli.shows.entities.Funcion;
import meli.shows.entities.Show;
import meli.shows.entities.assembler.FuncionAssembler;
import meli.shows.entities.assembler.ShowAssembler;
import meli.shows.entities.dto.FuncionDTO;
import meli.shows.entities.dto.ShowDTO;
import meli.shows.extra.Cache;
import meli.shows.repository.ButacaRepository;
import meli.shows.repository.FuncionRepository;
import meli.shows.repository.ShowRepository;
import meli.shows.services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    ShowRepository showRepository;
    @Autowired
    FuncionRepository funcionRepository;
    @Autowired
    ButacaRepository butacaRepository;

    Cache cache = Cache.getInstance();


    @Override
    public List<ShowDTO> getAll() {

        List<ShowDTO> showResponse = new ArrayList<>();

        if (cache.isDataValid()) {

            showResponse = cache.getAllShows();

        } else {

            for (Show show : showRepository.findAll()) {
                ShowDTO showDTO = ShowAssembler.assemble(show);
                cache.addShow(showDTO);
                showResponse.add(showDTO);
            }

        }

        return showResponse;

    }

    @Override
    public FuncionButacasResponse getShowInfo(Long idFuncion) {

        Funcion funcion = null;

        if (cache.isDataValid()) {
            funcion = FuncionAssembler.assemble(cache.getFuncion(idFuncion));
        }
        if (funcion == null) {
            funcion = funcionRepository.getById(idFuncion);
            cache.addFuncion(FuncionAssembler.assemble(funcion));
        }

        FuncionButacasResponse funButacaRes = new FuncionButacasResponse();
        funButacaRes.setIdShow(funcion.getShow().getId());
        funButacaRes.setNombre(funcion.getShow().getNombre());
        funButacaRes.setCategoria(funcion.getShow().getCategoria());
        funButacaRes.setDuracion(funcion.getShow().getDuracion());
        funButacaRes.setDiaHorario(funcion.getDiaHorario());

        return funButacaRes;
    }

    @Override
    public Show modificar(Show show) {
        return null;
    }

    @Override
    public void borrar(Long id) {

    }

    @Override
    public Optional<Show> getById(Long id) {

        return showRepository.findById(id);

    }
}
