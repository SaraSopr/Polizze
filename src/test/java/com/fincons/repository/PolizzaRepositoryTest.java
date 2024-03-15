package com.fincons.repository;

import com.fincons.PolizzeApplication;
import com.fincons.db.entity.PolizzaDb;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(classes = PolizzeApplication.class)
class PolizzaRepositoryTest {

    @Autowired
    private PolizzaRepository polizzaRepository;

    @Test
    void findAll() {
        polizzaRepository.insert(new PolizzaDb(1, "2", 2, 2, 2));
        polizzaRepository.insert(new PolizzaDb(1, "3", 2, 2, 2));
        polizzaRepository.insert(new PolizzaDb(1, "4", 2, 2, 2));
        List<PolizzaDb> actual = polizzaRepository.findAll();
        assertThat(actual.size()).isEqualTo(3);
    }


    @Test
    void insertPolizza(){
        PolizzaDb polizza = new PolizzaDb(1, "2", 2, 2, 2);
        polizzaRepository.insert(polizza);
        assertThat(polizzaRepository.findAll().size()).isEqualTo(1);
    }

    @Test
    void findPolizzaByNumber(){
        polizzaRepository.insert(new PolizzaDb(1, "111", 222, 333, 444));
        polizzaRepository.insert(new PolizzaDb(2, "555", 666, 777, 888));

        PolizzaDb actual = polizzaRepository.findByNumeroPolizza("555");

        assertThat(actual).isEqualTo(new PolizzaDb(2, "555", 666, 777, 888));
    }
}