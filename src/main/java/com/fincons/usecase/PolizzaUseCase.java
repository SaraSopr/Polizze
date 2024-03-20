package com.fincons.usecase;

import com.fincons.db.entity.AnagraficaDB;
import com.fincons.db.entity.PolizzaDb;
import com.fincons.dominio.entity.Anagrafica;
import com.fincons.dominio.entity.Polizza;
import com.fincons.repository.AnagraficaRepository;
import com.fincons.repository.PolizzaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PolizzaUseCase {

    final PolizzaRepository polizzaRepository;
    final AnagraficaRepository anagraficaRepository;
    public int getIdContraente(String numeroPolizza) {
        PolizzaDb polizzaDb = polizzaRepository.findByNumeroPolizza(numeroPolizza);
        return polizzaDb.getIdContraente();
    }

    public List<PolizzaDb> getPolizzeByCF(String codiceFiscale) {
        AnagraficaDB anagrafica = anagraficaRepository.findIdAnagraficaByCF(codiceFiscale);
        List<PolizzaDb> polizze = polizzaRepository.findPolizzeByIDAnagrafica(anagrafica.getId());
        return polizze;
    }

    public List<Polizza> getPolizzaByCF(String codiceFiscale) {
        AnagraficaDB anagraficaDB = anagraficaRepository.findIdAnagraficaByCF(codiceFiscale);
        List<PolizzaDb> polizzaDbList = polizzaRepository.findPolizzeByIDAnagrafica(anagraficaDB.getId());
        HashMap<Integer, Anagrafica> mappaAnagrafiche = new HashMap<>();
        return polizzaDbList.stream().map(polizzaDb -> map(polizzaDb, mappaAnagrafiche)).collect(Collectors.toList());
    }

    private Polizza map(PolizzaDb polizzaDb, HashMap<Integer, Anagrafica> mappaAnagrafica) {
        if(anagraficaGiaPresente(mappaAnagrafica, polizzaDb.getIdContraente())) {
            Anagrafica contraente = getAnagrafica(polizzaDb.getIdContraente());
            mappaAnagrafica.put(polizzaDb.getIdContraente(), contraente);
        }
        if(anagraficaGiaPresente(mappaAnagrafica, polizzaDb.getIdBeneficiario())) {
            Anagrafica beneficiario = getAnagrafica(polizzaDb.getIdBeneficiario());
            mappaAnagrafica.put(polizzaDb.getIdBeneficiario(), beneficiario);
        }
        if(anagraficaGiaPresente(mappaAnagrafica, polizzaDb.getIdAssicurato())) {
            Anagrafica assicurato = getAnagrafica(polizzaDb.getIdAssicurato());
            mappaAnagrafica.put(polizzaDb.getIdAssicurato(), assicurato);
        }
        return new Polizza(
                polizzaDb.getId(),
                polizzaDb.getNumeroPolizza(),
                mappaAnagrafica.get(polizzaDb.getIdContraente()),
                mappaAnagrafica.get(polizzaDb.getIdBeneficiario()),
                mappaAnagrafica.get(polizzaDb.getIdAssicurato())
        );
    }

    private static boolean anagraficaGiaPresente(HashMap<Integer, Anagrafica> map, int polizzaDb) {
        return !map.containsKey(polizzaDb);
    }

    private Anagrafica getAnagrafica(int idAnagrafica) {
        AnagraficaDB contraenteDB = anagraficaRepository.findByID(idAnagrafica);
        Anagrafica contraente = new Anagrafica(contraenteDB.getId(), contraenteDB.getNome(), contraenteDB.getCognome(), contraenteDB.getSesso());
        return contraente;
    }
}
