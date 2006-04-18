package be.benja.emcalculator.system;

import javax.microedition.lcdui.Form;

import be.benja.emcalculator.controller.AbstractBackingBean;
import be.benja.emcalculator.service.ServiceLocator;
import be.benja.microapp.em.Controller;

public interface Initializer {
	public Controller init();

}
