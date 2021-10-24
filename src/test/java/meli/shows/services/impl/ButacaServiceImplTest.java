package meli.shows.services.impl;

import meli.shows.entities.Butaca;
import meli.shows.repository.ButacaRepository;
import meli.shows.services.ButacaService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

class ButacaServiceImplTest {

    private ButacaRepository butacaRepository;

    private ButacaService butacaService;

    private Butaca butaca;

    @BeforeEach
    public void setUp() {
        butacaRepository = Mockito.mock(ButacaRepository.class);
        butacaService = new ButacaServiceImpl(butacaRepository);
        butaca = createButaca();
    }

    @Test
    void getAll() {

        List<Butaca> hola = List.of(butaca, butaca, butaca);

        Mockito.when(butacaRepository.findAll()).thenReturn(hola);
        Assert.assertEquals(butacaService.getAll().size(), 3);
        Assert.assertEquals(butacaService.getAll().get(0), butaca);
        Assert.assertEquals(butacaService.getAll().get(0), butaca);
        Assert.assertEquals(butacaService.getAll().get(0), butaca);

    }

    @Test
    void getById() {

        Mockito.when(butacaRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(butaca));
        Assert.assertEquals(butacaService.getById(butaca.getId()).get(), butaca);

    }

    @Test
    void getButacasLibresFuncion() {
    }

    private Butaca createButaca(){
        return new Butaca()
                .setId(1L)
                .setFila(1)
                .setPosicion(1)
                .setSeccion(null)
                .setSala(null);
    }

}