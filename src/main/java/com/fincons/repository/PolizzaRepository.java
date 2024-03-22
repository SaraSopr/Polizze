package com.fincons.repository;

import com.fincons.db.entity.PolizzaDb;
import com.fincons.usecase.PolizzaUseCase;
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
                                rs.getInt("IDBENEFICIARIOVITA1"),
                                rs.getInt("IDBENEFICIARIOVITA2"),
                                rs.getInt("IDBENEFICIARIOVITA3"),
                                rs.getInt("IDBENEFICIARIOVITA4"),
                                rs.getInt("IDBENEFICIARIOVITA5"),
                                rs.getInt("IDBENEFICIARIOMORTE1"),
                                rs.getInt("IDBENEFICIARIOMORTE2"),
                                rs.getInt("IDBENEFICIARIOMORTE3"),
                                rs.getInt("IDBENEFICIARIOMORTE4"),
                                rs.getInt("IDBENEFICIARIOMORTE5"),
                                rs.getInt("ID_FONDO"),
                                rs.getInt("ID_PRODOTTO")
                        )
        );
    }

    public void insertPolizza(PolizzaDb polizza) throws Exception {
        PolizzaUseCase.checkRispettoRequisiti(polizza);
        jdbcTemplate.update("INSERT INTO polizza (id, numero_polizza, id_contraente,contraenteugualeassicurato,id_assicurato1,id_assicurato2,idbeneficiariovita1,idbeneficiariovita2,idbeneficiariovita3,idbeneficiariovita4,idbeneficiariovita5,idbeneficiariomorte1,idbeneficiariomorte2,idbeneficiariomorte3,idbeneficiariomorte4,idbeneficiariomorte5,id_fondo,id_prodotto) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
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
        String query = "select * from polizza where ID_CONTRAENTE = '"+id+ "' or ID_ASSICURATO1 = '"+id +"' or ID_ASSICURATO2 = '"+id + "' or IDBENEFICIARIOVITA1 = '" + id+ "' or IDBENEFICIARIOVITA2 = '"+id + "' or IDBENEFICIARIOVITA3 = '"+id + "' or IDBENEFICIARIOVITA4 = '"+id + "' or IDBENEFICIARIOVITA5 = '"+id + "' or IDBENEFICIARIOMORTE1 = '"+id + "' or IDBENEFICIARIOMORTE2 = '"+id + "' or IDBENEFICIARIOMORTE3 = '"+id + "' or IDBENEFICIARIOMORTE4 = '"+id + "' or IDBENEFICIARIOMORTE5 = '"+id + "'";
        return jdbcTemplate.query(query, (rs, rowNum) -> new PolizzaDb(
                        rs.getInt("ID"),
                        rs.getString("NUMERO_POLIZZA"),
                        rs.getInt("ID_CONTRAENTE"),
                        rs.getString("CONTRAENTEUGUALEASSICURATO"),
                        rs.getInt("ID_ASSICURATO1"),
                        rs.getInt("ID_ASSICURATO2"),
                        rs.getInt("IDBENEFICIARIOVITA1"),
                        rs.getInt("IDBENEFICIARIOVITA2"),
                        rs.getInt("IDBENEFICIARIOVITA3"),
                        rs.getInt("IDBENEFICIARIOVITA4"),
                        rs.getInt("IDBENEFICIARIOVITA5"),
                        rs.getInt("IDBENEFICIARIOMORTE1"),
                        rs.getInt("IDBENEFICIARIOMORTE2"),
                        rs.getInt("IDBENEFICIARIOMORTE3"),
                        rs.getInt("IDBENEFICIARIOMORTE4"),
                        rs.getInt("IDBENEFICIARIOMORTE5"),
                        rs.getInt("ID_FONDO"),
                        rs.getInt("ID_PRODOTTO")
                )
        );
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