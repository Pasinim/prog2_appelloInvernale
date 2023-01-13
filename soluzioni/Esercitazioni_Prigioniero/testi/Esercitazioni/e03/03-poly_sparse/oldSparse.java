import java.util.Objects;
/**
 * OVERVIEW: le istanze di questa clase rappresentano polinomi sparsi. 
 * Gli oggetti di questa classe non sono mutabili.
 */
public class Sparse {
    //CAMPI
    private final int degree[];
    private final int terms[];

    //COSTRUTTORI
    /**
     * EFFECTS: Inizializza un nuovo polinomio zero 
     *  */ 
    public Sparse (){
        terms = new int[1];
        degree = new int[1];
    }

    /**
     * EFFECTS: Inizializza  un nuovo polinomio cx^n.
     *          Se n<0 viene sollevata una eccezione NegativeExponentException
     */
    public Sparse (int c, int n){
        if (n<0) throw new NegativeExponentException("n must be positive. Found: " + n);
        if (n == 0){
            degree = new int[1];
            terms = new int[1];
            //degree[0] = terms[0] = 0; lo fa in automatico
        }else{
            degree = new int[1];
            terms = new int[1];
            terms[0] = c; degree[0] = n;
        }
    }

    //EFFECTS

    /**
     * AF: AF(terms, size) --> terms[a_1, ... a_n], degree[b_1, ..., b_n] = a_1x^(b_1) + ... + a_nx^(b_n)
     * REP INV: terms.size == degree.size,
     *          terms == degree != null
     * ABS INV: terms.size == degree.size
     */
    
     //Metodi:
     //REQUIRES: deg > 0
     //EFFECTS: restituisce l'indice di deg in this.degree
    public int degIdx (int deg){
        for (int i=0; i<degree.length; i++)
            if (this.degree[i] == deg) return i;
        throw new IllegalArgumentException("Indice di " + deg + " non trovato")     ;
    }

     //EFFECTS: restituisce il coefficente del termine di grado deg 
     public int coeff (int deg){
        return terms[this.degIdx(deg)];
     }

     //EFFECTS: restituisce true
     public boolean isIn(int elem, Sparse q){
         Objects.requireNonNull(q);
         for (int i=0; i<q.degree.length; i++)
            if (elem == q.degree[i]) return true;
        return false;
     }

     //EFFECTS:
     public Sparse add (Sparse q){
        //  int new_deg = this.degree;
        //  for (int i=0; i<this.degree.length; i++)
        //     if (this.isIn(this.terms[i], q)) new_deg--;
         Sparse add_sparse = new Sparse();
         System.out.println("\tinit " + add_sparse.toString());
         for (int i=0; i<this.degree.length; i++){
            for (int j=0; j<q.degree.length; j++){
                if (this.degree[i] == q.degree[j]){
                    System.out.println("\tok, sommo");
                    add_sparse.degree[i] = this.degree[i];
                    add_sparse.terms[add_sparse.degree[i]] = this.coeff(this.degree[i]) + q.coeff(q.degree[j]);
                    System.out.println("\tresult " + add_sparse.toString());
                }
            }
         }
         return add_sparse;
     }

     @Override
     public String toString(){
         String str = "";
         for (int i=0; i<terms.length; i++)
            str += terms[i] + "x^" + degree[i] + " + ";
         return str; 
     }
}

