package Robot;
// Un **magazzino logistico** è un elenco numerato (non vuoto e finito) di

import java.util.Collections;
import java.util.List;
import java.util.Objects;

// **scaffalature** ciascuna delle quali ospita diversi **pacchi** ciascuno dei
// quali è caratterizzato da un *prodotto* (specificato con una stringa non vuota).

/* Le istanze di questa classe immutabile rappresentano un magazzino logistico */

public class Magazzino {

    /**
     * IR: scaffali != null && scaffali.size() > 0
     * AF: per ogni scaffale i presente nel magazzino: scaffale[i].toString()
     */

    // variabile di istanza privata ed immutabile che rappresenta l'elenco di
    // scaffalature
    private final List<Scaffalatura> scaffali;

    /**
     * Inizializza un nuovo magazzino con le scaffalature specificate.
     * 
     * @param scaffalatura la lista di scaffalature da inserire nel magazzino
     * @throws NullPointerException     se la lista di scaffalature è nulla
     * @throws IllegalArgumentException se la lista di scaffalature è vuota
     */
    public Magazzino(final List<Scaffalatura> scaffalatura) {
        Objects.requireNonNull(scaffalatura, "La lista di scaffalature non può essere null");
        if (scaffalatura.isEmpty())
            throw new IllegalArgumentException("La lista di scaffalature non può essere vuota");
        // cosi espongo la rappresentazione? Scaffalatura è final, non posso cambiare il
        // riferimento
        this.scaffali = Collections.unmodifiableList(scaffalatura);
        List.copyOf(scaffalatura);
        System.out.println(scaffali.size());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < scaffali.size(); i++) {
            sb.append(scaffali.get(i).toString());
            sb.append("_".repeat(10) + System.lineSeparator());
        }
        return sb.toString();
    }

    /**
     * Preleva il pacco dalla scaffalatura con indice scaffalatura
     * 
     * @param scaffalatura indice della scaffalatura da cui prelevare il pacco
     * @return il pacco prelevato
     * @throws IllegalArgumentException se l'indice della scaffalatura non esiste o
     *                                  se è negativo
     */
    public Pacco preleva(int scaffalatura) {
        if (scaffalatura > scaffali.size())
            throw new IllegalArgumentException("La scaffalatura non esiste");
        if (scaffalatura < 0)
            throw new IllegalArgumentException("L'indice della scaffalatura non può essere negativo");
        return scaffali.get(scaffalatura).preleva();
    }

    /**
     * Deposita il pacco nella scaffalatura con indice end
     * 
     * @param p   Pacco da depositare
     * @param end indice della scaffalatura in cui depositare il pacco
     * @throws IllegalArgumentException se l'indice della scaffalatura non esiste o
     *                                  se è negativo
     */
    public void deposita(Pacco p, int end) {
        if (end > scaffali.size())
            throw new IllegalArgumentException("La scaffalatura non esiste");
        if (end < 0)
            throw new IllegalArgumentException("L'indice della scaffalatura non può essere negativo");
        scaffali.get(end).deposita(p);
    }

}
