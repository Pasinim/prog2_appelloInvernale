package pigeongram_old;

public class Musica extends Messaggio {

    public Musica(Utente mittente, Utente destinatario, String msg) {
        super(mittente, destinatario, msg);
    }


    @Override
    public String toString(){
        return "{T}: " + super.toString();
    }
    
}
