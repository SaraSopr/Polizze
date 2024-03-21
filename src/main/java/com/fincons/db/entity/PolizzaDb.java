package com.fincons.db.entity;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PolizzaDb {
    int id;
    String numeroPolizza;
    int idContraente;
    String contraenteUgualeAssicurato;
    int idAssicurato1;
    int idAssicurato2;
    int idBeneficiarioVita1;
    int idBeneficiarioVita2;
    int idBeneficiarioVita3;
    int idBeneficiarioVita4;
    int idBeneficiarioVita5;
    int idBeneficiarioMorte1;
    int idBeneficiarioMorte2;
    int idBeneficiarioMorte3;
    int idBeneficiarioMorte4;
    int idBeneficiarioMorte5;
    int idFondo;
    int idProdotto;
}
