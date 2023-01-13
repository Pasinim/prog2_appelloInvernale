package tde.excel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe Inteprete capace di leggere da Stdin e di modificare il Foglio di calcolo
 * di conseguenza
 */
public class Interprete {
    
    /**
     * Legge comandi da Stdin e li esegue sul Foglio f.
     * 
     * @param f Foglio su cui eseguire i comandi.
     */
    public static void leggi(Foglio f){
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(is);

        try {
            for(String line = reader.readLine(); line != null; line = reader.readLine()){
                String[] token = line.split(" ");
                String cmd = token[0];

                switch (cmd) {
                    case "?":
                        //Ricavo Coordinata
                        int col = token[1].charAt(0) - 65;
                        int row = Integer.parseInt(token[1].substring(1));

                        Interprete.interroga_foglio(f, new Coordinata(row, col));
                        break;
                    case "P":
                        Interprete.stampa_foglio(f);
                        break;
                    case "!":
                        //Ricavo Coordinata
                        int c2 = token[1].charAt(0) - 65;
                        int r2 = Integer.parseInt(token[1].substring(1));

                        Interprete.aggiorna_foglio(f, new Coordinata(r2, c2), token);
                        break;
                    default:
                        break;
                }

            }            
        } catch (IOException e) {
            System.out.println("Errore lettura input");
            e.printStackTrace();
        }
    }

    private static void stampa_foglio(Foglio f){
        System.out.println(f.toString());
    }

    private static void interroga_foglio(Foglio f, Coordinata c){
        System.out.println(f.getValore(c));        
    }

    private static void aggiorna_foglio(Foglio f, Coordinata c, String[] operazione){
        if(operazione[2].equals("=")){
            //Nuova formula
            Operazione o = Operazione.valueOf(operazione[3]);
            String[] operatori = operazione[4].split(";");
            List<Cella> celle = new ArrayList<>();

            for(int i = 0; i < operatori.length; i++){
                //Ricavo Coordinata
                int col = operatori[i].charAt(0) - 65;
                int row = Integer.parseInt(operatori[i].substring(1));

                celle.add(f.getCella(new Coordinata(row, col))); //aggiungo la nuova cella con le coordinate trovate al fogloo
            }

            Contenuto formula = new Formula(celle, o); //formula estende COntenuto
            f.setValore(c, formula);
        }else{
            //Nuova costante
            int v = Integer.parseInt(operazione[2]);
            Contenuto cont = new Costante(v);

            f.setValore(c, cont);
        }
    }

    public static void main(String args[]){
        Foglio f = new Foglio(10);
        Interprete.leggi(f);
    }
}
