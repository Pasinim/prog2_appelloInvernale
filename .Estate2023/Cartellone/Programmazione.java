import java.util.Iterator;

/**
 * Interfaccia che stabilisce il contratto per una programmazione
 * L'interfaccia estende il comportamento dell'interfaccia Iterable, che
 * permette di iterare sui giorni
 * della programmazione
 */
public interface Programmazione {

    /**
     * 
     * @return un iteratore che itera sulle date della programmazione
     */
    Iterator<Integer> iterator();

}
