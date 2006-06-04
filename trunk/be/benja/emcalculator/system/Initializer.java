package be.benja.emcalculator.system;

import javax.microedition.lcdui.Display;
import be.benja.emcalculator.controller.Controller;
import be.benja.emcalculator.controller.exceptions.InitializationException;



public interface Initializer {
	public Controller init(Display display) throws InitializationException;

}
