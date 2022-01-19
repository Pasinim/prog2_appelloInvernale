package piastrelle.piastrelle;

import java.util.Objects;

public class Quadrata implements Rivestimento {

    public final int l;
    public final int c;

    public Quadrata(int lungh, int costo){
        if (lungh < 1 || costo < 1) throw new IllegalArgumentException();
        l = lungh;
        c = costo;
    }

    @Override
    public int getSuperficie() {
        return l*l;
    }

    @Override
    public int getCosto() {
        return c;
    }
    
}
