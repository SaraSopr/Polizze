package com.fincons.usecase;

import com.fincons.db.entity.AnagraficaDB;
import com.fincons.db.entity.PolizzaDb;
import com.fincons.dominio.entity.Polizza;
import com.fincons.mother.PolizzaDBMother;
import com.fincons.repository.AnagraficaRepository;
import com.fincons.repository.PolizzaRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;

import static com.fincons.mother.AnagraficaDBMother.*;
import static com.fincons.mother.AnagraficaMother.getMarco;
import static com.fincons.mother.PolizzaDBMother.getListaPolizzeDiMarco;
import static com.fincons.mother.PolizzaDBMother.getListaPolizzeDiMarco2;
import static com.fincons.mother.PolizzaMother.getPolizzeMarco;
import static com.fincons.mother.PolizzaMother.getPolizzeMarco2;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PolizzaUseCaseTest {

    @InjectMocks
    private PolizzaUseCase polizzaUseCase;
    @Mock
    private PolizzaRepository polizzaRepository;
    @Mock
    private AnagraficaRepository anagraficaRepository;

    @Test
    void getIdContraente() {

        PolizzaDb polizzaDb = PolizzaDBMother.getPolizza("111");
        when(polizzaRepository.findByNumeroPolizza("111")).thenReturn(polizzaDb);

        int actual = polizzaUseCase.getIdContraente("111");

        assertThat(actual).isEqualTo(1);
    }

    //usecase chiama i due repository e mette insieme le cose
    @Test
    void getPolizzeByCodiceFiscale() {
        getListaPolizzeDiMarco();
        AnagraficaDB anagraficaMarco = getAnagraficaMarco();
        when(anagraficaRepository.findIdAnagraficaByCF(anagraficaMarco.getCodiceFiscale())).thenReturn(anagraficaMarco);
        when(polizzaRepository.findPolizzeByIDAnagrafica(anagraficaMarco.getId())).thenReturn(getListaPolizzeDiMarco());

        List<PolizzaDb> actual = polizzaUseCase.getPolizzeByCF("marco");

        assertThat(actual).isEqualTo(getListaPolizzeDiMarco());
    }

//    @Test
//    void getPolizzeByCFAndReturnListOfPolizza(){
//        when(anagraficaRepository.findIdAnagraficaByCF("marco")).thenReturn(getAnagraficaMarco());
//        List<PolizzaDb> listaPolizzeDiMarco = getListaPolizzeDiMarco();
//        when(polizzaRepository.findPolizzeByIDAnagrafica(getMarco().getId())).thenReturn(listaPolizzeDiMarco);
//        when(anagraficaRepository.findByID(listaPolizzeDiMarco.get(0).getIdContraente())).thenReturn(getAnagraficaMarco());
//        when(anagraficaRepository.findByID(listaPolizzeDiMarco.get(0).getIdBeneficiario())).thenReturn(getAnagraficaMario());
//        when(anagraficaRepository.findByID(listaPolizzeDiMarco.get(0).getIdAssicurato())).thenReturn(getAnagraficaSofia());
//
//        List<Polizza> actual = polizzaUseCase.getPolizzaByCF("marco");
//
//        //solamente 3 accessi al db
//        verify(anagraficaRepository, times(1)).findByID(listaPolizzeDiMarco.get(0).getIdContraente());
//        verify(anagraficaRepository, times(1)).findByID(listaPolizzeDiMarco.get(0).getIdBeneficiario());
//        verify(anagraficaRepository, times(1)).findByID(listaPolizzeDiMarco.get(0).getIdAssicurato());
//        assertThat(actual).isEqualTo(getPolizzeMarco());
//    }

    @Test
    @Disabled
    void getPolizzeByCFAndReturnListOfPolizza2() {
    }
    }
//        when(anagraficaRepository.findIdAnagraficaByCF("marco")).thenReturn(getAnagraficaMarco());
//        List<PolizzaDb> listaPolizzeDiMarco = getListaPolizzeDiMarco2();
//        when(polizzaRepository.findPolizzeByIDAnagrafica(getMarco().getId())).thenReturn(listaPolizzeDiMarco);
//        when(anagraficaRepository.findByID(listaPolizzeDiMarco.get(0).getIdContraente())).thenReturn(getAnagraficaMarco());
//        when(anagraficaRepository.findByID(listaPolizzeDiMarco.get(0).getIdBeneficiario())).thenReturn(getAnagraficaMario());
//        when(anagraficaRepository.findByID(listaPolizzeDiMarco.get(0).getIdAssicurato())).thenReturn(getAnagraficaSofia());
//        when(anagraficaRepository.findByID(listaPolizzeDiMarco.get(2).getIdContraente())).thenReturn(getAnagraficaAntonio());
//        when(anagraficaRepository.findByID(listaPolizzeDiMarco.get(2).getIdAssicurato())).thenReturn(getAnagraficaLuigi());
//
//        List<Polizza> actual = polizzaUseCase.getPolizzaByCF("marco");
//
//        //solamente 3 accessi al db
//        verify(anagraficaRepository, times(1)).findByID(listaPolizzeDiMarco.get(0).getIdContraente());
//        verify(anagraficaRepository, times(1)).findByID(listaPolizzeDiMarco.get(0).getIdBeneficiario());
//        verify(anagraficaRepository, times(1)).findByID(listaPolizzeDiMarco.get(0).getIdAssicurato());
//        verify(anagraficaRepository, times(1)).findByID(listaPolizzeDiMarco.get(2).getIdContraente());
//        verify(anagraficaRepository, times(1)).findByID(listaPolizzeDiMarco.get(2).getIdAssicurato());
//        assertThat(actual).isEqualTo(getPolizzeMarco2());
//    }
