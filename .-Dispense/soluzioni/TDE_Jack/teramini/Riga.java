package tde.teramini;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


/**
 * Classe Riga mutabile.
 * 
 * Rappresenta una Riga di una board di gioco, caratterizzata da una data lunghezza e contenente una data
 * collezione di Teramini.
 * 
 * Ogni istanza di Riga puó essere rappresentata tramite la seguente funzione d'astrazione:
 *  AF(c) = Per ogni cella della riga: stampa il suo contenuto.
 * 
 * Ogni Teramino all'interno della riga deve inoltre avere una posizione valida, quindi compresa tra 0 e la lunghezza massima 
 * della riga.
 */
public class Riga {
    private final int len;
    private int full;
    //Mappa Teramino -> Traslazione
    private Map<Teramino, Coordinata> teramini;
    //Bitmap per collisioni
    private int[] bitmap;
    private char[] namemap;

    /**
     * Inizializza una nuova riga di lunghezza l.
     * 
     * l deve essere > 0
     * 
     * @throws IllegalArgumentException Se la lunghezza in ingresso é minore o uguale a 0.
     * @param l Lunghezza riga.
     */
    public Riga(int l){
        if(l <= 0){
            throw new IllegalArgumentException();
        }

        this.len = l;
        this.full = l;
        this.bitmap = new int[len];
        this.namemap = new char[len];

        for(int i = 0; i < l; i++){
            bitmap[i] = 0;
            namemap[i] = '.';
        }
        this.teramini = new HashMap<>();
    }

    /**
     * Aggiunge un nuovo Teramino a this.
     * 
     * Se la posizione indicata é giá occupata viene sollevata un'eccezione.
     * É importante notare come vengano controllate le collisioni solamente a livello di Riga (quindi nel dominio di Coordinate y = 0), eventuali collisioni
     * al di fuori di tale dominio verrano demandate al controllo delle righe superiori.
     * 
     * La posizione a cui inserire il nuovo Teramino viene calcolata utilizzando l'offset fornito in input, 
     * che é relativo all'inizio della Riga this.
     * 
     * @param t Teramino da inserire.
     * @param offset Offset dal applicare al Teramino.
     */
    public void addTeramino(Teramino t, Coordinata offset){
        Set<Coordinata> c = t.coordinate();

        for (Coordinata coordinata : c) {
            int x = coordinata.getX() + offset.getX();
            int y = coordinata.getY() + offset.getY();

            System.out.println("" + x + y);

            if(x < 0 || x >= len){
                throw new IllegalArgumentException("Teramino fuori riga");
            }

            if(y == 0){
                if(bitmap[x] == 0){
                    full -= 1;
                    bitmap[x] = 1;
                    namemap[x] = t.nome();
                }else{
                    throw new IllegalArgumentException("Collisione sulla riga");
                }
            }
        }
        
        teramini.put(t, offset);
    }

    /**
     * Ritorna una mappa contenente i teramini contenuti in this con relativi offset.
     * 
     * @return Mappa contenente Teramini.
     */
    public Map<Teramino, Coordinata> teramini(){
        return new HashMap<>(teramini);
    }

    @Override
    /**
     * Ritorna funzione d'astrazione di this.
     * 
     * @return String rappresentante stato di this.
     */    
    public String toString(){
        String ret = "";

        for (int i = 0; i < this.len; i++){
            ret += namemap[i];
        }

        return ret;
    }

    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        Riga ri = new Riga(15);

        while(s.hasNext()){
            int x = s.nextInt();
            int y = s.nextInt();
            char n = s.next().charAt(0);
            char t = s.next().charAt(0);
            int r = s.nextInt();


            System.out.println("" + x + y + n + t + r);
            Teramino te = Teramini.teramino(n, t, r);
            ri.addTeramino(te, new Coordinata(x, y));
        }
        s.close();
        System.out.println(ri.toString());
    }

}
