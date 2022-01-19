package pigeongram;
import java.util.*;
/**
 * OVERVIEW: Le istanze di questa classe rappresentano una conversazione tra due utenti
 * AF: msg.toString() se msg.size() > 0
 *     "Nessun messaggio presente nella conversazione" se msg.size() == 0
 * IR:
 *      m != null
 *      d != null
 *      msg != null, ogni messaggio presente in msg != null
 *      ultimoLetto_m, ultimoLetto_d >= 0
 *      i messaggi inviati devono essere esclusiavamente tra m e d
 *      
 */

public class Conversazione {
    /**
     * Le seguenti v.i. rappresentano la lista dei messaggi scambiati (in ordine cronologico)
     * e gli indici che permettono di tenere traccia dell'ultimo messaggio letto dei due utenti
     */
    public final List<Messaggio> msg;
    private int ultimoLetto_m = 0;
    private int ultimoLetto_d = 0;
    public final Utente m, d;
    /**
     * Inizializza una nuova conversazione tra gli utenti mittente e destinatario.
     * @param mittente Utente 1 
     * @param destinatario Utente 2
     * @throws NullPointerException se mittente o destinatario sono riferimenti a null
     */
    public Conversazione(Utente mittente, Utente destinatario){
        m = Objects.requireNonNull(mittente);
        d = Objects.requireNonNull(destinatario);
        msg = new ArrayList<Messaggio>();
    }

    /**
     * Manda un messaggio da un utente all'altro nella conversazione this
     * @param Mittente mittente del messaggio m
     * @param m Messaggio da mandare 
     * @throws NullPointerException se m o mittente sono null
     * @throws IllegalArgumentException se mittente non fa parte della conversazione
     * @throws IllegalArgumentException se m è una stringa vuota
     */
    /** **Come funziona?** Prima di inviare effettivamente il messsaggio è necessario controllare
     * che `mittente` sia this.m oppure this.d. Se `mittente` è this.m il destinatario sarà automaticamente
     * this.d, altrimenti il destinatario è this.m. Di conseguenza di provvede ad aggiornare il relativo indice 
     * per i messaggi non letti
     * 
     */
    public void invia(Utente mittente, String m){
        if (!(checkUtente(mittente))) throw new IllegalArgumentException("Utente non valido nella conversazione");        
        Objects.requireNonNull(m);
        Objects.requireNonNull(mittente);
        if (m.isEmpty()) throw new IllegalArgumentException("Impossibile mandare un messaggio vuoto");
        Utente destinatario = null;
        if (this.m.equals(mittente)) 
            destinatario = this.m;
        else 
            destinatario = this.d;

        this.msg.add(new Messaggio(mittente, destinatario, m));
        if (this.m.equals(mittente)) 
            this.ultimoLetto_m = msg.size();
        else 
            this.ultimoLetto_d = msg.size();

    }

    /**
     * Restituisce solamente i messaggi non letti di u nella conversazione this
     * @param u Utente di cui si vogliono conoscere i messaggi non letti
     * @return Messaggi non letti da u
     */
    public List<Messaggio> nonLetti(Utente u){
        if (!(checkUtente(u))) throw new IllegalArgumentException("Utente non presente nella conversazione corrente");
        int idx;
        if (this.m.equals(u)) 
            idx = this.ultimoLetto_m; 
        else 
            idx = this.ultimoLetto_d;

        List<Messaggio> unread = new ArrayList<Messaggio>();
        for (int i = idx; i < msg.size(); i++){
            unread.add(msg.get(i));
        }
        return unread;
    }

    @Override
    public String toString(){
        if (msg.size() == 0) return "Nessun messaggio presente nella conversazione";
        else {
            String str = "[";
            for (int i = 0; i < msg.size(); i ++)
                str += msg.get(i).toString() + ", ";
            return str + "]";
        }
    }

    /**
     * Controlla che l'utente u sia un utente valido (cioè che sia mittente o destinatario)
     * nella conversazione this
     * @param u Utente su cui effettuare il check
     * @return true se u = this.m oppure u = this.d
     */
    private Boolean checkUtente(Utente u){
        Objects.requireNonNull(u);
        return (this.m.equals(u) || this.d.equals(u));
    }
    

    public static void main(String[] args) {
        Utente u1 = new Utente("A", "1");
        Utente u2 = new Utente("B", "1");
        Conversazione c = new Conversazione(u1, u2);
        c.invia(u1, "ciao" );
        c.invia(u1, "bro" );
        List<Messaggio> l = c.nonLetti(u2);
        System.out.println("Non letti di A: " + l.toString());
        c.invia(u2, "lol" );
        System.out.println("Tutti msg: " + c.toString());
        l = c.nonLetti(u2);
        System.out.println("Non letti di A: " + l.toString());
        l = c.nonLetti(u1);
        System.out.println("Non letti di B: " + l.toString());
        c.invia(u1, "basta ciao"); 
        l = c.nonLetti(u2);
        System.out.println("Non letti di A: " + l.toString());


    }

}
