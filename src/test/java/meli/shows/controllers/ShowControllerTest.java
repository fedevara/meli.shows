package meli.shows.controllers;

import meli.shows.entities.dto.ShowDTO;
import meli.shows.entities.exception.ReservaAlreadyExistException;
import meli.shows.services.ButacaService;
import meli.shows.services.FuncionService;
import meli.shows.services.ReservaService;
import meli.shows.services.ShowService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ShowController.class)
public class ShowControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ShowService showService;
    @MockBean
    private ReservaService reservaService;
    @MockBean
    private ButacaService butacaService;
    @MockBean
    private FuncionService funcionService;

    @Test
    void testGetAllShowsResponse200() throws Exception {

        List<ShowDTO> expectedShows = buildShowsResponse();

        Mockito.doReturn(expectedShows).when(showService).getAll();

        mockMvc.perform(get("/shows/listar-shows")
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id").value(expectedShows.get(0).getId()))/*
                .andExpect(jsonPath("$.items[0].total").value(expectedShows.getItems().get(0).getTotal()))
                .andExpect(jsonPath("$.items[1].id").value(expectedShows.getItems().get(1).getId()))
                .andExpect(jsonPath("$.items[1].total").value(expectedShows.getItems().get(1).getTotal()))
                .andExpect(jsonPath("$.paging.total").value(expectedShows.getPaging().getTotal()))*/
        ;
    }

    @Test
    void testGetAllShowsResponse500() throws Exception {

        doThrow(new ReservaAlreadyExistException()).when(showService).getAll();

        mockMvc.perform(get("/shows/listar-shows")
                .contentType("application/json"))
                .andExpect(status().is5xxServerError())
        ;
    }

    private List<ShowDTO> buildShowsResponse() {
        ShowDTO show = new ShowDTO().setCategoria("Comedia").setId(1L).setDuracion(123).setNombre("Show test");
        return List.of(show);
    }

}
