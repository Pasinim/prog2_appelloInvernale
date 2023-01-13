package trasmissioni;
import java.util.*;

public abstract class Trasmissione {
    //OVERVIEW:classe astratta e immutabile rappresenta una trasmissione dotata di un titolo  
    //IR: title.lenght>0 && title!=null
    //AF: AF(trasmissione): title
    
    //VAR istanza che rappresenta il titolo della trasmissione
    public final String title;

    //COSTRUTTORE

    //EFFECTS: vado ad istanziare una trasmissione con titolo title, se questa non rispetta l'invariante di rappresentanza solleva un IllegalArgumentException
    public Trasmissione(String n){
        title=n;
        if(!repOk()){
            if(title==null) throw new IllegalArgumentException("il titolo non puo esser Null");
            if(title.length()==0) throw new IllegalArgumentException("Il titolo non puo essere vuoto");
        }
    }

    public boolean repOk(){
        if( (title==null)||(title.length()==0) ) return false;
        return true;
    }

    //EFFCTS: confronto la trasmissione t con this per verificare se le 2 si sovrapponogno.
    public abstract boolean Intersaction(Trasmissione t);

    @Override
    public String toString(){
        String s=title;
        return s;
    }
}
