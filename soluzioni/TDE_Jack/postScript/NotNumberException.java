package tde.postScript;

public class NotNumberException extends RuntimeException {
    public NotNumberException(){
        super();
    }

    public NotNumberException(String s){
        super(s);
    }
}
