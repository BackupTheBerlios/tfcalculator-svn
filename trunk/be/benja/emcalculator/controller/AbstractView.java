package be.benja.emcalculator.controller;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;

import be.benja.emcalculator.controller.i18n.I18NTranslator;


public abstract class AbstractView extends Form implements CommandListener{

	private I18NTranslator emi18n;
	private Controller controller;
	public I18NTranslator getEmi18n() {
		return emi18n;
	}

	public void setEmi18n(I18NTranslator emi18n) {
		this.emi18n = emi18n;
	}

	public AbstractView(I18NTranslator emi18n,Controller controller, String name) {
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
