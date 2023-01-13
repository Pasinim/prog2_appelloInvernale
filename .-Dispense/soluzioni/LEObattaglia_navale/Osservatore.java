package battaglia_navale;

import java.util.*;

public class Osservatore {
    //OVERVIEW: La classe concreta mutabile composta da 2 giocatori che compiono un insieme di mosse a testa, l'osservatore esegue le mosse e 
    // e stampa le griglie corrispondenti per entrambi i giocatori
    //IR: g1!=null && g2!=null && mosse!=null && turno>=0;
    //AF: AF(Osservatore)-> g1.toString() | g2.toString();

    //Var di istanza che rappresenta il primo giocatore
    private Giocatore g1;
    //Var di istanza che rappresenta le mosse dei 2 giocatori
    private List<Posizione> mosse;
    //Var di istanza che rappresenta il secondo giocatore
    private Giocatore g2;
    
    //Var che rappresenta il turno di gioco
    private int turno;

    //COSTRUTTORE

    //EFFECTS:viene istanziata una variabile osservatore dove la flotta_g1 rappresenta la flotta di g1 e la flotta avversaria di g2 e viceversa.
    //vengono inizializzate le collezzioni di mosse di g1 con m_g1 e quello di g2 con m_g2
    public Osservatore(Set<Nave> flotta_g1,Set<Nave> flotta_g2,List<Posizione> m_g1,List<Posizione> m_g2 ){
        turno=0;
        g1=new Giocatore(flotta_g1, flotta_g2);
        g2=new Giocatore(flotta_g2, flotta_g1);
        mosse= new ArrayList<>();
        int min_moves=m_g1.size();
        
        if(m_g2.size()<min_moves) min_moves=m_g2.size();
        for(int i=0;i<min_moves;i++){
            mosse.add(m_g1.get(i));
            mosse.add(m_g2.get(i));
        }
        if(!repOk()){
            if(g1==null || g2==null) throw new IllegalArgumentException("I giocatori non possono essere null");
            throw new IllegalArgumentException("Le mosse dei giocatori non possono essere null");
        }
    }


    //MODIFIES: this.g1, this.g2, this.mosse
    //EFFECTS:va a eseguire la mossa e la rimuove, se non ci sono piu mosse solleva una EndGameException
    //se la rep invariant viene violata solleva un 
    public void moves(){
        if(mosse.size()==0) throw new EndGameException("Non ci sono piu mosse il gioco é terminato");
        Posizione mossa=mosse.get(turno);
        if(turno%2==0){
            g1.my_moves(mossa);
            g2.enemy_moves(mossa);
        }else{
            g2.my_moves(mossa);
            g1.enemy_moves(mossa);
        }
        turno++;
        if(!repOk()){
            throw new IllegalMoves("La mossa non é valida");
        }
    }

    //MODIFIES: this.g1, this.g2, this.mosse
    //EFFECTS:esegue immediatamente tutte le mosse dei giocatori 
    public void endgame(){
        if(mosse.size()==0) throw new EndGameException("Non ci sono piu mosse il gioco é terminato");
        while(turno<mosse.size()){
            moves();
        }
    }

    public boolean repOk(){
        if(g1==null || g2==null || mosse==null || turno<0) return false;
        return true;
    }

    @Override
    public String toString(){
        String s="";
        for(int i=0;i<10;i++){
            s+=g1.toStringLine(i)+" | "+g2.toStringLine(i)+"\n";
        }
        return s;
    }
}
