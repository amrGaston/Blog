package io.redbee.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RequestContentTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void cuandoSeGuardaUnComentarioEntoncesElResultadoEs200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/comentario")
                        .content("{\"texto\":\"Un comentario\",\"post\":{\"id\":1}}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk() );

    }

    @Test
    public void cuandoSeGuardaUnPostEntoncesElResultadoEs200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/post")
                        .content("{\"compra\":100,\"venta\":101,\"usuario\":{\"id\":1}}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk() );
    }

    @Test
    public void cuandoSeGuardaUnUsuarioEntoncesElResultadoEs200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/usuario")
                        .content("{\"nombre\":\"Gas\",\"correo\":\"gaston@gmail.com\"}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk() );
    }
}
