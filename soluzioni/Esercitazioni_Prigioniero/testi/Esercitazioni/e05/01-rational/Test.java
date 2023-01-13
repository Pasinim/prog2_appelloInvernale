import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Test {
    public static void stampa (List<Rational> l){
        System.out.println();
        for (int i=0; i<l.size(); i++){
            System.out.println(i + ": " + l.get(i));
        }
    }
    public static void main(String[] args) {
        List<Rational> l = new ArrayList<>();
        //List<Integer> l = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()){
            int n =scan.nextInt();
            int d =scan.nextInt();
            Rational r = new Rational(n,d);
            l.add(r);
            if (scan.hasNextLine()) continue;
            
        }
        scan.close();
        stampa(l);
    }
}
