package com.fincons.db.entity;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PolizzaDb {
    int id;
    String numeroPolizza;
    int idContraente;
    int idAssicurato;
    int idBeneficiario;
}
