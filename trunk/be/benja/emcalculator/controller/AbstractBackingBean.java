package be.benja.emcalculator.controller;

import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Form;

import be.benja.emcalculator.controller.i18n.EMI18N;
import be.benja.emcalculator.service.ControllerService;




public abstract class AbstractBackingBean extends Form implements CommandListener{

	private EMI18N emi18n;
	private Controller controller;
	public EMI18N getEmi18n() {
		return emi18n;
	}

	public void setEmi18n(EMI18N emi18n) {
		this.emi18n = emi18n;
	}

	public AbstractBackingBean(EMI18N emi18n,Controller controller, String name) {
		super(name);

		this.emi18n = emi18n;
		this.controller = controller;
		this.setCommandListener(this);
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}
	




}
