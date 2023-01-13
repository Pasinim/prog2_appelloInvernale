public class test {
    public static void main(String[] args) {
        IntSet s = new IntSet();
        //s.choose();
        s.insert(1);
        s.insert(2);
        s.insert(3);
        s.remove(2);
        System.out.println(s.toString());
    }
}   
