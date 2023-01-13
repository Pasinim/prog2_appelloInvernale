package tde.bancarelle;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Classe mutabile Compratore.
 * 
 * Rappresenta un consumer in grado di acquistare Giocattoli da un insieme di Bancarelle.
 */
public abstract class Compratore {
    private Set<Bancarella> bancarelle;
    
    /**
     * Inizializza un Compratore in grado di comprare dal Set b di bancarelle.
     * 
     * @param b Set di bancarelle
     */
    public Compratore(Set<Bancarella> b){
        this.bancarelle = new HashSet<>(b);
    }

    /**
     * Effettua un acquisto di num giocattoli di tipo Giocattolo.
     * Restituisce un Acquisto che descrive la transazione effettuata.
     * 
     * Solleva un'eccezione se la quantitá totale di giocattolo presente nelle bancarelle non raggiunge
     * quella indicata in num
     * 
     * @param num Numero di Giocattoli da comprare
     * @param giocattolo Giocattolo da comprare.
     * @return Acquisto relativo alla transazione.
     */
    public abstract Acquisto compra(final int num, final Giocattolo giocattolo);

    public Iterator<Bancarella> bancarelle(){
        Set<Bancarella> b = new HashSet<>(bancarelle);
        return b.iterator();
    }
}
