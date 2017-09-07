package dev.paie.service;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.entite.Grade;
import dev.paie.spring.DataSourceMySQLConfig;
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DataSourceMySQLConfig.class)
public class GradeServiceJdbcTemplateTest {
	@Autowired private GradeService gradeService;
	@Before
	public void init() {
		gradeService.truncate();
	}
	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		Grade grade1 = new Grade("F001",new BigDecimal("151.87"),new BigDecimal("11.70"));
		gradeService.sauvegarder(grade1);
		List<Grade> listGrade = gradeService.lister();
		assertTrue(listGrade.contains(grade1));
	// TODO sauvegarder un nouveau grade
	// TODO vérifier qu'il est possible de récupérer le nouveau grade via la méthode lister
	// TODO modifier un grade
	// TODO vérifier que les modifications sont bien prises en compte via la méthode lister
	}
}
