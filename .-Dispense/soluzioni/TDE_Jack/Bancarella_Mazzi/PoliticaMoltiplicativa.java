
/**
 * Le istanze di questa classe rappresentano una politica moltiplicativa.
 * Le istanze di questa classe sono immutabili e restituiscono il prezzo totale dato un giocattolo,il suo prezzo
 * e la quantità di questo da acquistare.
 * Essendo una classe immutabile possiamo permetterci di avere campi pubblici.
 */
public class PoliticaMoltiplicativa implements ListinoPrezzi{

    public PoliticaMoltiplicativa(){
    }

    /**
     * @param g giocattolo
     * @param quantità da acquistare
     * @return quantità * prezzoAcquisto.
     */
    @Override
    public int politicaMoltiplicativa(Giocattolo g, int quantità) {
        if(g.prezzo < 0) throw new IllegalArgumentException("il prezzo d'acquisto non può essere negativos");
        if(quantità < 0) throw new IllegalArgumentException("la quantità da accquistare non può essere negativa");
        return quantità * g.prezzo;
    }
}