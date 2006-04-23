package be.benja.emcalculator.controller;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Display;

import be.benja.emcalculator.controller.beans.CompetitionListBean;




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
		else if(this.display.getCurrent() instanceof CompetitionListBean)
		{
			switch(status)
			{
			case Command.ITEM:
					display.setCurrent(backingBeanFactory.getBackingBean(ScreenName.SCREEN_2_newCompetition));
			}
		}
		

		
	}

}
