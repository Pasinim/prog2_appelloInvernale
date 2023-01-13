package tde.filesystem;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Classe in grado di contenere in una coda LIFO i nomi delle Entry all'interno
 * di un Filesystem.
 * 
 * Classe mutabile.
 */
public class Path {
    private Deque<String> path;

    /**
     * Inizializza una Path con radice n.
     * 
     * @param n Nome della radice.
     */
    public Path(String n){
        this.path = new LinkedList<>();
        path.push(n);
    }

    /**
     * Ritorna l'ultimo elemento inserito nella Path
     * 
     * @return String dell'ultimo elemento della path
     */
    public String pop(){
        return path.pop();
    }

    /**
     * Inserisce la String s come ultimo elemento della Path.
     * 
     * @param s String da inserire
     */
    public void push(String s){
        path.push(s);
    }

    
    @Override
    public String toString(){
        StringBuilder ret = new StringBuilder();

        for (String s : path) {
            ret.append(String.format("%s:", s));
        }

        return ret.toString();
    }
}   
