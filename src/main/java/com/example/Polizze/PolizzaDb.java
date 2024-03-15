package com.example.Polizze;


import lombok.Value;

@Value
public class PolizzaDb {
    int id;
    String numeroPolizza;
    int idContraente;
    int idAssicurato;
    int idBeneficiario;
}
