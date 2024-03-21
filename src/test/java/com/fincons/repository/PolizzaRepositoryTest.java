package com.fincons.repository;

import com.fincons.PolizzeApplication;
import com.fincons.db.entity.PolizzaDb;
import com.fincons.mother.PolizzaDBMother;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(classes = PolizzeApplication.class)
class PolizzaRepositoryTest {

    @Autowired
    private PolizzaRepository polizzaRepository;

    @Autowired
    private AnagraficaRepository anagraficaRepository;

    @Test
    void findAll() {
        //polizzaRepository.insertPolizza(PolizzaDBMother.getPolizza("3"));
        polizzaRepository.insertPolizza(PolizzaDBMother.getPolizza("3"));


//        polizzaRepository.insertPolizza(new PolizzaDb(1, "2", 2, 2, 2, 0, 0));
//        polizzaRepository.insertPolizza(new PolizzaDb(2, "3", 2, 2, 2, 0, 0));
//        polizzaRepository.insertPolizza(new PolizzaDb(3, "4", 2, 2, 2, 0, 0));
        List<PolizzaDb> actual = polizzaRepository.findAll();
        assertThat(actual.size()).isEqualTo(1);
    }


    @Test
    void insertPolizza(){
//        PolizzaDb polizza = new PolizzaDb(1, "2", 2, 2, 2, 0,0);
//        polizzaRepository.insertPolizza(polizza);
//        assertThat(polizzaRepository.findAll().size()).isEqualTo(1);
    }

    @Test
    void findPolizzaByNumber(){
//        polizzaRepository.insertPolizza(new PolizzaDb(1, "111", 222, 333, 444, 0, 0));
//        polizzaRepository.insertPolizza(new PolizzaDb(2, "555", 666, 777, 888, 0,0));
//
//        PolizzaDb actual = polizzaRepository.findByNumeroPolizza("555");
//
//        assertThat(actual).isEqualTo(new PolizzaDb(2, "555", 666, 777, 888, 0, 0));
    }

    @Test
    void findPolizzeByIDContraenteOrAssicuratoOrBeneficiario(){
//        PolizzaDb polizzaDb = new PolizzaDb(1, "111", 222, 333, 444, 0, 0);
//        polizzaRepository.insertPolizza(polizzaDb);
//        polizzaRepository.insertPolizza(new PolizzaDb(2, "555", 666, 777, 888, 0, 0));
//
//        List<PolizzaDb> actual = polizzaRepository.findPolizzeByIDAnagrafica(222);
//        assertThat(actual).isEqualTo(asList(polizzaDb));
    }
}