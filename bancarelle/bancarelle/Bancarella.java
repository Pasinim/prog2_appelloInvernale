package bancarelle;

import java.util.*;

/**
 * Le istanze di questa classe rappresentano una bancarella, identificata da
 * proprietario, inventario e listino.
 * AF: "bancarella di" + this.proprietario + quantità + giocattolo.toString() + prezzo
 * IR:  listino.size = inventario.size
 *      listino != null
 *      proprietario != null
 *      inventario != null
 */
public class Bancarella { 
    public final String proprietario;
    private Inventario inventario;
    private Listino listino; 
    /**
     * Inizializza una nuova bancarella. Se uno dei parametri passati è NULL solleva
     * una eccezione di tipo NullPointerException.  
     * @param inventario inventario della bancarella
     * @param listino listino
     */
    public Bancarella (String proprietario, Inventario inventario, Listino listino){
        Objects.requireNonNull(proprietario);
        Objects.requireNonNull(inventario);
        Objects.requireNonNull(listino);

        this.proprietario = proprietario;
        this.inventario = inventario;
        this.listino = listino;
    }

    @Override
    public String toString(){
        String str = "Bancarella di: ";
        str += proprietario + "\n";
        Iterator<Giocattolo> it_inv = inventario.iterator();
        while (it_inv.hasNext()){
            Giocattolo g = it_inv.next();
            str += "num. " + inventario.getQuantita(g) + " " + g.toString() + ", prezzo: " + listino.getPrezzo(g) + "\n";
        }
        return str;
    }
}
