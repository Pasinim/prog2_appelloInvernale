package piastrelle;

public abstract class Piastrella implements Rivestimento {


    public final int costo;

    public Piastrella(final int costo) {
        if (costo <= 0) throw new IllegalArgumentException("Il costo dev'essere positivo.");
        this.costo = costo;
    }

    @Override
    public abstract int getSuperficie();

    @Override
    public int getCosto() { 
        return costo;
    }
  } 
