package dev.paie.service;

import java.util.List;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import dev.paie.entite.Grade;
import dev.paie.service.mapper.GradeMapper;
@Service
public class GradeServiceJdbcTemplate implements GradeService {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public GradeServiceJdbcTemplate(DataSource dataSource) {
		super();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void sauvegarder(Grade nouveauGrade) {
		String sql = "Insert into Grade(code,nbHeureBase,tauxBase) Values(?,?,?)";
		jdbcTemplate.update(sql, nouveauGrade.getCode(), nouveauGrade.getNbHeuresBase(),nouveauGrade.getTauxBase());

	}

	@Override
	public void mettreAJour(Grade grade) {
		String sql = "Update Grade set nbHeureBase = ?, tauxBase = ? where code = ?";
		jdbcTemplate.update(sql,grade.getNbHeuresBase(),grade.getTauxBase(),grade.getCode());

	}

	@Override
	public List<Grade> lister() {
		String sql = "select * from Grade";
		return jdbcTemplate.query(sql,new GradeMapper());
	}

	@Override
	public void truncate() {
		jdbcTemplate.execute("truncate table Grade");
		
	}

}
