package tde.filesystem2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Rappresenta una struttura FIFO in grado di contenere nomi di Entry.
 * L'ordine con cui i nomi delle Entry sono inseriti all'interno della struttura indica la relativa Path nel Filesystem.
 * 
 * Classe mutabile
 * 
 * Una Path ha la seguente funzione d'astrazione:
 *  AF(c) = Per ogni nome (Partendo da quello inserito prima) in this: nome:
 * Ed il seguente invariante:
 *  rep_inv = true
 */
public class Path {
    private final Deque<String> path;

    /**
     * Inizializza una Path vuota
     */
    public Path(){
        this.path = new LinkedList<>();
    }


    /**
     * Inizializza una Path sulla base del contenuto di s.
     */
    public Path(String s){
        this.path = new LinkedList<>();
        String[] tkns = s.split(":");


        for(int i = 0; i < tkns.length; i++){
            //Eventuali path assolute
            if(tkns[i].equals("")){
            }else{
                path.push(tkns[i]);
            }
        }
    }

    /**
     * Copy constructor
     * 
     * @param p Path p.
     */
    public Path(Path p){
        this.path = new LinkedList<>(p.path);
    }

    /**
     * Aggiunge il nome n in coda alla Path attuale.
     * 
     * @param n Nome
     */
    public void push(String n){
        if(Objects.isNull(n)){
            throw new IllegalArgumentException();
        }
        path.add(n);
    }

    /**
     * Ritorna il primo nome n presente nella Path.
     * 
     * Ritorna null se la path é vuota
     * 
     * @return Ultimo nome n inserito sulla Path.
     */
    public String pop(){
        try {
            return path.removeLast();        
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override
    public String toString(){
        StringBuilder ret = new StringBuilder();

        for (String string : path) {
            ret.append(String.format("%s:", string));
        }

        return ret.toString();
    }
}
