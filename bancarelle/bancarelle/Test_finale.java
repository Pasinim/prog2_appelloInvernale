package bancarelle;
import java.util.*;

public class Test_finale {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // String cmd[] = input.nextLine().split("");
        Set<Bancarella> bancarelle = new HashSet<Bancarella>();
        int n_bancarelle = input.nextInt();
        System.out.println("Numero bancarelle: "+ n_bancarelle + "\n");
        for (int i = n_bancarelle; i > 0; i--){
            String s = input.nextLine();
            String proprietario[] = s.split(" ");
            Listino l = new Listino();

            Bancarella b = new Bancarella(proprietario, 
            
        }
        while (input.hasNextLine()){
            String line = input.nextLine();
            String tkns[] = line.split(" ");
            if (Character.isDigit(tkns[0].toCharArray()[0])){

            }
           
        }
        input.close();
    }
    
}
/**
 *3
Massimo 4
3 cane pezza 10
2 bilia vetro 2
10 elastico gomma 1
1 soldatino stagno 3
Carlotta 2
10 braccialetti perline 3
4 bilia vetro 1
Federico 3
10 soldatino stagno 2
10 bilia vetro 3
1 cane pezza 5
 */