package tde.postScript;

import java.util.Iterator;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
/**
 * Classe immutabile Parser.
 * 
 * Permette di iterare su una serie di Token separati da WhiteSpace.
 */
public class Parser implements Iterator<Token<?>> {
    private final BufferedReader stream;
    private final String[] tokens;

    public Parser(InputStream is){
        this.stream = new BufferedReader(new InputStreamReader(is));
        
    }

    public boolean hasNext(){

    }

    public Token<?> next(){
        this.stream.read()
    }
}
