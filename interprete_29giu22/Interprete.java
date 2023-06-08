import java.util.HashMap;
import java.util.List;

public class Interprete {
    
    private final List<Istruzione> istruzioni;

    private final Map<Character, Integer> variabili;

    public Interprete(final ArrayList<Istruzione> istr) {
        istruzioni = List.copyOf(istr);
        variabili = new HashMap<>();
    }
    
    int valuta(int[] ingresso) {
        if (ingresso.length > 26)
            throw new IllegalArgumentException("Ingresso deve contenere al più 26 interi. Trovati " + ingresso.length);
        for (int i = 0; i < ingresso.length; i++) 
            this.variabili.put("A" + i, ingresso[i]);
        

    }
}
