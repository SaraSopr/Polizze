package com.fincons.persistor;

import com.fincons.db.entity.AnagraficaDB;
import com.fincons.repository.AnagraficaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.fincons.mother.AnagraficaDBMother.*;

@Component
public class AnagraficaDBPersistor {
    @Autowired
    private AnagraficaRepository anagraficaRepository;

    public void inserisciAnagraficaMarco() {
        AnagraficaDB anagraficaDiMarco = getAnagraficaMarco();
        anagraficaRepository.insertAnagrafica(anagraficaDiMarco);
    }

    public void inserisciAnagraficaMario() {
        AnagraficaDB anagraficaDiMario = getAnagraficaMario();
        anagraficaRepository.insertAnagrafica(anagraficaDiMario);
    }

    public void inserisciAnagraficaSofia() {
        AnagraficaDB anagraficaDiSofia = getAnagraficaSofia();
        anagraficaRepository.insertAnagrafica(anagraficaDiSofia);
    }
}
