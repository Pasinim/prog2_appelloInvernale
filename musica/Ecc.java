import java.util.*;
public class Ecc {
    private final List<String> str;
    public Ecc(List<String> s){
        Objects.requireNonNull(s);
        if (s.isEmpty()) throw new IllegalArgumentException("La stringa non può essere nulla");
        this.str = List.copyOf(s);
    };

    public void metodoSbagliato(List<String> str){
        try{
            Ecc a = new Ecc(str);
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException("Errore in metodoSbagliato (" + e.toString() + ")" );
        }
    }

    public String toString(){
        return Arrays.toString(this.str.toArray());
    }
    public static void main(String[] args) {

    }
}
