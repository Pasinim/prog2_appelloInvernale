package tde.thomas2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
* Inteprete che in grado di processare input per la creazioni di Rotabili.
*/
public class Interprete {
    private final InputStream is;
    
    /**
    * Inizializza un Interprete in grado di leggere da InputStream is.
    */
    public Interprete(InputStream is){
        this.is = is;
    }
    
    /**
    * Inizia la lettura su is.
    */
    public Rotabile readLine(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        try {
            String line = reader.readLine();
            String[] tkns = line.split(" ");
            
            String type = tkns[0];
            
            switch (type) {
                case "L":
                Locomotore l  = creaLocomotore(tkns);
                return l;
                
                case "V":
                Vagone v = creaVagone(tkns);
                return v;
                
                default:
                throw new IllegalArgumentException();
            }    
        } catch (IOException e) {
            return null;
        } catch (IllegalArgumentException e){
            System.out.println("Errore nel formato della stringa");
            return null;
        }
    }
    
    private Locomotore creaLocomotore(String[] tkns){
        try {
            String nome = tkns[1];
            int peso = Integer.parseInt(tkns[2]);
            int potenza = Integer.parseInt(tkns[3]);
            
            return new Locomotore(nome, peso, potenza);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException();
        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }
    
    private Vagone creaVagone(String[] tkns){
        try {
            String nome = tkns[1];
            int peso = Integer.parseInt(tkns[2]);
            List<Dotazione> d = new ArrayList<>();
            
            for(int i = 3; i < tkns.length; i++){
                String n = tkns[i];
                int qta = Integer.parseInt(tkns[++i]);
                
                d.add(new Dotazione(n, qta));
            }
            
            
            return new Vagone(nome, peso, d);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ciao");
            throw new IllegalArgumentException();
        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    public static void main(String args[]){
        Interprete i = new Interprete(System.in);

        while(true){
            System.out.println(i.readLine());;
        }
    }
}
