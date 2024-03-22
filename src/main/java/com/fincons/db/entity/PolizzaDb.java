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
    Integer idAssicurato1;
    Integer idAssicurato2;
    Integer idBeneficiarioVita1;
    Integer idBeneficiarioVita2;
    Integer idBeneficiarioVita3;
    Integer idBeneficiarioVita4;
    Integer idBeneficiarioVita5;
    Integer idBeneficiarioMorte1;
    Integer idBeneficiarioMorte2;
    Integer idBeneficiarioMorte3;
    Integer idBeneficiarioMorte4;
    Integer idBeneficiarioMorte5;
    int idFondo;
    int idProdotto;
}
