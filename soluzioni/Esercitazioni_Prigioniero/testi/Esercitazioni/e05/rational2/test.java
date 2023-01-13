import java.util.Scanner; 
public class test {
    public static void main(String[] args) {
        Scanner s = new Scanner (System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        Rational r = new Rational(n, m);
        r.gcd(n,m);

    }
}
