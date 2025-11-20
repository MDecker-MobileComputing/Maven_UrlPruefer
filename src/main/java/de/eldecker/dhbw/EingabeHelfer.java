package de.eldecker.dhbw;

import java.util.Optional;
import java.util.Scanner;


/**
 * Diese Klasse kapselt den Code für das Einlesen der
 * URL von der Tastatur.
 */
public class EingabeHelfer {

	/** Objekt zum Einlesen der Tastatureingabe. */
	private static final Scanner sScanner = new Scanner( System.in );
	
	
	/**
	 * URL von Tastatur einlesen.
	 * 
	 * @return Optional enthält den eingegeben String, wenn der Nutzer
	 *         etwas eingegeben hat.
	 */
    public static Optional<String> urlEinlesen() {

        System.out.print( "Bitte URL eingeben: " );
        String eingabeZeile = sScanner.nextLine();

        if (eingabeZeile == null) {

        	return Optional.empty();
        }

        eingabeZeile = eingabeZeile.trim();
        if ( eingabeZeile.isEmpty() ) {

        	return Optional.empty();
        }

        return Optional.of( eingabeZeile );
    }
    
    
    /**
     * Scanner für Einlesen von Tastatur schließen. Sollte am besten
     * unmittelbar vor Ende des Programms aufgerufen werden.
     */
    public static void eingabeSchliessen() {
    	
    		sScanner.close();
    }
    	
}
