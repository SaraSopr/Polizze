package com.fincons.usecase;

import com.fincons.db.entity.AnagraficaDB;
import com.fincons.db.entity.PolizzaDb;
import com.fincons.dominio.entity.Polizza;
import com.fincons.mother.PolizzaDBMother;
import com.fincons.mother.PolizzaMother;
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
import static com.fincons.mother.PolizzaDBMother.getListaPolizzeDiMarco;
import static com.fincons.mother.PolizzaMother.getPolizzeMarco;
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

        PolizzaDb polizzaDb = PolizzaDBMother.getPolizza(2, "111");
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
    void getPolizzeByCFAndReturnListOfPolizza2() {
        when(anagraficaRepository.findIdAnagraficaByCF("marco")).thenReturn(getAnagraficaMarco());
        List<PolizzaDb> listaPolizzeDiMarco = getListaPolizzeDiMarco();
        when(polizzaRepository.findPolizzeByIDAnagrafica(getAnagraficaMarco().getId())).thenReturn(listaPolizzeDiMarco);
        when(anagraficaRepository.findByID(listaPolizzeDiMarco.get(0).getIdContraente())).thenReturn(getAnagraficaMarco());
        when(anagraficaRepository.findByID(listaPolizzeDiMarco.get(0).getIdBeneficiarioVita1())).thenReturn(getAnagraficaLuigi());
        when(anagraficaRepository.findByID(listaPolizzeDiMarco.get(0).getIdBeneficiarioVita2())).thenReturn(getAnagraficaAntonio());
        when(anagraficaRepository.findByID(listaPolizzeDiMarco.get(0).getIdBeneficiarioVita3())).thenReturn(getAnagraficaMario());
        when(anagraficaRepository.findByID(listaPolizzeDiMarco.get(0).getIdBeneficiarioVita4())).thenReturn(getAnagraficaMario());
        when(anagraficaRepository.findByID(listaPolizzeDiMarco.get(0).getIdBeneficiarioVita5())).thenReturn(getAnagraficaMario());
        when(anagraficaRepository.findByID(listaPolizzeDiMarco.get(0).getIdBeneficiarioMorte1())).thenReturn(getAnagraficaMario());
        when(anagraficaRepository.findByID(listaPolizzeDiMarco.get(0).getIdBeneficiarioMorte2())).thenReturn(getAnagraficaLuigi());
        when(anagraficaRepository.findByID(listaPolizzeDiMarco.get(0).getIdBeneficiarioMorte3())).thenReturn(getAnagraficaMario());
        when(anagraficaRepository.findByID(listaPolizzeDiMarco.get(0).getIdBeneficiarioMorte4())).thenReturn(getAnagraficaMario());
        when(anagraficaRepository.findByID(listaPolizzeDiMarco.get(0).getIdBeneficiarioMorte5())).thenReturn(getAnagraficaSofia());
        when(anagraficaRepository.findByID(listaPolizzeDiMarco.get(0).getIdAssicurato1())).thenReturn(getAnagraficaLuigi());
        when(anagraficaRepository.findByID(listaPolizzeDiMarco.get(0).getIdAssicurato2())).thenReturn(getAnagraficaSofia());
        when(anagraficaRepository.findByID(listaPolizzeDiMarco.get(1).getIdContraente())).thenReturn(getAnagraficaMarco());
        when(anagraficaRepository.findByID(listaPolizzeDiMarco.get(1).getIdBeneficiarioVita1())).thenReturn(getAnagraficaSofia());
        when(anagraficaRepository.findByID(listaPolizzeDiMarco.get(1).getIdBeneficiarioVita2())).thenReturn(getAnagraficaMario());
        when(anagraficaRepository.findByID(listaPolizzeDiMarco.get(1).getIdBeneficiarioVita3())).thenReturn(getAnagraficaMario());
        when(anagraficaRepository.findByID(listaPolizzeDiMarco.get(1).getIdBeneficiarioVita4())).thenReturn(getAnagraficaLuigi());
        when(anagraficaRepository.findByID(listaPolizzeDiMarco.get(1).getIdBeneficiarioVita5())).thenReturn(getAnagraficaAntonio());
        when(anagraficaRepository.findByID(listaPolizzeDiMarco.get(1).getIdBeneficiarioMorte1())).thenReturn(getAnagraficaMarco());
        when(anagraficaRepository.findByID(listaPolizzeDiMarco.get(1).getIdBeneficiarioMorte2())).thenReturn(getAnagraficaMario());
        when(anagraficaRepository.findByID(listaPolizzeDiMarco.get(1).getIdBeneficiarioMorte3())).thenReturn(getAnagraficaMarco());
        when(anagraficaRepository.findByID(listaPolizzeDiMarco.get(1).getIdBeneficiarioMorte4())).thenReturn(getAnagraficaSofia());
        when(anagraficaRepository.findByID(listaPolizzeDiMarco.get(1).getIdBeneficiarioMorte5())).thenReturn(getAnagraficaSofia());
        when(anagraficaRepository.findByID(listaPolizzeDiMarco.get(1).getIdAssicurato1())).thenReturn(getAnagraficaLuigi());
        when(anagraficaRepository.findByID(listaPolizzeDiMarco.get(1).getIdAssicurato2())).thenReturn(getAnagraficaMario());


        List<Polizza> actual = polizzaUseCase.getPolizzaByCF("marco");

        //solamente 3 accessi al db
        verify(anagraficaRepository, times(1)).findByID(listaPolizzeDiMarco.get(0).getIdContraente());
        verify(anagraficaRepository, times(1)).findByID(listaPolizzeDiMarco.get(0).getIdBeneficiarioVita1());
        verify(anagraficaRepository, times(1)).findByID(listaPolizzeDiMarco.get(0).getIdBeneficiarioVita2());
        verify(anagraficaRepository, times(1)).findByID(listaPolizzeDiMarco.get(0).getIdBeneficiarioVita3());
        verify(anagraficaRepository, times(1)).findByID(listaPolizzeDiMarco.get(0).getIdBeneficiarioVita4());
        verify(anagraficaRepository, times(1)).findByID(listaPolizzeDiMarco.get(0).getIdBeneficiarioVita5());
        verify(anagraficaRepository, times(1)).findByID(listaPolizzeDiMarco.get(0).getIdBeneficiarioMorte1());
        verify(anagraficaRepository, times(1)).findByID(listaPolizzeDiMarco.get(0).getIdBeneficiarioMorte2());
        verify(anagraficaRepository, times(1)).findByID(listaPolizzeDiMarco.get(0).getIdBeneficiarioMorte3());
        verify(anagraficaRepository, times(1)).findByID(listaPolizzeDiMarco.get(0).getIdBeneficiarioMorte4());
        verify(anagraficaRepository, times(1)).findByID(listaPolizzeDiMarco.get(0).getIdBeneficiarioMorte5());
        verify(anagraficaRepository, times(1)).findByID(listaPolizzeDiMarco.get(0).getIdAssicurato1());
        verify(anagraficaRepository, times(1)).findByID(listaPolizzeDiMarco.get(0).getIdAssicurato2());
        verify(anagraficaRepository, times(1)).findByID(listaPolizzeDiMarco.get(1).getIdContraente());
        verify(anagraficaRepository, times(1)).findByID(listaPolizzeDiMarco.get(1).getIdBeneficiarioVita1());
        verify(anagraficaRepository, times(1)).findByID(listaPolizzeDiMarco.get(1).getIdBeneficiarioVita2());
        verify(anagraficaRepository, times(1)).findByID(listaPolizzeDiMarco.get(1).getIdBeneficiarioVita3());
        verify(anagraficaRepository, times(1)).findByID(listaPolizzeDiMarco.get(1).getIdBeneficiarioVita4());
        verify(anagraficaRepository, times(1)).findByID(listaPolizzeDiMarco.get(1).getIdBeneficiarioVita5());
        verify(anagraficaRepository, times(1)).findByID(listaPolizzeDiMarco.get(1).getIdBeneficiarioMorte1());
        verify(anagraficaRepository, times(1)).findByID(listaPolizzeDiMarco.get(1).getIdBeneficiarioMorte2());
        verify(anagraficaRepository, times(1)).findByID(listaPolizzeDiMarco.get(1).getIdBeneficiarioMorte3());
        verify(anagraficaRepository, times(1)).findByID(listaPolizzeDiMarco.get(1).getIdBeneficiarioMorte4());
        verify(anagraficaRepository, times(1)).findByID(listaPolizzeDiMarco.get(1).getIdBeneficiarioMorte5());
        verify(anagraficaRepository, times(1)).findByID(listaPolizzeDiMarco.get(1).getIdAssicurato1());
        verify(anagraficaRepository, times(1)).findByID(listaPolizzeDiMarco.get(1).getIdAssicurato2());
        assertThat(actual).isEqualTo(getPolizzeMarco());
    }
}