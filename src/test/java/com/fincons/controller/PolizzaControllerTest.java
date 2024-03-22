package com.fincons.controller;

import com.fincons.db.entity.PolizzaDb;
import com.fincons.dominio.entity.Polizza;
import com.fincons.io.entity.Rapporto;
import com.fincons.mother.PolizzaMother;
import com.fincons.mother.RapportoMother;
import com.fincons.usecase.PolizzaUseCase;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.fincons.mother.AnagraficaMother.*;
import static com.fincons.mother.PolizzaDBMother.getListaPolizzeDiMarco;
import static com.fincons.mother.PolizzaMother.getPolizzeMarco;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PolizzaControllerTest {

    @InjectMocks
    private PolizzaController polizzaController;
    @Mock
    private PolizzaUseCase polizzaUseCase;

    @Test
    void dato_in_input_un_numero_di_polizza_dai_in_output_idContraente_associato(){
        when(polizzaUseCase.getIdContraente("111")).thenReturn(222);

        String actual = polizzaController.getIdContraente(111);

        assertThat(actual).isEqualTo("222");
    }


//    @Test
//    void dato_in_input_cf_output_polizze_con_figura(){
//        List<PolizzaDb> listaPolizzeDiMarco = getListaPolizzeDiMarco();
//        when(polizzaUseCase.getPolizzeByCF("3")).thenReturn(listaPolizzeDiMarco);
//
//        List<PolizzaDb> actual = polizzaController.getPolizzeByCF("3");
//
//        assertThat(actual).isEqualTo(listaPolizzeDiMarco);
//    }

    @Test
    void dato_in_input_cf_dai_in_output_polizze(){
        List<PolizzaDb> listaPolizzeDiMarco = getListaPolizzeDiMarco();
        when(polizzaUseCase.getPolizzeByCF("marco")).thenReturn(listaPolizzeDiMarco);

        List<PolizzaDb> actual = polizzaController.getPolizzeByCF("marco");

        assertThat(actual).isEqualTo(listaPolizzeDiMarco);
    }
    @Test
    @Disabled
    void dato_in_input_cf_dai_in_output_polizzeOutput(){
        when(polizzaUseCase.getPolizzaByCF("marco")).thenReturn(getPolizzeMarco());

        List<Rapporto> actual = polizzaController.getRapportiBy("marco");

        List<Rapporto> listaPolizzeDiMarco = RapportoMother.getListaRapportiMarco();
        assertThat(actual).isEqualTo(listaPolizzeDiMarco);
    }



}
