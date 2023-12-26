package io.redbee.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RequestTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void cuandoSeLlamaAUsuarioElResultadoEs200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/usuario")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk() );
    }

    @Test
    public void cuandoSeLlamaAUsuarioElResultadoDelContenidoEsJson() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/usuario")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON)
                );
    }

    @Test
    public void cuandoSeLlamaAPostElResultadoEs200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/post")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk() );
    }

    @Test
    public void cuandoSeLlamaAPostElResultadoDelContenidoEsJson() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/post")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON)
                );
    }

    @Test
    public void cuandoSeLlamaAComentarioElResultadoEs200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/comentario")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk() );
    }

    @Test
    public void cuandoSeLlamaAComentarioElResultadoDelContenidoEsJson() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/comentario")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON)
                );
    }
}
