package com.fincons.repository;

import com.fincons.PolizzeApplication;
import com.fincons.db.entity.PolizzaDb;
import com.fincons.mother.PolizzaDBMother;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(classes = PolizzeApplication.class)
class PolizzaRepositoryTest {

    @Autowired
    private PolizzaRepository polizzaRepository;

    @Autowired
    private AnagraficaRepository anagraficaRepository;

    @Test
    void findAll() {
//        polizzaRepository.insertPolizza(PolizzaDBMother.getPolizza(1, "3"));
//        List<PolizzaDb> actual = polizzaRepository.findAll();
//        assertThat(actual.size()).isEqualTo(1);
    }


    @Test
    void findPolizzaByNumber(){
//        polizzaRepository.insertPolizza(PolizzaDBMother.getPolizza(1,"1"));
//        polizzaRepository.insertPolizza(PolizzaDBMother.getPolizza(2, "2"));
//
//        PolizzaDb actual = polizzaRepository.findByNumeroPolizza("2");
//
//        assertThat(actual).isEqualTo(PolizzaDBMother.getPolizza(2, "2"));
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


    @Test
    void insertPolizzaAssicurato1UgualeAssicurato2(){
        PolizzaDb polizza = new PolizzaDb(1, "2", 1, "N", 3, 3, 5, 6, 5, 6, 7, 8, 3, 666, 2, 2, 0, 0);
        assertThatThrownBy(() -> {
            polizzaRepository.insertPolizza(polizza);
        }).isInstanceOf(Exception.class)
                .hasMessage("Errore IdAssicurato1 uguale a IdAssicurato2");
    }

    @Test
    void insertPolizzaBeneficiariSiaVitaCheMorte(){
        PolizzaDb polizza = new PolizzaDb(1, "2", 1, "N", 3, null, 5, null, null, null, null, 8, null, null, null, null, 0, 0);
        assertThatThrownBy(() -> {
            polizzaRepository.insertPolizza(polizza);
        }).isInstanceOf(Exception.class)
                .hasMessage("I beneficiari o tutti sono vita tutti sono morte");
    }

    @Test
    void insertPolizzaBeneficiariSUgualiAssicurati(){
        PolizzaDb polizza = new PolizzaDb(1, "2", 1, "N", 3, null, 3, null, null, null, null, null, null, null, null, null, 0, 0);
        assertThatThrownBy(() -> {
            polizzaRepository.insertPolizza(polizza);
        }).isInstanceOf(Exception.class)
                .hasMessage("Gli idBeneficiari sono uguali agli idAssicurati");
    }

    @Test
    void insertPolizzaSenzaBeneficiari(){
        PolizzaDb polizza = new PolizzaDb(1, "2", 1, "N", 3, null, null, null, null, null, null, null, null, null, null, null, 0, 0);
        assertThatThrownBy(() -> {
            polizzaRepository.insertPolizza(polizza);
        }).isInstanceOf(Exception.class)
                .hasMessage("E' obbligatorio avere almeno un beneficiario");
    }

    @Test
    void insertPolizzaIdContraenteUgualeAIdAssicurato(){
        PolizzaDb polizza = new PolizzaDb(1, "2", 1, "S", 1, null, 2, null, null, null, null, null, null, null, null, null, 0, 0);
        assertThatThrownBy(() -> {
            polizzaRepository.insertPolizza(polizza);
        }).isInstanceOf(Exception.class)
                .hasMessage("IdContraente uguale a IdAssicurato e idAssicurato deve essere vuoto");
    }

    @Test
    void insertPolizzaIdContraenteDiversoIdAssicurato(){
        PolizzaDb polizza = new PolizzaDb(1, "2", 1, "N", 1, 6, 4, null, null, null, null, null, null, null, null, null, 0, 0);
        assertThatThrownBy(() -> {
            polizzaRepository.insertPolizza(polizza);
        }).isInstanceOf(Exception.class)
                .hasMessage("Il contraente non è diverso dall'assicurato1 e assicurato2");
    }

    @Test
    void insertPolizzaContraenteUgualeABeneficiarioAltro(){
        PolizzaDb polizza = new PolizzaDb(1, "2", 1, "R", 1, null, 4, null, null, null, null, null, null, null, null, null, 0, 0);
        assertThatThrownBy(() -> {
            polizzaRepository.insertPolizza(polizza);
        }).isInstanceOf(Exception.class)
                .hasMessage("Ci devono essere 2 assicurati");
    }

    @Test
    void insertPolizzaContraenteUgualeABeneficiarioAltroNessunErrore() throws Exception {
        PolizzaDb polizza = new PolizzaDb(1, "2", 1, "R", 1, 2, 4, null, null, null, null, null, null, null, null, null, 0, 0);
        polizzaRepository.insertPolizza(polizza);

        PolizzaDb actual = polizzaRepository.findByNumeroPolizza("2");
        assertThat(actual).isEqualTo(polizza);
    }

    @Test
    //rinomina
    void insertPolizzaEBeneficiarioDuplicato(){
        PolizzaDb polizza = new PolizzaDb(1, "2", 1, "N", 3, 4, 5, 6, 5, 6, 7, 8, 3, 666, 2, 2, 0, 0);

        assertThatThrownBy(() -> {
            polizzaRepository.insertPolizza(polizza);
        }).isInstanceOf(RuntimeException.class)
                .hasMessage("Duplicate idBeneficiari: 5");

    }
}