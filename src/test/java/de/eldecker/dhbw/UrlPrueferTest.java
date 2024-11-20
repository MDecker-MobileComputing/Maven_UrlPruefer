package de.eldecker.dhbw;

import static de.eldecker.dhbw.UrlPruefer.pruefeUrl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


/**
 * Unit-Tests für die Klasse {@link de.eldecker.dhbw.UrlPruefer}.
 */
public class UrlPrueferTest {

    
    /**
     * Tests für Syntax-Überprüfung von korrekten URLs.
     */
    @Test
    void korrekteUrls() {
                
        final boolean ergebnis1 = pruefeUrl( "https://www.spiegel.de/" );
        assertTrue( ergebnis1 );

        // "http" statt "https" (unsichere URL)
        final boolean ergebnis2 = pruefeUrl( "http://www.spiegel.de/" );
        assertTrue( ergebnis2 );

        // URL mit URL-Parameter
        final boolean ergebnis3 = pruefeUrl( "https://www.google.com/search?q=karlsruhe" );
        assertTrue( ergebnis3 );
        
        /*
        final boolean ergebnis4 = pruefeUrl( "http://localhost:8080" ); // Commons Validator akzeptiert nicht "localhost" 
        assertTrue( ergebnis4, "Localhost auf Port 8080" );
        */   
    }
    
    
    /**
     * Die folgende Testmethode wird für jede der mit der Annotation {@code @ValueSource}
     * angegebenen URLs ausgeführt.
     * 
     * @param url Korrekte URL, für die zu überprüfen ist, ob sie von der Methode
     *            unter Test als syntaktisch korrekt erkannt werden.
     */
    @ParameterizedTest
    @ValueSource(strings = {
        "https://de.wikipedia.org/wiki/Computer#Grundlagen", // URL mit Anker
        "https://www.qwant.com/?q=testing&t=web"           , // URL mit zwei URL-Parametern
        "https://www.qwant.com/?q=Gr%C3%BCnkohl"             // URL mit kodiertem Umlaut in URL-Parameter
    })
    void korrekteUrls( String url ) {
    	
        assertTrue( pruefeUrl( url ) );
    }
    

    /**
     * Tests für Syntax-Überprüfung von inkorrekten URLs.<br>
     * 
     * Jedes {@code assertFalse()} hat als zweites Argument einen String mit einer
     * Nachricht, die beim Fehlschlagen dieser Assertion angezeigt werden.
     */
    @Test
    void inkorrekteUrls() {

        final boolean ergebnis1 = pruefeUrl( "https://www.spiegel" );
        assertFalse( ergebnis1, "Top-Level-Domain fehlt" );

        final boolean ergebnis2 = pruefeUrl( "www.spiegel.de" );
        assertFalse( ergebnis2, "Schema http(s) fehlt" );

        final boolean ergebnis3 = pruefeUrl( "abcd" ); 
        assertFalse( ergebnis3, "Nur vier Buchstaben" );
    }
    
}
