package be.benja.emcalculator.controller;

import javax.microedition.lcdui.Display;

import be.benja.microapp.em.Controller;

public class EMCalculatorController implements Controller{
	Display display;
	BackingBeanFactory backingBeanFactory;
	public EMCalculatorController(BackingBeanFactory backingBeanFactory)
	{
		this.backingBeanFactory = backingBeanFactory;
		backingBeanFactory.setController(this);
	}
	public void control(int Status) {
		if(display==null)
		{
			display.setCurrent(backingBeanFactory.getBackingBean(ScreenName.SCREEN_1_competitionList));
		}
		
	}

}
