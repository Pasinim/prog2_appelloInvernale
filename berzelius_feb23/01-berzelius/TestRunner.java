import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class TestRunner {
    public static void main(String[] args) {

        TavolaPeriodica tp = new TavolaPeriodica();

        try (Scanner in = new Scanner(new FileInputStream("./input-0.txt"))) {
            //aggiungo la tavola periodica degli elementi dal file di input
            for (int i = 1; in.hasNextLine(); i++) {
                String tkns[] = in.nextLine().split("\\s+");
                if (tkns.length > 3 || tkns.length < 1) throw new IllegalArgumentException("Errore lettura input");
                Elemento e = new Elemento(tkns[0], tkns[1], Float.parseFloat(tkns[2]));
                tp.aggiungi(e, i);
            }
        } catch (Exception ex) {
            System.out.println("Erorre scanner");
            System.err.println(ex);
        }
        System.out.println(tp.toString());

        /** Una volta aggiunta la tavola periodica devo analizzare gli argomenti passati da linea di comando
         * ed eseguire le operazioni necessarie, se ho tempo la riprendo
         */
         
        //  Molecola m = new Molecola("Na", tp);
        //  m.toString();
    }
}
