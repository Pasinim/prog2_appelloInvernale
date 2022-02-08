import java.util.Arrays;
import java.util.Objects;

public class VettoreNullo implements Vettore {
    
    private final int vect[];
    public VettoreNullo(int dim){
        if (dim < 0) throw new IllegalArgumentException("La dimensione deve essere > 0");
        vect = new int[dim];
    }
    @Override
    public String toString() {
        return Arrays.toString(vect);
    }
    @Override
    public int dim() {
        return vect.length;
    }
    @Override
    public int val(int i) {
        if (i > this.dim()) throw new IllegalArgumentException("idx > dim. Trovato: " + i );
        return 0;
    }
    @Override
    public Vettore per(int alpha) {
        return this;
    }
    @Override
    public Vettore piu(Vettore v) {
        Objects.requireNonNull(v);
        return v;
    }
}
