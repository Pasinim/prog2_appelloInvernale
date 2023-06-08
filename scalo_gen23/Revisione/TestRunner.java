import java.io.FileInputStream;
import java.util.Scanner;

import Estate2023.Molo;
import Estate2023.Rimorchiatore;
import Estate2023.Scalo;

public class TestRunner {
    public static void main(String[] args) {
        Scalo scalo = new Scalo();
        int nNavi = Integer.parseInt(args[0]);
        int nMoloPartenza = Integer.parseInt(args[1]);
        int nMoloArrivo = Integer.parseInt(args[2]);
        try (Scanner in = new Scanner(new FileInputStream("./Revisione/input-0.txt"))) {
            int nMoli = in.nextInt();
            in.nextLine();
            for (int i = 0; in.hasNextLine(); i++) {
                Molo m = new Molo();
                String tkns[] = in.nextLine().split(" ");
                for (int j = 0; j < tkns.length - 1; j = j + 2){
                    Nave n = new Nave(tkns[j], Integer.parseInt(tkns[j+1]));
                    m.attracca(n);
                }
                scalo.aggiungi(m);
            }
        } catch (Exception ex) {
            System.out.println("Erorre scanner");
            System.err.println(ex);
        }

        System.out.println(scalo.toString());


        Rimorchiatore r = new CautoRimorchiatore(scalo, 20);
        System.out.println(r.sposta(scalo.getMolo(nMoloPartenza), scalo.getMolo(nMoloArrivo), nNavi));
        System.out.println(scalo.toString());
    }

//     ```
// 0: < Mowgli[5], Simba[9], LiloPelekai[5], Baloo[21], BuzzLightyear[12], Woody[6], MickeyMouse[4] #
// 1: < Sirius[42], Orion[24], Pollux[11], Castor[33], Polaris[10] #
// 2: < Altair[12], Sun[9], Antares[51], Calcium[40], Iron[55], Argon[39], Hydrogen[1], Neon[10] #
// 3: < Madrid[3], Rome[3], Barcelona[1], Dubai[3], Tokyo[14], Paris[2], London[9] #
// ```
}
