package dev.paie.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.spring.JpaConfig;
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ServicesConfig.class,JpaConfig.class})
public class AvantageRepositoryTest {
	// TODO compléter la configuration
	@Autowired private AvantageRepository avantageRepository;
	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
	// TODO sauvegarder un nouvel avantage
	// TODO vérifier qu'il est possible de récupérer le nouvel avantage via la méthode findOne
	// TODO modifier un avantage
	// TODO vérifier que les modifications sont bien prises en compte via la méthode findOne
	}
	}
