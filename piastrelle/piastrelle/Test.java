package piastrelle;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        Pavimentazione p = new Pavimentazione();
        Scanner input = new Scanner(System.in);
        int lineCounter = 0;
        while (input.hasNext()){
            String line = input.nextLine();
            String tkns[] = line.split(" ");
            System.out.println("\t" + Arrays.toString(tkns));
            switch(tkns[0]){
                case "Q":
                    p.addPiastrella(new Quadrata(Integer.valueOf(tkns[1]), Integer.valueOf(tkns[2])));
                    break;
                case "R":
                    p.addPiastrella(new Romboidale(Integer.valueOf(tkns[1]), Integer.valueOf(tkns[2]), Integer.valueOf(tkns[3])));
                    break;
                case "T":
                    p.addPiastrella(new Triangolare(Integer.valueOf(tkns[1]), Integer.valueOf(tkns[2]), Integer.valueOf(tkns[3])));
                    break;
                case "P":
                    break;
                default:
                    break;
                    // if (tkns.length % 2 == 0) throw new IllegalArgumentException("Per creare una pavimentazione devi inserire una COPPIA di numeri");
                    // for (int i=0; i <= tkns.length-1; i = i + 2)
                    //     p.addPavimentazione(tkns[i], tkns[i+1]);
            }
        lineCounter++;
    }
    System.out.println(p.toString());
    input.close();
    }
}
