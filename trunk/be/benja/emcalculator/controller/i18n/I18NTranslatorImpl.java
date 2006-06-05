package be.benja.emcalculator.controller.i18n;

public class I18NTranslatorImpl implements I18NTranslator{
	Translation translation_fr;
	Translation translation_en;
	Translation translation_nl;
	
	public static final String LOCALE_FR="FR";
	public static final String LOCALE_EN="EN";
	public static final String LOCALE_NL="NL";
	String locale;
	
	public I18NTranslatorImpl(String locale)
	{
		setLocale(locale);
		translation_fr = new I18NTranslationFR();
		/*populate_FR();
		populate_EN();
		populate_NL();*/
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
			traducted = translation_fr.getTranslation(text);
		}
		/*else if(locale.compareTo(LOCALE_NL)==0)
		{
			
		}
		if(locale.compareTo(LOCALE_EN)==0)
		{
			
		}*/
		else traducted = translation_fr.getTranslation(text);
		
		if(traducted==null)
		{
			return text;
		}
		else
		{
			return traducted;
		}
	}

}
