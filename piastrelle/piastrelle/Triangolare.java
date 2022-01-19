package piastrelle.piastrelle;

public class Triangolare implements Rivestimento {

    public final int b, h, c;
    public Triangolare(int base, int altezza, int costo){
        if (base < 1 || altezza < 1 || costo < 1) throw new IllegalArgumentException();
        b = base;
        h = altezza;
        c = costo;
    }

    @Override
    public int getSuperficie() {
        return (b*h)/2;
    }

    @Override
    public int getCosto() {
        return c;
    }
    
}
