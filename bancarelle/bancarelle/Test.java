package bancarelle;
import java.util.*;

public class Test {
    
    public static void main(String[] args) {
        final Map<Giocattolo, Integer> inv  = new HashMap<Giocattolo, Integer>();
        final Map<Giocattolo, Integer> list  = new HashMap<Giocattolo, Integer>();
        Scanner input = new Scanner(System.in);
        String name = input.nextLine().toString();
        System.out.println(name.toString());
        
        while (input.hasNextLine()){
            String line = input.nextLine();
            String tkns[] = line.split(" ");
            int qnty = tkns[0].toCharArray()[0] - '0';
            int price = tkns[3].toCharArray()[0] - '0';
            Giocattolo g = new Giocattolo(tkns[1], tkns[2]);
            if (inv.containsKey(g)){
                System.out.println("Giocattolo già presente");
            }else{
                inv.put(g, qnty);
                list.put(g, price); 
            }
        }
        input.close();

    Inventario i = new Inventario(inv);
    Listino l = new Listino_unitario(list);
    Bancarella b = new Bancarella(name, i, l);
    System.out.println(b.toString());

    }
}

