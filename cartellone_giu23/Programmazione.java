public interface Programmazione extends Iterable<Integer> {

    /**
     * Metodo che imposta le date in cui avviene una certa proiezione.
     * 
     * @param gg       giorno da cui ha inizio la proiezione
     * @param repliche numero di repliche in seguito al primo giorno
     */
    // void setDate(final int gg, final int repliche);

    public String toString();

    /**
     * Restituisce il numero di date in cui avviene la proiezione.
     * 
     * @return il numero di date in cui avviene la proiezione
     */
    public int count();
}
