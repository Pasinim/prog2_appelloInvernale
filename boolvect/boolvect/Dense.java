import java.util.*;

/**
 * Le istanze di questa classe rappresentano un Boolvect denso, ossia con un numero di valori impostati
 * a vero NON molto inferiore alla taglia.
 * Le istanze di questa classe sono mutabili.
 */

public class Dense implements Boolvect{

    private final boolean[] vettore;

    private Dense(int dimensione){
        if (dimensione < 0) throw new IllegalArgumentException("La dimensione di un Boolvect deve essere positiva");
        this.vettore = new boolean[dimensione];

    }

    @Override
    public int taglia() {
        return vettore.length;
    }

    @Override
    public boolean leggi(int idx) {
        if (idx < 0) throw new IllegalArgumentException("L'indice deve essere >= 0");
        return vettore[idx];
    }

    @Override
    public void set(boolean v, int i) {
        try{
            this.vettore[i] = v;
        }catch(IndexOutOfBoundsException e){
            throw new IllegalArgumentException("Impossibile impostare l'indice " + i + e.getMessage());
        }
        
    }

    /**
     * 
     */
    @Override
    public int dimensione() {
        //parto dal fondo (cioè 0 per il vettore, ma max per l'implementazione di boolvect)
        for (int i = 0; i < this.taglia(); i++){
            System.out.println(i + ":\t + " + this.leggi(i));
            if (this.leggi(i)) return i + 1;
        }
        return 0;
    }

    /**
     * Super().
     * 
     * Restituisce un Boolvect della stessa taglia contenente il risultato dell'or logico.
     * Se this e o hanno dimensioni differenti solleva una eccezione di tipo IllegalArgumentException.
     * 
     * *- Si potrebbe implementare anche con taglie differenti, in questo caso ret deve avere la dimensione pari a
     * Math.Max(this.taglia(), o.taglia()) e poi copiare il contenuto dell'array più grande nelle posizioni rimanenti -*
     * 
     */
    @Override
    public void or(Boolvect o) {
        if (!compatibile(o)) throw new IllegalArgumentException("I due Boolvect devono avere la stessa taglia");
        for (int i = 0; i < vettore.length; i++)
            set(this.leggi(i) || o.leggi(i), i);
    }

    /**
     * super()
     */
    @Override
    public void xor(Boolvect o) {
        if (!compatibile(o)) throw new IllegalArgumentException("I due Boolvect devono avere la stessa taglia");
        for (int i = 0; i < vettore.length; i++)
            set(this.leggi(i) ^ o.leggi(i), i);
    }

    /**
     * super()
     */
    @Override
    public void and(Boolvect o) {
        if (!compatibile(o)) throw new IllegalArgumentException("I due Boolvect devono avere la stessa taglia");
        for (int i = 0; i < vettore.length; i++)
            set(this.leggi(i) && o.leggi(i), i);
    }

    @Override
    public String toString(){
        String str = "";
        for (int i = this.taglia() - 1; i >= 0; i--)
            str += (leggi(i) == true) ? "V" : "F";
        return str += "\n";
    }


}
