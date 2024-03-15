package com.example.Polizze.mother;

import com.example.Polizze.PolizzaDb;

public class PolizzaMother {
    public static PolizzaDb getPolizza(String number) {
        return new PolizzaDb(1, number, 2, 2, 2);
    }


}
