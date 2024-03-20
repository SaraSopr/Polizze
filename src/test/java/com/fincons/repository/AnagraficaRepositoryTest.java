package com.fincons.repository;

import com.fincons.PolizzeApplication;
import com.fincons.db.entity.AnagraficaDB;
import com.fincons.db.entity.PolizzaDb;
import com.fincons.mother.AnagraficaDBMother;
import com.fincons.persistor.AnagraficaDBPersistor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static com.fincons.mother.AnagraficaDBMother.getAnagraficaMarco;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(classes = PolizzeApplication.class)
class AnagraficaRepositoryTest {

    @Autowired
    private AnagraficaRepository anagraficaRepository;

    @Test
    void findIdAnagraficaByCF() {
        AnagraficaDB anagrafica = getAnagraficaMarco();
        anagraficaRepository.insertAnagrafica(anagrafica);

        AnagraficaDB actual = anagraficaRepository.findIdAnagraficaByCF(anagrafica.getCodiceFiscale());

        assertThat(actual).isEqualTo(anagrafica);
    }

    @Test
    void findByID() {
        AnagraficaDB anagrafica = getAnagraficaMarco();
        anagraficaRepository.insertAnagrafica(anagrafica);

        AnagraficaDB actual = anagraficaRepository.findByID(anagrafica.getId());

        assertThat(actual).isEqualTo(anagrafica);
    }
}