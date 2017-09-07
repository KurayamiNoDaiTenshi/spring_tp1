package dev.paie.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;
@Service
@Transactional
public class CotisationServiceJpa implements CotisationService {
	@PersistenceContext private EntityManager em;
	@Override
	public void sauvegarder(Cotisation nouvelleCotisation) {
		em.persist(nouvelleCotisation);
	}

	@Override
	public void mettreAJour(Cotisation cotisation) {
		Cotisation cot = findByCode(cotisation.getCode());
		cot.setLibelle(cotisation.getLibelle());
		cot.setTauxPatronal(cotisation.getTauxPatronal());
		cot.setTauxSalarial(cotisation.getTauxSalarial());
		
	}

	@Override
	public List<Cotisation> lister() {
		TypedQuery<Cotisation> query = em.createQuery("select c from Cotisation c", Cotisation.class);
		return new ArrayList<Cotisation>(query.getResultList());
	}

	@Override
	public Cotisation findByCode(String code) {
		TypedQuery<Cotisation> query = em.createQuery("select c from Cotisation c where c.code = :code",Cotisation.class);
		query.setParameter("code", code);
		return query.getSingleResult();
	}
}
