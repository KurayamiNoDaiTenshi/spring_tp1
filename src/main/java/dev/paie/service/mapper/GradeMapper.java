package dev.paie.service.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dev.paie.entite.Grade;

public class GradeMapper implements RowMapper<Grade> {

	@Override
	public Grade mapRow(ResultSet rs, int rowNum) throws SQLException {
		Grade grade = new Grade();
		grade.setCode(rs.getString("code"));
		grade.setNbHeuresBase(rs.getBigDecimal("nbHeureBase"));
		grade.setTauxBase(rs.getBigDecimal("tauxBase"));
		return grade;
	}

}
