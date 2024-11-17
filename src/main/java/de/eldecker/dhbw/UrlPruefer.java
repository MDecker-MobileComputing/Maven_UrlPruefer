package de.eldecker.dhbw;

import org.apache.commons.validator.routines.UrlValidator;


/**
 * Klasse mit Code für eigentliche Prüfung der URL, welche durch den  
 * <a href="https://commons.apache.org/proper/commons-validator/">Apache Commons Validator</a>
 * vorgenommen wird. 
 */
public class UrlPruefer {

	/** URL-Schemata für die Validierung. */
	private static final String[] URL_SCHEMA_ARRAY = { "http", "https", "ftp" };
	
	/** Objekt für Validierung von URLs. */
	private static UrlValidator _urlValidator = new UrlValidator( URL_SCHEMA_ARRAY );

	
	/**
	 * Methode zur syntaktischen Überprüfung von {@code url}.
	 * 
	 * @param url URL, die auf syntaktische Korrektheit überprüft werden soll
	 * 
	 * @return {@code true} gdw. die URL syntaktisch gerecht ist.
	 */
	public static boolean pruefeUrl( String url ) {
		
		return _urlValidator.isValid( url );
	}
	
}
