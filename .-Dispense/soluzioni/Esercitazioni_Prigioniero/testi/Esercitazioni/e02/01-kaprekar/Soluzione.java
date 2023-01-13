import java.util.Scanner;
import java.util.Arrays;
public class Soluzione {

 /**
  * Pre: a non null 
    Post: restituisce un array contenente gli elementi di a in ordine non crescente
  * 
  */
    public static void reverse(byte[] a){
        if (a==null) throw new NullPointerException();
        byte tmp;
        for (int i=0; i<a.length/2; i++){
            tmp=a[i];
            a[i]=a[a.length-1-i];
            a[a.length-1-i] = tmp;
        }
    }
  /**
   * Pre: n di 4 cifre
   * Post: restituisce un array conenente le cifre di n
   */
    public static byte[] intToDigits(int n, int digits){
        byte[] a = new byte[digits];
        for (int i=digits-1; i>=0; i--, n/=10){
            a[i]=(byte)(n%10);
        }
        return a;
    }
  /**
   * Pre: a non null 
   * Post: restituisce il numero composto dalle cifre in a
   */
    public static int digitsToInt (byte[] a){
        int num=0;
        for (byte b : a) {
                if (b<0 || b>9)
                    throw new IllegalArgumentException(
                        "I valori devono essere decimali. Trovato "+b); 
                    
            //System.out.println(b);
            num = num*10+b;
        }
        return num;
    }
    /**
   * Pre: n ha almeno due cifre diverse
   * Post: stampa la sequenza di Kaprekar
   */
    public static void printKaprekar (int n){
        System.out.println(n);
        while (n!=6174){
            n=kaprekarStep(n);
            System.out.println(n);
        }
    }
    /**
     * Pre: n ha almeno due cifre diverse
     * Post: esegue un passo della sequenza di Kaprekar
     * */
    public static int kaprekarStep(int n){
        byte[] digits = intToDigits(n, 4);
        Arrays.sort(digits);
        int num = -digitsToInt(digits);
        reverse(digits);
        
        return digitsToInt(digits) + num;
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        scan.close();
        // byte[] a = intToDigits(n, 4);
        // int num = digitsToInt(a);
        // System.out.println(num);
        printKaprekar(n);
    }
}
