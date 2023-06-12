package Indirizzi;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Le istanze di questa classe rappresentano un alias per un insieme di
 * indirizzi email aventi tutte
 * lo stesso dominio
 */
public class Alias {

    public final String nome;
    public final Dominio dominio;
    private final Set<Indirizzo> indirizzi;

    /**
     * Inizializza un nuovo ALias con nome e dominio speciificati   
     * @param nome il nome dell'alias
     * @param d il dominio dell'alias
     * @thriws NullPointerException se nome o d sono null
     * @throws IllegalArgumentException se nome è una stringa vuota
     */
    public Alias(String nome, Dominio d) {
        Objects.requireNonNull(nome, "Il nome non può essere null");
        if (nome.isEmpty())
            throw new IllegalArgumentException("Il nome non può essere una stringa vuota");
        Objects.requireNonNull(d, "Il dominio non può essere null");
        this.nome = nome;
        this.dominio = d;
        indirizzi = new HashSet<>();
    }

    /**
     * Aggiunge i all'insieme di indirizzi dell'alias. Se l'indirizzo è già presente non fa nulla.
     * @param i indirizzo da aggiungere
     * @throws IllegalArgumentException se il dominio di i non è lo stesso di quello dell'alias
     */
    public void aggiungi(Indirizzo i) {
        if (!i.dominio.equals(dominio))
            throw new IllegalArgumentException("L'indirizzo non appartiene al dominio dell'alias");
        indirizzi.add(i);
    }
}
