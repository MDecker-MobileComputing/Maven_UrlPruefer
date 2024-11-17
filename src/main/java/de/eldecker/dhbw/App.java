package de.eldecker.dhbw;

import java.util.Scanner;
import java.util.Optional;

public class App  {
	
	private static final Scanner sScanner = new Scanner( System.in );

    private static Optional<String> urlEinlesen() {

        System.out.print("Bitte URL eingeben: ");
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
        }

        System.out.println();
        
        sScanner.close();
    }
}
