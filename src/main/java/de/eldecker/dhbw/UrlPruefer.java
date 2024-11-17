package de.eldecker.dhbw;

import org.apache.commons.validator.routines.UrlValidator;


public class UrlPruefer {

	private static final String[] URL_SCHEMA_ARRAY = { "http", "https", "ftp" };
	
	private static UrlValidator _urlValidator = new UrlValidator( URL_SCHEMA_ARRAY );

	
	public static boolean pruefeUrl( String url ) {
		
		return _urlValidator.isValid( url );
	}
}
