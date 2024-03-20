package com.fincons.mother;

import com.fincons.db.entity.PolizzaDb;
import com.fincons.dominio.entity.Polizza;

import java.util.List;

import static com.fincons.mother.AnagraficaMother.*;
import static java.util.Arrays.asList;

public class PolizzaMother {
    public static Polizza getPolizza(String number) {
        return new Polizza(1, number, getMarco(), getMario(), getSofia());
    }

    public static List<Polizza> getPolizzeMarco() {
        return asList(new Polizza(90, "1", getMarco(), getMario(), getSofia()),
                new Polizza(100, "2", getMarco(), getSofia(), getMario()));
    }

    public static List<Polizza> getPolizzeMarco2() {
        return asList(new Polizza(90, "1", getMarco(), getMario(), getSofia()),
                new Polizza(100, "2", getMarco(), getSofia(), getMario()),
                new Polizza(200, "3", getAntonio(), getMarco(), getLuigi()));
    }
}
