package meli.shows.services.impl;

import meli.shows.controllers.request.AdvanceSearchRequest;
import meli.shows.controllers.response.FuncionButacasResponse;
import meli.shows.entities.Funcion;
import meli.shows.entities.Show;
import meli.shows.entities.assembler.FuncionAssembler;
import meli.shows.entities.assembler.ShowAssembler;
import meli.shows.entities.dto.ShowDTO;
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

    ShowRepository showRepository;
    @Autowired
    FuncionRepository funcionRepository;

    Cache cache = Cache.getInstance();

    @Autowired
    public ShowServiceImpl(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

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
    public FuncionButacasResponse getShowInfo(Long idFuncion, Long idShow) {
        Funcion funcion = getFuncion(idFuncion);
        ShowDTO show = getShowById(idShow);
        return fillFuncionButacaResponse(funcion, show);
    }

    private Funcion getFuncion(Long idFuncion) {
        Funcion funcion = null;
        if (cache.isDataValid()) {
            funcion = FuncionAssembler.assemble(cache.getFuncion(idFuncion));
        }
        if (funcion == null) {
            funcion = funcionRepository.getById(idFuncion);
            if(funcion==null){
                return null;
            }
            cache.addFuncion(FuncionAssembler.assemble(funcion));
        }
        return funcion;
    }

    private ShowDTO getShowById(Long idShow) {
        ShowDTO show = null;
        if (cache.isDataValid()) {
            show = cache.getShow(idShow);
        }
        if (show == null) {
            show = ShowAssembler.assemble(showRepository.getById(idShow));
            cache.addShow(show);
        }
        return show;
    }

    //TODO solo testear metodo publicos
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
