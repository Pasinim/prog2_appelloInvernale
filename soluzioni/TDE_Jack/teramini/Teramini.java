package tde.teramini;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * Classe utile a raggruppare tutti i possibili tipi di teramino
 */
public enum Teramini{
    //Possibili tipi di Teramino
    I(Arrays.asList(new Coordinata(0,0), new Coordinata(0,1), new Coordinata(0,2), new Coordinata(0,3))),
    T(Arrays.asList(new Coordinata(0,0), new Coordinata(0,1), new Coordinata(-1,1), new Coordinata(1,1))),
    J(Arrays.asList(new Coordinata(0,0), new Coordinata(1,0), new Coordinata(1,1), new Coordinata(1,2))),
    L(Arrays.asList(new Coordinata(0,0), new Coordinata(0,1), new Coordinata(0,2), new Coordinata(1,0))),
    O(Arrays.asList(new Coordinata(0,0), new Coordinata(0,1), new Coordinata(1,0), new Coordinata(1,1))),
    S(Arrays.asList(new Coordinata(0,0), new Coordinata(1,0), new Coordinata(1,1), new Coordinata(2,1))),
    Z(Arrays.asList(new Coordinata(0,0), new Coordinata(1,0), new Coordinata(0,1), new Coordinata(-1,1)));

    private List<Coordinata> coor;

    private Teramini(List<Coordinata> c){
        this.coor = c;
    }

    /**
     * Ritorna l'insieme di coordinate del dato Teramino
     * 
     * @return List contenente le coordinate del relativo Teramino
     */
    public List<Coordinata> getCoor(){
        return new ArrayList<>(this.coor);
    }

    /**
     * Ritorna un Teramino di nome name, tipo type e ruotato di r volte.
     * 
     * Se il tipo di teramino non esiste viene sollevata una IllegalArgumentException.
     * 
     * @throws IllegalArgumentException Tipo non esitente.
     * @return Teramino.
     */
    public static Teramino teramino(char name, char type, int rotazioni){
        try {
            Teramini ty = Teramini.valueOf(String.valueOf(type));
            List<Coordinata> c = ty.getCoor();
            Teramino t = new BoundingTeramino(name, c);

            for(int i = 0; i < rotazioni; i++){
                t = t.ruota();
            }

            return t;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Tipo non esistente");
        }
    }
}
