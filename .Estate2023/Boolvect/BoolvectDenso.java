package Boolvect;

import java.util.Objects;

/**
 * Le instanze di questa classe impelemtano i metodi definiti nell'interfaccia
 * boolvect
 */

public class BoolvectDenso implements Boolvect {

    private final boolean[] vettore;

    /**
     * Inizializza un nuovo boolvect denso
     * 
     * @param s Stringa da cui inizializzare il boolvect
     * @throws NullPointerException     se s == null
     * @throws IllegalArgumentException se s è vuota
     */
    public BoolvectDenso(String s) {
        Objects.requireNonNull(s, "Stringa nulla");
        if (s.isEmpty())
            throw new IllegalArgumentException("Stringa vuota");
        vettore = new boolean[s.length()];
        for (int i = 0; i < s.length() - 1; i++)
            if (s.charAt(i) == 'V')
                scrivi(true, i);
            else
                scrivi(false, i);

    }

    public BoolvectDenso(int taglia) {
        if (taglia < 0) {
            throw new IllegalArgumentException("Taglia negativa");
        }
        vettore = new boolean[taglia];
    }

    @Override
    public int getDimensione() {
        for (int i = taglia() - 1; i >= 0; i--) {
            if (vettore[i])
                return i + 1;
        }
        return 0;
    }

    @Override
    public int taglia() {
        return vettore.length;
    }

    @Override
    public boolean leggi(int index) throws IllegalArgumentException {
        if (index < 0 || index >= taglia())
            throw new IllegalArgumentException("Index out of bounds");
        return vettore[this.taglia() - index];
    }

    @Override
    public void scrivi(boolean valore, int index) {
        if (index < 0 || index >= taglia())
            throw new IllegalArgumentException("Index out of bounds");
        vettore[index] = valore;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < taglia(); i++)
            sb.append(leggi(i) ? "V" : "F");
        return sb.toString() + "\n";
    }

    public static void main(String[] args) {

        String s = "FFFFVFFVVV";
        Boolvect bv = new BoolvectDenso(s);
        System.out.println(bv);
        System.out.println(bv.leggi(1));
    }

}