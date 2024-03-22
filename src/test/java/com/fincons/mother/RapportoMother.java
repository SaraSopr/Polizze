package com.fincons.mother;

import com.fincons.io.entity.Rapporto;

import java.util.List;

import static java.util.Arrays.asList;

public class RapportoMother {
    public static Rapporto getRapportoMarcoContraenteEMarioBeneficiario(){

        return new Rapporto("1",
                AnagraficaMother.getMarco().getNome(),
                AnagraficaMother.getMarco().getCognome(),
                AnagraficaMother.getMarco().getSesso(),
                AnagraficaMother.getMario().getNome(),
                AnagraficaMother.getMario().getCognome(),
                AnagraficaMother.getMario().getSesso(),
                AnagraficaMother.getSofia().getNome(),
                AnagraficaMother.getSofia().getCognome(),
                AnagraficaMother.getSofia().getSesso(),
                AnagraficaMother.getMario().getNome(),
                AnagraficaMother.getMario().getCognome(),
                AnagraficaMother.getMario().getSesso(),
                AnagraficaMother.getMario().getNome(),
                AnagraficaMother.getMario().getCognome(),
                AnagraficaMother.getMario().getSesso(),
                AnagraficaMother.getMario().getNome(),
                AnagraficaMother.getMario().getCognome(),
                AnagraficaMother.getMario().getSesso(),
                AnagraficaMother.getMario().getNome(),
                AnagraficaMother.getMario().getCognome(),
                AnagraficaMother.getMario().getSesso(),
                AnagraficaMother.getMario().getNome(),
                AnagraficaMother.getMario().getCognome(),
                AnagraficaMother.getMario().getSesso(),
                AnagraficaMother.getMario().getNome(),
                AnagraficaMother.getMario().getCognome(),
                AnagraficaMother.getMario().getSesso(),
                AnagraficaMother.getMario().getNome(),
                AnagraficaMother.getMario().getCognome(),
                AnagraficaMother.getMario().getSesso(),
                AnagraficaMother.getMario().getNome(),
                AnagraficaMother.getMario().getCognome(),
                AnagraficaMother.getMario().getSesso(),
                AnagraficaMother.getMario().getNome(),
                AnagraficaMother.getMario().getCognome(),
                AnagraficaMother.getMario().getSesso(),
                AnagraficaMother.getMario().getNome(),
                AnagraficaMother.getMario().getCognome(),
                AnagraficaMother.getMario().getSesso());


    }

    public static Rapporto getRapportoMarcoContraenteAndSofiaBeneficiario(){

        return new Rapporto("1",
                AnagraficaMother.getMarco().getNome(),
                AnagraficaMother.getMarco().getCognome(),
                AnagraficaMother.getMarco().getSesso(),
                AnagraficaMother.getMario().getNome(),
                AnagraficaMother.getMario().getCognome(),
                AnagraficaMother.getMario().getSesso(),
                AnagraficaMother.getSofia().getNome(),
                AnagraficaMother.getSofia().getCognome(),
                AnagraficaMother.getSofia().getSesso(),
                AnagraficaMother.getMario().getNome(),
                AnagraficaMother.getMario().getCognome(),
                AnagraficaMother.getMario().getSesso(),
                AnagraficaMother.getMario().getNome(),
                AnagraficaMother.getMario().getCognome(),
                AnagraficaMother.getMario().getSesso(),
                AnagraficaMother.getMario().getNome(),
                AnagraficaMother.getMario().getCognome(),
                AnagraficaMother.getMario().getSesso(),
                AnagraficaMother.getMario().getNome(),
                AnagraficaMother.getMario().getCognome(),
                AnagraficaMother.getMario().getSesso(),
                AnagraficaMother.getMario().getNome(),
                AnagraficaMother.getMario().getCognome(),
                AnagraficaMother.getMario().getSesso(),
                AnagraficaMother.getMario().getNome(),
                AnagraficaMother.getMario().getCognome(),
                AnagraficaMother.getMario().getSesso(),
                AnagraficaMother.getMario().getNome(),
                AnagraficaMother.getMario().getCognome(),
                AnagraficaMother.getMario().getSesso(),
                AnagraficaMother.getMario().getNome(),
                AnagraficaMother.getMario().getCognome(),
                AnagraficaMother.getMario().getSesso(),
                AnagraficaMother.getMario().getNome(),
                AnagraficaMother.getMario().getCognome(),
                AnagraficaMother.getMario().getSesso(),
                AnagraficaMother.getMario().getNome(),
                AnagraficaMother.getMario().getCognome(),
                AnagraficaMother.getMario().getSesso());

    }

    public static List<Rapporto> getListaRapportiMarco() {
        return asList(getRapportoMarcoContraenteEMarioBeneficiario(), getRapportoMarcoContraenteAndSofiaBeneficiario());
    }
}
