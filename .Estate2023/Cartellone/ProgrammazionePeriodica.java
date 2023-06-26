public class ProgrammazionePeriodica extends ProgrammazioneAbs {

    /**
     * Inizializza una nuova programmazione peridoica partendo da un giorno iniziale
     * e un dato intervallo
     * 
     * @param numeroGG   numero di giorni presenti nella mensilta
     * @param start      giorno iniziale
     * @param intervallo intervallo tra una programmazione e l'altra
     * @throws IllegalArgumentException se intervallo non è compreso tra 0 e
     *                                  numeroGiorni
     */
    public ProgrammazionePeriodica(String titolo, int numeroGG, int start, int intervallo) {
        super(titolo, numeroGG, start);
        if (intervallo < 0 || intervallo > numeroGG)
            throw new IllegalArgumentException("Intervallo non valido");
        for (int i = start; i < numeroGiorni; i += intervallo)
            giorni[i] = i;

    }

}
