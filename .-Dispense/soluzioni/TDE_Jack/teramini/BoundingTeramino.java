package tde.teramini;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Classe mutabile rappresentante un Teramino.
 * 
 * Ogni teramino é caratterizzato da un Nome ed una collezione di Coordinate da cui é compost.
 */
public class BoundingTeramino implements Teramino {
    private final char nome;
    private final Set<Coordinata> coor;
    
    /**
     * Inizializza un Teramino di nome n ed avente coordinate pari a quelle contenute in c.
     * 
     * 
     * @throws IllegalArgumentException Se c é vuota.
     * @param n Nome.
     * @param c Lista coordinate.
     */
    public BoundingTeramino(char n, List<Coordinata> c){
        if(c.size() <= 0){
            throw new IllegalArgumentException("La lista non puó essere vuota");
        }

        this.nome = n;
        this.coor = new HashSet<>(c);
    }

    /**
     * Ritorna un Set contenente le coordinate di cui é composto this.
     * 
     * @return Set contenente coordinate di this.
     */
    public Set<Coordinata> coordinate(){
        return new HashSet<Coordinata>(this.coor);
    }

    /**
     * Ritorna la BoundingBox di this sulla base delle sue coordinate.
     * 
     * @return BoundingBox di this.
     */
    public Rettangolo boundingBox(){
        return Rettangolo.boundingBox(this.coor);
    }

    /**
     * Ritorna il nome di this.
     */
    public char nome(){
        return this.nome;
    }

    /**
     * Ritorna un Teramino this ruotato di 90gradi a destra.
     * 
     * @return Teramino this ruotato di 90gradi a destra.
     */
    public Teramino ruota(){
        List<Coordinata> l = new ArrayList<>();

        for (Coordinata coordinata : coor) {
            int x = coordinata.getX();
            int y = coordinata.getY();

            Coordinata c = new Coordinata(y, -x);
            l.add(c);
        }

        return new BoundingTeramino(this.nome, l);
    }

    @Override
    /**
     * Ritorna funzione d'astrazione di this.
     * 
     * @return String rappresentante stato di this.
     */    
    public String toString(){
        Rettangolo bb = this.boundingBox();
        String ret = String.format("%s\n", bb.toString());

        Coordinata min = bb.getMin();
        Coordinata max = bb.getMax();

        for(int y = max.getY(); y >= min.getY(); y--){
            for(int x = min.getX(); x <= max.getX(); x++){
                Coordinata c = new Coordinata(x, y);
                if(this.coor.contains(c)){
                    ret += this.nome;
                }else{
                    ret += ".";
                }
            }
            ret += "\n";
        }

        return ret;
    }

    @Override
    /**
     * Ritorna true sse o equals this.
     * 
     * Dati due oggetti x1 x2 di classe Teramino x1 equals x2 sse x1.nome == x2.nome.
     * 
     * @return True se this equals o, False altrimenti.
     */
    public boolean equals(Object o){
        if(!(o instanceof BoundingTeramino)){
            return false;
        }

        if( o == this){
            return true;
        }

        BoundingTeramino c = (BoundingTeramino) o;
        if (c.nome == this.nome){
            return true;
        }

        return false;
    }

    @Override
    /**
     * Ritorna hashCode di this.
     */
    public int hashCode(){
        String s = String.valueOf(this.nome);

        return s.hashCode();
    }
}
