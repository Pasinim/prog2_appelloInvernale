import java.util.Scanner;
public class test {
    public static void main(String[] args) {
        //Scanner s = new Scanner(System.in);
        //int n = s.nextInt();
        IntQueue q = new IntQueue(3);
        q.enqueue(1);
        q.enqueue(2);
        System.out.println(q.toString());

        System.out.println(q.hashCode());


        IntQueue p = new IntQueue(3);
        p.enqueue(1);
        p.enqueue(2);
        System.out.println(p.toString());
        p.dequeue();

        //System.out.println(p.toString());
        System.out.println(p.hashCode());

    }
}
