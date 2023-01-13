package tde.ps2;

import java.io.InputStream;
import java.util.Iterator;
import java.util.Scanner;


/**
 * Permette di Iterare su una serie di Token.
 */
public class Parser{
    private final InputStream is;

    public Parser(InputStream is){
        this.is = is;
    }

    /**
     * Ritorna un Generatore di Token sullo Stdin di this.
     * 
     * @return Generatore di Token.
     */
    public Iterator<Token<?>> tokens(){
        return new TokenIterator(is);
    }

    private class TokenIterator implements Iterator<Token<?>>{
        private final InputStream inputstream;
        private final Scanner scanner;

        public TokenIterator(InputStream s){
            this.inputstream = s;
            this.scanner = new Scanner(inputstream);
        }

        @Override
        public boolean hasNext() {
            return scanner.hasNext();
        }

        @Override
        public Token<?> next() {
            String next  = scanner.next();
            try {
                Double d = Double.parseDouble(next);
                return Token.tokenDouble(d);
            } catch (NumberFormatException e) { 
                return Token.tokenString(next);
            }
        }
        
    }
}
