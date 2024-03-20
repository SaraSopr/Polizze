package com.fincons.dominio.entity;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class Anagrafica {
    int id;
    String nome;
    String cognome;
    String sesso;
}
