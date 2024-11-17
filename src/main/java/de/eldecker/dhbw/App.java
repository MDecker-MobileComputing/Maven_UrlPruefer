package de.eldecker.dhbw;

import static de.eldecker.dhbw.UrlPruefer.pruefeUrl;

import java.util.Scanner;
import java.util.Optional;


/**
 * Klasse mit Einstiegsmethode.
 */
public class App  {
	
	/** Objekt zum Einlsen Eingabe von Tastatur. */
	private static final Scanner sScanner = new Scanner( System.in );

	
	/**
	 * URL von Tastatur einlesen.
	 * 
	 * @return Optional enthält den eingegeben String, wenn der Nutzer
	 *         etwas eingegeben hat.
	 */
    private static Optional<String> urlEinlesen() {

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
     * Einstiegspunkt der Programmausführung
     *
     * @param args Kommandozeilenargumente, werden nicht ausgewertet
     */
    public static void main( String[] args ) {

        Optional<String> urlOptional = null;
        while ( true ) {

            urlOptional = urlEinlesen();
            if ( urlOptional.isEmpty() ) {

                System.out.println( "Programm wird beendet" );
                break;
            }

            String url = urlOptional.get();
            System.out.println( "URL eingegeben: \"" + url + "\"" );
            
            boolean istOkay = pruefeUrl( url );
            if ( istOkay ) {
            	
            	System.out.println( "Die URL ist syntaktisch korrekt." );
            	
            } else {
            	
            	System.out.println( "Die URL ist syntaktisch NICHT korrekt." );
            }
            
            System.out.println();
        }
        
        sScanner.close();
    }
}
