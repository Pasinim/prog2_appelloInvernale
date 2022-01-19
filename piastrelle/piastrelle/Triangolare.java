package piastrelle;

public class Triangolare extends Piastrella {

    public final int b, h, c;
    public Triangolare(int base, int altezza, int costo){
        super(costo);
        if (base < 1 || altezza < 1) throw new IllegalArgumentException();
        b = base;
        h = altezza;
    }

    @Override
    public int getSuperficie() {
        return (b*h)/2;
    }
    
}
