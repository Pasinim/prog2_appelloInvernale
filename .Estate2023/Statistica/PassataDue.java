package Statistica;

import java.io.FileInputStream;
import java.util.Objects;
import java.util.Scanner;

/**
 * Le istanze di questa classe descrivono le statistiche di un certo numero di
 * osservazioni.
 */

public class PassataDue implements Statistica {
    /**
     * IR: osservazioni != null && osservazioni.length > 0
     * AF:
     */

    private final double[] osservazioni;

    /**
     * Inizializza una nuova PassataUno da un array di osservazioni
     * 
     * @param oss array di osservazioni
     * @throws NullPointerException     se oss == null
     * @throws IllegalArgumentException se oss.length == 0
     */
    public PassataDue(final double[] oss) {
        Objects.requireNonNull(oss, "Array osservazioni nullo");
        if (oss.length <= 0)
            throw new IllegalArgumentException("Array osservazioni vuoto");
        // Utilizzare osservazioni = oss non crea una copia dell'array, ma assegna il
        // riferimento all'array oss alla variabile osservazioni. Questo significa che
        // le modifiche all'array originale possono ancora essere fatte tramite il
        // riferimento osservazioni, compromettendo l'immobilità dell'oggetto. Pertanto,
        // è preferibile utilizzare il metodo clone() per creare una copia dell'array.
        osservazioni = oss.clone();
    }

    @Override
    public double media() {
        double somma = 0;
        for (double o : osservazioni)
            somma += o;
        return somma / osservazioni.length;
    }

    @Override
    public double varianza() {
        double media = media();
        double sommaScartiQuadrati = 0;

        for (double o : osservazioni) {
            double scarto = o - media;
            sommaScartiQuadrati += scarto * scarto;
        }
        return sommaScartiQuadrati / (osservazioni.length - 1);
    }

    public String toString() {
        return String.format("%d, %.8e, %.8e\n", osservazioni.length, media(), varianza());
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int c = 0;
        try (Scanner in = new Scanner(new FileInputStream("./Statistica/input-0.txt"))) {
            for (; in.hasNextLine(); c++)
                sb.append(in.nextLine()).append(" ");
            String osservazioni[] = sb.toString().split(" ");
            double[] oss = new double[osservazioni.length];
            for (int i = 0; i < osservazioni.length; i++) {
                oss[i] = Double.parseDouble(osservazioni[i]);
            }
            PassataDue pd = new PassataDue(oss);
            System.out.printf("%d, %.8e, %.8e\n", c, pd.media(), pd.varianza());

        } catch (Exception e) {
            System.out.println("Errore nella lettura del file");
        }
    }

}
