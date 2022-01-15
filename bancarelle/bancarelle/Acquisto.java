package bancarelle;
import java.util.*;
import java.util.function.DoubleBinaryOperator;
/**
 * Le istanze di questa classe rappresentano un acquisto, indentificato da: tipo del giocattolo, quantità da acquistare
 * prezzo (budget), quantità del giocattolo da acquistare, lista delle bancarelle da cui acquistare
 * AF:
 * IR:
 */
public class Acquisto {
     public final Giocattolo g;
     private int qnty, budget;
     Set<Bancarella> bancarelle;
    	/** 
     * Inizializza un nuovo acquisto. Se qualche parametro è null solleva una eccezione.
     */
    public Acquisto(Giocattolo g, final int qnty, int budget, Set<Bancarella> doveAcquistare){
         Objects.requireNonNull(g);
         Objects.requireNonNull(qnty);
         Objects.requireNonNull(budget);
         Objects.requireNonNull(doveAcquistare);
         this.g = g;
         this.qnty = qnty;
         this.budget = budget;
         this.bancarelle = doveAcquistare;
    }     

    @Override
    public String toString(){
          String str = "Acquisto di: ";
     //     str += this.g.toString() + ", pe run costo di " + "COSTO TOTALE" + ", numero: " + this.qnty + "di cui: ";
     //     Iterator<Bancarella> it = bancarelle.iterator();
     //     while (it.hasNext()){
     //          Bancarella b = it.next();
     //          str +=
     //     }
          return str;
    }
    
}
