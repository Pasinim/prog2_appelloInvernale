import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.naming.LimitExceededException;


/**
 * Le istanze di questa classe rappresentano una griglia della flotta del giocatore.
 * Essa memorizza le navi come disposte dal giocatore e può essere utilizzata sia per tener traccia dei danni 
 * complessivamente subiti, che per poter comunicare all'avversario l'esito dei suoi attacchi. 
 */
public class GrigliaFlotta {

    /**
     * La rappresentazione della griglia è data dalla lista contentente le navi (listaNavi) e dal numero di 
     * colpi complessivamente subiti.
     * La lista delle navi non può essere né null né vuota né contenere oggetti null e ogni nave al suo interno deve essere tale
     * per cui le posizioni da queste occupate non si sovrappongano e che siano all'interno della griglia 10*10.
     */
    public final List<Nave> listaNavi;
    private List<Posizione> listaPos;
    private int numColpiSubiti;

    /**
     * Post condizioni: inizializza this affinchè rappresenti una griglia della flotta del giocatore 
     * inizialmente vuota e con il numero di colpi subiti pari a 0
     * 
     * In questo modo l' invariante di rappresentazione è sempre valido perchè il costruttore è valido.
     * @param listaNavi del giocatore
     */
    public GrigliaFlotta(){
        this.listaNavi = new ArrayList<>();
        this.listaPos = new ArrayList<>();
        numColpiSubiti = 0;

       popolaGriglia();
    }


    /**
     * Effetti collaterali: riempie la griglia di posizioni che rappresenta la griglia di gioco.
     * Inoltre modifica le posizoni che sono occpate da una nave
     */
    private void popolaGriglia(){
        for(int r = 0; r < 10;r++){
            for(int c = 0; c < 10;c++){
                char colonna = (char) (c + 'A');
                Posizione p = new Posizione(r,colonna);
                listaPos.add(p);
            }
        }
    }

    private void aggiornaGriglia(){
        for(Nave nave : listaNavi){
            if(nave.orientamento.equals("verticale")){
                for(int i = nave.posizione.r; i < nave.tipo.numPosizioni;i++){
                    int index = listaPos.indexOf(new Posizione(i,nave.posizione.c));
                    Posizione p = listaPos.get(index);
                    p.setOccupata(true);
                    listaPos.set(index,p);
                }
            }else{
               for(int i = nave.posizione.c; i < 'A' + nave.tipo.numPosizioni;i++){
                int index = listaPos.indexOf(new Posizione(nave.posizione.r,(char) i));
                Posizione p = listaPos.get(index);
                p.setOccupata(true);
                listaPos.set(index,p);
               } 
            }
        }
    }

    /**
     * Post condizioni: effettua un controllo sulla posizioni delle navi all'interno della griglia per controllare che non escano dalla griglia di gioco
     * Effetti collaterali: solleva un'eccezione di tipo CollisionException nel caso in cui via sia una 
     * "collisione" tra una nave all'interno della lista e il bordo della griglia, ovvero la nave uscirebbe
     * dalla griglia di gioco.
     */
    private void checkOutsideGriglia(Nave n){
            if(n.orientamento.equals("verticale")){
                if(n.posizione.r + n.tipo.numPosizioni >= 9)throw new CollisionException();
            
            }else{
                if(n.posizione.r + n.tipo.numPosizioni >= 'J') throw new CollisionException();
            }
        
       
    }

    /**
     * Post condizioni: effettua un controllo sulla posizone delle navi all'interno della griglia per controllare che non si sovrappongano
     * Effetti collaterali: solleva un'eccezione di tipo CollisionException nel caso in cui 
     * vi sia una "collisione" tra due navi all'interno della griglia, ovvero due navi hanno una o più
     * posizioni in comune.
     * 
     */
    private void checkSovrapposizioni(Nave primaNave){
        for(int i = 0; i < listaNavi.size();i++){
            Nave secondaNave = listaNavi.get(i);
            if(primaNave.sovrapposizone(secondaNave))
                    throw new CollisionException();
        }
       
    }

    /**
     * Post condizioni: restituisce il numero di danni subiti nella totalità da ciascuna delle navi
     */
    private int numDanniSubiti(){
        int count = 0;
        for(Nave n : listaNavi){
            count += n.getNumColpiSubiti();
        }
        return count;
    }


    /**
     * Post condizoni: restituisce true se il colpo va a buon fine, false altrimenti
     * Effetti collaterali: solleva un'eccezione nel caso in cui la posizione che identifica un colpo sia null.
     * Restituisce lo stackTrace nel caso in cui venga sollevata un'eccezione di tipo LimitExceededException.
     * 
     * @param p
     * @return true se una nave viene colpita, false altrimenti
     */
    public boolean itsAHit(Posizione p){
        Objects.nonNull(p);
        boolean result = false;
        for(Nave n : listaNavi){
            if(n.orientamento.equals("verticale")){
                if(listaPos.get(listaPos.indexOf(p)).isOccupata()){
                    try{
                        n.aumentaColpiSubiti();
                    }catch(LimitExceededException e){
                        e.getStackTrace();
                    }finally{
                        p.setOccupata(true);
                        listaPos.set(listaPos.indexOf(p),p);
                        result= true;
                 }
                }  
            this.numColpiSubiti = numDanniSubiti();
        }
    }   
    return result;
}


/**
 * 
 * @return il numero di colpi subiti dalla flotta del giocatore in totale
 */
    public int getNumColpi(){
        return numColpiSubiti;
    }

    /**
     * Post condizioni: aggiunge una nave all'interno della griglia del giocatore
     * Effetti collaterali: Solleva un'eccezione di tipo NullPointerException nel caso in cui la nave data
     * in input sia null.
     * Stampa la natura dell'eccezione CollisionException nel caso in cui dovesse venire sollevata
     * 
     * @param nave da inserire nella griglia
     */
    public void aggiungiNaveNellaGriglia(Nave nave){
        Objects.nonNull(nave);
        try{
            checkSovrapposizioni(nave);
            checkOutsideGriglia(nave);
            listaNavi.add(nave);
            
            aggiornaGriglia();
        }catch(CollisionException e){
            e.fillInStackTrace();
        }
    }


}
