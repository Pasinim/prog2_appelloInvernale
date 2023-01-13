import java.util.Objects;

/** OVERVIEW:   Le istanze di questa classe rappresentano dei numeri interi 
 *              Gli oggetti non sono mutabili.
 *              un numero razionale tipico è n/d, dove n e d sono numeri interi e d è diverso da zero.
*/

public class Rational {
    //CAMPI
    /**
     * I campi che rappresentano il numeratore e il denominatore
     */
    private  int numerator, denominator; //non metto final, potrebbe essere comodo mutare i valori assegnatti ad essi per qustioni di efficienza, ...
    
    /* ABS FUN:  AF(numerator, denominator)  = numerator/denominator
     * REP INV:  denominator > 0
     * ABS INV:  denominator != 0 , posso evitare di scrivere questa dimostrazione dato che ho già dimostrato
     *          denominator > 0
     */

    //COSTRUTTORI
    /**
    POST:    inizializa this affinchè rappresenti il razionale n/d ridotto ai minimi termini
                se il denominatore == 0 solleva un'eccezione di tipo ArithmeticException
    Preservazione RI:   Se d==0 è sollevata un'eccezione e quindi this non è istanziato 
                            altrimenti è utilizzato il suo valore assoluto, quindi è preservato
    Correttezza: AF(numerator,denominator)
                = numerator/denominator
                = (numerator/cd)/(denominator/cd), dove cd = gcd(|numerator|, |denominator|)
                = -|numerator|/|denominator| se num * den < 0,
                |numerator|/|denominator| altrimenti
    
        
     */
    public Rational(int n, int d){
        if (d==0) throw new ArithmeticException("Il denominatore non può essere nullo.");
        numerator = (n*d > 0) ? Math.abs(numerator) : -Math.abs(numerator);
        denominator = Math.abs(denominator);
        reduce();
        assert RepOK();
    }

    //METODI 
    //NON HO EFFETTI COLLATERALI PERCHÈ GLI OGGETTI NON SONO MUTABILI QUINDI I METODI NON SONO MUTAZIONALI
    /**
     * POST: restitusice il numero razionale this + o
                Se o è null, solleva NullPointerException
    Preservazione RI:   this.denominator > 0 && o.denominator > 0 ->  denominator * o.denominator > 0 
    Correttezza: numerator/denominator + o.numerator/o.denominator = numerator * o.denominator + o.numerator * numerator / denominator * o.denominator

     */    
    public Rational add (Rational o){
        Objects.requireNonNull(o);
        return new Rational(numerator * o.denominator + o.numerator * numerator, denominator * o.denominator) ;
    }
    /**
     * POST: restituisce l'opposto del numero razionale -this
     * Preservazione RI:   denominator  > 0 infatti denominator non varia 
     */ 
    public Rational minus(){
        return new Rational(-numerator, denominator);
    }
    /**
     * POST:    restitusice il numero razionale this - o
     *          Se o è null, solleva NullPointerException
     * Preservazione RI:   o.denominator > 0 -> o.minus().denominator > 0 
     *                      this.denominator > 0 & o.minus().denominator > 0 -> this.add(o.minus().denominator) > 0
     */
    public Rational sub(Rational o) {
        return add(o.minus());
    }

    /**
     * POST:    restitusice il numero razionale this * o
     *          Se o è null, solleva NullPointerException
    Preservazione RI:   this.denominator > 0 && o.denominator > 0 ->  denominator * o.denominator > 0 
    Correttezza: numerator/denominator * o.numerator/o.denominator = numerator * o.numerator / denominator * o.denominator

     */
    public Rational mult(Rational o) {
        Objects.requireNonNull(o);
        return new Rational(numerator * o.numerator, denominator * o.denominator);
    }
     /**
     * POST:    restitusice il numero razionale this/o
     *          Se o è null, solleva NullPointerException
     *          solleva un'eccezione di tipo ArithmeticException se numeratore == 0
     * Preservazione IR:    se o è 0, allora è sollevata un'eccezione e non è restituito l'oggetto 
     *                      o.reciprocal().denominator > 0 && denominator > 0 -> this.mult(o.reciprocal.denominator) > 0
     */
    public Rational div(Rational o){
        Objects.requireNonNull(o);
        return mult(o.reciprocal());
    }
    
        /**
     * POST:    restitusice il numero razionale 1/this
     *          solleva un'eccezione di tipo ArithmeticException se numeratore == 0
     * Preservazione RI:   se numerator == 0 viene solleavata un'eccezione
     *                      altirmnti valido per ipotesi induttiva
     * 
     */
    public Rational reciprocal(){
        //if (numerator == 0) throw new ArithmeticException("Il numeratore non può essere nullo quando viene eseguito il reciproco");
        //lo controlla il costruttore
        return new Rational(denominator, numerator);
    }

    /**
     * PRE:     this.denominator > 0 
     * EFFETTI: potrebbe modificare this
     * POST:   riduce this ai minimi termini
     * Preservazione RI:   this.denominator > 0 -> denominator >= gcd(|Numerator|, denominator) > 0
     *                     pertanto, denominator / gcd(|Numerator|, denominator) > 0
        Correttezza:
        Preservazione AI: 
     */
    private void reduce (){
        int cd  = gdc(Math.abs(numerator), denominator);
        numerator /= cd;
        denominator /= cd;
    }
    
    /**
     * POST: restituisce il massimo comun divisore tra a e b
     * Preservazione RI: NON è mutazionale, non devo farlo
     * Correttezza: Non è un algoritmo che abbiamo inventato noi, non devo controllarla
     * 
     */
    private static int gdc(int a, int b){
        if (a<0 || b < 0) throw new IllegalArgumentException("A e B devono essere > 0");
        while (b!=0){
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }

    /**
     * den>0
     */
    private boolean RepOK(){
        return denominator > 0;
    }

    @Override
    public String toString(){
        if (denominator==1) return "" + numerator;
        return numerator + "/" + denominator;
    }

    @Override
    public int hashCode(){
        return 31 *  Integer.hashCode(denominator) + Integer.hashCode(numerator);
    }

    @Override
    public boolean equals(Object o){
        if (!(o instanceof Rational)) return false; //restituisce false anche se è null
        //mi sono accertato che o sia effettivamente Rational, quindi posso castare
        Rational other = (Rational) o;
        return denominator == other.denominator &&  numerator == other.numerator;
    }

}
