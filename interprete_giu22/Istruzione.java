import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * OVERVIEW: Le istanze di questa classe rappresentano una istruzione composta da
 * una funzione da valutare, una variabile a cui assegnare la valutazione della funzione, e gli argomenti della
 * funzione.
 * AF:
 * RI: 
 */
public class Istruzione {
    //public final Variabile var;

    public final int var;
    public final Funzione f;
    private final List<Funzione> argomenti;
    
    public Istruzione(final String s) {
        Objects.requireNonNull(s);
        if (s.isEmpty())
            throw new IllegalArgumentException("La stringa dell'istruzione non può essere vuota");
        String tkns[] = s.split(" +");
        if (tkns.length < 3) throw new IllegalArgumentException("Una istruzione deve sempre contenere variabile e funzione. Trovato/i solo " + tkns.length + "nome/i");
       
        

        
        if (tkns[1].equals("SUM")) {
            
        } else if (tkns[1].equals("MUL")) {
            if (tkns.length - 2 != 2)
                throw new IllegalArgumentException("Nella moltiplicazione il numero di argomenti deve essere 2.");
            argomenti = new ArrayList<>();
            argomenti.add()

            Funzione m = new Mul(argomenti.get(0), argomenti.get(1));
            
        } else if (tkns[1].equals("NEG")){
            
        }else throw new UnsupportedOperationException("Operazione " + tkns[1] + " non supportata");

    }
}
