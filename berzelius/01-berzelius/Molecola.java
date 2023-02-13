import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Le istanze di questa classe rappresentano una molecola, costituita da atomi dello stesso elemento
 * o da elementi differenti.
 * IR: peso >= 1
 *      atomi != null, atomi.length > 0
 * AF: atomi.toString + isSemplice + peso
 * 
 */
public class Molecola {
    /** Variabile che rappresenta il peso atomico della molecola */
    private  float peso = 0;

    /** Array conentente gli elementi che compongono la molecola */
    private final List<Elemento> atomi;

    /**
     * Istanzia una nuova molecola a partire da una stringa (composta da elementi prelevati da una tavola periodica)
     * @param mol molecola
     * @param tp TavolaPeriodica da cui prelevare gli elementi
    */
    public Molecola(String mol, TavolaPeriodica tp) {
        Objects.requireNonNull(mol);
        if (mol.isEmpty()) throw new IllegalArgumentException("La stringa che rappresenta la molecola non puo' essere vuota");
        atomi = new ArrayList<Elemento>();
         String[] stringAtomi = Helpers.parseFormula(mol);
        Elemento prev = null;
        for (int i = 0; i < stringAtomi.length; i++){
            
            Elemento curr = tp.getElementoFromNome(mol);
            // controllo se il char corrente e' un numero, in questo caso devo prelevare la molecola
            // precedentemente aggiunta e riaggiungerla nuovamente, aggiornando il peso
            if ((stringAtomi[i]).charAt(0) >= 30 && stringAtomi[i].charAt(0) <= 39){
                atomi.add(prev);
                peso += prev.getPeso();
            }else{
                atomi.add(curr);
                peso += curr.getPeso();
            }
            prev = curr; 
        }
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
