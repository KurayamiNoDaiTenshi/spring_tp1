package dev.paie.service.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dev.paie.entite.Cotisation;

public class CotisationMapper implements RowMapper<Cotisation> {

	@Override
	public Cotisation mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cotisation cot = new Cotisation();
		cot.setCode(rs.getString("code"));
		cot.setId(rs.getInt("id"));
		cot.setLibelle(rs.getString("libelle"));
		cot.setTauxSalarial(rs.getBigDecimal("tauxSalarial"));
		cot.setTauxPatronal(rs.getBigDecimal("tauxPatronal"));
		return cot;
	}

}
