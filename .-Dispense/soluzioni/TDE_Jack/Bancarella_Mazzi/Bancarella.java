import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Ogni bancarella è identificata da un proprietario (che è rappresentato tramite una stringa) e 
 * ha i suoi inventario e listino; evidentemente il listino deve permettere di conoscere il prezzo
 *  di ciascun giocattolo presente nell'inventario.
 *Una bancarella deve poter indicare quanti giocattoli di un certo tipo è in grado di vendere e a che
 *prezzo, nonché procedere alla vendita (aggiornando l'inventario).
 */

/**
 * Le istanze di questa classe rappresentano una bancarella.
 * Ciascuna bancarella ha associato un proprietario (definito da una stringa), da un inventario di giocattoli
 * e da un listino.
 * La bancarella è tale per cui è possibile sapere quanti giocattoli di un dato tipo è un grado
 * di vendere e a che prezzo ed effettuare la vendita.
 * Le istanze di questa classe sono mutabili, perciò è necessario che i suoi campi mutevoli devono essere
 * definiti private.
 */
public class Bancarella {

    /**
     * IR: {@link proprietario} non può essere {@code null}, {@link PoliticaMoltiplicativa} non può essere {@code null},
     * {@link Inventario} non può essere {@code null} e non può contenere alcun elemento {@code null}.
     * Tale invariante è assicurato dal suo unico costruttore e dal repOk.
     */
    public final String proprietario;
    public final PoliticaMoltiplicativa pm;
    private Inventario inventario;

    /**
     * Solleva un'eccezione del tipo {@link NullPointerException} nel caso in cui {@link proprietario} sia null.
     * @param proprietario della bancarella
     */
    public Bancarella(String proprietario){
        Objects.nonNull(proprietario);
        this.proprietario = proprietario;
        this.inventario = new Inventario();
        this.pm = new PoliticaMoltiplicativa();
    }

    /**
     * Solleva un'eccezione del tipo {@link NullPointerException} nel caso in cui {@link g} sia null.
     * Solleva un'eccezione del tipo {@link IllegalArgumentException} nel caso in cui {@link g} non sia presente nell'inventario.
     * @param g giocattolo 
     * @return il numero di giocattoli che è possibile acquistare, 0 se il giocattolo non è presente
     */
    public int getNumberOfGiocattolo(Giocattolo g){
        Objects.nonNull(g);
        int quantità = 0;
        Set<Map.Entry<Giocattolo,Integer>> entrySet= inventario.getGiocattoli().entrySet();
        for(Map.Entry<Giocattolo,Integer> entry : entrySet){
            if(entry.getKey().equals(g)) quantità =  entry.getValue();
        }
        return quantità;
    }

    /**
     * Pre condizioni: {@link quantità} è strettamente positiva
     * Post condizoni: aggiorna il numero di oggetti nell'inventario.
     * Solleva un'eccezione del tipo {@link IllegalArgumentException} nel caso in cui la {@link quantità} sia maggiore del numero di giocattoli nell'inventario.
     * Effetti collaterali: modifica inventario.
     * @param giocattolo da acquistare
     * @param quantità da acquistare
     */
    public void vendiGiocattolo(Giocattolo giocattolo, int quantità){
        if(getNumberOfGiocattolo(giocattolo) < quantità) throw new IllegalArgumentException("Non vi sono abbastanza giocattoli");
        for(int i = 0; i < quantità;i++){
            inventario.removeGiocattolo(giocattolo);
        }
        assert repOk();
    }

    public boolean repOk(){
        if(Objects.isNull(proprietario)) return false;
        if(Objects.isNull(inventario)) return false;
        Set<Map.Entry<Giocattolo,Integer>> entrySet= inventario.getGiocattoli().entrySet();
        for(Map.Entry<Giocattolo,Integer> entry : entrySet){
            if(Objects.isNull(entry)) return false;
        }
        if(Objects.isNull(pm)) return false;
        return true;
    }

    @Override
    public String toString() {
        String s = new String();
        s += "Bancarella di: " + inventario;
        Set<Map.Entry<Giocattolo,Integer>> entrySet= inventario.getGiocattoli().entrySet();
        for(Map.Entry<Giocattolo,Integer> entry : entrySet){
            s+= String.format("num. %d %s, prezzo: %d", entry.getValue(), entry.getKey().toString(),entry.getKey().prezzo);
        }
        return s;
    }

}
