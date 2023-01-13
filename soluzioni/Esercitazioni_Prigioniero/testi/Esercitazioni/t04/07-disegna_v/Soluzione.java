import java.util.Scanner;

public class Soluzione {
    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);
        int n=s.nextInt();
        s.close();
        int spazi2;
        spazi2=n+2;
        for (int r=0; r<n; r++){
            disegnaSpazi(r);
            System.out.print("*");
            disegnaSpazi(spazi2);
            spazi2-=2;w
            if (spazi2<1) {
                System.out.println();
                break;
            }
            System.out.println("*");
        }
    }

    static void disegnaSpazi (int n){
        for (int i=0; i<n; i++){
            System.out.print(" ");
                }
        }
}
