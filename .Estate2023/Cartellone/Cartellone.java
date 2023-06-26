import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Le istanze di questa classe rappresentano un cartellone di un cinema 
 */

public class Cartellone {
    /**
     * RI: cinema != null && durata > 0 && proiezioniSet != null && proiezioniGiorno
     * != null
     * AF:
     */

    public final String cinema;
    public final int durata;
    private final Set<Proiezione> proiezioniSet;
    // private final List<Proiezione> proiezioniGiorno;

    public Cartellone(String cinema, int durata) {
        this.cinema = Objects.requireNonNull(cinema, "Il nome del cinema non può essere null");
        this.durata = durata;
        proiezioniSet = new LinkedHashSet<>();
        // proiezioniGiorno = new ArrayList<>();

    }

    // TODO:: COME GESTISCO SOVRAPPOSIZIONI
    /**
     * Aggiunge una proiezione al cartellone. Se la proiezione si sovrappone ad un
     * altro giorno non fa nulla
     * 
     * @param titolo  titolo della proiezione
     * @param tipo    tipo di programmazione
     * @param primo   primo giorno di proiezione
     * @param secondo intervallo o numero di repliche dopo il pimo giorno
     * @thorws NullPointerException se titolo è null
     * @throws IllegalArgumentException se titolo è vuoto
     * @throws IllegalArgumentException se tipo non è R, P o null
     */

    static final Pattern PATTERN = Pattern
            .compile("\"(?<titolo>[^\"]+)\" (?<primo>\\d+)( (?<tipo>R|P)? (?<secondo>\\d+))?");

    // NON VA BENE NON È AL GIUSTO LIVELLO DI ASTRAZIONE
    public void aggiungiProiezione(final String titolo, final ProgrammazioneAbs prog) {
        Objects.requireNonNull(titolo, "Il titolo della proiezionenon puìo essere null");
        Objects.requireNonNull(prog, "La programmazione non può essere null");
        if (titolo.isEmpty())
            throw new IllegalArgumentException("Il titolo della proiezione non può essere vuoto");
        proiezioniSet.add(new Proiezione(titolo, prog));

    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("CARTELLONE\nCinema: %s, giorni: %d, proiezioni:%d\n", this.cinema, durata,
                proiezioniSet.size()));
        for (Proiezione p : proiezioniSet) {
            sb.append(p.toString() + "\n");
        }
        return sb.toString();
    }

    /**
     * Le istanze di questa classe interna rappresentano una proiezione nel
     * cartellone this
     */
    public class Proiezione {

        public final String titolo;
        // variabile con visibilità public dato che non ci sono metodo mutazionali in
        // Programmazione
        public final ProgrammazioneAbs prog;

        private Proiezione(final String t, final ProgrammazioneAbs p) {
            Objects.requireNonNull(t, "Il titolo non può essere null");
            Objects.requireNonNull(p, "La programmazione non può essere null");
            if (t.isEmpty())
                throw new IllegalArgumentException("Il titolo non può essere vuoto");
            titolo = t;
            prog = p;
        }

        private boolean isGiornoOccupato(int giorno) {
            return prog.giorni[giorno] != 0;
        }

        public String toString() {
            Iterator<Integer> it = prog.iterator();
            StringBuilder sb = new StringBuilder();
            for (int i = 1; it.hasNext(); i++) {
                sb.append(String.format("%d -  %d\n", i, it.next().toString()));
            }
            return sb.toString();

        }
    };
}
