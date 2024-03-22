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
    Anagrafica beneficiarioVita1;
    Anagrafica beneficiarioVita2;
    Anagrafica beneficiarioVita3;
    Anagrafica beneficiarioVita4;
    Anagrafica beneficiarioVita5;
    Anagrafica beneficiarioMorte1;
    Anagrafica beneficiarioMorte2;
    Anagrafica beneficiarioMorte3;
    Anagrafica beneficiarioMorte4;
    Anagrafica beneficiarioMorte5;
    Anagrafica assicurato1;
    Anagrafica assicurato2;
}
