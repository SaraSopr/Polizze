package com.fincons.controller;

import com.fincons.usecase.PolizzaUseCase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Pippo {
        String aaa ;
        String idContraente;
    }
}
