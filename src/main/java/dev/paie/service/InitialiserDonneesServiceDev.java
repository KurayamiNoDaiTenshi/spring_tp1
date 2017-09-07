package dev.paie.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
// Import de la configuration XML dans une configuration Java
@ImportResource({ "classpath:cotisations-imposables.xml", "classpath:cotisations-non-imposables.xml","classpath:entreprises.xml", "classpath:grades.xml", "classpath:profils-remuneration.xml" })
@ComponentScan({ "dev" })
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {

	@Override
	public void initialiser() {
		// TODO Auto-generated method stub

	}

}