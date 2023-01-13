/**
 * OVERVIEW: le istanze di questa classe rappresentano un insieme
 * Le istanze di questa classe sono mutabili
 */

import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Collections;
import java.util.NoSuchElementException;
public class IntList implements Iterable<Integer>{
/**
 * ABS FUN: AF(els) -> {els[0], els[1], ..., els[n]}
 * REP INV: - els non contiene duplicati -> Per ogni i, j dove i!=j els[i] != els[j]
 *            els non null
 * ABS INV: els non contiene duplicati -> Per ogni i, j dove i!=j els[i] != els[j]
 */

    //CAMPI
    //variabile di istanza che rappresenta gli elementi dell'insiem
    private List<Integer> els;

    //COSTRUTTORI
    //inizializza un insieme vuoto
    public IntList(){
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
        if (els.size()==0) throw new EmptyException("IntList is empty");
        return els.get(els.size()-1);
    };    

    //EFFECTS: restituisce true se x è presente, altrimenti restituisce -1
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

    @Override 
    public boolean equals(Object o){
        if (!(o instanceof IntList)) return false;
        IntList other = (IntList) o; 
        if (other.els.size() != this.els.size()) return false; 
        for (int i=0; i <this.els.size(); i++)
            if (!this.contains(other.els.get(i))) return false;
        return true;
    }

    @Override
    public int hashCode(){
        int result = 17;
        //devo fare l'iteratore e mettere tutto in un array ordinato
        List<Integer> inorder = new ArrayList<>();
        Iterator<Integer> g = iterator();
        while (g.hasNext())
            inorder.add(g.next());
        Collections.sort(inorder);
        for (int i = 0; i<this.els.size(); i++)
            result = result * 31 + Integer.hashCode(inorder.get(i));
        return result;     
    }


  @Override
  public Iterator<Integer> iterator() {
    return els.iterator();
  }

    //protected così può accedere anche il sottotipo
    protected boolean RepOK(){
        for (int i=0; i<this.els.size(); i++){
            for (int j=0; j<this.els.size(); j++)
                if ((this.els.get(i) == this.els.get(j)) && i!=j) return false;
        }
        return true;
    }

    
}
