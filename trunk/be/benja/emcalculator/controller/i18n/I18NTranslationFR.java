package be.benja.emcalculator.controller.i18n;

import java.util.Hashtable;

public class I18NTranslationFR implements Translation{
	Hashtable table_FR;
	public I18NTranslationFR()
	{
		populate_FR();
	}
	
	public void populate_FR() {
		table_FR = new Hashtable();
		table_FR.put(I18NKeys.COMPETITION_LIST,"Compétitions");
		table_FR.put(I18NKeys.BUTTON_CANCEL,"Annuler");
		table_FR.put(I18NKeys.BUTTON_DELETE,"Supprimer");
		table_FR.put(I18NKeys.BUTTON_EDIT,"Editer");
		table_FR.put(I18NKeys.BUTTON_NEW,"Nouveau");
		table_FR.put(I18NKeys.BUTTON_VALIDATE,"Valider");
		table_FR.put(I18NKeys.COMPETITION_ATHLETE_INPUT,"Athlète");
		table_FR.put(I18NKeys.COMPETITION_DATE_INPUT,"Date");
		table_FR.put(I18NKeys.COMPETITION_NAME_INPUT,"Nom");
		table_FR.put(I18NKeys.COMPETITION_PLACE_INPUT,"Lieu");
		
		/*
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
		*/
	}
	
	public String getTranslation(String key)
	{
		return (String)table_FR.get(key);
	}

}
