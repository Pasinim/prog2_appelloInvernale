import java.util.*;
/**
 * OVERVIEW: Le istanze di questa classe rappresentano la durata di un file musicale. È possibile creare delle variabili public dato che sono tutte dichiarate come
 * final. Ogni durata è espressa dalle ore, minuti e secondi.
 * AF: hh:mm:ss
 * IR:      h >= 0,
            m >= 0,
            m < 60,
            s >= 0,
            s < 60
 */
public class Durata {
    public final int s, m, h;
    /**
     * Dato i secondi totali della durata inizializza una nuova durata.
     * @param tot secondi totali
     * @throws IllegalArgumentExcpeiton se tot < 0
     */
    public Durata(int tot){
        if (tot < 0) throw new IllegalArgumentException("La durata non può essere negativa");
        this.s = tot % 60;
        this.m = (tot / 60)%60;
        this.h = (tot/60)/60;
        repOK(); 
    }
    /**
     * Data una durata sottoforma di stringa inizializza una nuova durata
     * @param str stringa nel formato "hh:mm:ss"
     * @throws IllegalArgumentException se la durata non è nel formato corretto
     */
    public Durata(String str){
        String tkns[] = str.split(":");
        if (tkns.length > 3 || tkns.length <= 0) throw new IllegalArgumentException("La lunghezza deve essere > 3 e <= 0. Trovato: " + tkns.length);
        if (tkns.length == 2) {
            this.s = Integer.valueOf(tkns[1]);
            this.m = Integer.valueOf(tkns[0]);
            this.h = 0;    
        }else{
            this.s = Integer.valueOf(tkns[2]);
            this.m = Integer.valueOf(tkns[1]);
            this.h = Integer.valueOf(tkns[0]);
        }
        
        repOK();
    }

    /**
     * @param d durata da sommare a this
     * @return this + d
     * @throws NullPointerException se d è null
     */
    public Durata sommaDurata(Durata d){
        Objects.requireNonNull(d);
        int somma = this.s + this.m * 60 + this.h * 3600;
        somma += d.s + d.m * 60 + d.h * 3600;
        return new Durata(somma);
    }

    /** A cosa serve?
     * Requires: d < this
     * @param d durata da sottrarre a this
     * @return this - d
     * @throws NullPointerException se d è null
     */
    public Durata sottraiDurata(Durata d){
        Objects.requireNonNull(d);
        int sott = this.s + this.m * 60 + this.h * 3600;
        sott -= d.s + d.m * 60 + d.h * 3600;
        return new Durata(sott);
    }


    @Override
    public String toString(){
        String str = "";
        str += String.format("%02d:%02d:%02d", h, m, s);
        return str;
    }

    /**
     * @return true se IR è rispettato, false altrimenti
     */
    private boolean repOK(){
        return (
            this.h >= 0 &&
            this.m >= 0 &&
            this.m < 60 &&
            this.s >= 0 &&
            this.s < 60
        );
    }
}
