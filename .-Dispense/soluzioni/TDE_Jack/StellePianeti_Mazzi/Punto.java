import java.util.Objects;


/**
 * Le istanze di questa classe rappresentano un Punto.
 * Ogni punto è formato da 3 campi: x,y,z che sono rappresentani come interi.
 * Questa classe inoltre possiede i metodi somma e sottrai che, dato un altro punto, eseguono la corrispondente operazione.
 * Questa classe è immutabili, perciò è legittimo avere i campi come public e il metodo norma.
 */
public class Punto {

    /**
     * AF: (x,y,z)
     */
    public final int x;
    public final int y;
    public final int z;

    /**
     * Inizializza this affinchè rappresenti un Punto
     * @param x
     * @param y
     * @param z
     */
    public Punto(int x,int y, int z){
        this.x = x;
        this.z = z;
        this.y = y;
    }

    /**
     * Effettua, coordinata per coordinata, la somma di due punti.
     * Solleva un'eccezione di tipo {@link NullPointerException} nel caso in cui il punto in input sia null
     * @param punto da sommare
     */
    public Punto somma(Punto punto){
        Objects.nonNull(punto);
        Punto p = new Punto(x+punto.x,y+punto.y,z+punto.z);
        return p;
    }

    /**
     * Effettua, coordinata per coordinata, la sottrazione di due punti.
     * Solleva un'eccezione di tipo {@link NullPointerException} nel caso in cui il punto in input sia null
     * @param punto da sommare
     */
    public Punto sottrai(Punto punto){
        Punto p = new Punto(x-punto.x,y-punto.y,z-punto.z);
        return p;
    }

    /**
     * Effettua la somma dei valori assoluti delle coordinate di un punto
     * @return la norma di un punto
     */
    public int norma(){
        int norma = Math.abs(x) + Math.abs(y) + Math.abs(z);
        return norma;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Punto)) return false;
        Punto p = (Punto) obj;
        if(p.x == x && p.y == y && p.z == z) return true;
        return false;
    }

    @Override
    public int hashCode() {
       int result = 31*Integer.hashCode(x) + Integer.hashCode(y) + Integer.hashCode(z);
       return result;
    }

    @Override
    public String toString() {
        return String.format("(%d,%d,%d)", x,y,z);
    }

}
