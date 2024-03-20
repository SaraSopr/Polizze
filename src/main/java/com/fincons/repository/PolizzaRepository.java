package com.fincons.repository;

import com.fincons.db.entity.PolizzaDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

@Repository
public class PolizzaRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AnagraficaRepository anagraficaRepository;

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
                                rs.getInt("ID_BENEFICIARIO"),
                                rs.getInt("ID_FONDO"),
                                rs.getInt("ID_PRODOTTO")
                        )
        );
    }

    public void insertPolizza(PolizzaDb polizza) {
        jdbcTemplate.update("INSERT INTO polizza (id, numero_polizza, id_contraente,id_assicurato,id_beneficiario,id_fondo,id_prodotto) VALUES (?, ?, ?, ?, ?, ?, ?)",
                polizza.getId(),
                polizza.getNumeroPolizza(),
                polizza.getIdContraente(),
                polizza.getIdAssicurato(),
                polizza.getIdBeneficiario(),
                polizza.getIdFondo(),
                polizza.getIdProdotto());
    }

    public PolizzaDb findByNumeroPolizza(String numeroDiPolizza) {
        PolizzaDb polizzaDb = (PolizzaDb) jdbcTemplate.queryForObject("select * from polizza where NUMERO_POLIZZA = ? ",
                new Object[]{numeroDiPolizza}, new BeanPropertyRowMapper(PolizzaDb.class));
        return polizzaDb;
    }






    public List<PolizzaDb> findPolizzeByIDAnagrafica(int id) {
        String query = "select * from polizza where ID_CONTRAENTE = '"+id+ "' or ID_ASSICURATO = '"+id + "' or ID_BENEFICIARIO = '" + id+"'";
        return jdbcTemplate.query(query, (rs, rowNum) -> new PolizzaDb(
                rs.getInt("ID"),
                rs.getString("NUMERO_POLIZZA"),
                rs.getInt("ID_CONTRAENTE"),
                rs.getInt("ID_ASSICURATO"),
                rs.getInt("ID_BENEFICIARIO"),
                rs.getInt("ID_FONDO"),
                rs.getInt("ID_PRODOTTO")
        ));
    }

//    public List<Pol> findPolizzeBy(int id) {
//        String query = "select * from polizza where ID_CONTRAENTE = '"+id+ "' or ID_ASSICURATO = '"+id + "' or ID_BENEFICIARIO = '" + id+"'";
//        return jdbcTemplate.query(query, (rs, rowNum) -> new Polizza(
//                rs.getInt("ID"),
//                rs.getString("NUMERO_POLIZZA"),
//                anagraficaRepository.findIdAnagraficaBy(String.valueOf(rs.getInt("ID_CONTRAENTE"))),
//                anagraficaRepository.findIdAnagraficaBy(String.valueOf(rs.getInt("ID_BENEFICIARIO"))),
//                anagraficaRepository.findIdAnagraficaBy(String.valueOf(rs.getInt("ID_ASSICURATO")))
//        ));
//    }


}