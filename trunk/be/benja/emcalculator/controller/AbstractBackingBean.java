package be.benja.emcalculator.controller;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;

import be.benja.emcalculator.controller.i18n.EMI18N;
import be.benja.emcalculator.service.ServiceLocator;




public abstract class AbstractBackingBean extends Form implements CommandListener{

	private ServiceLocator serviceLocator;
	private EMI18N emi18n;
	private Controller controller;
	public EMI18N getEmi18n() {
		return emi18n;
	}

	public void setEmi18n(EMI18N emi18n) {
		this.emi18n = emi18n;
	}

	public void setServiceLocator(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}

	public AbstractBackingBean(ServiceLocator serviceLocator, EMI18N emi18n,Controller controller, String name) {
		super(name);
		this.serviceLocator = serviceLocator;
		this.emi18n = emi18n;
	}
	
	public ServiceLocator getServiceLocator()
	{
		return serviceLocator;
	}
	
	public abstract void refresh();

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}
	




}
