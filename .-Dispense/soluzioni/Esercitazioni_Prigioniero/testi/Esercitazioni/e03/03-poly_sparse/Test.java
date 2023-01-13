public class Test {
    public static void main(String[] args) {
        PolySparse s = new PolySparse(3, 2);
        PolySparse p = new PolySparse(1, 1);
        System.out.println(s.toString());
        s=s.add(p);
        System.out.println(s.toString());    
    }
}
