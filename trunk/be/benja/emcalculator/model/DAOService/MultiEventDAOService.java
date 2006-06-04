package be.benja.emcalculator.model.DAOService;

import java.util.Vector;

import be.benja.emcalculator.model.MultiEvent;

public interface MultiEventDAOService {
	public MultiEvent load(String id);
	public Vector loadAll();
	

}
