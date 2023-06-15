
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * Le istanze di questa classe immutabile rappresentano un elenco ordinato, non
 * vuoto e senza ripetizioni di brani.
 * Un **album** è un elenco (ordinato, non vuoto e senza ripetizioni) di *brani*
 */

public class Album implements Iterable<Album.Brano> {

    /**
     * IR: titolo != null, titolo != "", brani != null, brani != [], durataTot !=
     * null
     * AF: Per ogni brani i nell'; album: Titolo album + durata[i] + brani[i] .... +
     * durata[n] + brani[n] + durataTot
     */
    public final String titolo;
    private final List<Brano> brani;
    public final Durata durataTot;

    /**
     * Inizializza un nuovo album dato un elenco di brani e durate
     * 
     * @param brani  lista di titoli di brani da inserire in this
     * @param durate lista di durate dei brani
     * @throws NullPointerException     se la lista dei brani o delle durate è nulla
     * @throws IllegalArgumentException se le liste non hanno la stessa dimensione
     * @throws IllegalArgumentException se le liste sono vuote
     */
    public Album(final List<String> titoliBrani, final List<Durata> durate, String t) {
        Objects.requireNonNull(titoliBrani, "La lista dei titoliBrani non può essere nulla");
        Objects.requireNonNull(durate, "La lista delle durate non può essere nulla");
        Objects.requireNonNull(t, "Il titolo non può essere nullo");
        if (t.isEmpty())
            throw new IllegalArgumentException("Il titolo non può essere vuoto");
        if (titoliBrani.size() != durate.size())
            throw new IllegalArgumentException("Le liste devono avere la stessa dimensione");
        if (titoliBrani.isEmpty() || durate.isEmpty())
            throw new IllegalArgumentException("Le liste non possono essere vuote");
        brani = new ArrayList<>();
        int totSecondi = 0;
        for (int i = 0; i < titoliBrani.size(); i++) {
            brani.add(new Brano(titoliBrani.get(i), durate.get(i)));
            totSecondi += durate.get(i).secondi;
        }
        titolo = t;
        durataTot = new Durata(totSecondi);
    }

    /**
     * Restituisce il brano avente il titolo specificato
     * 
     * @param str il titolo del brano da restituire
     * @return il brano avente il titolo specificato, null se non esiste
     * @throws NullPointerException     se il titolo è nullo
     * @throws IllegalArgumentException se il titolo è vuoto
     */
    public Brano getBrano(Brano str) {
        Objects.requireNonNull(str, "Il titolo non può essere nullo");
        for (Brano b : brani)
            if (b.titolo.equals(str.titolo))
                return b;
        return null;
    }

    /**
     * Restituisce il brano in posizione specificata
     * 
     * @param idx la posizione del brano da restituire
     * @return il brano in posizione specificata
     * @throws IllegalArgumentException se l'indice non è compreso tra 0 e la
     *                                  dimensione dell'album
     * @throws NullPointerException     se l'indice è nullo
     */
    public Brano getBrano(int idx) {
        if (idx > brani.size() || idx < 0)
            throw new IllegalArgumentException("L'indice deve essere compreso tra 0 e " + brani.size());
        return brani.get(idx);
    }

    /**
     * Restituisce la posizione del brano specificato
     * 
     * @param Brano il brano di cui si vuole conoscere la posizione
     * @throws NullPointerException     se il brano è nullo
     * @throws IllegalArgumentException se il brano non è presente nell'album
     */
    public int getPosizione(Brano brano) {
        Objects.requireNonNull(brano, "Il brano non può essere nullo");
        if (!brani.contains(brano))
            throw new IllegalArgumentException("Il brano non è presente nell'album");
        return brani.indexOf(brano);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Titolo Album: " + this.titolo + "\n");
        Iterator<Album.Brano> it = this.brani.iterator();
        for (int i = 1; it.hasNext(); i++) {
            Brano curr = it.next();
            sb.append(i + " - \"" + curr.titolo + "\" (" + curr.durata.toString() + ")\n");
        }
        sb.append("Durata totale: " + this.durataTot.toString() + "\n");
        return sb.toString();
    }

    /**
     * Le istanze di questa classe immutabile sono strettamente connessa a quelle di
     * Album e rappresentano un brano.
     */
    public class Brano {

        private final String titolo;
        private final Durata durata;

        /**
         * Inizializza un nuovo brano con titolo e durata specificati
         * 
         * @param t il titolo del brano
         * @param d la durata del brano
         * @throws NullPointerException     se il titolo o la durata sono nulli
         * @throws IllegalArgumentException se il titolo è vuoto
         */
        private Brano(final String t, final Durata d) {
            Objects.requireNonNull(t, "Il titolo non può essere nullo");
            Objects.requireNonNull(d, "La durata non può essere nulla");
            if (t.isEmpty())
                throw new IllegalArgumentException("Il titolo non può essere vuoto");
            this.titolo = t;
            this.durata = d;
        }

        /**
         * Restituisce l'album di appartenenza del brano
         * 
         * @return l'album di appartenenza del brano
         */
        public Album getAlbum() {
            return Album.this;
        }

        /**
         * Restituisce true se il brano appartiene all'album specificato
         * 
         * @param a l'album di cui si vuole verificare l'appartenenza
         * @return true se il brano appartiene all'album specificato
         * @throws NullPointerException se l'album è nullo
         */
        public boolean appartiene(Album a) {
            Objects.requireNonNull(a, "L'album non può essere nullo");
            return a.equals(this.getAlbum());
        }

        @Override
        public String toString() {
            return String.format("%s - %s (da %s)\n", this.titolo, this.durata.toString(), this.getAlbum().titolo);
        }

        /**
         * Non c’è alcun bisogno di definire i metodi equals e hashCode per i brani: è
         * del tutto plausibile ritenere diverse anche due istanze con la stesso titolo
         * e durata; si pensi ad esempio a un album corrispondente alla registrazione di
         * un podcast in cui i brani siano una serie di interviste di titolo e durata
         * differente alternate a uno “stacchetto” musicale che abbia sempre la stessa
         * durata e “Intermezzo” per titolo.
         */
        // public boolean equals(Object object) {
        // Objects.requireNonNull(object, "Il brano non può essere nullo");
        // if (object instanceof Brano) {
        // Brano brano = (Brano) object;
        // return brano.titolo.equals(this.titolo) && brano.durata.secondi ==
        // (this.durata.secondi);
        // }
        // return false;
        // }
    }

    @Override
    public Iterator<Brano> iterator() {
        return brani.iterator();
        // return new Iterator<Album.Brano>() {

        // @Override
        // public boolean hasNext() {
        // // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'hasNext'");
        // }

        // @Override
        // public Brano next() {
        // // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'next'");
        // }

        // };
    }
}
