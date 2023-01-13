
//eccezione sollevata nel caso in cui venga inserito un esponente negativo
public class NegativeExponentException extends RuntimeException{
    public NegativeExponentException() {
        super();
    }

    public NegativeExponentException(String m){
        super(m);
    }   
}
