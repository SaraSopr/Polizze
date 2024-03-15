package com.example.Polizze.repository;

import com.example.Polizze.PolizzaDb;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

@Repository
public class PolizzaRepository {

    private final JdbcTemplate jdbcTemplate;

    public PolizzaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<PolizzaDb> findAll() {
        return jdbcTemplate.query(
                "select * from polizza ",
                (rs, rowNum) ->
                        new PolizzaDb(
                                rs.getInt("ID"),
                                rs.getString("NUMERO_POLIZZA"),
                                rs.getInt("ID_CONTRAENTE"),
                                rs.getInt("ID_ASSICURATO"),
                                rs.getInt("ID_BENEFICIARIO")
                        )
        );
    }

    public void insert(PolizzaDb polizza) {
        jdbcTemplate.update("INSERT INTO polizza (numero_polizza, id_contraente,id_assicurato,id_beneficiario) VALUES (?, ?, ?, ?)",
                polizza.getNumeroPolizza(),
                polizza.getIdContraente(),
                polizza.getIdAssicurato(),
                polizza.getIdBeneficiario());
    }

    public void findPolizzaByNumber(String numeroDiPolizza) {

    }
}