package Robot;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class TestRunner {
    public static void main(String[] args) {
        List<Scaffalatura> scaffalature = new ArrayList<>();
        try (Scanner in = new Scanner(new FileInputStream("./Robot/input-0.txt"))) {
            int nScaffali = in.nextInt();
            in.nextLine();
            for (int i = 0; i < nScaffali; i++) {
                Scaffalatura m = new Scaffalatura();
                String tkns[] = in.nextLine().split(" ");
                for (int j = 0; j < tkns.length; j = j + 2) {
                    Pacco n = new Pacco(tkns[j], Integer.parseInt(tkns[j + 1]));
                    m.deposita(n);
                }
                scaffalature.add(m);
            }
        } catch (Exception ex) {
            System.out.println("Erorre scanner");
            System.err.println(ex);
        }
        Magazzino magazzino = new Magazzino(scaffalature);
        System.out.println(magazzino.toString() + " MADAZZINO DOPO:\n");

        Robot micro = new Micro(magazzino);
        micro.deposita(3, 1, 2);
        System.out.println(magazzino.toString());
    }
}
