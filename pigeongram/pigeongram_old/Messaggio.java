package pigeongram_old;
import java.util.*;

public class Messaggio {
    public final Utente m, d;
    //contenuto
    public final String msg;
    /**
     * Solleva una eccezione se uno dei parametri è un riferimento null oppure se il messaggio è vuoto
     * @param mittente
     * @param destinatario
     * @param msg
     */
    public Messaggio(Utente mittente, Utente destinatario, String msg){
        this.m = Objects.requireNonNull(mittente);
        this.d = Objects.requireNonNull(destinatario);
        this.msg = Objects.requireNonNull(msg);
        if (msg.isEmpty()) throw new IllegalArgumentException("Il mesaggio non può essere nullo");
    }

    @Override
    public String toString(){
        return this.msg.toString();
    }
}
