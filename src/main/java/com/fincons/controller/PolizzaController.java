package com.fincons.controller;

import com.fincons.db.entity.PolizzaDb;
import com.fincons.dominio.entity.Polizza;
import com.fincons.io.entity.Rapporto;
import com.fincons.usecase.PolizzaUseCase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("polizza")
public class PolizzaController {

    private final PolizzaUseCase polizzaUseCase;

    @GetMapping("/getContraente/{numeroPolizza}")
    public String getIdContraente(@PathVariable int numeroPolizza) {
        String numeroPolizzaInStringa = String.valueOf(numeroPolizza);
        int idContraente = polizzaUseCase.getIdContraente(numeroPolizzaInStringa);
        String idContraenteInStringa = String.valueOf(idContraente);
        return idContraenteInStringa;
    }

    @GetMapping("/getContraente1/{numeroPolizza}")
    public Pippo getIdContraente1(@PathVariable int numeroPolizza) {
        String numeroPolizzaInStringa = String.valueOf(numeroPolizza);
        int idContraente = polizzaUseCase.getIdContraente(numeroPolizzaInStringa);
        String idContraenteInStringa = String.valueOf(idContraente);
        return new Pippo("lol",idContraenteInStringa);
    }

    @GetMapping("/getPolizze/{codiceFiscale}")
    public List<PolizzaDb> getPolizzeByCF(@PathVariable String codiceFiscale) {
        List<PolizzaDb> polizze = polizzaUseCase.getPolizzeByCF(codiceFiscale);
        return polizze;
    }

    @GetMapping("/getRapporti/{codiceFiscale}")
    public List<Rapporto> getRapportiBy(@PathVariable String codiceFiscale) {
        List<Polizza> listaPolizze = polizzaUseCase.getPolizzaByCF(codiceFiscale);
        return map(listaPolizze);
    }

    public List<Rapporto> map(List<Polizza> listaPolizze) {
        List<Rapporto> listaRapporti = new ArrayList<>();
        for (Polizza polizza : listaPolizze) {
            Rapporto rapporto = new Rapporto(
                    polizza.getNumeroPolizza(),
                    polizza.getContraente().getNome(),
                    polizza.getContraente().getCognome(),
                    polizza.getContraente().getSesso(),
                    polizza.getBeneficiario().getNome(),
                    polizza.getBeneficiario().getCognome(),
                    polizza.getBeneficiario().getSesso(),
                    polizza.getAssicurato().getNome(),
                    polizza.getAssicurato().getCognome(),
                    polizza.getAssicurato().getSesso()
            );
            listaRapporti.add(rapporto);
        }
        return listaRapporti;
    }


    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Pippo {
        String aaa ;
        String idContraente;
    }
}
