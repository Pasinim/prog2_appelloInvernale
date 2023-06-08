import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TestRunner {
    public static void main(String[] args) {
       List<Double> lf = new ArrayList<Double>();
       int osservazioni = 0;
        try (Scanner in = new Scanner(new FileInputStream("./input-0.txt"))) {
            while (in.hasNext()) {
                lf.add(in.nextDouble());
                osservazioni++;
            }

        } catch (Exception ex) {
            System.out.println("Erorre scanner");
            System.err.println(ex);
        }

        Double[] array = new Double[osservazioni];
        lf.toArray(array);
        
        StatisticaAbs s1 = new PassataDue(osservazioni, array);
        StatisticaAbs s2 = new PassataDue(osservazioni, array);
        System.out.println(s1.toString());     
        System.out.println(s2.toString());       

    }
}
