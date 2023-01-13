package battaglia_navale;

public class Posizione{
    //OVERVIEW:classe immutabile concreta che rappresenta una coordinata sootoforma di lettera(ascisse) e numero(ordinate) all'interno di un campo di gioco di dimensioe
    //10x10, due coordinate possono essere definite ugulai se sono sulla stessa riga e stessa colonna
    //IR: riga>=0 && riga<=10 && colonna>=65  && colonna<=75
    //AF: AF(Posizione)-> this.colonna this.riga

    //Var di istanza che rappresenta le ascisse nel tabellone
    public final char colonna;

    //Var di istanza che rappresente le coordinate tabellone
    public final int riga;

    //COSTRUTTORE

    //EFFEVTS: istanzia una nuova var posizione con valore colonna=c e riga=r
    //Se non vinene rispettata l invariante di rappresentanza solleva IllegalArgumentException
    public Posizione(char c,int r){
        riga=r;
       
        colonna=c;
        //System.out.println("colonna:"+colonna+" riga:"+riga );
        if(!repok()){
            if(riga<0) throw new IllegalArgumentException("La riga non é nel range 0-10");
            if(riga>10) throw new IllegalArgumentException("La riga non é nel range 0-10");
            if(colonna<65  || colonna>75) throw new IllegalArgumentException("La colonna non é nel range A-J");
        }
    }

    public boolean repok(){
        if( (riga<0 || riga>10) || (colonna<65  || colonna>75) ) return false;
        return true;
    }

    //EFFECTS:restituisce l'intero relativo all'ascissa
    public int getAscissaInt(){
        return ((int)colonna)-65;
    }

    @Override 
    public String toString(){
        String s=""+colonna+" "+riga;
        return s;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Posizione){
            Posizione p=(Posizione) o;
            if(p.colonna==colonna && p.riga==riga) return true;
        }
        return false;
    }




}