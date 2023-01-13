package trasmissioni;

import java.util.*;

public class Test {

   public static void main(String args[]){
        Palinsesto palinsesto=new Palinsesto();
        Scanner input=new Scanner(System.in);
        while(input.hasNext()){
            Trasmissione new_t;
            String title="";
            String s=input.nextLine();
            String[] parse_s=s.split(" ");
            // SEMPLICE 10:15 45 Cartoni animati
            if(parse_s[0].equals("SEMPLICE")){
                String[] fascia=parse_s[1].split(":");
                Betaorario start=new Betaorario(Integer.parseInt(fascia[0]),Integer.parseInt(fascia[1]));
             
                for(int i=3;i<parse_s.length;i++){
                    title+=parse_s[i]+" ";
                }
                new_t=new TrasmissioneSemplice(title,start,Integer.parseInt(parse_s[2]) );
                System.out.println(new_t.toString());
                palinsesto.add(new_t);
            }
           
           
            //PERIODICA 13:30 40 2 1120 Ricette del giorno
            else if(parse_s[0].equals("PERIODICA")){
                String[] fascia=parse_s[1].split(":");
                //System.out.println(""+fascia[0]+"-"+fascia[1]);
                Betaorario start=new Betaorario(Integer.parseInt(fascia[0]),Integer.parseInt(fascia[1]) );
                
                
                for(int i=5;i<parse_s.length;i++){
                    title+=parse_s[i]+" ";
                }
                new_t=new TrasmissionePeriodica(title,start,Integer.parseInt(parse_s[2]),Integer.parseInt(parse_s[3]),Integer.parseInt(parse_s[4]) );
                System.out.println(new_t.toString());
                palinsesto.add(new_t);
            }

            //RADIOGIORNALE 10 Giornale radio
            else{
               
                for(int i=2;i<parse_s.length;i++){
                    title+=parse_s[i]+" ";
                }
                new_t=new RadioGiornale(title,Integer.parseInt(parse_s[1]) );
                System.out.println(new_t.toString());
                palinsesto.add(new_t);
            }
        }
        System.out.println(palinsesto.toString());
   } 
}
