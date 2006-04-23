package be.benja.emcalculator.system.impl;

import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;

import be.benja.emcalculator.controller.BackingBeanFactory;
import be.benja.emcalculator.controller.Controller;
import be.benja.emcalculator.controller.EMCalculatorController;
import be.benja.emcalculator.controller.i18n.EMI18N;
import be.benja.emcalculator.controller.i18n.I18NItems;
import be.benja.emcalculator.service.ServiceLocator;
import be.benja.emcalculator.service.impl.ServiceLocatorStaticDatasImpl;
import be.benja.emcalculator.system.Initializer;


public class StaticInitializerImpl implements Initializer {

	public Controller init(Display display) {
		EMI18N emi18n = new I18NItems(System.getProperty("microedition.locale"));
		ServiceLocator serviceLocator = new ServiceLocatorStaticDatasImpl(emi18n);
		BackingBeanFactory backingBeanFactory = new BackingBeanFactory(serviceLocator,emi18n);
		Controller controller = new EMCalculatorController(backingBeanFactory,display);
		return controller;
	}


}
