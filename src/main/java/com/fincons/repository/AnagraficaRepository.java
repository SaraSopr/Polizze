package com.fincons.repository;

import com.fincons.db.entity.AnagraficaDB;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AnagraficaRepository {
    private final JdbcOperations jdbcTemplate;

    public AnagraficaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public void insertAnagrafica(AnagraficaDB anagrafica) {
        jdbcTemplate.update("INSERT INTO anagrafica (id,CODICEFISCALE,nome,cognome,sesso,comunediresidenza,provinciadiresidenza,viadiresidenza,numerocivicodiresidenza) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
                anagrafica.getId(),
                anagrafica.getCodiceFiscale(),
                anagrafica.getNome(),
                anagrafica.getCognome(),
                anagrafica.getSesso(),
                anagrafica.getComuneDiResidenza(),
                anagrafica.getProvinciaDiResidenza(),
                anagrafica.getViaDiResidenza(),
                anagrafica.getNumeroCivicoDiResidenza());
    }
    public AnagraficaDB findIdAnagraficaByCF(String codiceFiscale) {
        return (AnagraficaDB) jdbcTemplate.queryForObject("select * from anagrafica where CODICEFISCALE = ? ",
                new Object[]{codiceFiscale.toString()}, new BeanPropertyRowMapper(AnagraficaDB.class));
    }


    public AnagraficaDB findByID(int id) {
        return (AnagraficaDB) jdbcTemplate.queryForObject("select * from anagrafica where id = ? ",
                new Object[]{id}, new BeanPropertyRowMapper(AnagraficaDB.class));
    }
}
