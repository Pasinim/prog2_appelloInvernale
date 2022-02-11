
/**
 * OVERVIEW: Interfaccia che rappresenta un Boolvect, ossia un vettore di valori booleani.
 * La *dimensione* è definita come 1 più la posizione più
 * grande in cui si trova un valore di verità uguale a vero (o 0 se tutti i valori
 * di verità sono falsi)
 * La *taglia* è la massima dimensione che esso può raggiungere e può essere infinita (nel senso che, per convenzione, può
 * coincidere con `Integer.MAX_VALUE`).
 * AF: taglia <= Integer.MAX_VALUE (numero massimo di elementi nel vettore)
 * IR: per ogni elemento i in Boolvect: toString + "V" se l'elemento i è true, toString + "F" altrimenti
 */
public interface Boolvect {
    int taglia();

    /**
     * @param idx indice dell'elemento
     * @return restituisce il valore del Boolvect in posizione i
     */
    boolean leggi(final int idx);

    /**
     * Imposta a v l'elemento i nel Boolvect 
     * @param i indice dell'elemento
     * @param v valore di Boolvect[i]
     */
    void set(final boolean v, final int i);

    /**
     * @return dimensione del Boolvect
     */
    int dimensione();

    /**
     * @param o Boolvect con cui eseguire l'or logico
     * @return Boolvect ottenuto dall'or logico tra this e o
     */
    Boolvect or(final Boolvect o);

    /**
     * @param o Boolvect con cui eseguire lo xor logico
     * @return Boolvect ottenuto dallo xor logico tra this e o
     */
    Boolvect xor(final Boolvect o);

    /**
     * @param o Boolvect con cui eseguire l'and logico
     * @return Boolvect ottenuto dall'and logico tra this e o
     */
    Boolvect and(final Boolvect o);

    default boolean compatibile(final Boolvect o){
        return taglia() == o.taglia();
    }

    
}
