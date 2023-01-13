package tde.bancarelle;

import java.util.Map;

/**
 * Interfaccia Listino.
 * 
 * Permette di definire una politica d'acquisto relativa ai Giocattoli e alle quantitá da acquistare.
 */
public interface Listino {
    /**
     * Dato un Giocattolo g e la relativa quantita restituisce il prezzo totale da pagare.
     * 
     * @param g Giocattolo da acquistare.
     * @param quantita Quantita.
     * @return Prezzo da pagare.
     */
    public int getPrezzo(Giocattolo g, int quantita);

    /**
     * Aggiunge un Giocattolo g a this.
     * 
     * Se g é giá presente il suo prezzo viene aggiornato.
     * 
     * @param g Giocattolo da aggiungere
     */
    public void aggiungi(Giocattolo g, int prezzo);

    /**
     * Rimuove il Giocattolo g dall'Inventario.
     * 
     * Se g non é presente viene sollevata un'eccezione
     * 
     * @param g Giocattolo da rimuovere
     */
    public void rimuovi(Giocattolo g);

    /**
     * Ritorna stringa rappresentante stato di this.
     * 
     * @return String AF.
     */
    public String toString();
}
