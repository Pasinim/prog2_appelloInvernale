package tde.teramini;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<Riga> rows;
    private final int len;
    private final int height;

    /**
     * Inizializza una Board vuota con altezza h e lunghezza l.
     * 
     * Se h o l sono inferiore ad 1 viene sollevata una eccezione.
     * 
     * @param h Altezza board.
     * @param l Lunghezza board.
     */
    public Board(int h, int l){
        if(h < 1 || l < 1){
            throw new IllegalArgumentException();
        }

        this.len = l;
        this.height = h;
        this.rows = new ArrayList<>();

        for(int i = 0; i < height; i++){
            rows.add(new Riga(this.len));
        }
    }

    /**
     * Inserisce il Teramino al centro della riga piú in alto della Board.
     * 
     * Dopo che il Teramino é stato inserito vengono eseguite la sequenza di mosse specificate all'interno 
     * dell'array m.
     * Viene eseguita una mossa ogni passo di avanzamento del Teramino.
     * 
     * Se m contiene un numero di mosse minore di this.height, per i passi rimanenti non verrá effettuata alcuna mossa, 
     * se m contiene un numero di mosse maggiore di this.height, le mosse in eccesso verranno ignorate.
     * 
     * @param t Teramino da inserire.
     * @param m Array contenente le mosse da eseguire.
     */
    public void inserisciTeramino(Teramino t, char[] m){
        //Inserisco il teramino in riga 1
        Riga r = rows.get(0);
        r.addTeramino(t, new Coordinata(len/2, 0));

        //Eseguo la simulazione
        for(int i = 0; i < height; i++){

        }
    }

    @Override
    /**
     * Ritorna funzione d'astrazione di this.
     * 
     * @return String rappresentante stato di this.
     */
    public String toString(){
        String ret = "";
        for (Riga riga : rows) {
            ret += riga.toString() + "\n";
        }
        return ret;
    }

}
