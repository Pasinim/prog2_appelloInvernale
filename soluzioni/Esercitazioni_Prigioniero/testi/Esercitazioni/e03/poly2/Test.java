
public class Test {
    public static void main(String[] args) {
        polin p = new polin(3, 3);
        polin q = new polin(2, 2);
        System.out.println(q.toString());
        System.out.println(q.degree());
        System.out.println(p.degree());
        q = q.mul(p);
        System.out.println(q.toString());
        }
}

