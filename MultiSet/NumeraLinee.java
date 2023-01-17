import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public  class NumeraLinee {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
        int n = 0;
        String linea;
        while ((linea = in.readLine()) != null)
        System.out.println(String.format("%02d: %s", ++n, linea));
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
