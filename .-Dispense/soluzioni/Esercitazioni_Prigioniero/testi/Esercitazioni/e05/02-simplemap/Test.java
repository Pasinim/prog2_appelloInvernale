import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Simplemap s = new Simplemap();
       Scanner scan = new Scanner(System.in);
       char c = scan.next().charAt(0);
       while(c != '\u0000'){
            String k = scan.nextLine();
            int v=scan.nextInt();
           
           switch (c){
               case '+':
                s.put(k, v);    
           }
       }
       s.toString();
    }
}
