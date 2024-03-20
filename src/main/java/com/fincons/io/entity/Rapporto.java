package com.fincons.io.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Value
public class Rapporto {
    String numeroPolizza;
    String nomeContraente;
    String cognomeContraente;
    String sessoContraente;
    String nomeBeneficiario;
    String cognomeBeneficiario;
    String sessoBeneficiario;
    String nomeAssicurato;
    String cognomeAssicurato;
    String sessoAssicurato;
}
