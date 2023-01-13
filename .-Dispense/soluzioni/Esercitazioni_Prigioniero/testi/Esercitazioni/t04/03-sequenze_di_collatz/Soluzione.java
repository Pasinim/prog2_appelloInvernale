import java.util.Scanner;

public class Soluzione {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        s.close();  
        int count=0;
        while(true){
            System.out.print(n + " ");
            count++;
            if (n==1) break;
            if (n%2==0)
                n=n/2;
            else 
                n=n*3+1;
        }
        System.out.println(count);
    }
}
