import java.io.FileInputStream;
import java.util.Scanner;

public class TestRunner {
    public static void main(String[] args) {
        Molo m = new Molo();
        try (Scanner in = new Scanner(new FileInputStream("./Revisione/input-0.txt"))) {
            for (int i = 1; in.hasNextLine(); i++) {
                String tkns[] = in.nextLine().split(" ");
                for (int j = 0; j < tkns.length - 1; j = j + 2){
                    Nave n = new Nave(tkns[j], Integer.parseInt(tkns[j+1]));
                    m.attracca(n);
                }
       
            }
        } catch (Exception ex) {
            System.out.println("Erorre scanner");
            System.err.println(ex);
        }
        System.out.println(m.toString());
    }
}
