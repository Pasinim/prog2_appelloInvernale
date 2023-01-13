package tde.stellepianeti;

/**
 * Classe Punto.
 * 
 * Rappresenta un punto nello spazio, definito tramite specifiche coordinate (x,y,z).
 * La classe e' immutabile.
 * 
 * Una tipica istanza di Punto e': Coordinate(x: this.x, y: this.y, z: this.z)
 */
public class Punto {
    // Fields rappresentanti le coordinate
    private final int x;
    private final int y;
    private final int z;

    /**
     * Inizializza un Punto avente coordinate (0,0,0).
     */
    public Punto(){
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    /**
     * Inizializza un Punto avente coordinate(x,y,z).
     * 
     * @param x Coordinata x.
     * @param y Coordinata y.
     * @param z Coordinata z.
     */
    public Punto(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Effettua la somma tra due istanze di Punto.
     * 
     * In questo contesto la somma e' definita in questo modo:
     * Dati p,q istanze di Punto e v = somma(p,q) ho:
     * v.x = p.x + q.x
     * v.y = p.y + q.y
     * v.z = p.z + q.z
     * 
     * @param p Il punto  con cui sommare this.
     * @return Nuovo Punto avente coordinate pari alla somma tra this e p.
     */
    public Punto somma(Punto p){
        int new_x = this.x + p.x;
        int new_y = this.y + p.y;
        int new_z = this.z + p.z;
        
        return new Punto(new_x, new_y, new_z);
    }

    /**
     * Ritorna la somma in valore assoluto delle coordinate di this.
     * 
     * @return Somma in valore assoluto delle coordinate di this.
     */
    public int norma(){
        return Math.abs(this.x) + Math.abs(this.y) + Math.abs(this.z);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }


    /**
     * Rappresenta la funzione d'astrazione AF
     */
    @Override
    public String toString(){
        return String.format("(%d,%d,%d)", this.x, this.y, this.z);
    }
}
