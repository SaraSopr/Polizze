package com.fincons.mother;

import com.fincons.db.entity.PolizzaDb;

import java.util.List;

import static java.util.Arrays.asList;


public class PolizzaDBMother {
    public static PolizzaDb getPolizza(int id, String number) {
        return new PolizzaDb(id, number, 1, "N", 3, 4, 5, 6, null, null, null,null, null, null, null, null, 0, 0);
    }

    public static List<PolizzaDb> getListaPolizzeDiMarco() {
          PolizzaDb polizzaDiMarcoEAntonio = new PolizzaDb(90, "1", 3, "N", 2, 1, 3, 4, 5, 6, 5, 6, 7,8, 3, 666,  0, 0);
          PolizzaDb polizzaDiMarcoEMario = new PolizzaDb(100, "2", 3, "N",2, 1, 3, 4, 5, 6, 5, 6, 7,8, 3, 666,  0, 0);
          List<PolizzaDb> listaPolizzeDiMarco = asList(polizzaDiMarcoEAntonio, polizzaDiMarcoEMario);
          return listaPolizzeDiMarco;

    }

    public static List<PolizzaDb> getListaPolizzeDiMarco2() {
//        PolizzaDb polizzaDiMarcoEMarioESofia = new PolizzaDb(90, "1", 3, 2, 1, 0, 0);
//        PolizzaDb polizzaDiMarcoEMario = new PolizzaDb(100, "2", 3, 1, 2, 0, 0);
//        PolizzaDb polizzaDiAntonioELuigiEMarco = new PolizzaDb(200, "3", 4, 5, 3, 0, 0);
//        List<PolizzaDb> listaPolizzeDiMarco = asList(polizzaDiMarcoEMarioESofia, polizzaDiMarcoEMario, polizzaDiAntonioELuigiEMarco);
        return null;
    }


}
