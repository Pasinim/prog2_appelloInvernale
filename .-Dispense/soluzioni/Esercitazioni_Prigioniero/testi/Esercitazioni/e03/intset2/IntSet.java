/**
 * OVERVIEW: le istanze di questa classe rappresentano un insieme
 * Le istanze di questa classe sono mutabili
 */

import java.util.List;
import java.util.ArrayList;
public class IntSet {
/**
 * ABS FUN: els[x_0, x_1, ..., x_n] | ogni x_i nell'insieme è diverso da un altro elemento nell'insieme x_j
 * 
 * ABS INV: - els non contiene duplicati 
 * 
 */

    //CAMPI
    //variabile di istanza che rappresenta gli elementi dell'insiem
    private List<Integer> els;

    //COSTRUTTORI
    //inizializza un insieme vuoto
    public IntSet(){
        els = new ArrayList<>();
    }

    //METODI
    //EFFETCS: inserisce l'elemento x all'insieme. Se è già presente non fa nulla
    public void insert(int x){
        if (!this.contains(x))
            els.add(x);
    };


    //EFFECTS: metodo che rimuove dall'insieme (se presente) l'elemento x
    public void remove(int x){
        if (els.indexOf(x) != -1)
            els.remove(els.indexOf(x));
    };

    //EFFECTS: restituisce l'ultimo elemento di this
            // solleva una eccezione di tipo emptyException se l'insieme è vuoto
    public int choose(){
        if (els.size()==0) throw new EmptyException("IntSet is empty");
        return els.get(els.size()-1);
    };    

    //EFFECTS: restituisce l'indice dell'elemento x. Se non è presente restituisce -1
    public boolean contains(int x){
        if (els.indexOf(x) == -1)
            return false;
        return true;
    };

    //EFFECTS: restituisce la lunghezza di size
    public int size(){
        return els.size();
    };
    
    @Override
    public String toString(){
        String str = "[ ";
        for (int i=0; i < this.size()-1; i++)
            str += els.get(i) + ", ";
        return str + els.get(this.size()-1) + " ]";
    }
}
