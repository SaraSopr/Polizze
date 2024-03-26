package com.fincons.e2e;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fincons.PolizzeApplication;
import com.fincons.controller.PolizzaController;
import com.fincons.db.entity.PolizzaDb;
import com.fincons.io.entity.Rapporto;
import com.fincons.persistor.AnagraficaDBPersistor;
import com.fincons.persistor.PolizzaDBPersistor;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static com.fincons.mother.PolizzaDBMother.getPolizza;
import static java.lang.String.valueOf;
import static java.util.Arrays.asList;
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
    PolizzaDBPersistor polizzaPersistor;
    @Autowired
    AnagraficaDBPersistor anagraficaDBPersistor;





    @Test
    @Disabled
    void happyPath2() throws Exception {
        List<PolizzaDb> polizzeDiMarco = polizzaPersistor.inserisciPolizzeMarco();
        String codiceFiscale = "marco";
        MvcResult mvcResult = this.mockMvc.perform(get("/polizza/getPolizze/" + codiceFiscale))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        ObjectMapper objectMapper = new ObjectMapper();
        List<PolizzaDb> actual = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), objectMapper.getTypeFactory().constructCollectionType(List.class, PolizzaDb.class));


        assertThat(actual).isEqualTo(polizzeDiMarco);
    }


    @Test
    @Disabled
    void happyPath3() throws Exception {
        polizzaPersistor.inserisciPolizzeMarco();
        List<Rapporto> listaRapportiMarco = asList(new Rapporto("1", "Marco", "Rossi", "M", "Sofia", "Gialli", "F", "Mario", "Verdi", "M", "Marco", "Rossi", "M", "Marco", "Rossi", "M", "Marco", "Rossi", "M", "Marco", "Rossi", "M", "Marco", "Rossi", "M", "Marco", "Rossi", "M", "Marco", "Rossi", "M", "Marco", "Rossi", "M", "Marco", "Rossi", "M", "Marco", "Rossi", "M"),
        new Rapporto("2", "Marco", "Rossi", "M", "Mario", "Verdi", "M", "Sofia", "Gialli", "F", "Mario", "Verdi", "M", "Marco", "Rossi", "M", "Marco", "Rossi", "M", "Marco", "Rossi", "M", "Marco", "Rossi", "M", "Marco", "Rossi", "M", "Marco", "Rossi", "M", "Marco", "Rossi", "M", "Marco", "Rossi", "M", "Marco", "Rossi", "M"));

        String codiceFiscale = "marco";
        MvcResult mvcResult = this.mockMvc.perform(get("/polizza/getRapporti/" + codiceFiscale))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        ObjectMapper objectMapper = new ObjectMapper();
        List<PolizzaDb> actual = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), objectMapper.getTypeFactory().constructCollectionType(List.class, Rapporto.class));


        assertThat(actual).isEqualTo(listaRapportiMarco);
    }


}
