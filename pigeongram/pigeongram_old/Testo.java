package pigeongram_old;

public class Testo extends Messaggio {

    public Testo(Utente mittente, Utente destinatario, String msg) {
        super(mittente, destinatario, msg);
        }
    
    @Override
    public String toString(){
        return "{M}: " + super.toString();
    }
}
