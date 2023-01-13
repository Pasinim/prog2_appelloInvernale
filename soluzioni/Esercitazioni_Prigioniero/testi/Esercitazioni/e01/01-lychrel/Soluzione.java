import java.util.Scanner;

public class Soluzione {
    //PRECONDIZIONI: 
    //POSTCONDIZIONI: restituisce il numero n in forma Strign
    public static String convertToString (long n){
        //Long x = n;
        //return x.toString();
        return "" + n;
    }

    //PRE: riferimento str a NULL
    //POST: restitisce la stringa capovolta
    public static String reverse(String str){
        int len=str.length();
        String reverse="";
        for (int i=0; i<len;i++){
            reverse+=str.charAt(i);
        }
        return reverse;
    }


    //PRECONDIZIONI: str riferimento non nullo
    //POSTCONDIZIONI: ritorna true se la stringa è palindroma, false altrimenti
   
    public static boolean isPalindromo (String str){
        for (int i=0; i < str.length()/2; i++){
            if (str.charAt(i)!=str.charAt(str.length()-i-1))
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scan  = new Scanner(System.in);
        long n=scan.nextLong();
        scan.close();
        System.out.print(convertToString(n));
    //     while (!isPalindromo(n)){
    //         n = n+transform(n);
    //         System.out.println(n);
    //         }
     }
}

