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
                    polizza.getBeneficiarioVita1().getNome(),
                    polizza.getBeneficiarioVita1().getCognome(),
                    polizza.getBeneficiarioVita1().getSesso(),
                    polizza.getBeneficiarioVita2().getNome(),
                    polizza.getBeneficiarioVita2().getCognome(),
                    polizza.getBeneficiarioVita2().getSesso(),
                    polizza.getBeneficiarioVita3().getNome(),
                    polizza.getBeneficiarioVita3().getCognome(),
                    polizza.getBeneficiarioVita3().getSesso(),
                    polizza.getBeneficiarioVita4().getNome(),
                    polizza.getBeneficiarioVita4().getCognome(),
                    polizza.getBeneficiarioVita4().getSesso(),
                    polizza.getBeneficiarioVita5().getNome(),
                    polizza.getBeneficiarioVita5().getCognome(),
                    polizza.getBeneficiarioVita5().getSesso(),
                    polizza.getBeneficiarioMorte1().getNome(),
                    polizza.getBeneficiarioMorte1().getCognome(),
                    polizza.getBeneficiarioMorte1().getSesso(),
                    polizza.getBeneficiarioMorte2().getNome(),
                    polizza.getBeneficiarioMorte2().getCognome(),
                    polizza.getBeneficiarioMorte2().getSesso(),
                    polizza.getBeneficiarioMorte3().getNome(),
                    polizza.getBeneficiarioMorte3().getCognome(),
                    polizza.getBeneficiarioMorte3().getSesso(),
                    polizza.getBeneficiarioMorte4().getNome(),
                    polizza.getBeneficiarioMorte4().getCognome(),
                    polizza.getBeneficiarioMorte4().getSesso(),
                    polizza.getBeneficiarioMorte5().getNome(),
                    polizza.getBeneficiarioMorte5().getCognome(),
                    polizza.getBeneficiarioMorte5().getSesso(),
                    polizza.getAssicurato1().getNome(),
                    polizza.getAssicurato1().getCognome(),
                    polizza.getAssicurato1().getSesso(),
                    polizza.getAssicurato2().getNome(),
                    polizza.getAssicurato2().getCognome(),
                    polizza.getAssicurato2().getSesso()
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
