package Statistica;

import java.io.FileInputStream;
import java.util.Scanner;

public class TestRunner {
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
            PassataUno pu = new PassataUno(oss);
            PassataDue pd = new PassataDue(oss);
            System.out.printf("Passata due: %s\n", pd.toString());
            System.out.printf("Passata uno: %d %s \n", osservazioni.length, pu.toString());

        } catch (Exception e) {
            System.out.println("Errore nella lettura del file");
        }
    }
}
