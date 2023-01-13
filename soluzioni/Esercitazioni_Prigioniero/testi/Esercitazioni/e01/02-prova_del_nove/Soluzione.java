import java.util.Scanner; 
import java.util.Arrays;
public class Soluzione {
    //somma cifre
    //conversione
    //confronto tra operandi e prodotto

    public static int[] numToDigits(int n, int digits){
        int[] a =new int[digits];
        for (int i = digits-1; i>=0; i--, n/=10 )
            a[i] = n%10;
        return a;
    }

    /**
     * POST: restituisce la somma delle cifre contenute in a finche
     * non rimane una sola cifra nell'array. Se il a è null solleva {@link NullPointerException}
     * 
     */
    public static int sumDigits (int[] a, int digits){
        if (a==null) throw new NullPointerException();
        int sum=0;
        for (int i=0; i<digits; i++)
            sum+=a[i];
        if (sum<10)
            return sum;
        return sumDigits(numToDigits(sum, String.valueOf(sum).length()), String.valueOf(sum).length());
    }

    public static boolean checkNine (int n1, int n2, int p){
        int l1 = String.valueOf(n1).length();
        int l2 = String.valueOf(n2).length();
        int lp = String.valueOf(p).length();
        int[] a1 = numToDigits(n1, l1);
        int[] a2 = numToDigits(n2, l2);
        int[] ap = numToDigits(p, lp);
        //System.out.println("\t sum1 " + sumDigits(a1, l1) + " sum2 " + sumDigits(a2, l2));
        //System.out.println((p));
        int[] prodotto = numToDigits((sumDigits(a1, l1) * sumDigits(a2, l2)), String.valueOf(prodotto).length());
        if (sumDigits(prodotto, String.valueOf(prodotto).length())==sumDigits(ap, l2))
            return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n1=scan.nextInt();
        int n2=scan.nextInt();
        scan.close();
        //System.out.println(Arrays.toString(numToDigits(n, String.valueOf(n).length())));
        int p = n1*n2;
        System.out.println("\t " + n1 + " " + n2 + " " + p);
        System.out.println(checkNine(n1, n2, p));
        //System.out.println(sumDigits(numToDigits(n1, 4), 4));
    }
}
