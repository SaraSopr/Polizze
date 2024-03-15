package com.fincons.usecase;

import com.fincons.db.entity.PolizzaDb;
import com.fincons.repository.PolizzaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PolizzaUseCaseTest {

    @InjectMocks
    private PolizzaUseCase polizzaUseCase;
    @Mock
    private PolizzaRepository polizzaRepository;

    @Test
    void getIdContraente() {

        PolizzaDb polizzaDb = new PolizzaDb(1,"111",222,333,444);
        when(polizzaRepository.findByNumeroPolizza("111")).thenReturn(polizzaDb);

        int actual = polizzaUseCase.getIdContraente("111");

        assertThat(actual).isEqualTo(222);
    }
}