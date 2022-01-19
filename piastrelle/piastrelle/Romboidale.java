package piastrelle;

public class Romboidale extends Piastrella  {

    public final int d1, d2, c;
    /**
     * Crea una nuova piastrelle romboidale di diagonali d1 e d2.
     * @param d1 Diagonale 1 
     * @param d2 Diagonale 2
     * @param costo Costo di una piastrella
     * @throws IllegalArgumentException se una delle due diagonali è <= 0 o se il costo è negativo
     */
    public Romboidale(int d1, int d2, int costo){
        super(costo);
        if (d1 <= 0 || d2 <=0) throw new IllegalArgumentException("Le diagonali devono essere positive");
        this.d1 = d1;
        this.d2 = d2;
    }
    @Override
    public int getSuperficie() {
        return (d1*d2)/2;
    }
    
}
