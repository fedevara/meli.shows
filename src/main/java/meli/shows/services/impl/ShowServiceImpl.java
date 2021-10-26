package meli.shows.services.impl;

import meli.shows.controllers.request.AdvanceSearchRequest;
import meli.shows.controllers.response.FuncionButacasResponse;
import meli.shows.entities.Funcion;
import meli.shows.entities.Show;
import meli.shows.entities.assembler.FuncionAssembler;
import meli.shows.entities.assembler.ShowAssembler;
import meli.shows.entities.dto.ShowDTO;
import meli.shows.entities.exception.FuncionNotFoundException;
import meli.shows.entities.exception.ShowNotFoundException;
import meli.shows.extra.Cache;
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
    public FuncionButacasResponse getShowInfo(Long idFuncion, Long idShow) throws FuncionNotFoundException, ShowNotFoundException {
        Funcion funcion = getFuncion(idFuncion);
        ShowDTO show = getShowById(idShow);
        return fillFuncionButacaResponse(funcion, show);
    }

    private Funcion getFuncion(Long idFuncion) throws FuncionNotFoundException {
        Funcion funcion = null;
        if (cache.isDataValid()) {
            funcion = FuncionAssembler.assemble(cache.getFuncion(idFuncion));
        }
        if (funcion == null) {
            try {
                funcion = funcionRepository.getById(idFuncion);
                cache.addFuncion(FuncionAssembler.assemble(funcion));
            } catch (Exception e) {
                throw new FuncionNotFoundException();
            }
        }
        return funcion;
    }

    private ShowDTO getShowById(Long idShow) throws ShowNotFoundException {
        ShowDTO show = null;
        if (cache.isDataValid()) {
            show = cache.getShow(idShow);
        }
        if (show == null) {
            try {
                show = ShowAssembler.assemble(showRepository.getById(idShow));
                cache.addShow(show);
            } catch (Exception e) {
                throw new ShowNotFoundException();
            }
        }
        return show;
    }

    private FuncionButacasResponse fillFuncionButacaResponse(Funcion funcion, ShowDTO show) {
        FuncionButacasResponse funButacaRes = new FuncionButacasResponse();
        funButacaRes.setIdShow(show.getId());
        funButacaRes.setNombre(show.getNombre());
        funButacaRes.setCategoria(show.getCategoria());
        funButacaRes.setDuracion(show.getDuracion());
        funButacaRes.setDiaHorario(funcion.getDiaHorario());
        return funButacaRes;
    }

    @Override
    public Optional<Show> getById(Long id) {
        return showRepository.findById(id);
    }

    @Override
    public List<ShowDTO> getAdvancedAll(AdvanceSearchRequest request) {

        List<ShowDTO> showResponse = null;

        if (cache.isDataValid()) {
            showResponse = cache.getAdvancedAll(request);
        }
        if (showResponse == null) {
            showResponse = new ArrayList<>();
            for (Show show : showRepository.findAdvancedAll(request)) {
                ShowDTO showDTO = ShowAssembler.assemble(show);
                cache.addShow(showDTO);
                showResponse.add(showDTO);
            }
            cache.addRequest(request, showResponse);
        }
        return showResponse;

    }
}
