import java.util.Objects;
import java.util.List;
import java.util.ArrayList;
/**
 * OVERVIEW: le istanze di questa clase rappresentano polinomi sparsi. 
 * Gli oggetti di questa classe sono mutabili.
 */
public class SparseList {
    //CAMPI
    private List<Integer> terms;
    private List<Integer> degree;

    //COSTRUTTORI
    /**
     * EFFECTS: Inizializza un nuovo polinomio zero 
     *  */ 
    public SparseList(){
        terms = new ArrayList<>();
        degree = new ArrayList<>();
    }

    /**
     * EFFECTS: Inizializza  un nuovo polinomio cx^n.
     *          Se n<0 viene sollevata una eccezione NegativeExponentException
     */
    public SparseList (int c, int n){
        if (n<0) throw new NegativeExponentException("n must be positive. Found: " + n);
        terms = new ArrayList<>();
        degree = new ArrayList<>();
        terms.add(c);
        degree.add(n);
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

     //EFFECTS: restituisce il coefficente del termine di degree[idx] 
     public int coeff (int idxDeg){
        return terms.get(degree.get(idxDeg)); //???
     }
 
     //EFFECTS: restituisce true se il q.degree[idx] è presente in q
     public boolean isIn(SparseList q, int idx){
         return q.degree.contains(this.degree.get(idx));
     }

     //EFFECTS:
     public SparseList add (SparseList q){
         SparseList  add_sparse = new SparseList();
         for (int i=0; i<this.terms.size(); i++){
             for (int j=0; j<q.terms.size(); j++){
                 if (this.isIn(q, i)){
                     System.out.println("\t sono nel isin");
                    // add_sparse.terms.add(this.coeff(this.indexOf(i)) + q.coeff(q.indexOf(j)));
                     add_sparse.degree.add(i);
                 }else{
                     //add_sparse.terms.add(this.coeff)
                 }
             }
         }
         return add_sparse;
     }

     @Override
     public String toString(){
         String str = "";
        if (this.terms.size() > 0) {
            for (int i=0; i<terms.size(); i++){
                //System.out.println("\tTerms: " + terms.get(i) + "deg: " + degree.get(i));
                str += terms.get(i) + "x^" + degree.get(i) + " + ";
            }
        }
         return str; 
     }
}

