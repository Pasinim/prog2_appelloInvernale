package tde.teramini;

import java.util.Scanner;
/**
 * Classe immutabile Coordinata.
 * 
 * Rappresenta una coppia di coordinate (x,y).
 * 
 * Un'istanza di Coordinata ha la seguente funzione d'astrazione:
 *  AF(c) = <this.x, this.y>
 */
public class Coordinata {
    private final int x;
    private final int y;

    private final Integer i1;
    private final Integer i2;
    
    /**
     * Inizializza Coordinata con x = x e y = y.
     * 
     * @param x Valore coordinata x
     * @param y Valore coordinata y
     */
    public Coordinata(int x, int y){
        this.x = x;
        this.y = y;

        this.i1 = (Integer) x;
        this.i2 = (Integer) y;
    }

    /**
     * Ritorna il valore di x.
     * 
     * @return Valore x.
     */
    public int getX(){
        return x;
    }

    /**
     * Ritorna il valore di y.
     * 
     * @return Valore y.
     */
    public int getY(){
        return y;
    }

    @Override
    /**
     * Ritorna funzione d'astrazione di this.
     * 
     * @return String rappresentante stato di this.
     */
    public String toString(){
        String ret = String.format("<%d, %d>", this.x, this.y);
        return ret;
    }

    @Override
    /**
     * Ritorna true sse o equals this.
     * 
     * Dati due oggetti x1 x2 di classe Coordinata x1 equals x2 sse x1.x == x2.x and x1.y == x2.y.
     * 
     * @return True se this equals o, False altrimenti.
     */
    public boolean equals(Object o){
        if(!(o instanceof Coordinata)){
            return false;
        }

        if( o == this){
            return true;
        }

        Coordinata c = (Coordinata) o;
        if (c.x == this.x && c.y == this.y){
            return true;
        }

        return false;
    }

    @Override
    /**
     * Ritorna hashCode di this.
     */
    public int hashCode(){
        int hash;
        hash = this.i1.hashCode();
        hash += 31* this.i2.hashCode();

        return hash;
    }
}
