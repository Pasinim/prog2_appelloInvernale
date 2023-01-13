package battaglia_navale;


import java.util.*;
public class Griglia_Strategica extends Griglia{
    //OVERVIEW: Classe concreta e mutabile che estende la classe griglia, questa griglia permette di visualizzare lo storico delle proprie mosse e del loro effetto 
    //sul tabellone di gioco avversario
    //IR:
    //AF: AF(GRiglia_Flotta): Griglia.toString();

    //COSTRUTTORE
    //EFFECTS: costruisce la griglia e vi posiziona le navi della flotta;
    //Se nella flotta due o piu navi si sovrappongono solleva un IllegalArgumentException 
    public Griglia_Strategica(Set<Nave> f){
        super(f);
    }

    
    public void Hit(Posizione p){
        Nave n=getNave(p);
        if(n==null){
             griglia[p.riga][p.getAscissaInt()]='.';
             return;
        }
            griglia[p.riga][p.getAscissaInt()]='*';
            n.hit(p);
            if(n.destroy()){
                griglia[p.riga][p.getAscissaInt()]='#';  
            }
        
    }
}
