import java.util.*;
/**
 * 
 */
public class MatriceDiagonale extends MatriceAbs {
        
    private final int[] mtx;
    
    public MatriceDiagonale(int dim){
        if (dim <= 0) throw new IllegalArgumentException("La dimensione della matrice deve essere almeno 1x1"); 
        mtx = new int[dim];
    }

    public MatriceDiagonale(int[] mtx){
        if (mtx.length == 0) throw new IllegalArgumentException("La dimensione della matrice deve essere almeno 1x1");
        this.mtx = Objects.requireNonNull(mtx);
    }


    @Override
    public Matrice prodottoScalare(int numb) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Matrice sommaMat(Matrice o) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Matrice prodMat(Matrice o) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Matrice prodMat(Vettore v) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int dim() {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
