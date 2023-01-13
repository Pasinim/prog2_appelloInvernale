package trasmissioni;

import java.util.*;

public class RadioGiornale extends Trasmissione {
    //OVERVIEW:Classe concreta statica che rappresenta la trasmissiosne del radiogiornal che viene eseguita agli orari preffissati `09:40`, `11:40`, `19:40`, `21:40`, `22:40` e
    //`25:40`, la durata della trasmissione deve essere inferiore alla betaora
    //IR: orari!=null foreach(FasciaBetaoraria;
    //AF: AF

    //Var istanza che rappresneta gli orari a cui viene trasmesso il rg
    Set<FasciaBetaoraria> orari;

    //COSTUTTORI

    //EFFECTS:istanzio una variabile di tipo Radiogiornale la cui durata e durata ed il titolo titolo
    //Se durata>79 solleva una IllegalArgumetException
    //Se il repok non vviene rispettato solleva una IllegalArgumentException
    public RadioGiornale(String titolo,int durata){
        super(titolo);
        if(durata>79) throw new IllegalArgumentException("La durata deve essere minnore di 79 betaminuti");
        orari=new HashSet<>();
        orari.add(new FasciaBetaoraria(new Betaorario(9,40),durata));
        orari.add(new FasciaBetaoraria(new Betaorario(11,40),durata));
        orari.add(new FasciaBetaoraria(new Betaorario(19,40),durata));
        orari.add(new FasciaBetaoraria(new Betaorario(21,40),durata));
        orari.add(new FasciaBetaoraria(new Betaorario(22,40),durata));
        orari.add(new FasciaBetaoraria(new Betaorario(25,40),durata));

        if(!repOk()){
            throw new IllegalArgumentException("La collezzione di FasceBetaorarie non puo essere Null");
        }
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
                for(FasciaBetaoraria value2:tp.orari)
                    if(value.intersection(value2)) return true;
        
            }
        }
        else if(t instanceof RadioGiornale){
            RadioGiornale rg=(RadioGiornale) t;
            for(FasciaBetaoraria value:orari){
                for(FasciaBetaoraria value2:rg.orari)
                    if(value.intersection(value2)) return true;
        
            }
        }

        return false;
    }

    public boolean repOk(){
        if(orari==null) return false;
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
