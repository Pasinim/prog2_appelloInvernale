package tde.bancarelle;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

/**
 * Classe immutabile Acquisto.
 * 
 * Rappresenta un Acquisto fatto da un cliente.
 * 
 * Ogni acquisto deve avvenire per una quantitá > 0 di un determinato tipo di
 * Giocattolo
 */
public class Acquisto {
    private final Map<Bancarella, Integer> bancarelle;
    private final Giocattolo g;
    private final int quantita;
    private final int prezzo;

    /**
     * Inizializza un Acquisto di Giocattolo g in quantita q dalla lista di
     * Bancarelle b
     * 
     * @param b Bancarelle da cui effettuo l'acquisto con relative quantitá.
     * @param g Tipo di Giocattolo g da acquistare.
     * @param q Totale quanititá acquistata.
     */
    public Acquisto(Map<Bancarella, Integer> b, Giocattolo g, int q, int p) {
        if (q <= 0) {
            throw new IllegalArgumentException();
        }

        this.bancarelle = new HashMap<>(b);
        this.g = g;
        this.quantita = q;
        this.prezzo = p;
    }

    @Override
    /**
     * Ritorna stringa rappresentante stato di this.
     * 
     * @return String AF.
     */
    public String toString(){
        StringBuilder ret = new StringBuilder(String.format("Acquisto di %s, per un costo di %s, numero %d di cui:\n", this.g.toString(), this.prezzo, this.quantita));

        for ( Entry<Bancarella, Integer> entry : bancarelle.entrySet()) {
            ret.append(String.format("%d da %s", entry.getValue(), entry.getKey().getOwner()));
        }

        return ret.toString();
    }
}   
