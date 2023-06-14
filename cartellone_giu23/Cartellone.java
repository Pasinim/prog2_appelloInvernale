import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.swing.text.html.HTMLDocument.Iterator;

/**
 * Le istanze di questa classe rappresentano un cartellone mensile di un cinema.
 */
public class Cartellone {
    /**
     * IR: cinema != null, cinema non vuoto,
     * durata compresa tra 28 e 31
     * AF:
     */
    public final String cinema;
    // variabile di instanza che indica quanti giorni ci sono nel mese
    public final int durata;
    private final LinkedHashSet<Proiezione> proiezioni;
    private Map<Integer, Proiezione> proiezioniPerGiorno;

    /**
     * Inizializza un nuovo cartellone con il nome del cinema e la durata del mese.
     * 
     * @param cinema il nome del cinema
     * @param durata la durata del mese (in giorni)
     * @throws NullPointerException     se cinema è null
     * @throws IllegalArgumentException se cinema è una stringa vuota
     * @throws IllegalArgumentException se durata non è compresa tra 28 e 31
     */
    public Cartellone(String cinema, int durata) {
        Objects.requireNonNull(cinema, "Impossibile istanziare un cartellone con una stringa nulla");
        if (cinema.isEmpty())
            throw new IllegalArgumentException("Impossibile istanziare un cartellone con una stringa vuota");
        if (durata <= 27 || durata > 31)
            throw new IllegalArgumentException("La durata deve essere compresa tra 28 e 31 giorni");

        this.cinema = cinema;
        this.durata = durata;
        this.proiezioni = new LinkedHashSet<>();
        this.proiezioniPerGiorno = new HashMap<>();
    }

    /**
     * Inserisce una nuova proiezione nel cartellone nel giorno indicato. Se il
     * giorno è già occupato da una altra proiezione stampa un messaggio che informa
     * l'utente e non modifica this.
     * 
     * @param proiezione la proiezione da aggiungere
     * @param giorno     il giorno in cui aggiungere la proiezione
     * @throws NullPointerException     se proiezione è null
     * @throws IllegalArgumentException se giorno non è compreso tra 1 e durata
     */
    public void aggiungi(Proiezione proiezione, int giorno) {
        Objects.requireNonNull(proiezione, "Impossibile aggiungere una proiezione null");
        if (giorno <= 0 || giorno > durata)
            throw new IllegalArgumentException("Il giorno deve essere compreso tra 1 e " + durata);
        if (proiezioniPerGiorno.containsKey(giorno)) {
            System.out.println("Il giorno è già occupato da una altra proiezione.");
            return;
        }
        proiezioni.add(proiezione);
        proiezioniPerGiorno.put(giorno, proiezione);
    }

    /**
     * Restituisce le proiezioni nell'ordine in cui sono state aggiunte.
     * 
     * @return le proiezioni nell'ordine in cui sono state aggiunte
     */
    public LinkedHashSet<Proiezione> getProiezioniOrdineAggiunta() {
        return proiezioni;
    }

    /**
     * Restituisce le proiezioni in ordine di giorno.
     * 
     * @return le proiezioni in ordine di giorno
     */
    public Map<Integer, Proiezione> getProiezioniOrdineGiorno() {
        return proiezioniPerGiorno;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CARTELLONE\n\nCinema: " + cinema.toString() + ", giorni: " + durata + ", proiezioni: "
                + proiezioni.size() + "\n");
        return sb.toString();

    }

    /**
     * Classe interna che implementa la proiezione di un film.
     */
    public class Proiezione {
        public final String film;
        private final Programmazione programmazione;

        /**
         * Inizializza una nuova proiezione con il titolo del film e la programmazione
         * specificati
         * 
         * @param film titolo del film
         * @param p    programmazione
         * @throws NullPointerException     se film o p sono null
         * @throws IllegalArgumentException se film è una stringa vuota
         */
        public Proiezione(final String film, final Programmazione p) {
            Objects.requireNonNull(film, "Impossibile istanziare una proiezione con una stringa nulla");
            Objects.requireNonNull(p, "Impossibile istanziare una proiezione con una programmazione nulla");
            if (film.isEmpty())
                throw new IllegalArgumentException("Impossibile istanziare una proiezione con una stringa vuota");
            this.film = film;
            this.programmazione = p;

        }

        /**
         * Restituisce un riferimento al cartellone a cui la proiezione appartiene.
         *
         * @return cartellone a cui la proiezione appartiene
         */
        public Cartellone cartellone() {
            return Cartellone.this;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Cinema: " + cartellone().cinema.toString() + ", titolo: \"" + film.toString() + "\", date: "
                    + programmazione.toString() + "\n");
            // sb.append("PROIEZIONI:");
            // Iterator<Cartellone.Proiezione> it = getProiezioniOrdineGiorno().iterator();
            // while (it.hasNex()) {
            // Proiezione curr = it.next();
            // sb.append(curr.toString() + "\n");
            // }
            return sb.toString();
        }
    }

}
