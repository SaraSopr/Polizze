package com.fincons.persistor;

import com.fincons.db.entity.PolizzaDb;
import com.fincons.mother.PolizzaDBMother;
import com.fincons.repository.PolizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PolizzaDBPersistor {

    @Autowired
    PolizzaRepository polizzaRepository;
    @Autowired
    private AnagraficaDBPersistor anagraficaDBPersistor;

    public void inserisciPolizze(List<PolizzaDb> listaPolizze) throws Exception {
        for (PolizzaDb polizzaDb : listaPolizze) {
            polizzaRepository.insertPolizza(polizzaDb);
        }
    }

    public List<PolizzaDb> inserisciPolizzeMarco() throws Exception {
        anagraficaDBPersistor.inserisciAnagraficaMarco();
        anagraficaDBPersistor.inserisciAnagraficaMario();
        anagraficaDBPersistor.inserisciAnagraficaSofia();
        List<PolizzaDb> polizzeDiMarco = PolizzaDBMother.getListaPolizzeDiMarco();
        this.inserisciPolizze(polizzeDiMarco);
        return polizzeDiMarco;
    }

}
