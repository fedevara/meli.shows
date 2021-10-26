package meli.shows.services.impl;

import meli.shows.controllers.request.AdvanceSearchRequest;
import meli.shows.entities.Funcion;
import meli.shows.entities.Reserva;
import meli.shows.entities.Show;
import meli.shows.entities.dto.ShowDTO;
import meli.shows.repository.FuncionRepository;
import meli.shows.repository.ShowRepository;
import meli.shows.services.ShowService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class ShowServiceImplTest {

    private ShowRepository showRepository;
    private FuncionRepository funcionRepository;

    private ShowService showService;

    private final List<Show> showList = new ArrayList<Show>();
    private Show show;
    private Funcion funcion;
    private ShowDTO showDto;

    @BeforeEach
    public void setUp() {
        showRepository = Mockito.mock(ShowRepository.class);
        funcionRepository = Mockito.mock(FuncionRepository.class);
        showService = new ShowServiceImpl(showRepository);
        createDataset();
    }

    @Test
    void getAll() {

        Mockito.when(showRepository.findAll()).thenReturn(showList);
        Assertions.assertEquals(showService.getAll().size(), 3);

    }

    @Test
    void getShowInfo() {

        Mockito.when(funcionRepository.getById(Mockito.anyLong())).thenReturn(funcion);
        Mockito.when(showRepository.getById(Mockito.anyLong())).thenReturn(show);
        Assertions.assertEquals(showService.getShowInfo(1L, 1L), null);

    }

    @Test
    void getById() {

        Mockito.when(funcionRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(funcion));
        Assertions.assertEquals(showService.getById(1L).get(), funcion);

    }

    @Test
    void getAdvancedAllByNombre() {

        Mockito.when(showRepository.findAdvancedAll(Mockito.any(AdvanceSearchRequest.class))).thenReturn(null);
        Assertions.assertEquals(showService.getAdvancedAll(null), null);

    }

    private void createDataset() {

        LocalDateTime dateTime = LocalDateTime.of(2021, Month.JULY, 29, 19, 30, 0);
        funcion = new Funcion().setId(1L).setDiaHorario(dateTime);

        show = new Show().setId(1L).setNombre("Test 1").setDuracion(120).setCategoria("Test 1");
/*
        List<Butaca> butacaList = new ArrayList<Butaca>();

        for (int i = 0; i < 7 ; i++){
            butacaList.add(new Butaca().setId((long) i).setFila(i).setPosicion(i).setSeccion(null).setSala(null));
        }

        for (int i = 0; i < 7 ; i++){
            reservaList.add(new Reserva().setFuncion(func).setNombre("Test " + i).setButaca(butacaList.get(i)).setPrecio(new BigDecimal(200)));
        }

        reserva = new Reserva().setFuncion(func).setNombre("Test 1").setButaca(butacaList.get(1)).setPrecio(new BigDecimal(200));*/
    }

}