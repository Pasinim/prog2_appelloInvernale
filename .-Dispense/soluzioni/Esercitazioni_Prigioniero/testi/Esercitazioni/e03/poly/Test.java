package poly;
public class Test {
    public static void main(String[] args) {
        Poly p = new Poly(3, 3);
        Poly q = new Poly(2, 2);
        q =  q.add(p);
        System.out.println(q.toString());
        System.out.println(q.degree());
        q = q.mul(q);
        System.out.println("mult" + q.toString());
        }
}

