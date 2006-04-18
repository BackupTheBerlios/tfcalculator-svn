package be.benja.emcalculator.controller;

import javax.microedition.lcdui.Command;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

import be.benja.emcalculator.system.Initializer;
import be.benja.emcalculator.system.impl.StaticInitializerImpl;
import be.benja.microapp.em.Controller;

public class EMCalculatorLauncher  extends MIDlet {
	Controller controller;
	protected void startApp() throws MIDletStateChangeException {
		Initializer initializer = new StaticInitializerImpl();
		Controller controller = initializer.init();
		this.controller = controller;
		controller.control(Command.OK);
		
	}

	protected void pauseApp() {
		controller.control(Command.HELP);
	}

	protected void destroyApp(boolean arg0) throws MIDletStateChangeException {
		controller.control(Command.STOP);
		
	}
	

}
