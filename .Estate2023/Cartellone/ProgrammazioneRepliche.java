public class ProgrammazioneRepliche extends ProgrammazioneAbs {

    /**
     * Inizializza una nuova programmazione con repliche di un mese
     * 
     * @param numeroGG numero di giorni presenti nella mensilta
     * @param start    giorno iniziale
     * @param repliche numero di repliche da effettuare dopo start
     */
    public ProgrammazioneRepliche(String titolo, int numeroGG, int start, int repliche) {
        super(titolo, numeroGG, start);
        if (repliche <= 0 || repliche > numeroGG)
            throw new IllegalArgumentException("Numero di repliche non valido");
        for (int i = start; i < numeroGiorni; i++)
            giorni[i] = i;
    }

}
