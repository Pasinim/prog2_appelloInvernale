import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

/**
 * OVERVIEW: Le istanze di questa classe mutabile rappresentano un elenco di indirizzi, costruiti
 * a partire da un alias oppure facendo la somma o la differenza insiemistica di due liste di distribuzione
 * 
 */
public class Lista {

    /**
    * RI: lista != null, ogni chiave e ogni valore di this.lista non deve essere nulla
    * AF: Per ogni indirizzo presente nella lista: indirizzo.toString();
     */
    private Map<HashSet<Locale>, Dominio> lista;

    /**
     * Istanzia una nuova lista partendo dagli indirizzi contenuti in un alias
     * 
     * @param a Alias da cui costuire la lista di distribuzione
     * @throws NullPointerException se a è nulla

     */
    public Lista (Alias a){
        Objects.requireNonNull(a, "Impossibile creare una lista da un alias null");
        lista = new HashMap<HashSet<Locale>, Dominio>();
        lista.put(new HashSet<Locale>(a.getLocali()), a.dominio);        
    }


    /**
     * Istanzia una nuova lista di distribuzione vuota
     */
    public Lista(){
        lista = new HashMap<HashSet<Locale>, Dominio>();
    }
    
    public void aggiungi ()
}
