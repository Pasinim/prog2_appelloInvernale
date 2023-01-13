package tde.postScript;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

/**
 * Classe mutabile TokenStack.
 * 
 * Rappresenta una Stack con politica LIFO con relative operazioni contenente elementi di tipo Token.
 * La grandezza della TokenStack aumenta in base alla necessita'.
 * 
 * Una tipica istanza di TokenStack e' data dalla funzione d'astrazione:
 *  AF(c) = 
 * 
 */
public class TokenStack {
    private Deque<Token<?>> stack;

    /**
     * Inizializza una Stack sulla base dei Token presenti in l.
     * Nello specifico l'istanza della Stack conterra' i valori presenti in l nello stesso ordine
     * con cui sono inseriti nella Lista.
     * 
     * Se l e' null viene sollevata una IllegalArgumentException.
     * 
     * @param l Lista contenente gli elementi con cui inizializzare this.
     */
    public TokenStack(List<Token<?>> l){
        Objects.requireNonNull(l, "La lista non deve essere null");
        this.stack = new ArrayDeque<>(l);
    }

    /**
     * Inizializza una stack vuota avente inzialmente una capienza di 16.
     */
    public TokenStack(){
        this.stack = new ArrayDeque<>();
    }

    /**
     * Inserisce t nella Stack con politica FIFO.
     * 
     * @param t Token da inserire
     */
    public void push(Token<?> t){
        stack.addLast(t);
    }

    /**
     * Ritorna e rimuove l'ultimo Token inserito, se la Stack e' vuota.
     * 
     * @throws NoSuchElementException Se this e' vuoto.
     * @return Ultimo Token inserito sulla Stack.
     */
    public Token<?> pop(){
        return this.stack.removeLast();
    }

    @Override
    /**
     * Implementa la funzione d'astrazione.
     */
    public String toString(){
        String s = String.format("Stack: %s", stack.toString());
        return s;
    }

}
