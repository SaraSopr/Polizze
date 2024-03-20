package com.fincons.db.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnagraficaDB {
    int id;
    String nome;
    String cognome;
    String codiceFiscale;
    String sesso;
    String comuneDiResidenza;
    String provinciaDiResidenza;
    String viaDiResidenza;
    String numeroCivicoDiResidenza;
}
