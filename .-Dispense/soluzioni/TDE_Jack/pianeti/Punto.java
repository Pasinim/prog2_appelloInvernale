package tde.pianeti;

/**
 * Rappresenta un Punto immutabile.
 * 
 * L'invariante é sempre rispettato, qualsiasi tupla di valori (x,y,z) é valida per la classe.
 */
public class Punto {
    private final int x;
    private final int y;
    private final int z;

    /**
     * Inizializza un Punto di coordinate x,y,z
     * 
     * @param x Valore x.
     * @param y Valore y.
     * @param z Valore z.
     */
    public Punto(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public int getZ(){
        return this.z;
    }
    /**
     * Restituisce this + p.
     * 
     * L'operazione di somma é defintiva come una normale operazione di somma tra vettori.
     * 
     * @param p Punto da sommare.
     * @return this + p.
     */
    public Punto somma(Punto p){
        return new Punto(this.x + p.x, this.y + p.y, this.z + p.z);
    }

    /**
     * Restituisce la somma dei valori assoulti delle coordinate di this.
     * 
     * @return Norma di this.
     */
    public int norma(){
        return this.x + this.y + this.z;
    }

    @Override
    public String toString(){
        String ret = String.format("(%d, %d, %d)", this.x, this.y, this.z);
        return ret;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Punto)){
            return false;
        }

        if(o == this){
            return true;
        }

        Punto p = (Punto) o;

        if(this.x == p.x && this.y == p.y && this.z == p.z){
            return true;
        }

        return false;
    }

    @Override
    public int hashCode(){
        Integer x = (Integer) this.x;
        Integer y = (Integer) this.y;
        Integer z = (Integer) this.z;

        int hashCode = x.hashCode();
        hashCode += 31 * y.hashCode();
        hashCode += 31 * z.hashCode();

        return hashCode;
    }
}
