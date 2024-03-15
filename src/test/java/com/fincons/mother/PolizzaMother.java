package com.fincons.mother;

import com.fincons.db.entity.PolizzaDb;

public class PolizzaMother {
    public static PolizzaDb getPolizza(String number) {
        return new PolizzaDb(1, number, 2, 2, 2);
    }


}
