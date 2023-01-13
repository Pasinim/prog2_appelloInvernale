public class Test {
    public static void main(String[] args) {
        SparseList p = new SparseList (3, 2);
        SparseList q = new SparseList (2, 2);
        System.out.println(p.isIn(q, 0));
        System.out.println("coeff: " + p.coeff(0));
        //q = q.add(p);

        System.out.println(q.toString());
    }
}
