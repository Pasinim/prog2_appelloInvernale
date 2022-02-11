import java.util.*;
/**
 * 
 */
public class MatriceDiagonale extends MatriceAbs {
        
    private final int[][] mtx;
    
    /**
     * Istanzia una nuova matrice di dimensione dim*dim
     * @param dim
     */
    // private MatriceDiagonale(int dim){
    //     if (dim <= 0) throw new IllegalArgumentException("La dimensione della matrice deve essere almeno 1x1"); 
    //     mtx = new int[dim][dim];
    // }

    public MatriceDiagonale(int[] mtx){
        if (mtx.length == 0) throw new IllegalArgumentException("La dimensione della matrice deve essere almeno 1x1");
        Objects.requireNonNull(mtx);
        int len = mtx.length;
        this.mtx = new int[len][len];
        for (int i = 0; i < len; i++)
            this.mtx[i][i] = mtx[i];
    }


    @Override
    public Matrice prodottoScalare(int numb) {
        int[] prodotto = new int[dim()*dim()];
        for (int i = 0; i < this.dim(); i++)
                prodotto[i] = this.val(i, i)*numb;
        return new MatriceDiagonale(prodotto);
    }

    //devo fare tutti i casi per ogni matrice (nulla, diagonale, id)?
    @Override
    public Matrice sommaMat(Matrice o) {
        if (!conforme(o)) throw new IllegalArgumentException("Le operazioni possono essere eseguite solamente tra matrici conformi");
        int[] sum = new int[dim()*dim()];
        for (int i = 0; i < this.dim(); i++)
            for (int j = 0; j < this.dim(); j++)
                sum[i+j] = this.val(i,j) + o.val(i,j);
        return new MatriceDiagonale(sum);
    }

    @Override
    public Matrice prodMat(Matrice o) {
        if (!conforme(o)) throw new IllegalArgumentException("Le operazioni possono essere eseguite solamente tra matrici conformi");
        int[] prod = new int[dim()*dim()];
        for (int i = 0; i < this.dim(); i++)
            for (int j = 0; j < this.dim(); j++)
                prod[i+j] = this.val(i,j) * o.val(i,j);
        return new MatriceDiagonale(prod);
    }

    //TODO
    @Override
    public Matrice prodMat(Vettore v) {
        return new MatriceDiagonale(new int[]{1,2,3});
    }

    @Override
    public int dim() {
        return mtx.length;
    }

    @Override
    public int val(int i, int j) {
        if (i >= this.dim() || j >= this.dim() || i < 0 || j < 0)
            throw new IllegalArgumentException(String.format("I valori [%d %d] non sono validi", i, j ));
        return mtx[i][j];
    }

    public static void main(String[] args) {
        System.out.println("adadad");
    }
}
