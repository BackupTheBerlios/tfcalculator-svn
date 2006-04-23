package be.benja.emcalculator.controller;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Display;



public class EMCalculatorController implements Controller{
	Display display;
	BackingBeanFactory backingBeanFactory;
	public EMCalculatorController(BackingBeanFactory backingBeanFactory,Display display)
	{
		this.backingBeanFactory = backingBeanFactory;
		backingBeanFactory.setController(this);
		this.display = display;
	}
	public void control(int status) {
		if(display.getCurrent()==null)
		{
			display.setCurrent(backingBeanFactory.getBackingBean(ScreenName.SCREEN_1_competitionList));
		}
		else if(status==Command.OK)
		{
			display.setCurrent(backingBeanFactory.getBackingBean(ScreenName.SCREEN_1_competitionList));
		}

		
	}

}
