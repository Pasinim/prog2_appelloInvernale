package pigeongram;
import java.util.*;

/**
 * Le istanze di questa classe rappresentano un utente, identificato da nome e da password.
 * La V. di Ist. nome è lecito dichiararla pubblica dato che è final.
 * La password non deve essere esposta quindi è necessario dichiararla privata.
 * Essendo entrambe final suppongo che l'utente non possa modificare nè nome nè psw
 * AF: nome.toString()
 * IR: 
 *      nome != null
 *      psw != NULL
 *      conversazioni != NULL
 */



public class Utente {
    public final String nome;
    private final String psw;
    /** la variabile di istanza conversazioni permette di associare a this
     * una serie di conversazioni con vari utenti
     */
    public final Map<Utente, Conversazione> conversazioni;

    /**
     * Inizializza un nuovo utente con una nuova password. Al momento
     * della creazione l'insieme di interlocutori è vuoto.
     * Se nome = null o psw = null solleva NullPointerExc
     * Se nome o psw è vuoto solleva una eccezione di tipo IllegalArgExc
     * @param nome nome utente
     * @param psw password utente
     */
    public Utente(String nome, String psw){
        Objects.requireNonNull(nome);
        Objects.requireNonNull(psw);
        if (nome.isEmpty() || psw.isEmpty()) throw new IllegalArgumentException();
        this.nome = nome;
        this.psw = psw;
        this.conversazioni = new HashMap<Utente, Conversazione>();
    }

    /**
     * Restituisce una stringa contenente gli interlocutori di this
     * @return stringa contenente gli interlocutori di this
     */
    public String getInterlocutori(){
        String str = "Interlocutori di " + nome.toString() + ": [" ;
        Set<Utente> setUtenti = this.conversazioni.keySet();
        Iterator<Utente> it = setUtenti.iterator();
        while (it.hasNext())
            str += it.next().nome.toString();
        str += "]\n";
        return str;
    }

    /**
     * Restituisce la conversazione con l'utente u. Solleva una eccezione se 
     * utente è null.
     * Se u non è presente nelle conversazioni di this solleva una eccezione di tipo IllegalArgumentExc
     * @param u utente
     * @return conversazione di this con u
     */
    public Conversazione getConversazioni(Utente u){
        Objects.requireNonNull(u);
        if (!(this.conversazioni.containsKey(u))) throw new IllegalArgumentException();
        return this.conversazioni.get(u);
    } 

    /**
     * Inizia una nuova conversazione con l'utente U.
     * Al momento della creazione viene creata anche una Conversazione tra u e this
     * @param u utente con cui iniziare una nuova conversazione
     * @throws NullPointerException se u è null 
     */
    public Conversazione inizia(Utente u){
        Objects.requireNonNull(u);
        Conversazione c = new Conversazione(this, u);
        conversazioni.put(u, c);
        /**
         * devo creare una conversazione anche nella mappa delle conversazioni
         * di u. Il riferimento alla conversazione è sempre lo stesso, quindi è uguale tra
         * this e u (credo)
        */
        u.conversazioni.put(this, c);
        return c;
    }
    /**
     * @param u utente con cui riprendere la conversazione 
     * @return Conversazione tra this e u
     * @throws NullPointerException se u è null
     * @throws IllegalArgumentException se this non ha ancora iniziato una conversazione con u
     */
    public Conversazione riprendi(Utente u){
        Objects.requireNonNull(u);
        if (!(conversazioni.containsKey(u))) throw new IllegalArgumentException("Utente non presente, crea prima una nuova conversazione");
        return conversazioni.get(u);
    }
    
    /**
     * @param u Utente di cui si vogliono conoscere i messaggi mandati da this
     * @return Messaggi inviati da this a u
     */
    public List<Messaggio> getInviati(Utente u){
        Objects.requireNonNull(u);
        return riprendi(u).sent;
    }

    /**
     * @param u Utente di cui si vogliono conoscere i messaggi ricevuti da this
     * @return Messaggi inviati da this a u
     */
    public List<Messaggio> getRicevuti(Utente u){
        Objects.requireNonNull(u);
        return riprendi(u).recived;
    }

    /**
     * @param u Utente di cui si vogliono conoscere i messaggi mandati da this (che this non ha ancora letto)
     * @return Messaggi inviati da this a u
     */
    public List<Messaggio> getUnread(Utente u){
        Objects.requireNonNull(u);
        return riprendi(u).unread;       
    }


    @Override
    public int hashCode(){
        return Objects.hash(nome, psw);
    }

    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof Utente)) return false;
        final Utente o = (Utente)obj;
        return (o.nome.equals(this.nome));
    }
}
