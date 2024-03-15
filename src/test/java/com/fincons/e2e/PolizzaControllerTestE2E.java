package com.fincons.e2e;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fincons.PolizzeApplication;
import com.fincons.controller.PolizzaController;
import com.fincons.db.entity.PolizzaDb;
import com.fincons.repository.PolizzaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(classes = PolizzeApplication.class)
@AutoConfigureMockMvc
public class PolizzaControllerTestE2E {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    PolizzaRepository polizzaRepository;

    @Test
    void happyPath() throws Exception {
        polizzaRepository.insert(new PolizzaDb(1, "111", 222, 2, 2));
        String numeroDiPolizza = "111";

        MvcResult mvcResult = this.mockMvc.perform(get("/polizza/getContraente1/" + numeroDiPolizza))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();;

        ObjectMapper objectMapper = new ObjectMapper();
        PolizzaController.Pippo actual = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), PolizzaController.Pippo.class);

        //assertThat(mvcResult.getResponse().getContentAsString()).isEqualTo("{\"aaa\":\"lol\",\"idContraente\":\"222\"}");
        PolizzaController.Pippo expected = new PolizzaController.Pippo("lol","222");
        assertThat(actual).isEqualTo(expected);

    }

}
