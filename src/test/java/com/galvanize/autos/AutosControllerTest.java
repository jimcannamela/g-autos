package com.galvanize.autos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AutosController.class)
class AutosControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AutosRepository autosRepository;

    @Test
    void getAutomobiles() throws Exception {
        when(autosRepository.findAll()).thenReturn(Arrays.asList(new Automobile("YEAR","MAKE","MODEL")));

        mockMvc.perform(get("/autos"))
                .andExpect(status().isOk());
    }

    @Test
    void getAutomobile() throws Exception {
        Automobile auto = new Automobile("YEAR","MAKE","MODEL");
        when(autosRepository.findById(anyLong())).thenReturn(Optional.of(auto));

        mockMvc.perform(get("/autos/99"))
                .andExpect(status().isOk());
    }

    @Test
    void createAutomobile() throws Exception {
        Automobile auto = new Automobile("YEAR","MAKE","MODEL");
        when(autosRepository.save(any(Automobile.class))).thenReturn(auto);
        // {"year": "year", "make": "make", "model": "model"}
        mockMvc.perform(post("/autos").contentType(MediaType.APPLICATION_JSON)
                .content("{\"year\": \"year\", \"make\": \"make\", \"model\": \"model\"}"))
                .andExpect(status().isOk());
    }

    @Test
    void deleteAutomobile() throws Exception {
        Automobile auto = new Automobile("YEAR","MAKE","MODEL");

        when(autosRepository.findById(anyLong())).thenReturn(Optional.of(auto));

        mockMvc.perform(delete("/autos/99"))
                        .andExpect(status().isAccepted());

        verify(autosRepository).delete(any(Automobile.class));
    }
}