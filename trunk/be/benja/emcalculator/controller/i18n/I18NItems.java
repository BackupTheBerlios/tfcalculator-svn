package be.benja.emcalculator.controller.i18n;

import java.util.Hashtable;
public class I18NItems implements EMI18N{
	Hashtable table_FR;
	
	public static final String LOCALE_FR="FR";
	public static final String LOCALE_EN="EN";
	String locale;
	public I18NItems(String locale)
	{
		
	}
	
	public void setLocale(String locale)
	{
		this.locale = locale;
	}
	
	public String translate(String text)
	{
		if(locale.compareTo(LOCALE_FR)==0)
		{
		return get_FR(text);
		}
		else return get_FR(text);
	}
	
	public String get_FR(String text)
	{
		if(table_FR==null)
		{
			populate_FR();
		}
		Object result = table_FR.get(text);
		if(result==null)
		{
			return "PAS_TRADUIT";
		}
		return (String)result;
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

}
