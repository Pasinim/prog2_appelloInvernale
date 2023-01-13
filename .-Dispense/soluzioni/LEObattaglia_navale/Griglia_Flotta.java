package battaglia_navale;
import java.util.*;



public class Griglia_Flotta extends Griglia {
    //OVERVIEW: Classe concreta e mutabile che estende la classe griglia, questa griglia permette di visualizzare la posizione ed il tipo delle navi in gioco e
    // di aggiornare il tabellone a seguito di affondamenti o colpi da parte dell'avversario;
    //IR:
    //AF: AF(GRiglia_Flotta): Griglia.toString();

    //COSTRUTTORE
    //EFFECTS: costruisce la griglia e vi posiziona le navi della flotta;
    //Se nella flotta due o piu navi si sovrappongono solleva un IllegalArgumentException 
    public Griglia_Flotta(Set<Nave> f){
        super(f);
        for(Nave nave:flotta){
            for (Map.Entry<Posizione, Boolean> entry : nave.spazio_occupato.entrySet()){
                
                if(griglia[entry.getKey().riga][entry.getKey().getAscissaInt()] !='~'){
                   
                    throw new IllegalArgumentException("Due o piu navi si sovrappongono");
                
                }
                griglia[entry.getKey().riga][entry.getKey().getAscissaInt()]=nave.tipo.nome;
            }
        }
    }

    
    public void Hit(Posizione p){
        if(p==null) throw new IllegalArgumentException("La posizione della mossa non puo essere Null ");
        Nave n=getNave(p);
        if(n==null) return;
        
            griglia[p.riga][p.getAscissaInt()]='*';
            n.hit(p);
            if( n.destroy() ){
                for (Map.Entry<Posizione, Boolean> entry : n.spazio_occupato.entrySet()) {
                    griglia[entry.getKey().riga][entry.getKey().getAscissaInt()]='#';
                }
            }
        
    }



}
