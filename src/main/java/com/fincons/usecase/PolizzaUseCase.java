package com.fincons.usecase;

import com.fincons.db.entity.AnagraficaDB;
import com.fincons.db.entity.PolizzaDb;
import com.fincons.dominio.entity.Anagrafica;
import com.fincons.dominio.entity.Polizza;
import com.fincons.repository.AnagraficaRepository;
import com.fincons.repository.PolizzaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

@Service
@AllArgsConstructor
public class PolizzaUseCase {

    final PolizzaRepository polizzaRepository;
    final AnagraficaRepository anagraficaRepository;

    public static void checkRispettoRequisiti(PolizzaDb polizza) throws Exception {
        ArrayList<Integer> idBeneficiariVita = new ArrayList<>(Arrays.asList(polizza.getIdBeneficiarioVita1(), polizza.getIdBeneficiarioVita2(), polizza.getIdBeneficiarioVita3(), polizza.getIdBeneficiarioVita4(), polizza.getIdBeneficiarioVita5()));
        ArrayList<Integer> idBeneficiariMorte =  new ArrayList<>(Arrays.asList(polizza.getIdBeneficiarioMorte1(), polizza.getIdBeneficiarioMorte2(), polizza.getIdBeneficiarioMorte3(), polizza.getIdBeneficiarioMorte4(), polizza.getIdBeneficiarioMorte5()));
        idBeneficiariVita.removeIf(Objects::isNull);
        idBeneficiariMorte.removeIf(Objects::isNull);
        if(polizza.getIdAssicurato1() == polizza.getIdAssicurato2()){
            throw new Exception("Errore IdAssicurato1 uguale a IdAssicurato2");
        }
        checkDuplicates(idBeneficiariVita);
        checkDuplicates(idBeneficiariMorte);
        if(!idBeneficiariVita.isEmpty() && !idBeneficiariMorte.isEmpty()){
            throw new Exception("I beneficiari o tutti sono vita tutti sono morte");
        }
        if(idBeneficiariVita.contains(polizza.getIdAssicurato1()) || idBeneficiariVita.contains(polizza.getIdAssicurato2())){
            throw new Exception("Gli idBeneficiari sono uguali agli idAssicurati");
        }

        if(idBeneficiariVita.isEmpty() && idBeneficiariMorte.isEmpty()){
            throw new Exception("E' obbligatorio avere almeno un beneficiario");
        }


        switch (polizza.getContraenteUgualeAssicurato()){
            case "S":
                if((polizza.getIdAssicurato1() == polizza.getIdContraente()) || (polizza.getIdAssicurato2() == polizza.getIdContraente()) || (polizza.getIdAssicurato1() == null) || (polizza.getIdAssicurato2() == null)) {
                    throw new Exception("IdContraente uguale a IdAssicurato e idAssicurato deve essere vuoto");
                }
            case "N":
                if((polizza.getIdAssicurato1() == polizza.getIdContraente())){
                    throw new Exception("Il contraente non è diverso dall'assicurato1 e assicurato2");
                }

            default:
                if(polizza.getIdAssicurato1() == null || polizza.getIdAssicurato2() == null){
                    throw new Exception("Ci devono essere 2 assicurati");
                }
        }
    }

    public static void checkDuplicates(List < Integer > numbers) throws RuntimeException {
        numbers.removeIf(Objects::isNull);
        Set < Integer > uniqueNumbers = new HashSet < > ();
        for (Integer num: numbers) {
            if (uniqueNumbers.contains(num) && num != null) {
                throw new RuntimeException("Duplicate idBeneficiari: " + num);
            }
            uniqueNumbers.add(num);
        }
    }

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
        return null;
   }
//        if(anagraficaGiaPresente(mappaAnagrafica, polizzaDb.getIdContraente())) {
//            Anagrafica contraente = getAnagrafica(polizzaDb.getIdContraente());
//            mappaAnagrafica.put(polizzaDb.getIdContraente(), contraente);
//        }
//        if(anagraficaGiaPresente(mappaAnagrafica, polizzaDb.getIdBeneficiarioVita1())) {
//            Anagrafica beneficiario = getAnagrafica(polizzaDb.getIdBeneficiario());
//            mappaAnagrafica.put(polizzaDb.getIdBeneficiario(), beneficiario);
//        }
//        if(anagraficaGiaPresente(mappaAnagrafica, polizzaDb.getIdAssicurato())) {
//            Anagrafica assicurato = getAnagrafica(polizzaDb.getIdAssicurato());
//            mappaAnagrafica.put(polizzaDb.getIdAssicurato(), assicurato);
//        }
//        return new Polizza(
//                polizzaDb.getId(),
//                polizzaDb.getNumeroPolizza(),
//                mappaAnagrafica.get(polizzaDb.getIdContraente()),
//                mappaAnagrafica.get(polizzaDb.getIdBeneficiario()),
//                mappaAnagrafica.get(polizzaDb.getIdAssicurato())
//        );
//    }

    private static boolean anagraficaGiaPresente(HashMap<Integer, Anagrafica> map, int polizzaDb) {
        return !map.containsKey(polizzaDb);
    }

    private Anagrafica getAnagrafica(int idAnagrafica) {
        AnagraficaDB contraenteDB = anagraficaRepository.findByID(idAnagrafica);
        Anagrafica contraente = new Anagrafica(contraenteDB.getId(), contraenteDB.getNome(), contraenteDB.getCognome(), contraenteDB.getSesso());
        return contraente;
    }
}
