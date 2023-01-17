import java.io.FileInputStream;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;


public class TestRunner {
    // Scrivete una classe che abbia un metodo statico main che legga dal
    //  flusso di ingresso due linee contenenti ciascuna una sequenza di parole
    //   separate da spazi e costruisca due multiset a partire 
    //   da essi; una volta letto l’ingresso, la classe deve emettere sul flusso
    //    d’uscita, uno per linea, i due insiemi e la loro intersezione e unione, precedendo ogni 
    //    insieme dall’indicazione della sua cardinalità.
    
    public static void main(String[] args) {
        List<MapStringMS> els = new ArrayList<MapStringMS>(); 
        System.out.println("CTRL + Z per uscire...");
        //try (Scanner in = new Scanner(System.in)){ //lettura da tastiera
       try (Scanner in = new Scanner(new FileInputStream("./input.txt"))) {
            while (in.hasNextLine()) {
                MapStringMS ms = new MapStringMS();
                String line = in.nextLine();
                // System.out.println(line);
                String tkns[] = line.split(" ");
                for ( int i = 0; i < tkns.length; i++ ){
                   ms.add(tkns[i]);     
                }
                els.add(ms);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(els.get(0).toString()); 
        System.out.println(els.get(1).toString()); 
        System.out.println((els.get(0).union(els.get(1))).toString()); 

    }
}
