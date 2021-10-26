package meli.shows.services.impl;

import meli.shows.entities.Funcion;
import meli.shows.repository.FuncionRepository;
import meli.shows.services.FuncionService;
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

class FuncionServiceImplTest {

    @Mock
    private FuncionRepository funcionRepository;

    @InjectMocks
    private FuncionServiceImpl funcionService;

    private final List<Funcion> funcionList = new ArrayList<>();
    private Funcion funcion;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        createDataset();
    }

    @Test
    void getAll() {

        Mockito.when(funcionRepository.findAll()).thenReturn(funcionList);
        Assertions.assertEquals(funcionService.getAll().size(), 5);

    }

    @Test
    void getById() {

        Mockito.when(funcionRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(funcion));
        Assertions.assertEquals(funcionService.getById(1L).get(), funcion);

    }

    private void createDataset(){

        LocalDateTime dateTime = LocalDateTime.of(2021, Month.JULY, 29, 19, 30, 0);

        for (int i = 0; i < 5 ; i++){
            funcionList.add(new Funcion().setId((long) i).setDiaHorario(dateTime));
        }

        funcion = new Funcion().setId(1L).setDiaHorario(LocalDateTime.now());

    }

}