package trasmissioni;

import java.util.*;

public class TrasmissioneSemplice extends Trasmissione{
    //OVERVIEW: la classe immutabile e concreta rappresenta una trasmissione con una fasciabetaoraria 
    //IR: fascia!=null
    //AF: AF(TrasmissioneSemplice): super.toString() fascia.inizo.toString();

    //Var istanza che rappresenta la fascia betaoraria della trasmissione
    public final FasciaBetaoraria fascia;

    //COSTRUTTORE

    //EFFECTS: istanzio una trasmissione con titolo t e che va in onda nella fascia betaoraria fb
    //se non rispetto l'invariante di rappresentanza solleva IllegalArgumetnException
    public TrasmissioneSemplice(String t,Betaorario start,int durata){
        super(t);
        fascia=new FasciaBetaoraria(start,durata);
        if(!repok()){
            throw new IllegalArgumentException("La fasciabetaoraria non puo essere null");
        }
    }


    public boolean repok(){
        if(fascia==null) return false;
        return true;
    }

    @Override
    public boolean Intersaction(Trasmissione t){
        if(t instanceof TrasmissioneSemplice){
            TrasmissioneSemplice ts= (TrasmissioneSemplice) t;
            return fascia.intersection(ts.fascia);
        }
        else if(t instanceof TrasmissionePeriodica){
            TrasmissionePeriodica tp=(TrasmissionePeriodica) t;
            for(FasciaBetaoraria value:tp.orari){
                    if(value.intersection(fascia)) return true;
            }    
        }
        else if(t instanceof RadioGiornale){
            RadioGiornale rg=(RadioGiornale) t;
            for(FasciaBetaoraria value:rg.orari){
                    if(value.intersection(fascia)) return true;
            }    
        }
        return false;
    }

    @Override
    public String toString(){
        String s=fascia.start.toString()+" - "+super.toString();
        return s;
    }
}
