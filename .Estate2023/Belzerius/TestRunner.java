import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestRunner {
    public static void main(String[] args) {

        List<Elemento> elementi = new ArrayList<>();
        try (Scanner in = new Scanner(new FileInputStream("./input.txt"))) {
            for (int i = 0; in.hasNextLine(); i++) {
                String tkns[] = in.nextLine().split(" ");
                // System.out.println(tkns.toString());
                Elemento e = new Elemento(tkns[0], tkns[1], Double.parseDouble(tkns[2]), i);
                elementi.add(e);
            }
        } catch (Exception ex) {
            System.out.println("Erorre scanner");
            System.err.println(ex);
        }
        TavolaPeriodica tp = new TavolaPeriodica(elementi);
        System.out.println(tp);
        System.out.println("________________");
        Molecola m = new Molecola(tp, "H2O");
        System.out.println(m.toString());
    }
}
