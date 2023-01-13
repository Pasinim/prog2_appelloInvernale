/**
 * OVERVIEW: le istanze di questa classe rappresentano un numero razionale
 * Le istanze di questa classe non sono mutabili 
 */

public class Rational {
 //CAMPI
 //queste variabili d'istanza rappresentano il numeratore e il denominatore
private int num, den;
 //COSTRUTTORI
 /**
  * EFFECTS: restitisce il numero num/den. Se il denominatore <= 0 solleva una eccezioe
  */
public Rational(int n, int d){
    if (!(d>0)) throw new IllegalArgumentException("den must be positive. Found " + d);
    if (num * dem < 0) num `
    num = n ;
    den = d ;
    
}
/**
 * ABS FUN: AF(num, den) -> num/den
 * REP INV: den > 0 
 * ABS INV: den >0
 */

 //METODI

//  public Rational add (Rational b);
//  public Rational sub (Rational b);
//  public Rational mul (Rational b);
//  public Rational div (Rational b);
//  public Rational oppostite ();

 public Rational reduce(){
     while (den%num != 0){
         num /= den;
     }

 }

 //EFFECTS: restituisce il massimo comune divisiore tra a e b
 public static int gcd(int a, int b) {
    if (a < 0 || b < 0) throw new IllegalArgumentException("Arguments must be positive integers.");

    while (b != 0) {
        System.out.println(a + " " + b);
      int tmp = b;
      b = a % b;
      a = tmp;
      System.out.println("\t" + a + " " + b);

    }

    return a;
  }
private boolean RepOK(){
    return true;
}

@Override
public String toString(){
    return "";
}


}
