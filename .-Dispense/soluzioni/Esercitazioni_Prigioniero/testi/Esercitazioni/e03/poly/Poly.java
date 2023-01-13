//package poly;
import java.util.Scanner;
import java.util.Objects;
//OVERVIEW: Le istanze di questa classe forniscono una rappresentazione di un polinomio denso
//gli oggetti di questa classe NON sono mutabili e i metodi sono creazionali

/**
 * Non uso i set dato che per loro natura non sono ordinati 
 */
public class Poly {
   //CAMPI
   //Variabile d'istanza che rappresenta i coefficienti del polinomio
   private int terms[];
   //Variabile d'istanza che rappresenta il grado del polinomio
   private int deg;
   /**
    * ABS FUNC: AF(terms, deg) = {terms[0], terms[1]...., terms[deg-1], terms[deg]}
    * REP INV: deg > 0
    * ABS INV: deg > 0
    */

   //COSTRUTTORI
   //POST: istanzia un polinomio zero
   public Poly(){
        terms = new int[1];
        deg = 0;
   }
    
   //POST: Istanzia un polinomio cx^n
//          Se n<0 solleva una eccezione di tipo NegativeExponentException
   public Poly (int c, int n){
        if (n<0) throw new NegativeExponentException ("Poly must have a positive exponent. Found: " + n);
        if (n==0){
            deg = 0;
            terms = new int[1];
        }
        else{
            terms = new int[n+1];
            //for (int i=0; i<n; i++) 
              //  terms[i] = 0; //serve davvero o lo fa da solo??
            deg = n;
            terms[n] = c; 
        }
   }
   
   //EFFECTS: restituisce un nuovo polinomio di grado d
            // se n<0 restituisce una eccezione di tipo NegativeExponentException
   public Poly (int n){
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
   public Poly add(Poly q){
        Objects.requireNonNull(q);
        Poly add_poly;
        if (this.deg >= q.degree()){
            add_poly = new Poly(this.deg);
            for (int i=0; i<=q.degree(); i++)
                add_poly.terms[i] = this.terms[i] + q.coeff(i);
            for (int i=q.degree()+1; i<=add_poly.deg; i++)
                add_poly.terms[i] = this.terms[i];
        }else{
            add_poly = new Poly (q.degree());
            for (int i=0; i<=this.deg; i++)
                add_poly.terms[i] = this.terms[i] + q.coeff(i);
            for (int i=this.deg+1; i<=add_poly.deg; i++)
                add_poly.terms[i] = q.terms[i];
        }
        return add_poly;
    }

    //q non null
    //EFFECTS: restituisce un nuovo polinomio ottenuto da this - q
    public Poly sub(Poly q){
        Objects.requireNonNull(q);
        return this.add(q.minus());
    }

    //EFFECTS: restituisce il polinomio opposto
    public Poly minus(){
        Poly p = new Poly(this.deg);
        for (int i=0; i<=deg; i++)
            p.terms[i] = -this.terms[i];
        return p;
    }

    //REQUIRES: q != null
    //EFFECTS: restitusice un nuovo polinomio ottenuto da this * q
    public Poly mul(Poly q){
        Objects.requireNonNull(q);
        Poly mult_poly = new Poly(this.deg + q.degree());
        for (int i=0; i<=this.deg; i++){
            for (int j=0; i<q.degree(); j++){
                System.out.println("\tthis= " + i + " q= " + j );
                mult_poly.terms[i+j] += this.terms[i] * q.coeff(j); 
            }
        }
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
        return deg > 0;
    }

    public static void main(String[] args) {
        Poly p = new Poly(3, 3);
        Poly q = new Poly(2, 2);
        q =  q.add(p);
        System.out.println(q.toString());
        System.out.println(q.degree());
        q = q.mul(q);
        System.out.println("mult" + q.toString());
        }
}


