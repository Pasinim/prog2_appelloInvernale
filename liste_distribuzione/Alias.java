import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/**
 * OVERVIEW: Questa classe mutabile rappresenta un elenco di parti locali
 * a cui è associato un dominio ed è identificata da un nome.
 * Due alias con lo stesso nome sono consderati uguali. Una volta impostato il dominio è impossibile modificarlo
 * 
 */

public class Alias implements Iterable<Indirizzo> {
/**
 * IR: locals != null, locals non contiene elementi null
 * AF:
 */

 public final String nome;
 private Set<Locale> locals;
 public final Dominio dominio;

 /**
  * Istanzia un nuovo alias vuoto con un nome e un dominio 
  * @param n Nome dell'alias
  * @param d Dominio dell'alias
  * @throws NullPointerException se n è null o se d è null
  * @throws IllegalArgumentException se n è una stringa vuota
  */
    public Alias (final String n, final Dominio d){ 
        Objects.requireNonNull(n, "Il nome dell'alias non può essere null");
        if (n.isEmpty()) throw new IllegalArgumentException("Il nome dell'alias non può essere vuoto");
        nome = n;
        Objects.requireNonNull(d, "Impossibile creare un alias per un dominio null");
        dominio = d;
        locals = new HashSet<Locale>();
        }

 /**
  * Aggiunge un indirizzo locale all'alias. Se è già presente non fa nulla.
  * @param l indirizzo locale
  * @throws NullPointerException se l è un riferimento null
  */
    public void add (final Locale l){
        Objects.requireNonNull(l, "Impossibile aggiungere un alias per un locale null");
        if (locals.contains(l)) return;
        locals.add(l);
    }

    /**
     * Rimuove un indirizzo locale all'alias. 
     * @param l indirizzo locale da rimuovere
     * @throws NoSuchElementException se l non è presente in this
     * @throws NullPointerException se l è un riferimento null
     */
    public void remove (final Locale l){
        Objects.requireNonNull(l, "Impossibile rimuovere un alias per un locale null");
        if (!locals.contains(l)) throw new NoSuchElementException("Impossibile rimuovere un indirizzo locale non presente nell'alias");
        locals.remove(l);
    }

    /**
     * Restituisce una copia dell'elenco dei locali dell'alias
     * @return elenco di this.locales
     */
    public Set<Locale> getLocali(){
        return Set.copyOf(locals);
    }

    @Override
    public Iterator<Indirizzo> iterator() {
        return new Iterator<Indirizzo>() {
            Iterator<Locale> it = locals.iterator();
            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public Indirizzo next() {
                return new Indirizzo(it.next(), dominio);
            }  
        };
    }

    public String toString(){
        String str= nome.toString() + " =\n";
        Iterator<Indirizzo> it = this.iterator();
        while (it.hasNext()){
            Indirizzo curr = it.next();
            str += String.format("\t%s\n", curr);
        }
        return str;

    }

    public static void main(String[] args) {
        Alias a = new Alias("Alias primo", new Dominio("dominio.baz"));
        a.add(new Locale("marco"));
        a.add(new Locale("federico"));
        a.add(new Locale("marco"));
        a.add(new Locale("daniele"));

        System.out.println(a.toString());

    }

}
