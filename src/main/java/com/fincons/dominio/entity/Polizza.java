package com.fincons.dominio.entity;

import lombok.Value;

@Value
public class Polizza {
    private final String numeroPolizza;
    private final int idConatraente;
    private final int idAssicurato;
    private final int idBeneficiario;
}
