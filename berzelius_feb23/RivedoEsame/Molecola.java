import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Le istanze di questa classe rappresentano una molecola, costituita da atomi dello stesso elemento
 * o da elementi differenti.
 * IR: peso >= 1
 *  DEVO ANCHE SPECIFICARE CHE IL PESO SIA LA SOMMA DEGLI ATOMI CHE COMPOPNDONO LA MOLECOLA
 *      atomi != null, atomi.length > 0
 * AF: atomi.toString + isSemplice + peso
 * 
 */
public class Molecola {
    /** Variabile che rappresenta il peso atomico della molecola */
    private  float peso = 0;

    /** Array conentente gli elementi che compongono la molecola */
    private final List<Elemento> atomi;

    public Molecola(final List<Elemento> atomi) {
        Objects.requireNonNull(atomi);
        this.atomi = List.copyOf(atomi);
        for (Elemento elemento : atomi) {
            peso += elemento.getPeso();
        }
    }

    @Override
    public String toString() {
        //*  ClNa, 58.44277, composta */
        String atomiStr = "";
        for (int i = 0; i < atomi.size(); i++)    atomiStr += atomi.get(i);
        String ret = String.format("%s, %f, %s", atomiStr, peso, isSemplice() ? "semplice" : "composta" );
        return ret;
    }

    /**
     * @return true se la molecola e' semplice, false altrimenti
     * Nota: Da rivedere, non testata
     */
    public boolean isSemplice() {
        Set a = new HashSet<Elemento>(atomi);
        if (a.size() == 1) return true;
        return false;
    }    
}
