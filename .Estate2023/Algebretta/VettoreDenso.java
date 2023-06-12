package Algebretta;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

import Scalo.Molo;
import Scalo.Nave;

/**
 * Classe concreta che implementa l'interfaccia vettore
 */
public class VettoreDenso implements Vettore {

    /**
     * IR: vettore != null && vettore.length > 0
     * AF: Per ogni elemento i del vettore: vettore[0] + vettore[1] + ... +
     * vettore[n-1];
     */

    private final int[] vettore;

    public VettoreDenso(final int[] v) {
        Objects.requireNonNull(v, "Il vettore non può essere null");
        if (v.length == 0)
            throw new IllegalArgumentException("Il vettore non può essere vuoto");
        this.vettore = v.clone();
    }

    @Override
    public int dim() {
        return this.vettore.length;
    }

    /**
     * super()
     * 
     * @throws IllegalArgumentException se i è negativo o se i è maggiore della
     *                                  dimensione del vettore
     */
    @Override
    public int val(int i) {
        if (i < 0 || i >= this.dim())
            throw new IllegalArgumentException("Indice non valido");
        return this.vettore[i];
    }

    @Override
    public Vettore per(int alpha) {
        int[] tmp = new int[this.dim()];
        for (int i = 0; i < this.dim(); i++)
            tmp[i] = this.val(i) * alpha;
        return new VettoreDenso(tmp.clone());
    }

    /**
     * Super()
     * 
     * @throws NullpointerException se v è null
     */
    @Override
    public Vettore più(Vettore v) throws IllegalArgumentException {
        Objects.requireNonNull(v, "Il vettore non può essere null");
        if (!this.isConforme(v))
            throw new IllegalArgumentException("I vettori non sono conformi");
        int[] tmp = new int[this.dim()];
        for (int i = 0; i < this.dim(); i++)
            tmp[i] = this.val(i) + v.val(i);
        return new VettoreDenso(tmp.clone());

    }

    @Override
    public boolean isConforme(Vettore v) {
        return this.dim() == v.dim();
    }

    @Override
    public String toString() {
        return Arrays.toString(this.vettore);
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(new FileInputStream("./.Estate2023/Algebretta/input.txt"))) {
            String vettoreString = in.nextLine();
            String[] numeri = vettoreString.substring(1, vettoreString.length() - 1).split(", ");
            int[] v = new int[numeri.length];
            for (int i = 0; i < numeri.length; i++)
                v[i] = Integer.parseInt(numeri[i]);
            Vettore vettore = new VettoreDenso(v);

            System.out.println(vettore.toString());

        } catch (Exception ex) {
            System.out.println("Erorre scanner");
            System.err.println(ex);
        }
    }
}
