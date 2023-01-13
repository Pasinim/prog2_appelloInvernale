package tde.ps2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import tde.treni.FailureException;

/**
 * Stack di Token con politica LIFO.
 * 
 * Classe mutabile.
 * 
 * Una TokenStack ha la seguente funzione d'astrazione:
 *  AF(c) = Per ogni Token t in Token stack: t.toString()
 * 
 * Una TokenStack non puó avere dimensione minore di 0, quindi:
 *  rep_inv = this.dimensione >= 0 && this.dimensione < 1024
 */
public class TokenStack {
    private final Deque<Token<?>> stack;

    /**
     * Crea una TokenStack vuota.
     */
    public TokenStack(){
        this.stack = new LinkedList<>();
    }

    /**
     * Inserisce come ultimo elemento il Token t.
     * 
     * @param t Token da inserire nella Stack.
     */
    public void push(Token<?> t){
        this.stack.push(t);

        if(!repOk()){
            throw new FailureException();
        }
    }

    /**
     * Restituisce ed elimina dalla stack l'ultimo elemento inserito sulla Stack.
     * 
     * @throws NoSuchElementException Se la Stack é vuota.
     * @return Ultimo elemento inserito sulla Stack.
     */
    public Token<?> pop(){
        try {
            return stack.pop();           
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException();
        }
    }

    /**
     * Restituisce e NON elimina dalla stack l'ultimo elemento inserito sulla stack.
     * 
     * @return Ultimo elemento inserio sulla Stack.
     */
    public Token<?> peek(){
        return this.stack.peek();
    }

    /**
     * Ritorna la grandezza della Stack.
     * 
     * @return Size di this.
     */
    public int size(){
        return this.stack.size();
    }

    @Override
    public String toString(){
        return this.stack.toString();
    }

    /**
     * Controlla invariante di rappresentazione.
     * 
     * @return True se invariante rispettato, False altrimenti.
     */
    public boolean repOk(){
        if(this.stack.size() < 0 && this.stack.size() > 1023){
            return false;
        }
        return true;
    }
}
