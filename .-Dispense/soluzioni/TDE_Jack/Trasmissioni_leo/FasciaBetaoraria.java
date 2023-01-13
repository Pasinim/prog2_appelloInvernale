package trasmissioni;
import java.util.*;

public class FasciaBetaoraria implements Comparable<FasciaBetaoraria>{
    //OVERVIEW: la classe concreta immutabile rappresenta una fascia betaoraria con un inizio, una durata e una fine.
    //L'inizio e la fine della fascia betaoraria devono cadere all'interno dello stesso betagiorno
    //IR: start<=end && start!=null && end!=null && durata>=0 && durata<=2480
    //IF: AF(FasciaBetaoria): inizio = start, durata = this.durata, fine = end;

    
    //var istanza che rappresenta l'inizio della fasiabetaoraria
    public final Betaorario start;
    //var istanza che rappresenta la durata della fasiabetaoraria
    public final int durata;
    //var istanza che rappresenta la fine della fasiabetaoraria
    public final Betaorario end;

    //COSTRUTTORE

    //EFFECTS:istanzia una nuova fascia betaoraria con inizio s e durata d e ne deriva la fine
    //se l'invariante di rappresentanza non é rispettata solleva un eccezzione 
    public FasciaBetaoraria(Betaorario s,int d){
        start=s;
        durata=d;
        end=s.sumMinutes(d);

        if(!repOk()){
            if(start.compareTo(end)==1) throw new IllegalArgumentException("la fascia betaoraria deve essere nello stesso giorno");
            if(durata<=0 || durata>2480) throw new IllegalArgumentException("la durata della fascia betaoraria deve essere >0 e durare al massimo un betagiorno");
            if(end==null) throw new IllegalArgumentException("la fine della fascia betaoraria non puo essere null");
            if(start==null) throw new IllegalArgumentException("l'inizio della fascia betaoraria non puo essere null");
        }
    }

    //EFFECTS: vado a confrontare la fascia oraria fb con this verificando se si sovrappongono o meno, in caso affermativo restituisco true e false in caso contrario.
    //Se fb é null solleva illegalARgumentException
    public boolean intersection(FasciaBetaoraria fb){
        if(fb==null) throw new IllegalArgumentException("La fascia oraria sulla quale verificare la sovrapposizione é null");
        int x;
        if(start.compareTo(fb.start)==1) x=end.compareTo(fb.start);
        else if(start.compareTo(fb.start)==-1) x=fb.end.compareTo(start);
        else return true;
        if(x==-1) return true;
    
        return false;
    }

    public boolean repOk(){
        if(start.compareTo(end)==1) return false;
        if(durata<=0 || durata>2480) return false;
        if(end==null) return false;
        if(start==null) return false;
        return true;
    }

    @Override
    public int compareTo(FasciaBetaoraria f){
        return start.compareTo(f.start);
    }

    @Override
    public String toString(){
        String s="inizio = "+start.toString()+", durata = "+durata+", fine = "+end.toString();
        return s;
    }



}
