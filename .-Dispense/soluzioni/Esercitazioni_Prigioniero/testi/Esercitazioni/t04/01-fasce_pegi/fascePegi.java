import java.util.Scanner;


public class fascePegi{
    public static void main (String[] args){
        Scanner s = new Scanner (System.in);
        int age = s.nextInt();
        s.close();
        int fascia;
        if (age<7)
            fascia=3;
        else if (age <12)
            fascia = 7;
        else if (age <16)
            fascia = 12;
        else if (age <17)
            fascia = 16;
        else 
            fascia=18;
        System.out.println("fascia " + fascia);
    }
}
