package com.fincons.dominio.entity;

import com.fincons.db.entity.AnagraficaDB;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class Polizza {
    int id;
    String numeroPolizza;
    Anagrafica contraente;
    Anagrafica beneficiario;
    Anagrafica assicurato;


}
