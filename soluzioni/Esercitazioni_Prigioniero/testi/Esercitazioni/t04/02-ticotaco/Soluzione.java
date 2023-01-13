import java.util.Scanner;

// tico 3 taco 7
public class Soluzione{
    public static void main(String[] args) {
        Scanner s=new Scanner (System.in);
        String str = "";
        
        int n = s.nextInt();
        s.close();
        for (int i=0; i<=n; i++){
            if (i==0)
                continue;
            if (i%3==0 && i%7==0 ){
                str+="Tico Taco\n";
            }
            else if (i%3==0){
                str+="Tico\n";
            }
            else if (i%7==0){
                str+="Taco\n";
            }
            else
                str+=i+"\n";
        }
        System.out.print(str);
    }
}