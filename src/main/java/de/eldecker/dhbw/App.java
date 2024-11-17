package de.eldecker.dhbw;

import static de.eldecker.dhbw.EingabeHelfer.eingabeSchliessen;
import static de.eldecker.dhbw.EingabeHelfer.urlEinlesen;
import static de.eldecker.dhbw.UrlPruefer.pruefeUrl;

import java.util.Optional;


/**
 * Klasse mit Einstiegsmethode des Programms, das eine Syntax-Prüfung
 * von per Tastatur eingegebenen URLs vornimmt. 
 */
public class App  {
	

    /**
     * Einstiegspunkt der Programmausführung, enthält die Hauptschleife.
     *
     * @param args Kommandozeilenargumente, werden nicht ausgewertet
     */
    public static void main( String[] args ) {

    	System.out.println( "\nProgramm beenden durch leere Eingabe.\n" );
    	
        Optional<String> urlOptional = null;
        while ( true ) {

            urlOptional = urlEinlesen();
            if ( urlOptional.isEmpty() ) {

                System.out.println( "\nProgramm wird beendet\n" );
                break;
            }

            String url = urlOptional.get();
            System.out.println( "URL eingegeben: \"" + url + "\"" );
            
            boolean istOkay = pruefeUrl( url );
            if ( istOkay ) {
            	
            	System.out.println( "Die URL ist syntaktisch korrekt.\n" );
            	
            } else {
            	
            	System.out.println( "Die URL ist syntaktisch NICHT korrekt.\n" );
            }
        }
        
        eingabeSchliessen();
    }

}
