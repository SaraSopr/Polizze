package com.example.Polizze;

import com.example.Polizze.repository.PolizzaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static com.example.Polizze.mother.PolizzaMother.getPolizza;
import static org.assertj.core.api.Assertions.assertThat;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(classes = PolizzeApplication.class)
class PolizzaRepositoryTest {

    @Autowired
    private PolizzaRepository polizzaRepository;

    @Test
    void findAll() {
        polizzaRepository.insert(getPolizza("2"));
        polizzaRepository.insert(getPolizza("3"));
        polizzaRepository.insert(getPolizza("4"));
        List<PolizzaDb> actual = polizzaRepository.findAll();
        assertThat(actual.size()).isEqualTo(3);
    }


    @Test
    void insertPolizza(){
        PolizzaDb polizza = getPolizza("2");
        polizzaRepository.insert(polizza);
        assertThat(polizzaRepository.findAll().size()).isEqualTo(1);
    }

    @Test
    void findPolizzaByNumber(){
        polizzaRepository.findPolizzaByNumber("1");
        assertThat(polizzaRepository.findAll().size()).isEqualTo(2);
    }
}