import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestRunner {
    public static void main(String[] args) {
        if (args.length != 3)
            throw new IllegalArgumentException("Indicare tutti i dati da linea di comando");
        int numeroNavi = Integer.parseInt(args[0]);
        int partenza = Integer.parseInt(args[1]);
        int arrivo = Integer.parseInt(args[2]);

        System.out.println("Numero navi: " + numeroNavi + " Partenza: " + partenza + " Arrivo: " + arrivo);

        List<Molo> listaMoli = new ArrayList<Molo>();

        try (Scanner in = new Scanner(new FileInputStream("./Scalo/input.txt"))) {
            int nMoli = in.nextInt();
            in.nextLine();
            for (int i = 0; i < nMoli; i++) {
                Molo m = new Molo();
                String tkns[] = in.nextLine().split(" ");
                for (int j = 0; j < tkns.length - 1; j = j + 2) {
                    Nave n = new Nave(tkns[j], Integer.parseInt(tkns[j + 1]));
                    m.attracca(n);
                }
                listaMoli.add(m);
            }
        } catch (Exception ex) {
            System.out.println("Erorre scanner");
            System.err.println(ex);
        }

        Scalo sc = new Scalo(listaMoli);
        System.out.println(sc.toString());
        System.out.println();
        Rimorchiatore r = new SuperRimorchiatore(sc);
        r.sposta(numeroNavi, partenza, arrivo);

        System.out.println(sc.toString());
    }
}
