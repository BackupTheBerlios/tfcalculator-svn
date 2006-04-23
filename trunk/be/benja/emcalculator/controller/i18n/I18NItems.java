package be.benja.emcalculator.controller.i18n;

import java.util.Hashtable;
public class I18NItems implements EMI18N{
	Hashtable table_FR;
	Hashtable table_EN;
	Hashtable table_NL;
	
	public static final String LOCALE_FR="FR";
	public static final String LOCALE_EN="EN";
	public static final String LOCALE_NL="NL";
	String locale;
	
	public I18NItems(String locale)
	{
		setLocale(locale);
		populate_FR();
		populate_EN();
		populate_NL();
	}
	
	public void setLocale(String locale)
	{
		this.locale = locale;
	}
	
	public String translate(String text)
	{
		String traducted = null;
		if(locale.compareTo(LOCALE_FR)==0)
		{
			traducted = (String)table_FR.get(text);
		}
		else if(locale.compareTo(LOCALE_NL)==0)
		{
			traducted = (String)table_NL.get(text);
		}
		if(locale.compareTo(LOCALE_EN)==0)
		{
			traducted = (String)table_EN.get(text);
		}
		else traducted = (String)table_FR.get(text);
		
		if(traducted==null)
		{
			return text;
		}
		else
		{
			return traducted;
		}
	}
	
	private void populate_FR() {
		table_FR = new Hashtable();
		
		table_FR.put("KEY_category","Catégorie");
		table_FR.put("KEY_continue","Continuer");
		table_FR.put("100m","100m");
		table_FR.put("long","longueur");
		table_FR.put("poids","poids");
		table_FR.put("haut","hauteur");
		table_FR.put("400m","400m");
		table_FR.put("110mh","110mh");
		table_FR.put("disq","disque");
		table_FR.put("perch","perche");
		table_FR.put("jav","javelot");
		table_FR.put("1500m","1500m");
	}
	
	private void populate_NL() {
		table_NL = new Hashtable();
	}
	
	private void populate_EN() {
		table_EN = new Hashtable();
	}

}
