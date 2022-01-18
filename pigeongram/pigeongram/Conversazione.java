package pigeongram;
import java.util.*;

public class Conversazione {
    public final Utente m, d;
    //V.I. che rappresenta i messaggi che m manda a d. Se true = unread
    public final Map<Messaggio, Boolean> ricevuti;
    //public final List<Messaggio> inviati;
    public final List<Messaggio> tuttiMsg;

    public Conversazione(Utente m, Utente d){
        this.m = Objects.requireNonNull(m);
        this.d = Objects.requireNonNull(d);
       // this.inviati = new ArrayList<Messaggio>();
        this.tuttiMsg = new ArrayList<Messaggio>();
        this.ricevuti = new HashMap<Messaggio, Boolean>();
    }

    public void invia(Messaggio msg){
        Objects.requireNonNull(msg);
        // m -> d
        tuttiMsg.add(msg);
        /**
         * Unread fa riferimento ai messaggi che d ha ricevuto da m.
         * true = messaggio NON letto
         */
        d.riprendi(m).ricevuti.put(msg, true);
        //devo prendere la conversazione che d ha con m e aggiungere questo messaggio
        //d.getConversazione(m).put(unread);
        //quando this manda un messaggio a u devo segnare automaticamente tutti
        //i messaggi di this letti
        markLetto();

    }

    /**
     * Segna come "letto" tutti i messaggi ricevuti di u
     * @param u Utente
     */
    private void markLetto(){

        List<Messaggio> nonLetti= this.getNonLetti();
        for (int i = 0; i < nonLetti.size(); i++)
            ricevuti.put(nonLetti.get(i), false);
    }

    /**
     * Restituisce tutti i messaggi ricevuti
     */
    public List<Messaggio> getTutti(){
        List<Messaggio> tutti = new ArrayList<>(ricevuti.keySet());
        return tutti;
    }

    /**
     * Restituisce solo i messaggi non letti di this
     */
    public List<Messaggio> getNonLetti(){
        List<Messaggio> nonLetti = new ArrayList<>();
        /**
         * creo un iteratore sulle entries della mappa poi, con una altra entry, verifico se il messaggio
         * è stato letto oppure no
         */
        Iterator<Map.Entry<Messaggio, Boolean>> it = ricevuti.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<Messaggio, Boolean> entry = it.next();
            if (entry.getValue())
                nonLetti.add(entry.getKey());
        }
        return nonLetti; 
    }
}
