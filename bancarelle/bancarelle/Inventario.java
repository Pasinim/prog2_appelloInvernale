package bancarelle;

import java.util.*;

/**
 * Le istanze di questa classe rappresentano l'inventario di una bancarella. L'inventario indica,
 * per ogni giocattolo, la quanità relativa. La classe fornisce anche i metodi necessari al suo aggiornamento, 
 * nel caso di aggiunta o rimozione di giocattoli
 * AF:  str += "num. " + this.getQuantita(g) + " " + g.toString() +"\n";
 * IR: inventario != NULL
 */
public class Inventario implements Iterable<Giocattolo>{

     /**variabile d'istanza che rappresenta l'inventario. La sua visitbilità è privata per non esporre la rappresentaione.
     * Un utente non è così in grado di assegnare un nuovo inventario, ma solamente di aggiungere o rimuovere
     * giocattoli
     */
    public final Map<Giocattolo, Integer> inventario;
    /**
     * Inizializza un nuovo inventario. Se inventario è NULLl solleva una eccezione di tipo NullPointerException
     * @param inventario
     */
    public Inventario(Map<Giocattolo, Integer> inventario){
        Objects.requireNonNull(inventario);
        this.inventario = inventario;
    }

    /**
     * Aggiunge g all'inventario. Se g è null solleva una eccezione.
     * @param g Giocattolo da aggiungere all'inventario
     */
    public void aggiungi(Giocattolo g, int qnty){
        Objects.requireNonNull(g);
        inventario.put(g, qnty);
    }

   /**
    * Rimuove g all'inventario. Se g è null solleva una eccezione.
    * @param g Giocattolo da rimuovere dall'inventario
    */    
    public void rimuovi (Giocattolo g){
        Objects.requireNonNull(g);
        if (!(inventario.containsKey(g))) throw new IllegalArgumentException("Giocattolo non presente, impossibile rimuovere");
        if (inventario.get(g) == 1) inventario.remove(g);
        else
            inventario.replace(g, inventario.get(g)-1); 
        return;
    }

    /**
     * Metodo che crea un iteratore che itera sull'inventario.
     * Per fare ciò non è necessario definire sia il metodo hasNext()
     * che il metodo next() ma è sufficiente iterare sul set.
     */
    @Override
    public Iterator<Giocattolo> iterator() {
        List<Giocattolo> lg= new ArrayList<>(inventario.keySet());
        return lg.iterator();
    }
    
    /**
     * Restituisce la quantità del giocattolo g.
     * Solleva una eccezione se il giocattolo non è presente nell'inventario
     * oppure se g è NULL
     * @param g Giocattolo
     * @return quantità di g presente nell'inventario
     */
    public int getQuantita(Giocattolo g){
        Objects.requireNonNull(g);
        if (!inventario.containsKey(g)) throw new IllegalArgumentException("Giocattolo non presente nell'inventario");
        return inventario.get(g);
    }
    
    @Override
    public String toString(){
        String str = "";
        Iterator<Giocattolo> it = this.iterator();
        while (it.hasNext()){
            Giocattolo g = it.next();
            str += "num. " + this.getQuantita(g) + " " + g.toString() +"\n";
        }
        return str;
    }

    //non serve
    // @Override
    // public int hashCode(){
    //     int res = 31;
    //     Iterator<Giocattolo> it = this.iterator();
    //     while (it.hasNext())
    //         res += 37 * it.next().hashCode();
    //     return res;
    // }

    // public static void main(String[] args) {
    //     final Map<Giocattolo, Integer> giochi  = new HashMap<Giocattolo, Integer>();
    //     Scanner input = new Scanner(System.in);
    //     while (input.hasNext()){
    //         String line = input.nextLine();
    //         String tkns[] = line.split(" ");
    //         Giocattolo g = new Giocattolo(tkns[0], tkns[1]);
    //         //se il giocattolo è già presente aumento la quantità
    //         if (giochi.containsKey(g)) {
    //             System.out.println("Giocattolo già presente, inserisco la nuova quantità\n");
    //             giochi.replace(g, giochi.get(g)+1);
    //         }else{
    //             giochi.put(g, 1);
    //         } 
    //     }
    //     input.close();
    //     Inventario i = new Inventario(giochi);
    //     System.out.println("Ora stampo l'inventario con l'iteratore: \n" + i.toString());
        
    //     }
    
    }

