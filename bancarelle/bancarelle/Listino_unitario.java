package bancarelle;
import java.util.*;
/**
 * Classe concreta che estende l'interfaccia 'Listino'. Ogni bancarella possiede un listino con il prezzo di ciascun giocattolo.
 */

public class Listino_unitario implements Listino, Iterable<Giocattolo> {

    public final Map<Giocattolo, Integer> listino;
    
    /**
     * Inizializza un nuovo listino.
     * Se listino è null solleva una eccezione
     * @param listino Listino dei giocattoli e dei relativi prezzi
     */
    public Listino_unitario (Map<Giocattolo, Integer> listino){
        Objects.requireNonNull(listino);
        this.listino = listino;
    }

    public void addPrezzo(Giocattolo g, int p){
        Objects.requireNonNull(g);
        if (p <= 0) throw new IllegalArgumentException();
        this.listino.replace(g, p);
    }

    /**
     * Crea un iteratore sfruttando il metodo keySet implementato nella mappa di listino
     * @return iteratore su (giocattoli del) listino
     */
    @Override
    public Iterator<Giocattolo> iterator() {
        List<Giocattolo> lg = new ArrayList<>(listino.keySet());
        return lg.iterator();
    }

    /**
     * Restituisce il prezzo del giocattolo g
     * Solleva una eccezione se g non è nel listino oppure 
     * se g è null
     */
    public int getPrezzo(Giocattolo g){
        Objects.requireNonNull(g);
        if (!listino.containsKey(g)) throw new IllegalArgumentException("Giocattolo non presente nel listino");
        return listino.get(g).intValue();
    }

    @Override
    public String toString(){
        String str = "";
        Iterator<Giocattolo> it = this.iterator();
        while (it.hasNext()){
            Giocattolo g = it.next();
            str += g.toString() + " prezzo: " + this.getPrezzo(g) + "\n";
        }
        return str;
    }

    @Override
    /**
     * Dato che la politica di prezzo è unitaria il prezzo totale è ottenuto semplicemento moltiplicando.
     * Se qnty <=0, g è NULL oppure non è presente nel listino solleva una eccezione
     * @return qnty* prezzo di g
     */
    public float prezzo_acquisto(int qnty, Giocattolo g) throws IllegalArgumentException {
        Objects.requireNonNull(g);
        if (qnty <= 0) throw new IllegalArgumentException("La quantità deve essere positiva. Trovato " + qnty);
        if (!(listino.containsKey(g))) throw new IllegalArgumentException("Giocattolo non presente nell'inventario");
        float tot = 0;
        for (Map.Entry<Giocattolo, Integer> entry : listino.entrySet())
            if (g.equals(entry)) tot += qnty * listino.get(g);
        return tot;
    }

    
    public static void main(String[] args) {
        final Map<Giocattolo, Integer> giochi  = new HashMap<Giocattolo, Integer>();
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            String line = input.nextLine();
            String tkns[] = line.split(" ");
            Giocattolo g = new Giocattolo(tkns[0], tkns[1]);
            //se il giocattolo è già presente aumento la quantità
            if (giochi.containsKey(g)) {
                System.out.println("Giocattolo già presente, inserisco la nuova quantità\n");
                giochi.replace(g, giochi.get(g)+1);
            }else{
                giochi.put(g, 1);
            } 
        }
        input.close();
        //qui associo ad ogni giocattolo il prezzo
        Listino_unitario l = new Listino_unitario(giochi);
        System.out.println("Aggiungo i prezzi\n");
        
    }   
}

