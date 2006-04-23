package be.benja.emcalculator.system;

import javax.microedition.lcdui.Display;
import be.benja.emcalculator.controller.Controller;



public interface Initializer {
	public Controller init(Display display);

}
