import java.util.*;
public class Costruttore_Lista {
    private final List<String> str;
    public Costruttore_Lista(List<String> s){
        this.str = List.copyOf(s);
    };

    public String toString(){
        return Arrays.toString(this.str.toArray());
    }
    public static void main(String[] args) {

    }
}
