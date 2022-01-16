package pigeongram;
import java.util.*;

/**
 * Le istanze di questa classe rappresentano un utente, identificato da nome e da password.
 * La V. di Ist. nome è lecito dichiararla pubblica dato che è final.
 * La password non deve essere esposta quindi è necessario dichiararla privata.
 * Essendo entrambe final suppongo che l'utente non possa modificare nè nome nè psw
 * AF: nome.toString()
 * IR: nome != null, psw != NULL
 */
public class Utente {
    public final String nome;
    private final String psw;
    //public final Set<Utente> interlocutori;
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
    public Conversazione getConversazione(Utente u){
        Objects.requireNonNull(u);
        if (!(this.conversazioni.containsKey(u))) throw new IllegalArgumentException();
        return this.conversazioni.get(u);
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

    public static void main(String[] args) {
        //PROVA A CREARAE TUTTO, MAPPA E VEDERE SE STAMPA
    }

}
