import java.util.*;


public class Locomotore extends Rotabile {
    private final int potenza;
    public Locomotore(final String modello, final int peso, final int pot){
        super(modello, peso);
        if (pot < 0) throw new IllegalArgumentException("La potenza non può essere negativa");
        this.potenza = pot;
    }

    public String toString(){
        return String.format("Locomotore: modello = %s, peso = %d, potenza = %d\n", getModello(), getPeso(), potenza);
    }
}
