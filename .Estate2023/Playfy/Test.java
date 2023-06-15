import java.io.FileInputStream;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new FileInputStream("./.Estate2023/Playfy/input.txt"))) {
            String firstLine = in.nextLine();
            String[] tkns = firstLine.split("ALBUM");
            String titAlbum = tkns[0];

            // in.nextLine();
            // for (int i = 0; in.hasNextLine(); i++) {
            // Molo m = new Molo();
            // String tkns[] = in.nextLine().split(" ");
            // for (int j = 0; j < tkns.length - 1; j = j + 2) {
            // Nave n = new Nave(tkns[j], Integer.parseInt(tkns[j + 1]));
            // m.attracca(n);
            // }
            // scalo.aggiungi(m);
            // }
            System.out.println(titAlbum.toString());
        } catch (Exception ex) {
            System.out.println("Erorre scanner");
            System.err.println(ex);
        }
    }

}
