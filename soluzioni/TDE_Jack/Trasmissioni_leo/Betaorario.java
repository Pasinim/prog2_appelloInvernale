package trasmissioni;
import java.util.*;
public class Betaorario implements Comparable<Betaorario>{
    //OVERVIEW: la classe concreta e immutabile rappresenta un betaorario composto da betaminuti e betaore i quali sono confrontabili sulla base di queste 2 var
    //IR: this.betaminutes>=0 && betaminutes<=79 && betahour>=0 && betahour<=30
    //AF: AF(Betaorario): betahour:betaminutes

    //Var Istanza che rappresenta le Betaore
    public final int betahour;
    //Var Istanza che rappresenta i betaminuti
    public final int betaminutes;

    //COSTRUTTORI

    //EFFECTS: istanzia un betaorario con betaohour 0 e bratminutes 0

    public Betaorario(){
        betahour=0;
        betaminutes=0;
    }

    //EFFECTS:istanza un betaorario con betaore bh e con betaminuti bm,se l invariante di rappresentanza non é rispettata sollevo un IllegalArgumentException
    public Betaorario(int bh,int bm){
        betahour=bh;
        betaminutes=bm;
        if(!repOk()){
            if( (betahour<0)||(betahour>30) ) throw new IllegalArgumentException("Le Betaore devono essere nel range 0-30");
            if( betaminutes<0 || betaminutes>79) throw new IllegalArgumentException("I betaminuti devono essere nel range 0-79");
        }
    }

    //EFFECTS:il metodo sumMinutes aggiunge al Betaorario this i Betaminuti bm e ne restituisce un nuovo Betaorario frutto di questa somma;
    public Betaorario sumMinutes(int bm){
        Betaorario updated_betorario;
        int new_minutes=betaminutes;
        int new_hours=betahour;
        new_minutes=( new_minutes+bm );
        new_hours=(new_hours+(new_minutes/80) ) % 31;
        new_minutes=new_minutes % 80;
        //System.out.println("bh="+new_hours+" bm="+betaminutes);
        updated_betorario=new Betaorario(new_hours,new_minutes);
        return updated_betorario;


    }

    

    public boolean repOk(){
        if(betahour<0 || betahour>30 || betaminutes<0 || betaminutes>79) return false;
        return true;
    }

    @Override
    public String toString(){
        String s="";
        if(betahour<10) s+="0";
        s+=betahour+" : ";
        if(betaminutes<10) s+="0";
        s+=betaminutes;
        return s;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Betaorario){
            Betaorario b=(Betaorario) o;
            if( (b.betahour==betahour)&&(b.betaminutes==betaminutes) ) return true;

        }
        return false;
    }

    @Override 
    public int compareTo(Betaorario b){
        if(betahour==b.betahour) return ((Integer)betaminutes).compareTo((Integer)b.betaminutes );
        return ((Integer)betahour).compareTo((Integer)b.betahour );
    }
}