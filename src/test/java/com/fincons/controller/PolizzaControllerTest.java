package com.fincons.controller;

import com.fincons.usecase.PolizzaUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

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

}
