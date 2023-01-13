package trasmissioni;

import java.util.*;

public class TrasmissionePeriodica extends Trasmissione{
    //OVERVIEW:La classe immutabile e concreta rappresenta una trasmissione periodica che viene trasmessa regolarmente ogni tot betaminuti e con una durata fissata di tot betaminuti.
    //IR: orari!=null && !orari.isEmpty();
    //AF: AF(Trasmissioneperiodica): super.toString

    //Var istanza che racchiude tutte le fasciebetaorarie in cui viene trasmessa la trasmissione super.
    public final Set<FasciaBetaoraria> orari;

    //COSTRUTTORI:

    //EFFECTS:istanzio una TrasmisisonePeriodica con title t della durata d che viene trasmessa ogni n betaminuti e che inizia al Betaorario inizio per un totale di x volte
    //Se l invariante di rappresentanza non é rispettata solleva IllegalArgumetnExcedption
    public TrasmissionePeriodica(String t, Betaorario inizio,int durata,  int ripetizioni, int intervallo){
        super(t);
        orari=createOrari(durata,intervallo,inizio,ripetizioni);
        if(!repOk()){

        }       
    }

    //EFFECTS:creo un set di fasciebetaorarie che iniziano al betaorario s durano d betaminuti e vengono trasmesse per n volte ogni i betaminuti
    private Set<FasciaBetaoraria> createOrari(int d,int i,Betaorario s,int n){
        Set<FasciaBetaoraria> new_orari=new HashSet<>();
        new_orari.add( new FasciaBetaoraria(s,d) );
        for(int j=1;j<n;j++){
            s=s.sumMinutes(i);
            new_orari.add( new FasciaBetaoraria(s,d) );
          
        }
        
        return new_orari;
    }

    @Override
    public boolean Intersaction(Trasmissione t){
        if(t instanceof TrasmissioneSemplice){
            TrasmissioneSemplice ts= (TrasmissioneSemplice) t;
            for(FasciaBetaoraria value:orari){
                if(value.intersection(ts.fascia)) return true;
            }
        }
        else if(t instanceof TrasmissionePeriodica){
            TrasmissionePeriodica tp=(TrasmissionePeriodica) t;
            for(FasciaBetaoraria value:orari){
                for(FasciaBetaoraria value2:tp.orari){
                    if(value.intersection(value2)) return true; 
                }
            }
        }
        else if(t instanceof RadioGiornale){
            RadioGiornale rg=(RadioGiornale) t;
            for(FasciaBetaoraria value:orari){
                for(FasciaBetaoraria value2:rg.orari){
                    if(value.intersection(value2)) return true; 
                }
            }
        }

        return false;
    }


    public boolean repOk(){
        if( (orari==null) || (orari.isEmpty()) ) return false;
        return true;
    }

    @Override
    public String toString(){
        String s="";
        for(FasciaBetaoraria value:orari){
            s+=value.start.toString()+" - "+super.toString()+"\n";
        }

        return s;

    }


}
