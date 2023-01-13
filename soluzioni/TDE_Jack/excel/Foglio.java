package tde.excel;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe Foglio comprendente un insieme di Celle organizzate come tabella
 * bidimensionale.
 * 
 * Classe mutabile.
 * 
 * La funzione d'astrazione di Foglio puó essere definita come: AF(c) = Per ogni
 * Cella c in this -> c.toString()
 * 
 * Ogni Foglio ha un numero fissato e non cambiabile di righe e di colonne, ogni
 * Cella al suo interno deve avere un valore valido: rep_inv = this.righe > 0 &&
 * this.colonne > 0 && Per ogni Cella c -> c not null
 */
public class Foglio {
    private Map<Coordinata, Cella> foglio;
    private final int righe;

    /**
     * Inizializza un Foglio con 26 colonne e n righe.
     * 
     * n > 0
     * 
     * @param n Numero righe
     */
    public Foglio(int n){
        this.righe = n;
        this.foglio = new HashMap<>();

        if(!repOk()){
            throw new IllegalArgumentException();
        }
    }

    /**
     * Ritorna il valore presente alla Coordinata c
     * 
     * @param c Coordinata da cui estrarre il valore
     */
    public int getValore(Coordinata c){
        if(this.foglio.containsKey(c)){
            return this.foglio.get(c).getValore();
        }
        return 0;
    }

    /**
     * Ritorna il numero di righe di this.
     * 
     * @return Righe di this
     */
    public int getRighe(){
        return this.righe;
    }

    /**
     * Setta il contenuto della Cella presente in cor
     * 
     * @param cor Coordinate della Cella
     * @param c Contenuto
     * @return True se é avvenuto correttamente.
     */
    public boolean setValore(Coordinata cor, Contenuto c){
        if(!foglio.containsKey(cor)){
            foglio.put(cor, new Cella(c));
        }else{
            Cella cell = this.getCella(cor);
            cell.setValore(c);
        }
        return true;
    }

    /**
     * Ritorna, se presente, la Cella alla coordinata cor
     * 
     * @param cor Coordinata della Cella
     * @return Cella presente in Cor
     */
    public Cella getCella(Coordinata cor){
        if(!foglio.containsKey(cor)){
            throw new IllegalArgumentException();
        }

        return foglio.get(cor);
    }

    /**
     * Ritorna true se l'invariante é rispettato, false altrimenti.
     * 
     * @return
     */
    public boolean repOk(){
        if(this.righe <= 0){
            return false;
        }
        return true;
    }

    @Override
    public String toString(){
        return this.foglio.toString();
    }
}
