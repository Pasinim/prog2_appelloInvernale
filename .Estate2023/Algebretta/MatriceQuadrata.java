package Algebretta;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Classe concreta che implementa l'interfaccia matrice
 */

public class MatriceQuadrata implements Matrice {
    /**
     * RI: dimensione > = 0
     * AF: matrice[0][0] + matrice[0][1] + ... + matrice[0][n-1] + ... +
     * matrice[n-1][n-1]
     */
    private int dimensione;
    private int[][] matrice;

    public MatriceQuadrata(final int dimensione) {
        if (dimensione <= 0)
            throw new IllegalArgumentException("La dimensione deve essere maggiore di 0");
        this.dimensione = dimensione;
        this.matrice = new int[dimensione][dimensione];
    }

    @Override
    public int getDimensione() {
        return dimensione;
    }

    /**
     * Super()
     * 
     * @throws IllegalArgumentException se riga o colonna sono negativi o maggiori
     *                                  della dimensione della matrice
     */
    @Override
    public int getElemento(int riga, int colonna) {
        if (riga < 0 || riga >= dimensione || colonna < 0 || colonna >= dimensione)
            throw new IllegalArgumentException("Indice non valido");
        return matrice[riga][colonna];
    }

    /**
     * Super()
     * 
     * @throws IllegalArgumentException se riga o colonna sono negativi o maggiori
     *                                  della dimensione della matrice
     */
    @Override
    public void setElemento(int riga, int colonna, int valore) {
        matrice[riga][colonna] = valore;
    }

    @Override
    public Matrice prodottoPerScalare(int scalare) {
        MatriceQuadrata risultato = new MatriceQuadrata(dimensione);
        for (int i = 0; i < dimensione; i++) {
            for (int j = 0; j < dimensione; j++) {
                risultato.setElemento(i, j, matrice[i][j] * scalare);
            }
        }
        return risultato;
    }

    @Override
    public Matrice sommaMatriciale(Matrice altraMatrice) {
        if (altraMatrice instanceof MatriceQuadrata) {
            MatriceQuadrata altraMatriceQuadrata = (MatriceQuadrata) altraMatrice;

            if (isConforme(altraMatrice))
                throw new IllegalArgumentException("Le due matrici devono avere la stessa dimensione");

            MatriceQuadrata risultato = new MatriceQuadrata(dimensione);

            for (int i = 0; i < dimensione; i++) {
                for (int j = 0; j < dimensione; j++) {
                    risultato.setElemento(i, j, matrice[i][j] + altraMatriceQuadrata.getElemento(i, j));
                }
            }

            return risultato;
        } else
            throw new IllegalArgumentException("La matrice passata come parametro non è una matrice quadrata");

    }

    @Override
    public Matrice prodottoMatriciale(Matrice altraMatrice) {
        if (altraMatrice instanceof MatriceQuadrata) {
            MatriceQuadrata altraMatriceQuadrata = (MatriceQuadrata) altraMatrice;

            if (dimensione != altraMatriceQuadrata.getDimensione()) {
                throw new IllegalArgumentException("Le due matrici devono avere la stessa dimensione");
            }

            MatriceQuadrata risultato = new MatriceQuadrata(dimensione);

            for (int i = 0; i < dimensione; i++) {
                for (int j = 0; j < dimensione; j++) {
                    int valore = 0;
                    for (int k = 0; k < dimensione; k++) {
                        valore += matrice[i][k] * altraMatriceQuadrata.getElemento(k, j);
                    }
                    risultato.setElemento(i, j, valore);
                }
            }

            return risultato;
        } else
            throw new IllegalArgumentException("La matrice passata come parametro non è una matrice quadrata");

    }

    @Override
    public boolean isConforme(Matrice altraMatrice) {
        return getDimensione() == altraMatrice.getDimensione();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dimensione; i++) {
            for (int j = 0; j < dimensione; j++) {
                int x = matrice[i][j];
                sb.append(matrice[i][j] + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Imposta tutti gli elementi della matrice con i valori della matrice data
     * @param matrice matrice da cui prendere i valori
     * @param dimMatrice dimensione della matrice
     * @throws IllegalArgumentException se le due matrici non hanno la stessa dimensione
     */
    public void setAllElementi(int[][] matrice, int dimMatrice) {
        if (dimMatrice != dimensione )
            throw new IllegalArgumentException("Le due matrici devono avere la stessa dimensione");
        for (int i = 0; i < dimensione; i++) 
            for (int j = 0; j < dimensione; j++) 
                    setElemento(i, j, matrice[i][j]);
                
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new FileInputStream("./.Estate2023/Algebretta/input-matrix.txt"))) {

            String matriceInput = scanner.nextLine();
            System.out.println(matriceInput.toString());

            String[] righe = matriceInput.substring(1, matriceInput.length() - 2).split("; ");
            int numeroRighe = righe.length;
            int numeroColonne = righe[0].split(", ").length;

            int[][] matrice = new int[numeroRighe][numeroColonne];

            for (int i = 0; i < numeroRighe; i++) {
                String[] elementi = righe[i].split(", ");
                for (int j = 0; j < numeroColonne; j++)
                    matrice[i][j] = Integer.parseInt(elementi[j]);
            }
            Matrice m = new MatriceQuadrata(numeroRighe);
            m.setAllElementi(matrice);
            }
            System.out.println(m.toString());

        } catch (Exception ex) {
            System.out.println("Erorre scanner");
            System.err.println(ex);
        }
    }
