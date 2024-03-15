package com.fincons.usecase;

import com.fincons.db.entity.PolizzaDb;
import com.fincons.repository.PolizzaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PolizzaUseCase {

    final PolizzaRepository polizzaRepository;
    public int getIdContraente(String numeroPolizza) {
        PolizzaDb polizzaDb = polizzaRepository.findByNumeroPolizza(numeroPolizza);
        return polizzaDb.getIdContraente();
    }
}
