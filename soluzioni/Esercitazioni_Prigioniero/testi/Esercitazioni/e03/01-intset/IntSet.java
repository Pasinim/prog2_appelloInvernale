import java.util.List;
import java.util.ArrayList;

/** 
 * Le istanze di questa classe rappresentano degli insiemi di interi. Gli oggetti di questa classe
 * sono mutabili
 */

public class IntSet {
    //CAMPI
    /**
     * Struttura dati contenenti gli elementi dell'insieme.
     * Un array ha una dimensione prefissata, quindi è meglio una 
     * lista. 
     */
    private List<Integer> elements; //metto privato, con public l'utilizzatore potrebbe cancellarlo
    //meglio non mostrare i dettagli implementativi
      
    
    //costruttori
    /**
     *  Post: inizializza un nuovo insieme vuoto di interi
     */
    public IntSet() {
        elements = new ArrayList<>();
    }


    /**
     * Effetti Collaterali: potrebbe modificare this: 
     * this_post=this + {x}
     * Post: inserisce l'intero n in this
     */
    public void insert (int n) {
        if (contains(n))
            elements.add(n); //avviene il boxing automaticamente
            //non è necessario trasormare int in Integer
    }

    /**
     * Effetti Collaterali: potrebbe modificare this: 
     * this_post = this - {x}
     * Post: rimuove l'intero n da this
     */
    public void remove (int n){
        int index = elements.indexOf(n);
        if (index!=-1){
            int lastIndex = elements.size()-1;
            elements.set(index, elements.get(lastIndex)); //sposto l'elemento in unlitma posizione nella posizione dell'elemento da rimuovere
            elements.remove(lastIndex); //tolgo l'ultimo elemento dato che l'ho copiato nella posizione di x
            }
        }

    /**
     * PostCondizioni: restituisce un intero scelto arvitratiamente tra
     * gli elementi dell'istanza this. Se l'insieme è vuoto viene 
     * sollevata un'eccezione EmptyExcption
     */
    public int choose(){
        if (size()==0) throw new EmptyException("L'insieme è vuoto, impossibile restituire un elemento");
        return elements.get(elements.size()-1);
    }

    /**
     * Post: restituisce il numero di elementi dell'insieme
     */
    public int size() {
        return elements.size();
    }

    /**
     * Post: restituisce true se x è in this, false altrimenti
     */
    public boolean contains (int x) {
        return elements.contains(x);
    }

    /**
     * Post: restituisce una rappresentazione testuale di IntSet
     */
    @Override
    public  String toString(){
        String str = "IntSet: ";
        for (int i=0; i<size()-1; i++) str+= i + ", ";
        str += elements.get(size()-1);
        return str + "}";
        
    }





}
