package meli.shows.services.impl;

import meli.shows.entities.Butaca;
import meli.shows.entities.Funcion;
import meli.shows.entities.Reserva;
import meli.shows.entities.assembler.ReservaAssembler;
import meli.shows.entities.dto.FuncionDTO;
import meli.shows.entities.dto.ReservaDTO;
import meli.shows.entities.exception.ReservaAlreadyExistException;
import meli.shows.repository.FuncionRepository;
import meli.shows.repository.ReservaRepository;
import meli.shows.services.ReservaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class ReservaServiceImplTest {

    private ReservaRepository reservaRepository;

    private ReservaService reservaService;

    private final List<Reserva> reservaList = new ArrayList<Reserva>();
    private Reserva reserva;

    @BeforeEach
    public void setUp() {
        reservaRepository = Mockito.mock(ReservaRepository.class);
        reservaService = new ReservaServiceImpl(reservaRepository);
        createFuncionDataset();
    }

    @Test
    void registrarOk() throws ReservaAlreadyExistException {

        Mockito.when(reservaRepository.save(Mockito.any(Reserva.class))).thenReturn(reserva);
        ReservaDTO response = reservaService.registrar(ReservaAssembler.assemble(reserva));
        Assertions.assertEquals(ReservaAssembler.assemble(reserva), response);

    }

    @Test
    void getAll() {

        Mockito.when(reservaRepository.findAll()).thenReturn(reservaList);
        Assertions.assertEquals(reservaService.getAll().size(), 7);

    }

    @Test
    void registrarNok() {

        Throwable ex = Assertions.assertThrows(ReservaAlreadyExistException.class, () -> {reservaService.registrar(ReservaAssembler.assemble(reservaList.get(1)));});
        Assertions.assertEquals("La butaca seleccionada ya no se encuentra disponible para la funcion", ex.getMessage());

    }

    @Test
    void getById() {

        Mockito.when(reservaRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(reserva));
        Assertions.assertEquals(reservaService.getById(1L).get(), reserva);

    }

    private void createFuncionDataset(){

        LocalDateTime dateTime = LocalDateTime.of(2021, Month.JULY, 29, 19, 30, 0);
        Funcion func = new Funcion().setId(1L).setDiaHorario(dateTime);

        List<Butaca> butacaList = new ArrayList<Butaca>();

        for (int i = 0; i < 7 ; i++){
            butacaList.add(new Butaca().setId((long) i).setFila(i).setPosicion(i).setSeccion(null).setSala(null));
        }

        for (int i = 0; i < 7 ; i++){
            reservaList.add(new Reserva().setFuncion(func).setNombre("Test " + i).setButaca(butacaList.get(i)).setPrecio(new BigDecimal(200)));
        }

        reserva = new Reserva().setFuncion(func).setNombre("Test 1").setButaca(butacaList.get(1)).setPrecio(new BigDecimal(200));
    }

}