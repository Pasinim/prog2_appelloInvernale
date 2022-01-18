package pigeongram_old;
import java.util.*;
public class Conversazione {
    //variabili di istanza che rappresentano mittente e destinatario
    public final Utente m, d;
    //V.I. che rappresenta i messaggi che m ha mandato a d
    public final List<Messaggio> sent;
    //V.I. che rappresenta i messaggi che d ha mandato a m
    public final Map<Messaggio, Boolean> recived;

    /**
     * Solleva una eccezione se mittente e destinatario sono lo stesso utente
     * @param mittente
     * @param destinatario
     */
    public Conversazione(Utente mittente, Utente destinatario){
        if (mittente.equals(destinatario)) throw new IllegalArgumentException("Impossibile avviare una Conversazione tra lo stesso utente");
        this.m = Objects.requireNonNull(mittente);
        this.d = Objects.requireNonNull(destinatario);
        this.sent = new ArrayList<Messaggio>();
        this.recived = new HashMap<Messaggio, Boolean>();
    }
 
    /**
     * Quando m manda a d il messaggio deve anche essere aggiunto ai messaggi ricevuti di d
     * @param messaggio
     */
    public void send(String messaggio){
        Objects.requireNonNull(messaggio);
        Messaggio msg = new Messaggio(m, d, messaggio);
        this.sent.add(msg);
        d.riprendi(m).recived.add(msg, false);
    } 

    @Override
    public String toString(){
        String str = "";
        for (int i = 0; i < sent.size(); i++)
            str += sent.get(i).toString() + "\n";
        return str;
    }

}