package tde.excel;

/**
 * Classe rappresentante una coppia di coordinate (x,y).
 * 
 * Classe immutabile.
 * 
 * Le Coordinate vengono rappresentate usando le lettere dalla A alla Z per le y e numeri interi per le x, quindi:
 *  AF(c) = this.y % 26 this.x
 * 
 * L'invariante é quindi:
 *  rep_int = true
 * 
 * Importante notare come anche se l'invariante sia sempre vero, di fatto il dominio delle y di this sia compreso in un
 * intervallo intero [0, 25], questo viene espresso anche dalla funzione d'astrazione.
 */
public class Coordinata {
    public final int x;
    public final int y;

    public Coordinata (int x, int y){
        this.x = x;
        this.y = y%26;
    }

    @Override
    public boolean equals(Object o){
        //Dati due istanze di Coordinata (c1,c2), c1.equals(c2) sse c1.x == c2.x && c2.y = c1.y

        //Se o non é Contenuto o sottotipo di esso ritorno false.
        if(!(o instanceof Coordinata)){
            return false;
        }

        if(o == this){
            return true;
        }

        Coordinata c = (Coordinata) o;
        if(this.x == c.x && this.y == c.y){
            return true;
        }

        return false;
    }

    @Override 
    public int hashCode(){
        Integer n1 = (Integer) x;
        Integer n2 = (Integer) y;

        int ret = n1.hashCode();
        ret += 31*n2.hashCode();

        return ret;
    }

    @Override
    public String toString(){
        //Cast implicito
        char col = (char) (y + 65);

        String ret = String.format("%s%s", String.valueOf(col), String.valueOf(x));
        return ret;
    }
}
