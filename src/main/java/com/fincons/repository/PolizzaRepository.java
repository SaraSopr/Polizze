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
                                rs.getString("CONTRAENTEUGUALEASSICURATO"),
                                rs.getInt("ID_ASSICURATO1"),
                                rs.getInt("ID_ASSICURATO2"),
                                rs.getInt("ID_BENEFICIARIOVITA1"),
                                rs.getInt("ID_BENEFICIARIOVITA2"),
                                rs.getInt("ID_BENEFICIARIOVITA3"),
                                rs.getInt("ID_BENEFICIARIOVITA4"),
                                rs.getInt("ID_BENEFICIARIOVITA5"),
                                rs.getInt("ID_BENEFICIARIOMORTE1"),
                                rs.getInt("ID_BENEFICIARIOMORTE2"),
                                rs.getInt("ID_BENEFICIARIOMORTE3"),
                                rs.getInt("ID_BENEFICIARIOMORTE4"),
                                rs.getInt("ID_BENEFICIARIOMORTE5"),
                                rs.getInt("ID_FONDO"),
                                rs.getInt("ID_PRODOTTO")
                        )
        );
    }

    public void insertPolizza(PolizzaDb polizza) {
        jdbcTemplate.update("INSERT INTO polizza (id, numero_polizza, id_contraente,contraenteugualeassicurato,id_assicurato1,id_assicurato2,id_beneficiariovita1,id_beneficiariovita2,id_beneficiariovita3,id_beneficiariovita4,id_beneficiariovita5,id_beneficiariomorte1,id_beneficiariomorte2,id_beneficiariomorte3,id_beneficiariomorte4,id_beneficiariomorte5,id_fondo,id_prodotto) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                polizza.getId(),
                polizza.getNumeroPolizza(),
                polizza.getIdContraente(),
                polizza.getContraenteUgualeAssicurato(),
                polizza.getIdAssicurato1(),
                polizza.getIdAssicurato2(),
                polizza.getIdBeneficiarioVita1(),
                polizza.getIdBeneficiarioVita2(),
                polizza.getIdBeneficiarioVita3(),
                polizza.getIdBeneficiarioVita4(),
                polizza.getIdBeneficiarioVita5(),
                polizza.getIdBeneficiarioMorte1(),
                polizza.getIdBeneficiarioMorte2(),
                polizza.getIdBeneficiarioMorte3(),
                polizza.getIdBeneficiarioMorte4(),
                polizza.getIdBeneficiarioMorte5(),
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
                rs.getString("CONTRAENTEUGUALEASSICURATO"),
                rs.getInt("ID_ASSICURATO1"),
                rs.getInt("ID_ASSICURATO2"),
                rs.getInt("ID_BENEFICIARIOVITA1"),
                rs.getInt("ID_BENEFICIARIOVITA2"),
                rs.getInt("ID_BENEFICIARIOVITA3"),
                rs.getInt("ID_BENEFICIARIOVITA4"),
                rs.getInt("ID_BENEFICIARIOVITA5"),
                rs.getInt("ID_BENEFICIARIOMORTE1"),
                rs.getInt("ID_BENEFICIARIOMORTE2"),
                rs.getInt("ID_BENEFICIARIOMORTE3"),
                rs.getInt("ID_BENEFICIARIOMORTE4"),
                rs.getInt("ID_BENEFICIARIOMORTE5"),
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