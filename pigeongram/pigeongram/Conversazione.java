package pigeongram;
import java.util.*;
public class Conversazione {
    //variabili di istanza che rappresentano mittente e destinatario
    public final Utente m, d;

    public Conversazione(Utente mittente, Utente destinatario){
        this.m = Objects.requireNonNull(mittente);
        this.d = Objects.requireNonNull(destinatario);
    }
}