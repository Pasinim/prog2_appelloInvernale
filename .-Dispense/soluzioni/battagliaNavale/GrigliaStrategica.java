import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * La seconda è la griglia strategica che, viceversa, tiene traccia dell'esito sulla flotta 
 * avversaria degli attacchi effettuati dal giocatore. Anche questa griglia può essere descritta con una 
 * stringa, ad esempio
 * corrisponde alla griglia dell'avversario che ha attaccato le posizioni D1, D2, G3, G4 e I3 del giocatore 
 * la cui flotta è stata mostrata in precedenza (affondando il Cacciamine in Veritcale e colpendo due volte 
 * il Sottomarino in riga 3). Il colpo mancato G4 è indicato con ., il secondo colpo sulla colonna D è 
 * rappresentato come # perché è il colpo che ha causato l'affondamento, mentre in generale viene usato * per 
 * indicare le posizioni in cui è stata colpita una nave. Dopo questa sequenza di attacchi, la griglia della 
 * flotta del giocatore è descritta dalla stringa
 * Si osservi che il Cacciamine affondato è rappresentato da # anche nella prima posizione: per il giocatore 
 * (che conosce le sue navi) è infatti più semplice renderne omogenea la rappresentazione
 */

/**
 * Le istanze di questa classe rappresentano una griglia strategica, ovvero la griglia dell'avversario dal
 * punto di vista del giocatore.
 * Questo è una classe mutabile formata dall'insieme di posizione che sono state colpite e dall'insieme di posizioni
 * che non sono sono state colpite (perchè non possedevano una barca).
 */
public class GrigliaStrategica{

    /**
     * Le liste che formano la griglia non sono null e non possono contenere né elementi null né elementi che
     * si ripetono tra di loro.
     * L'invariante di rappresentazione è sempre valido perchè l'unico metodo mutazionale presente
     * va ad aggiungere un elemente a una delle due liste, controllando però che esso non sia null.
     */

    private List<Posizione> posColpite;
    private List<Posizione> posMancate;


    public GrigliaStrategica(){
        this.posColpite = new ArrayList<>();
        this.posMancate = new ArrayList<>();
    }

    /**
     * Effetti collaterali: nel caso in cui venisse colpita una nave, allora il colpo viene aggiunto all'insieme
     * dei colpi che sono andati a segno. Altrimenti viene aggiunto all'insieme dei colpi che hanno mancato.
     * 
     * @param p posizione obiettivo
     * @param grigliaFlottaAvversario
     */
    public void colpisci(Posizione p,GrigliaFlotta grigliaFlottaAvversario){
        Objects.nonNull(p);
        if(grigliaFlottaAvversario.itsAHit(p)){
            posColpite.add(p);
            System.out.println("colpito!");
        }else{
            if(!posMancate.contains(p)) 
                posMancate.add(p);  
            System.out.println("mancato!");
        }
    }

    /**
     * @param p posizione 
     * @return true se la posizione indicata ha colpito una nave,false altrimenti.
     */
    public boolean hoColpito(Posizione p){
        if(posColpite.contains(p)) return true;
        return false;
    }

    /**
     * 
     * @param p posizione
     * @return true se la posizione indicata ha mancato una nave,false altrimenti.
     */
    public boolean hoMancato(Posizione p){
        if(posMancate.contains(p)) return true;
        return false;
    }

    public List<Posizione> getPosColpite() {
        return posColpite;
    }

    public List<Posizione> getPosMancate() {
        return posMancate;
    }

}