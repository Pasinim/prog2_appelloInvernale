package battaglia_navale;
import java.util.*;


public abstract class Griglia {
    //OVERVIEW: la classe astratta e mutabile rappresenta una griglia di gioco di dimensione 10x10
    //IR: griglia.getCulomnDimension()==10 && griglia.getRowDimension()==10 && flotta!=null && !flotta.isEmpty()
    //AF: AF(griglia)->
    protected char[][] griglia;
    protected Set<Nave> flotta;
    //COSTRUTTORE

    //EFFECTS:inizializza una griglia 10x10 composta solo da caratteri '~';
    //Se la rep Invariant non viene rispetta solleva una TableDimException
    public Griglia(Set<Nave> f){
        flotta=f;
        griglia= new char[10][10];
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                griglia[i][j]='~';
            }
        }
        if(!repOk()){
            if(flotta==null || flotta.isEmpty()) throw new IllegalArgumentException("La flotta non é valida");
            throw new TableDimException("la griglia non é 10x10");
        }
    }

    public boolean repOk(){
        if(griglia.length!=10 || griglia[0].length!=10 || (flotta==null || flotta.isEmpty()) ) return false;
        return true;

    }

    //REQUIRES:p!=null
    //EFFECTS: data una posizione sulla griglia restituisco la nave che si trova in p
    
    protected Nave getNave(Posizione p){
        for(Nave nave:flotta){    
            for(Posizione pos:nave.spazio_occupato.keySet()){
             
                if(pos.equals(p)) {
                    System.out.println("c'e una nave!\n");
                    return nave;
                }
            }
        }
        return null;
    }
    
    //MODIFIES:this.griglia
    //EFFECTS:vado ad aggiornare la griglia a seconda che il colpo in posizione p sia vuoto,a segno o  affondi una nave
    //Se p==null solleva una IllegalArgumetnException
    public abstract void Hit(Posizione p);

    //EFFECTS: restituisce una stringa corrispondente allo stato della riga i
    //se i<0 o i>10 solleva un IllegalArgumentException
    public String toStringLine(int i){
        String s="";
        for(int j=0;j<10;j++){
            s+=griglia[i][j];
        }
        return s;
    }


    @Override
    public String toString(){
        String s="";
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                s+=griglia[i][j]+" ";
            }
            s+="\n";
        }
        return s;
    }
}
