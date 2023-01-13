import java.util.List;
import java.util.LinkedList;
/** 
 * Le istanze di questa classe rappresentano code (illimitate) 
 * di interi FIFO. Gli oggetti sono mutabili
 */
public class UnboundedIntQueue {
    //CAMPI
    //Struttura dati che contiene gli elementi di IntQUeue
    private final List<Integer> elements;
    /**
     * Head e tail rappresentano gli indici della coda .
     * Head indica il primo elemento di IntQueue, -1 se è vuota
     * Tail rappresenta la prima posizione disponibile, quando tail==head 
     * non è possibile aggiungere elementi
     */
   
    /**
     * AF: Dominio: oggetti concreti, dominio: oggetto astratto:
     * AF(elements) -->  [elements[i]]= 
     *                          [] se elements.isEmpty = true la coda è vuota
     *                          se isEmpty == false: (elements[0], elements[1] ... elements.size()-1)
     *                        
     * IR: 
     *      - elements non deve essere null
     *      - 0 <= elements[i] < element.size-1
     
     
     */
    //COSTRUTTORI
    /**
     *POSTCONDIZIONI: inizializza this affinchè sia una coda vuota
     */
    public UnboundedIntQueue(){
        elements = new LinkedList<>(); 
        
        assert repOk();
    }
    //METODI
        /**
     *PRECONDIZONI: 
     *EFFETTI COLLATERALI: potrebbe modificare this
     *POSTCONDIZIONI:   aggiunge n alla coda
                        
     */
    public void enqueue (int n){
        elements.add(n);
        assert RepOk();
    }

    //PostCondizioni: restituisce true se la coda è vuota, false altrimenti
    public boolean isEmpty(){
        return elements.isEmpty();
    }
        /**
     *PRECONDIZONI: 
     *EFFETTI COLLATERALI: potrebbe modificare this
     *POSTCONDIZIONI:   rimuove e restituisce l'intero nella testa della coda
                        se la coda è piena solleva un'eccezione di tipo EmptyException
     */
    public int dequeue(){
        if (isEmpty()) throw new EmptyException("Impossibile rimuovere. Coda vuota");
        return elements.remove(0);
        
        assert repOk();
    }

    public int size (){
        return elements.size();
    }

    @Override
    public String toString(){
        assert repOk();

        String str = "IntQueue: [";
        int i;
        if (!isEmpty()){
            for (i=0; i<size()-1; i++)
                str+=elements.get(i) + ", "; 
            str+=elements.get(0); //perchè l'ultimo elemento non ha  la virgola 
        }
        return str + "]";
    }

    // @Override
    // public booean equals(IntQueue other){}

    //POSTCONDIZIONI: implementa la funzione di astrazione
    private boolean repOk(){
        //metto in end le condizioni nella AF
        return elements!=null
            && elements.size>=0;
    }
}
