package tde.bancarelle;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe mutabile ListinoStandard.
 * 
 * Implementa un Listino con politica d'acquisto standard, ogni prezzo verrá
 * calcolato con la seguente formula: prezzo = Giocattolo.prezzo * quantitá
 */
public class ListinoStandard implements Listino {
    private Map<Giocattolo, Integer> prezzi;

    /**
     * Inizializza un Listino vuoto.
     */
    public ListinoStandard(){
        prezzi = new HashMap<>();
    }

    /**
     * Dato un Giocattolo g e la relativa quantita restituisce il prezzo totale da pagare.
     * 
     * Il prezzo viene calcolato con una politica moltiplicativa.
     * 
     * Se g non é presente nel listino viene sllevata una eccezione.
     * 
     * @param g Giocattolo da acquistare.
     * @param quantita Quantita.
     * @return Prezzo da pagare.
     */
    public int getPrezzo(Giocattolo g, int quantita){
        if(!(prezzi.containsKey(g))){
            throw new IllegalArgumentException("Giocattolo non presente nel listino");
        }

        int prezzo = prezzi.get(g);

        return prezzo * quantita;
    }   

    /**
     * Aggiunge un Giocattolo g a this.
     * 
     * Se g é giá presente il suo prezzo viene aggiornato.
     * 
     * @param g Giocattolo da aggiungere
     */
    public void aggiungi(Giocattolo g, int prezzo){
        prezzi.compute(g, (key, value) -> value = prezzo);
    }

    /**
     * Rimuove il Giocattolo g dall'Inventario.
     * 
     * Se g non é presente viene sollevata un'eccezione
     * 
     * @param g Giocattolo da rimuovere
     */
    public void rimuovi(Giocattolo g){
        if(!(prezzi.containsKey(g))){
            throw new IllegalArgumentException();
        }

        prezzi.remove(g);
    }

    @Override
    /**
     * Ritorna stringa rappresentante stato di this.
     * 
     * @return String AF.
     */
    public String toString(){
        return prezzi.toString();
    }

    public static void main(String args[]){
        Giocattolo g1 = new Giocattolo("Biglia", "Vetro");
        Giocattolo g2 = new Giocattolo("Biglia", "Metallo");
        Giocattolo g3 = new Giocattolo("Vaso", "Vetro");
        Giocattolo g4 = new Giocattolo("Biglia", "Vetro");
        Giocattolo g5 = new Giocattolo("Vaso", "Vetro");
        Giocattolo g6 = new Giocattolo("Vaso", "Vetro");

        Listino l = new ListinoStandard();
        l.aggiungi(g1, 10);
        l.aggiungi(g2, 10);
        l.aggiungi(g3, 10);
        l.aggiungi(g1, 20);

        System.out.println(l);
        System.out.println(l.getPrezzo(g1, 20));
    }
}
