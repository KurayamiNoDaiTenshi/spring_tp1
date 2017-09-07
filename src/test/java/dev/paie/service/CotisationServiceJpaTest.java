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

import dev.paie.entite.Cotisation;
import dev.paie.spring.JpaConfig;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = JpaConfig.class)
public class CotisationServiceJpaTest {
	private static Cotisation cot, cot2;
	private static List<Cotisation> list;
	@Autowired
	private CotisationService cotisationService;

	@Before
	public void init() {
		cot = new Cotisation();
		cot2 = new Cotisation();
	}

	@Test
	public void test_sauvegarder() {
		cot.setCode("nope");
		cot.setLibelle("nope");
		cot.setTauxPatronal(new BigDecimal("66.66"));
		cot.setTauxSalarial(new BigDecimal("0.0"));
		cotisationService.sauvegarder(cot);
		list = cotisationService.lister();
		assertTrue(list.contains(cot));
	}

	@Test
	public void test_maj() {
		cot2.setCode("nope2");
		cot2.setLibelle("nope");
		cot2.setTauxPatronal(new BigDecimal("66.66"));
		cot2.setTauxSalarial(new BigDecimal("0.0"));
		cotisationService.sauvegarder(cot2);
		cot2.setLibelle("Cotisation standard");
		cot2.setTauxPatronal(new BigDecimal("33.3"));
		cot2.setTauxSalarial(new BigDecimal("33.3"));
		cotisationService.mettreAJour(cot2);
		list = cotisationService.lister();
		assertTrue(list.contains(cot2));
	}

	@Test
	public void test_lister() {
		cot.setCode("nope");
		cot.setLibelle("nope");
		cot.setTauxPatronal(new BigDecimal("66.66"));
		cot.setTauxSalarial(new BigDecimal("0.0"));
		cot2.setCode("nope2");
		cot2.setLibelle("Cotisation standard");
		cot2.setTauxPatronal(new BigDecimal("33.3"));
		cot2.setTauxSalarial(new BigDecimal("33.3"));
		list = cotisationService.lister();
		assertTrue(list.contains(cot));
		assertTrue(list.contains(cot2));
		assertTrue(list.size() == 2);
	}
}
