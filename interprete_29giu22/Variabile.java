import java.util.*;
/**
 * OVERVIEW; Le istanze di questa classe rappresentano una variabile
 */
class Variabile {
    private int valore;
    public final char nome;
    
    public Variabile(final int val, final char c) {
        valore = val;
        if (!(Character.isLetter(c)))
            throw new IllegalArgumentException("Il nome della variabile deve essere una lettera");
        nome = c;
    }

    public set(int x){
        valore = x;
    }
    
    @Override
    public String toString() {
        return String.format("%c = %d ", nome, valore); 
    }
}
