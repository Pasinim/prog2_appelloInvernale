import java.util.*;

/**
 * OVERVIEW: Classe che rappresenta un vettore denso
 * AF:
 * RI:
 */
public class VettoreDenso implements Vettore {

    /**i
     * dichiaraare il vettore final non è una buona implementazione dato che devo eseguire le 
     * operazioni che dovranno modiifcare il vettore
     */
    private final int[] vect;

    /**
     * Inizializza un vettore di interi con il contenuto di a
     * @param a array di interi da cui inizializzare this
     * @throws NullPointerException se a = null
     * @throws IllegalArgumentException se a è vuoto
     * 
     */
    public VettoreDenso (int a[]){
        Objects.requireNonNull(a);
        if (a.length == 0) throw new IllegalArgumentException("Il vettore deve contenere almeno un elemento");
        vect = a.clone();
    }
    @Override
    public int dim() {
        return vect.length;
    }

    @Override
    public int val(int i) {
        if (i > vect.length || i < 0) throw new IndexOutOfBoundsException("Impossibile accedere a vect[" + i + "]");
        return vect[i];
    }

    /**
     * super()
     */
    @Override
    public Vettore per(int alpha) {
        if (alpha == 0) return new VettoreNullo(this.dim());
        final int[] mult = new int[this.dim()];
        for (int i = 0; i < vect.length; i++)
            mult[i] = alpha * this.val(i);
        return new VettoreDenso(mult);
    }

    @Override
    public Vettore piu(Vettore v) {
        if (!(this.conforme(v))) throw new IllegalArgumentException("Impossibile eseguire la somma su un vettore di dimensione differtente");
        final int[] sum = new int[this.dim()];
        for (int i = 0; i < vect.length; i++)
            sum[i] = v.val(i) + this.val(i);
        return new VettoreDenso(sum);
    }

    @Override
    public String toString(){
        return Arrays.toString(vect).replace("[", "(").replace("]", ")");
    }
    public static void main(String[] args) {
        
    }
}
