//Eccezione che viene sollevata nel caso in cui si cerchi di 
//rimuovere un elemento quando la coda è vuota
public class EmptyException extends RuntimeException{
    public EmptyException(){    
        super();
    }

    public EmptyException(String msg){
        super(msg);
    }
    
}
