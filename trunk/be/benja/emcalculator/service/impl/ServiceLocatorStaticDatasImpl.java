package be.benja.emcalculator.service.impl;

import java.util.Vector;

import javax.microedition.lcdui.Choice;
import javax.microedition.lcdui.ChoiceGroup;

import be.benja.emcalculator.controller.i18n.EMI18N;
import be.benja.emcalculator.datas.MultiEventDatas;
import be.benja.emcalculator.datas.impl.MultiEventDatasImpl;
import be.benja.emcalculator.model.MultiEvent;
import be.benja.emcalculator.service.ServiceLocator;

public class ServiceLocatorStaticDatasImpl implements ServiceLocator {

	MultiEventDatas multiEventDatas = new MultiEventDatasImpl();
	EMI18N emi18N;
	public ServiceLocatorStaticDatasImpl(EMI18N emi18N)
	{
		this.emi18N = emi18N;

	}
	public ChoiceGroup getCompetitionList() {
		return null;
	}
	
	public ChoiceGroup getMultiEventList() {
		return getChoiceGroup(multiEventDatas.getMultiEventList());
	}
	
	private ChoiceGroup getChoiceGroup(Vector vector)
	{
		
		if(vector!=null&&vector.elementAt(0)!=null)
		{
			if(vector.elementAt(0) instanceof MultiEvent)
			{
				ChoiceGroup choiceGroup = new ChoiceGroup(emi18N.translate("multieventlist_key"),Choice.EXCLUSIVE);
				for(int i =0; i<vector.size();i++)
				{
					MultiEvent multiEvent = (MultiEvent) vector.elementAt(i);
					choiceGroup.append(emi18N.translate(multiEvent.getName())+" "+emi18N.translate(multiEvent.getCategory())+" "+emi18N.translate(multiEvent.getGender()),null);
				}
				return choiceGroup;
			}
		}
		return new ChoiceGroup(emi18N.translate("unknownlist_key"),Choice.EXCLUSIVE);
	}

}
