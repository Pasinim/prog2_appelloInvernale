import java.util.Arrays;

public class VettoreNullo implements Vettore {
    
    private final int vect[];
    public VettoreNullo(int dim){
        if (dim < 0) throw new IllegalArgumentException("La dimensione deve essere > 0");
        vect = new int[dim];
    }
    @Override
    public String toString() {
        return "VettoreNullo [vect=" + Arrays.toString(vect) + "]";
    }
}
