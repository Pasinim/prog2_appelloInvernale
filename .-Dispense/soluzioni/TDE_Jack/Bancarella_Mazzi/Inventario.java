import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Ogni bancarella offre un certo insieme di giocattoli, per tener traccia di quanti e quali
 *  giocattoli offra in un certo momento è utile usare un inventario: una classe in grado di tener 
 * traccia dei giocattoli man mano aggiunti ed eliminati (ad esempio perché venduti) dalla bancarella.
 */

/**
 * Le istanze di questa classe rappresentano una bancarella, la quale è formata da un insieme di giocattoli e
 * permette di aggiungere e di eliminare giocattoli da questo insieme.
 * Le istanze di questa classe sono mutabili e quindi è necessario avere i campi private.
 */
public class Inventario{
    
    /**
     * IR: {@link giocattoli} non può essere {@code null}, nessuno dei suoi elementi può essere  {@code null}
     * e il valore associato al giocattolo non può essere negativo.
     * Tale invariante è sempre assicurato dal suo unico costruttore e dal repOk. 
     */

    private Map<Giocattolo,Integer> giocattoli;

    public Inventario(){
        this.giocattoli = new HashMap<>();
    }

    /**
     * Post condizioni: inserisce il giocattolo indicato all'interno dell'insieme aumentando di 1 il valore
     * ad esso associato se questo fa già parte dell'insieme, altrimenti associa ad esso il valore 1.
     * Solleva un'eccezione di tipo {@link NullPointerException} nel caso in cui il giocattolo passato in
     * input sia null.
     * Effetti collaterali: modifica giocattoli
     * @param giocattolo da inserire
     */
    public void addGiocattolo(Giocattolo giocattolo){
        Objects.nonNull(giocattolo);
        if(giocattoli.containsKey(giocattolo)){
            giocattoli.replace(giocattolo, giocattoli.get(giocattolo)+1);
        }else{
            giocattoli.put(giocattolo, 1);
        }
        assert repOk();
    }

    /**
     * Post condizioni: elimina il giocattolo indicato all'interno dell'insieme diminuendo di 1 il valore
     * ad esso associato se questo fa già parte dell'insieme, altrimenti lo rimuove.
     * Solleva un'eccezione di tipo {@link NullPointerException} nel caso in cui il giocattolo passato in
     * input sia null.
     * Solleva un'eccezione di tipo {@link IllegalArgumentException} nel caso in cui il giocattolo passato in
     * input non faccia parte dell'insieme dei giocattoli.
     * Effetti collaterali: modifica giocattoli
     * @param giocattolo da rimuovere
     */
    public void removeGiocattolo(Giocattolo giocattolo){
        Objects.nonNull(giocattolo);
        try{
            giocattoli.replace(giocattolo, giocattoli.get(giocattolo)-1);
            if(giocattoli.get(giocattolo) == 0) giocattoli.remove(giocattolo);

        }catch(NullPointerException e){
            throw new IllegalArgumentException("il giocattolo indicato non è presente nell'inventario");
        }
        assert repOk();
    }

    public boolean repOk(){
        if(Objects.isNull(giocattoli)) return false;
        for(Map.Entry<Giocattolo,Integer> g : giocattoli.entrySet()){
            if(Objects.isNull(g) || g.getValue() < 0) return false;
        }
        return true;
    }

    public boolean contains(Giocattolo g){
        return giocattoli.containsKey(g);
    }

    public Map<Giocattolo, Integer> getGiocattoli() {
        return giocattoli;
    }

    @Override
    public String toString() {
        String s = new String();
        for(Map.Entry<Giocattolo,Integer> g : giocattoli.entrySet()){
            s+=g.getValue()+ g.getKey().toString();
            s+= "\n";
        }
        return s;
    }

    
}
