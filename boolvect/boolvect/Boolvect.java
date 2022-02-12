
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
    boolean leggi(final int idx) throws IndexOutOfBoundsException;

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
     * this = o OP this. Vengono scritti i valori in this pari al risultato dell'operazione
     * @param o Boolvect con cui eseguire l'or logico
     */
    void or(final Boolvect o);

    /**
     * this = o OP this. Vengono scritti i valori in this pari al risultato dell'operazione
     * @param o Boolvect con cui eseguire lo xor logi
     */
    void xor(final Boolvect o);

    /**
     * this = o OP this. Vengono scritti i valori in this pari al risultato dell'operazione
     * @param o Boolvect con cui eseguire l'and logico
     */
    void and(final Boolvect o);

    default boolean compatibile(final Boolvect o){
        return taglia() == o.taglia();
    }

    /**
     * Rende tutti i valori del boolvect uguali a false.
     */
    default void pulisci(){
        for (int i = 0; i < taglia(); i++)
            set(false, i);
    };

    /**
     * Rende il BoolVect uguale ai valori di verità specificati nella stringa data.
     * @param vals Stringa dei valori di verità
     */
    default void daString(final String vals){
        if (vals.length() > taglia()) throw new IllegalArgumentException("La lunghezza della stringa è maggiore della lunghezza del boolvect");
        pulisci();
        for (int i = 0; i < vals.length(); i++)
            if (vals.charAt(vals.length() - i - 1) == 'V')
                set(true, vals.length() - i - 1);
    }

    
}
