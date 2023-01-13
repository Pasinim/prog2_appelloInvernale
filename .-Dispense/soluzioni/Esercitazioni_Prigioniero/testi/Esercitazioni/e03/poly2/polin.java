import java.util.Objects;
public class polin {
     //CAMPI
   //Variabile d'istanza che rappresenta i coefficienti del polinomio
   private final int terms[];
   //Variabile d'istanza che rappresenta il grado del polinomio
   private final int deg;
   /**
    * ABS FUNC: AF(terms, deg) = {terms[0], terms[1]...., terms[deg-1], terms[deg]}
    * REP INV: deg > 0
    * ABS INV: deg > 0
               terms.size()=deg+1;
    */

   //COSTRUTTORI
   //POST: Inizializza un polinomio zero
   public polin(){
        terms = new int[1];
        deg = 0;
   }
    
   //POST: Inizializza un polinomio cx^n
//          Se n<0 solleva una eccezione di tipo NegativeExponentException
   public polin (int c, int n){
        if (n<0) throw new NegativeExponentException ("Poly must have a positive exponent. Found: " + n);
        if (n==0){
            deg = 0;
            terms = new int[1];
        }
        else{
            terms = new int[n+1];
            deg = n;
            terms[n] = c; 
        }
   }
   
   //EFFECTS: Inizializza un nuovo polinomio di grado d
            // se n<0 restituisce una eccezione di tipo NegativeExponentException
   public polin (int n){
        if (n<0) throw new NegativeExponentException ("Poly must have a positive exponent. Found: " + n);
        if (n==0){
            terms = new int[1];
            deg = 0;
        }else{
            terms = new int[n+1];
            deg=n;
        }
   }

   //METODI
   //(questi primi due metodi mi permettono di non esporre la rappresentazione)
   //EFFECTS: restituisce il grado di this
   public int degree(){
       return this.deg;
   }

   //EFFECTS: restituisce il coefficente del termine di grado d
   public int coeff(int d){
       if (d<0) throw new NegativeExponentException("Exponent must be positive. Found: " + d);
       if (d>this.deg) throw new IllegalArgumentException("Exponent must be smaller the maxDegree. Found: "+ d);
       return this.terms[d];
   }

   //PRE: q not null
   //EFFETCS: restituisce un nuovo polinomio ottenuto da this + q
   public polin add(polin q){
        Objects.requireNonNull(q);
        polin add_poly;
        if (this.deg >= q.degree()){
            add_poly = new polin(this.deg);
            for (int i=0; i<=q.degree(); i++)
                add_poly.terms[i] = this.terms[i] + q.coeff(i);
            for (int i=q.degree()+1; i<=add_poly.deg; i++)
                add_poly.terms[i] = this.terms[i];
        }else{
            add_poly = new polin (q.degree());
            for (int i=0; i<=this.deg; i++)
                add_poly.terms[i] = this.terms[i] + q.coeff(i);
            for (int i=this.deg+1; i<=add_poly.deg; i++)
                add_poly.terms[i] = q.terms[i];
        }
        return add_poly;
    }

    //q non null
    //EFFECTS: restituisce un nuovo polinomio ottenuto da this - q
    public polin sub(polin q){
        Objects.requireNonNull(q);
        return this.add(q.minus());
    }

    //EFFECTS: restituisce il polinomio opposto
    public polin minus(){
        polin p = new polin(this.deg);
        for (int i=0; i<=deg; i++)
            p.terms[i] = -this.terms[i];
        return p;
    }

    //REQUIRES: q != null
    //EFFECTS: restitusice un nuovo polinomio ottenuto da this * q
    public polin mul(polin q){
        Objects.requireNonNull(q);
        polin mult_poly = new polin(this.deg + q.degree());
        for (int i=0; i<=this.deg; i++){
            for (int j=0; j<=q.degree(); j++)  
                mult_poly.terms[i+j] += this.terms[i] * q.coeff(j);   
        }
        assert repOK(); //come faccio a verificarlo su poly mult?
        return mult_poly;
    }

    //EFFECTS: restituisce una rappresentazione testuale del polinomio this
    @Override
   public String toString(){
       String str = "";
       for (int i=deg; i>0; i--){
            if (terms[i] == 0) continue; 
            str += terms[i] + "x^" + i + " + ";
       }
       return str + terms[0] + "";
    }

    private boolean repOK(){
        return degree() >= 0
        && terms.length == degree() + 1;
    }

}
