    //OVERVIEW: eccezione sollevata nel caso di insieme vuoto
public class EmptyException extends RuntimeException{
    //costruttori
    public EmptyException() {
        super();
    } //eredito il costruttore della superclasse RuntimeExeptio
    public EmptyException(String m) {
     super(m);
    }
}
