import java.util.concurrent.ThreadPoolExecutor;

//OVERVIEW: le istanze di questa classe rappresentano code FIFO di interi di dimensione prefissata
// Gli oggetti di questa classe sono mutabili
public class IntQueue {
    //CAMPI
    //istanza che rappresenta la coda
    private final int[] els;
    //istanze che rappresentano l'inizio e la fine della coda.
    //head rappresenta la posizione del primo elemento e vale -1 se la coda è vuota.
    private int head, tail;

    /** 
     * ABS FUN: AF(els, head, tail) -> 
     *      {els[i] | head <= i <= tail}
     *      {els[head], els[head+1], ..., els[tail-1]} se -1 <= head <= tail 
     *      {els[head], ..., els[size-1], els[0], els[tail-1]}  se head>size
     * 
     * REP INV: La dimensione della coda può essere al massio els.size-1
     *      -1 <= head < size
     *      0 <= tail < size 
     *      head = -1 -> tail = 0 
     * 
     * ABS INV: size > 0
     *          isEmpty ->  head = -1 -> tail = 0 
     *          !isEmpty -> head && tail >= 0
     *      
     */

    //COSTRUTTORI
    //EFFECTS inizializza una lista vuota di dimensione n. Se n <= 0 solleva una eccezione IllegalArgumentException
    /**
     * Correttezza: AF(els, head, tail) = {}, head = -1; tail = 0;
     * Preservazione RI: head = -1; tail = 0, quindi entrambe minore di size
     * Preservazione AI: size > 0
     */
    public IntQueue (int n){
        if (n<=0) throw new IllegalArgumentException("n must be > 0. Found " + n);
        els = new int[n];
        head = -1; 
        tail = 0;
    }

    //METODI
    /**
     * Effects: aggiunge l'elemento x alla coda. Se la coda è piena solleva un'eccezione di tipo ILlegalArgument
     * Correttezza: Assumo di avere una coda {x_1, x_2, ..., x_n}, dove n<size.
     *              se la coda non è piena la coda in segito all'aggiunta di x sarà {x_1, x_2, ..., x_n, x} se head < tail 
     *              {x, x_1, x_2, ..., x_n} se head > tail (in questo esempio tail = 0)
     * Preservazione RI: head e tail < size dato che sto operando con il modulo
     * Preservazione AI: size > 0 per il costruttore
     */
    
    public void enqueue(int x){
        if (isFull()) throw new IllegalArgumentException("coda piena, impossibil aggiungere elementi");
        if (head == -1){
            head = 0;
        }
        els[tail] = x;
        tail = (tail + 1) % els.length;
    };

    /**
     * Effects: restiuisce l'elemento nella testa rimuoendonodall'insieme. Se la coda è vuota solleva un'eccezione
     * Correttezza: Assumo di avere una coda {x_1, x_2, ..., x_n}, dove n<size.
     *              se la coda non è piena la coda in segito alla rimozione dell'elemento in testa sarà { x_2, ..., x_n, x} (in questo es head == 0)
     * Preservazione RI: (head + 1) % els.length -> head < size
     *                      se head == tail -> head = -1 && tail == 0 
     * Preservazione AI:    
     */
   public int dequeue(){
       if (isEmpty()) throw new IllegalArgumentException("La coda è vuota, impossibile rimuovere elementi");
        int el = els[head];
        head = (head + 1) % els.length;
        if (head == tail){
            head = -1;
            tail = 0;
        }
        return el;

   };

   //EFFECTS: restituisce l'indice dell'elemento in posizione x. Se non è presente restituisce -1
   public int getIdx (int x){
       for (int i=0; i<els.length; i++)
            if (els[i] == x) return i;
        return -1;
   }
   //EFFECTS: restitusice true se la coda è piena, false altrimenti
     public boolean isFull(){
       return head == tail;
   }

   //EFFECTS: restitusice true se la coda è vuota, false altrimenti
   public boolean isEmpty(){
       return head == -1;
   }

   public int size (){
    if (isEmpty()) return 0;
    if (isFull()) return els.length;
    return (tail - head + els.length) % els.length;
   }

    @Override
    public String toString(){
        String r = "IntQueue : [";
        if (!isEmpty()) {
          int i;
          for (i = 0; i < size() - 1; i++) r += els[(head + i) % els.length] + ", ";
          r += els[(head + i) % els.length];
        }
        return r + "]";
    }

    @Override 
    public boolean equals(Object o){
        if (!(o instanceof IntQueue)) return false;
        IntQueue other = (IntQueue) o; 
        if (other.size() != this.size() 
            || other.els.length != this.els.length) return false;

        for (int i = 0; i < this.size(); i++)
            if (this.els[(this.head + i) % els.length] 
                != other.els[(other.head + i) % other.els.length]) return false;
        return true;
    }

    @Override 
    public int hashCode (){
        //JS 3.8
        int result = 17; //salvo una costante diversa da zero
        for (int i = 0; i<this.size(); i++)
            result = 37 * result + Integer.hashCode(this.els[(head + i) % els.length]);
        return result;          
    }

    private boolean repOk(){
        return head > -1
            && head < els.length
            && tail >= 0
            && tail < els.length
            && (head != -1 || tail == 0);
    }
}

