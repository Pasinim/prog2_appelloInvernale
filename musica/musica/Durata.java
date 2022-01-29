import java.util.*;
/**
 * OVERVIEW: Le istanze di questa classe rappresentano la durata di un file musicale. È possibile creare delle variabili public dato che sono tutte dichiarate come
 * final. Ogni durata è espressa dalle ore, minuti e secondi.
 * Le istanze di questa classe sono immutabili
 * AF: hh:mm:ss
 * IR:      La classe è immutabile, quindi basta controllare IR in costruzione
 *          h >= 0,
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
    static Durata str_to_Durata(String str){
        String tkns[] = str.split(":");
        int ore, min, sec;
        if (tkns.length > 3) throw new IllegalArgumentException("La lunghezza deve essere > 3 e <= 0. Trovato: " + tkns.length);
        if (tkns.length < 3){
            ore = 0;
            if (tkns.length < 2) {
                min = 0;    
                sec = Integer.valueOf(tkns[0]);
            }else {
                min = Integer.valueOf(tkns[1]);
            }
        }else{
            min = Integer.valueOf(tkns[1]);
            ore = Integer.valueOf(tkns[0]);
        }
        sec = Integer.valueOf(tkns[tkns.length - 1]);
        return new Durata(ore * 3600 + min * 60 + sec);
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

    public static void main(String[] args) {
        Durata d = str_to_Durata("1");
        System.out.println(d.toString());
    }
}
