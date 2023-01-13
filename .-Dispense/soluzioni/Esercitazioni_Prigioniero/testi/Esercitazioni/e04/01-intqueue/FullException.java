//eccezione che viene sollevata nel caso in cui si cerchi
//di aggiungere un elemento in una coda piena
public class FullException extends RuntimeException {
    public FullException(){    
        super();
    }

    public FullException(String msg){
        super(msg);
    }   
}
