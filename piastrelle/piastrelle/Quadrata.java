package piastrelle;
import java.util.*;

public class Quadrata extends Piastrella {

    public final int l;

    public Quadrata(int lungh, int costo){
        super(costo);
        if (lungh < 1) throw new IllegalArgumentException();
        l = lungh;
    }

    @Override
    public int getSuperficie() {
        return l*l;
    }
    
}
