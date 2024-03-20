package com.fincons.mother;

import com.fincons.dominio.entity.Anagrafica;
import com.fincons.dominio.entity.Polizza;

public class AnagraficaMother {

    public static Anagrafica getMarco() {
        return new Anagrafica(3, "Marco", "Rossi", "M");
    }

    public static Anagrafica getMario() {
        return new Anagrafica(2, "Mario", "Verdi", "M");
    }

    public static Anagrafica getSofia() {
        return new Anagrafica(1, "Sofia", "Gialli", "F");
    }

    public static Anagrafica getAntonio() {
        return new Anagrafica(4, "Antonio", "Grigio", "M");
    }

    public static Anagrafica getLuigi() {
        return new Anagrafica(5, "Luigi", "Blu", "M");
    }
}
