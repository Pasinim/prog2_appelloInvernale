/**
 * Le istanze di questa classe rappresentano una Posizione all'interno di una griglia di gioco.
 * Tale classe è inoltre immutabile e quindi l'utilizzo di campi pubblici è consentito e non espone la
 * rappresentazione.
 */

public class Posizione {

    /**
     * La rappresentazione di una posizione è data dalla sua riga espressa come un intero da 0 a 9 (r),
     * dalla sua colonna espressa come un char da A a J (c) e infine da una valore booleano che indica
     * se essa è occupata da un qualsiasi tipo di nave.
     * tale invariante è assicurato dal suo unico costruttore e dal momento che non ha metodi mutazionali.
     */

    public final int r;
    public final char c;
    private boolean occupata;

    /**
     * Post condizioni: Costruisce una posizione.
     * 
     * Effetti collaterali: viene sollevata un'eccezione di tipo IllegalArgumentException nel caso in cui
     * r non sia nell'intervallo da 0 a 9, oppure nel caso in cui c non si trovi nell'intervallo tra A e K.
     * 
     * @param r la riga
     * @param c la colonna 
     * @param occupata se è occupata da una nave
     */
    public Posizione(int r, char c){
        if(r < 0 || r >= 10) throw new IllegalArgumentException("il valore delle righe deve essere tra 0 e 9");
        if(c < 'A' || c >= 'K') throw new IllegalArgumentException("il valore delle colonne deve essere tra A e J");
        this.r = r;
        this.c = c;
        this.occupata = false;
    }

    public char getC() {
        return c;
    }

    public int getR() {
        return r;
    }

    public void setOccupata(boolean b){
        this.occupata = b;
    }

    /**
     * Post condizioni: restituisce true se la posizione è occupata da una nave, false altrimenti
     */
    public boolean isOccupata(){
        return occupata;
    }

    /**
     * Restituisce la rappresentazione della rappresentazione dove riga e colonna sono separati da ":"
     */
    @Override
    public String toString() {
        return String.format("%c:%d",c,r);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Posizione)) return false;
        Posizione p = (Posizione) obj;
        if(p.c == c && p.r == p.r) return true;
        return false;
    }

    @Override
    public int hashCode() {
        int result = 31*Integer.hashCode(r);
        result += Character.hashCode(c);
        return result;
    }

}
