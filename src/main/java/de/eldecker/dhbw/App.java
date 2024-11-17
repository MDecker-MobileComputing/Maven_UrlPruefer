package de.eldecker.dhbw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

public class App  {

    private static Optional<String> urlEinlesen() {

        try {

            InputStreamReader inputStream = new InputStreamReader( System.in );
            BufferedReader reader = new BufferedReader( inputStream );
            System.out.print( "\nBitte geben Sie eine URL ein: " );
            String eingabe = reader.readLine();
            //reader.close();

            return Optional.of( eingabe );

        } catch (IOException ex) {

            System.err.println( "Ein Fehler ist aufgetreten: " + ex.getMessage() );
            return Optional.empty();
        }
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
    }
}
