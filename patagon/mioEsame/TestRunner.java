import java.io.FileInputStream;
import java.util.Scanner;

public class TestRunner {
    public static void main(String[] args) {

        /**
         * Non ho tempo per implementare la lettura
         * input.txt `e un file nella stessa directory di questo main in cui e` riportato lo stesso input dell'esempio nella traccia dell` esame
         */

        MagazzinoLogistico ml = new MagazzinoLogistico();
        // Scanner inScaffali = new Scanner(System.in);
        // int nScaffali = inScaffali.nextInt();
        // System.out.println("Scaff: "  + nScaffali);

        try (Scanner in = new Scanner(new FileInputStream("./input.txt"))) {
            //in.nextLine();
            for (int i = 0; in.hasNextLine(); i++ ) {
                Scaffalatura scaff = new Scaffalatura(i);
                String scaffale = in.nextLine();
                //System.out.println("..."  + scaffale.toString());
                String tkns[] = scaffale.split(" ");
                for ( int j = 0; j<tkns.length; j+=2){
                    //System.out.printf("tkns[%d] = %s \n", j, tkns[j].toString());
                    scaff.deposita(new Pacco(tkns[j], Integer.valueOf(tkns[j+1])));
                }
               // System.out.println(scaff.toString());
                ml.add(scaff);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(ml.toString());
    }   
}
