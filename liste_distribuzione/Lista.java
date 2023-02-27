import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * OVERVIEW: Le istanze di questa classe immutabile rappresentano un elenco di indirizzi, costruiti
 * a partire da un alias oppure facendo la somma o la differenza insiemistica di due liste di distribuzione
 * 
 */
public class Lista implements Iterable<Indirizzo> {

    /**
    * AF: Per ogni indirizzo presente nella lista: indirizzo.toString();
     */

     public final String nome;
     private final List<Indirizzo> indirizzi;


     /**
      * Istanzia una nuova lista di distribuzione partendo da un alias
      * @param nome Nome della lista
      * @param a Alias
      * @throws NullPointerException se nome o a sono null
      * @throws IllegalArgumentException se nome e' vuoto
      */
     public Lista(String nome, Alias a) {
        Objects.requireNonNull(nome, "Nome della lista non può essere null");
        Objects.requireNonNull(a, "Alias non può essere null");
        indirizzi = new ArrayList<>();
        this.nome = nome;
        if (nome.isEmpty()) throw new IllegalArgumentException("La stringa del nome non può essere vuota");
        Iterator<Indirizzo> it = a.iterator();
        while (it.hasNext()) 
            indirizzi.add(it.next());
        
     }


     public Lista(String nome, Lista o) {
        Objects.requireNonNull(nome, "Nome della lista non può essere null");
        Objects.requireNonNull(o, "Lista non può essere null");
        indirizzi = new ArrayList<>();
        this.nome = nome;
        if (nome.isEmpty()) throw new IllegalArgumentException("La stringa del nome non può essere vuota");
        Iterator<Indirizzo> it = o.indirizzi.iterator();
        while (it.hasNext()) 
            indirizzi.add(it.next());
     }

     public String toString() {
        String ret = this.nome + "\n";
        for (Indirizzo i : indirizzi)
            ret += "\t" + i.toString() + "\n";
        return ret;
     }

     public Lista somma (Lista o, String nome) {
      ArrayList<Indirizzo> ret = new ArrayList<>();
        Iterator<Indirizzo> this_it = this.iterator();
        Iterator<Indirizzo> o_it = o.iterator();
        while (o_it.hasNext()){
            Indirizzo curr = o_it.next();
            if (ret.contains(curr)) continue;
            ret.add(curr);
        }
       Lista ot = new Lista(z, ret);


        return new Lista(nome, new Alias );
    }


     public static void main(String[] args) {
        Alias a = new Alias("Alias primo", new Dominio("dominio.baz"));
        a.add(new Locale("marco"));
        a.add(new Locale("federico"));
        a.add(new Locale("marco"));
        a.add(new Locale("daniele"));

        Lista l = new Lista("Lista prima", a);
        System.out.println(l.toString());
        
        Lista l2 = new Lista("Lista seconda", l);
        System.out.println(l2.toString());

     }


    @Override
    public Iterator<Indirizzo> iterator() {
       return indirizzi.iterator();
    }
     
   
}
