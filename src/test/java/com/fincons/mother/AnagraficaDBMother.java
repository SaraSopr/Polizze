package com.fincons.mother;

import com.fincons.db.entity.AnagraficaDB;

public class AnagraficaDBMother {
    public static AnagraficaDB getAnagraficaMarco() {
        return new AnagraficaDB(3, "Marco", "Rossi", "marco", "M", "s", "m", "3", "3");
    }

    public static AnagraficaDB getAnagraficaMario() {
        return new AnagraficaDB(2, "Mario", "Verdi", "M", "M", "m", "3", "f", "4");
    }

    public static AnagraficaDB getAnagraficaSofia() {
        return new AnagraficaDB(1, "Sofia", "Gialli", "F","F", "m", "3", "3","4");
    }

    public static AnagraficaDB getAnagraficaAntonio() {
        return new AnagraficaDB(4, "Antonio", "Grigio", "antoniocf","M", "m", "3", "3","4");
    }

    public static AnagraficaDB getAnagraficaLuigi() {
        return new AnagraficaDB(5, "Luigi", "Blu", "luigicf","M", "m", "3", "3","4");
    }
}
