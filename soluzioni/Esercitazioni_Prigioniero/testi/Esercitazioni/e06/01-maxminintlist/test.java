public class test {
    public static void main(String[] args) {
            IntList a = new IntList();
            IntList b = new IntList();
            a.insert(1);
            a.insert(13);
            a.insert(2);
            a.insert(12);
            a.insert(222);
            a.insert(21);
            a.insert(2222);


            b.insert(2);
            b.insert(1);
            b.insert(112);
            
            System.out.println(a.hashCode());
            System.out.println(b.hashCode());

            //System.out.println(a.equals(b));

    }
}
