/**
 * OVERVIEW: eccezione che viene sollevata nel caso in cui il polinomio sia vuoto
 */

public class EmptyException extends RuntimeException{
    public EmptyException(){
        super();
    }
    
    public EmptyException(String msg){
        super(msg);
    }
}
