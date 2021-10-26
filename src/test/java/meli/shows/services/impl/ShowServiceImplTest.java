package meli.shows.services.impl;

import meli.shows.controllers.response.FuncionButacasResponse;
import meli.shows.entities.Funcion;
import meli.shows.entities.Show;
import meli.shows.entities.exception.FuncionNotFoundException;
import meli.shows.entities.exception.ShowNotFoundException;
import meli.shows.repository.FuncionRepository;
import meli.shows.repository.ShowRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class ShowServiceImplTest {

    @Mock
    private ShowRepository showRepository;
    @Mock
    private FuncionRepository funcionRepository;

    @InjectMocks
    private ShowServiceImpl showService;

    private final List<Show> showList = new ArrayList<>();
    private Show show;
    private Funcion funcion;
    private FuncionButacasResponse response;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        createDataset();
    }

    @Test
    void getAll() {

        Mockito.when(showRepository.findAll()).thenReturn(showList);
        Assertions.assertEquals(showService.getAll().size(), 1);

    }

    @Test
    void getShowInfo() {

        Mockito.when(funcionRepository.getById(Mockito.anyLong())).thenReturn(funcion);
        Mockito.when(showRepository.getById(Mockito.anyLong())).thenReturn(show);
        try {
            Assertions.assertEquals(showService.getShowInfo(1L, 1L), response);
        } catch (FuncionNotFoundException | ShowNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Test
    void getById() {

        Mockito.when(showRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(show));
        Assertions.assertEquals(showService.getById(1L).get(), show);

    }

    private void createDataset() {

        LocalDateTime dateTime = LocalDateTime.of(2021, Month.JULY, 29, 19, 30, 0);
        funcion = new Funcion().setId(1L).setDiaHorario(dateTime);

        show = new Show().setId(1L).setNombre("Test 1").setDuracion(120).setCategoria("Test 1");

        showList.add(show);

        response = new FuncionButacasResponse().setButacas(null).setIdShow(1L).setCategoria("Test 1").setDuracion(120).setDiaHorario(dateTime).setNombre("Test 1");

    }

}