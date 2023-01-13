import java.util.Scanner;

public class Test{
    public static void main(String[] args) {
        IntSet is = new IntSet();
        System.out.println("asdada");
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()){
            int n = scan.nextInt();
            is.insert(n);
        }
        System.out.println(is.size());
    }
}