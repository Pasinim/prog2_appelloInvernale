package battaglia_navale;
import java.util.*;






public class Giocatore {
    //OVERVIEW: classe concreta mutabile che rappresenta un giocatore che possiede una griglia_Strategica per attaccare l'avversario ed una griglia_flotta per monitorare
    //la propria flotta
    //IR: flotta_perosnale!=null && flotta_nemica!=null
    //AF: AF(Giocatore)-> flotta_personale.toString()  | flotta_nemica.toString();

    //Var di istanza che rappresneta la propria flotta sul tabellone di gioco
    private Griglia_Flotta flotta_personale;
    //Var di istanza che rappresneta la flotta nemica sul tabellone di gioco nemico
    private Griglia_Strategica flotta_nemica;

    //COSTRUTTORE
    
    //EFFECTS: istanzio un nuovo giocatore con una flotta f sulla griglia flotta_personale rd una flotta nemica fn sulla griglia flotta nemica
    //se l'invariante di rappresentanza non é rispettato solleva una ILLEGAL ARGUMENT EXCEPTION
    public Giocatore(Set<Nave> f,Set<Nave> fn){
        flotta_personale=new Griglia_Flotta(f);
        flotta_nemica=new Griglia_Strategica(fn);
        if(!repOk()){
            throw new IllegalArgumentException("Nessuna flotta deve essere Null");
        }
    }


    public boolean repOk(){
        if(flotta_personale==null || flotta_nemica==null) return false;
        return true;
    }


    //MODIFIES: this.flotta_personale
    //EFFECTS: eseguo la mossa nemica in posizione p
    public void enemy_moves(Posizione p){
        flotta_personale.Hit(p);
        return;
    }

    //MODIFIES: this.flotta_nemica
    //EFFECTS: eseguo la mossa sul nemico in posizione p
    public void my_moves(Posizione p){
        flotta_nemica.Hit(p);
        return;
    }

    //EFFECTS: restituisce una stringa corrispondente allo stato della riga i della griglia personale e di quella avversaria 
    //se i<0 o i>10 solleva un IllegalArgumentException
    public String toStringLine(int i){
        String s="";   
            s+=flotta_personale.toStringLine(i)+" - "+flotta_nemica.toStringLine(i);
        return s;
    }


    @Override 
    public String toString(){
        String s="";
        for(int i=0;i<10;i++){
            s+=flotta_personale.toStringLine(i)+"-"+flotta_nemica.toStringLine(i);
        }
        return s;
    }




}
