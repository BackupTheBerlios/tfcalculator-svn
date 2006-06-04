package be.benja.emcalculator.model.DAOService;

import java.util.Vector;

import be.benja.emcalculator.model.Competition;


public interface CompetitionDAOService {
	public Vector loadAll();
	public Competition load(String id);
	public void saveOrUpdate(Competition competition);

}
