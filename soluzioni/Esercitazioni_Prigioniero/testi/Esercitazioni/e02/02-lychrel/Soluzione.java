import java.util.Scanner;
import java.util.Arrays;

public class Soluzione {

    /**
     * Post: restituisce true se il numero è palinromo
     */
    public static boolean isPalin (long a[]){
        if (a.length==0 || a.length==1)
            return true;
        if (a[0]==a[a.length-1])   
            return isPalin(Arrays.copyOfRange(a, 1, a.length-1));
        return false;
    }
    /**
     * Post: converte il numero memorizzato in a in un numero di tipo long
     * Se a è null solleva {@link NullPointerException}
     */
    public static long digitsToLong(long[] a){
        if (a==null) throw new NullPointerException();
        long n=0;
        for (long b : a)
            n=n*10+b;
        return n;
    }

    /**
     * Post: restituisce le cifre del numero n, lungo digits, in un array 
     * Se il numero è più lungo di 9 cifre viene lancaite {@link IllegalArgumentException}
     */
    public static long[] longToDigits(long n, int digits){
        if (digits>9) throw new IllegalArgumentException(
            "\nIl numero deve avere al massimo 9 cifre. Trovato " + n);
        long[] a = new long[digits];
        for (int i=digits-1; i>=0; i--, n/=10)
            a[i]=(long)(n%10);
        return a;
    }

    /**
     * 
     * Post: restituisce il numero n con le cifre invertite. Solleva una eccezione 
     * di tipo NillPointerExcetion se viene passato come riferimento di digit ub null
     * Solleva una eccezione di tipo {@link IllegalArgumentException} se viene 
     * digits è maggiore di 9 cifre
     */
    public static void reverse (long[] digits){
        if (digits.length>9) throw new IllegalArgumentException(
            "\nIl numero deve avere al massimo 9 cifre. Trovato " + String.valueOf(digits).length());
        if (digits==null) throw new NullPointerException("\n long non deve essere null");
        for (int i=0; i<digits.length/2; i++){
            long tmp=digits[i];
            digits[i]=digits[digits.length -1 -i];
            digits[digits.length -1 -i] = tmp;
        }
    }
    /**
     * Pre: al più 9 cifre -> n<1000000000
     * Post: esegue uno "step di lychrel". Se il numero inserito eccede le 9 cifre
     * viene sollevata un eccezione di tipo {@link IllegalArgumentException}
     */
    public static long lychrelStep (long n){
        if (n>1000000000) throw new IllegalArgumentException(
            "\nIl numero deve avere al massimo 9 cifre. Trovato " + n);
        long[] a = longToDigits(n, String.valueOf(n).length());
        reverse(a);
        long n2 = digitsToLong(a);
        return n2 + n;
    }
    /**
     * Pre: al più 9 cifre -> n<1000000000
     * Post: stampa la sequenza di lychrel
     */
    
    public static void printLychrel (long n){
        if (n>1000000000) throw new IllegalArgumentException(
            "\nIl numero deve avere al massimo 9 cifre. Trovato " + n);
        
        System.out.println(n);
        while (true){
            n=lychrelStep(n);
            System.out.println(n);
            if (isPalin(longToDigits(n, String.valueOf(n).length())))
                break;
        }
    }
public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n=scan.nextInt();
    scan.close();
    printLychrel(n);
    }
}