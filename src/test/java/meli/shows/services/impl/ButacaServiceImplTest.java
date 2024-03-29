package meli.shows.services.impl;

import meli.shows.entities.Butaca;
import meli.shows.entities.dto.ButacaDTO;
import meli.shows.repository.ButacaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class ButacaServiceImplTest {

    @Mock
    private ButacaRepository butacaRepository;

    @InjectMocks
    private ButacaServiceImpl butacaService;

    private final List<Butaca> butacaList = new ArrayList<>();
    private final List<ButacaDTO> butacaListDto = new ArrayList<>();
    private Butaca butaca;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        createDataset();
    }

    @Test
    void getAll() {

        Mockito.when(butacaRepository.findAll()).thenReturn(butacaList);
        Assertions.assertEquals(butacaService.getAll().size(), 10);

    }

    @Test
    void getById() {

        Mockito.when(butacaRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(butaca));
        Assertions.assertEquals(butacaService.getById(1L).get(), butaca);

    }

    @Test
    void getButacasLibresFuncion() {

        Mockito.when(butacaRepository.getButacasLibresFuncion(Mockito.anyLong())).thenReturn(butacaList);

        Assertions.assertEquals(butacaService.getButacasLibresFuncion(1L), butacaListDto);

    }

    private void createDataset(){

        for (int i = 0; i < 10 ; i++){
            butacaList.add(new Butaca().setId((long) i).setFila(i).setPosicion(i).setSeccion(null).setSala(null));
        }

        butaca = new Butaca().setId(1L).setFila(1).setPosicion(1).setSeccion(null).setSala(null);

        for (int i = 0; i < 10 ; i++){
            butacaListDto.add(new ButacaDTO().setId((long) i).setFila(i).setPosicion(i));
        }

    }

}