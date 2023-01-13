package tde.teramini;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Classe immutabile Rettangolo.
 * 
 * Rappresenta un rettangolo definito come insieme di coordinata su un piano cartesiano.
 * 
 * Una tipica istanza di Rettangolo ha la seguente funzione d'astrazione:
 *  AF(c) = [<this.xLowLeft, this.yLowLeft>, <this.xupRigth, this.yUpRigth>]
 * 
 * Ogni Rettangolo inoltre deve essere composto da almeno una Coordinata.
 */
public class Rettangolo {
    private final Coordinata lowLeft;
    private final Coordinata upRight;

    /**
     * Inizializza un Rettangolo date due coordinate rappresentanti la sua bounding box.
     * 
     * @param c1 Coordinata 1.
     * @param c2 Coordinata 2.
     */
    public Rettangolo(Coordinata c1, Coordinata c2){
        this.lowLeft = c1;
        this.upRight = c2;
    }


    /**
     * Ritorna la bounding box di una lista c di Coordinate in ingresso.
     * 
     * Una Bounding Box é una coppia di coordinate rappresentanti rispettivamente il 
     * limite inferiore sinistro ed il limite superiore destro del rettangolo formato dalle Coordinate in c.
     * 
     * É imporante notare come una coordinata della Bounding Box non per forza appartiene alla lista c.
     * 
     * Se la Lista c contiente un solo parametro le coordinate della Bounding Box coincideranno.
     * 
     * @throws IllegalArgumentException Se la lista non contiene elementi.
     * @param c Lista da cui prelevare i punti.
     * @return Bounding Box.
     */
    public static Rettangolo boundingBox(List<Coordinata> c){
        if(c.size() <= 0){
            throw new IllegalArgumentException("La lista non puó essere vuota");
        }

        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;

        for (Coordinata coordinata : c) {
            int x = coordinata.getX();
            int y = coordinata.getY();

            if(x < minX){
                minX = x;
            }
            if(x > maxX){
                maxX = x;
            }

            if(y < minY){
                minY = y;
            }
            if(y > maxY){
                maxY = y;
            }
        }

        return new Rettangolo(new Coordinata(minX, minY), new Coordinata(maxX, maxY));
    }

    /**
     * Ritorna la bounding box di una lista c di Coordinate in ingresso.
     * 
     * Una Bounding Box é una coppia di coordinate rappresentanti rispettivamente il 
     * limite inferiore sinistro ed il limite superiore destro del rettangolo formato dalle Coordinate in c.
     * 
     * É imporante notare come una coordinata della Bounding Box non per forza appartiene alla lista c.
     * 
     * Se la Lista c contiente un solo parametro le coordinate della Bounding Box coincideranno.
     * 
     * @throws IllegalArgumentException Se la lista non contiene elementi.
     * @param c Lista da cui prelevare i punti.
     * @return Bounding Box.
     */
    public static Rettangolo boundingBox(Set<Coordinata> c){
        if(c.size() <= 0){
            throw new IllegalArgumentException("La lista non puó essere vuota");
        }

        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;

        for (Coordinata coordinata : c) {
            int x = coordinata.getX();
            int y = coordinata.getY();

            if(x < minX){
                minX = x;
            }
            if(x > maxX){
                maxX = x;
            }

            if(y < minY){
                minY = y;
            }
            if(y > maxY){
                maxY = y;
            }
        }

        return new Rettangolo(new Coordinata(minX, minY), new Coordinata(maxX, maxY));
    }

    @Override
    /**
     * Ritorna funzione d'astrazione di this.
     * 
     * @return String rappresentante stato di this.
     */
    public String toString(){
        String ret = String.format("Boundaries: [%s , %s]", this.lowLeft.toString(), this.upRight.toString());
        return ret;
    }

    public Coordinata getMin(){
        return this.lowLeft;
    }

    public Coordinata getMax(){
        return this.upRight;
    }
}
