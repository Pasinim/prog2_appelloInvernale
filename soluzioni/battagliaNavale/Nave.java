import java.util.Objects;

import javax.management.OperationsException;
import javax.naming.LimitExceededException;

/**
 * Le istanze di questa classe rappresentano una Nave.
 * Ogni nave, di tipo assegnato, è quindi disposta a partire da una posizione dello spazio di gioco 
 * e con un dato orientamento (verticale, o orizzontale). Al fine di tener traccia dello stato del gioco,
 * ogni nave è inoltre in grado di memorizzare i danni subiti (ossia quali delle posizioni che occupa sono
 * state colpite dal nemico) e, nel caso, determinare se sia stata affondata.
 * La classe è immutabile ma alcuni campi come affondata e numColpiSubiti non sono immutabili per ovvia natura.
 * 
 */

public class Nave {

    /**
     * La rappresentazione della nave è data da un tipo (tipo), un orientamento (orientamento),
     * una posizione (posizone), un valore booleano che indica se è affondata oppure no (affondata) e 
     * infine da un numero di colpi subiti (numColpiSubiti).
     * 
     */

    public final Tipo tipo;
    public final String orientamento;
    public final Posizione posizione;
    private boolean affondata;
    private int numColpiSubiti;

    /**
     * Post condizioni: inizializza una nave ponendo come valori standard di numColpiSubiti pari a 0
     * e affondata a false per rappresentare una nave in perfetto stato.
     * Effetti collaterali: solleva un'eccezione del tipo NullPointerException nel caso in cui il tipo,
     * o la posizone o l'orientamento presi in input siano null.
     * Solleva inoltre un'eccezione del tipo IllegalArgumentException nel caso in cui l'orientamento preso in
     * input sia diverso da verticale od orizzontale.
     * 
     * @param tipo della nave 
     * @param orientamento (verticale o orizzontale)
     * @param posizione all'interno della griglia di gioco
     */
    public Nave(Tipo tipo, String orientamento, Posizione posizione){
        Objects.nonNull(tipo);
        this.tipo = tipo;

        Objects.nonNull(orientamento);
        if(orientamento.isEmpty()) throw new IllegalArgumentException("la stringa non può essere vuota");
        if(!orientamento.equals("orizzontale") && !orientamento.equals("verticale"))  throw new IllegalArgumentException("orientamento non consentito");
        this.orientamento = orientamento;
        Objects.nonNull(posizione);
        this.posizione = posizione;
        this.posizione.setOccupata(true);
        this.affondata = false;
        this.numColpiSubiti = 0;
    }

    /**
     * Effetti collaterali: aumenta di 1 il numero di colpi subiti dalla nave
     * @throws LimitExceededException nel caso in cui il metodo venga chiamato su una nave che è già stata affondata
     */
    public void aumentaColpiSubiti() throws LimitExceededException{
        try{
            if(numColpiSubiti < tipo.numPosizioni) this.numColpiSubiti++;
            affonda();
        }catch(OperationsException e){
            throw new LimitExceededException("La nave è già stata affondata!");
        }

    }

    /**
     * Effetti collaterali: modifica la variabile affondata ponendola a true nel caso in cui il numero di colpi subiti
     * sia pari al numero di posizioni occupate dalla nave
     * @throws OperationsException nel caso in cui l'operazione venga chiamata su una nave già affondata
     */
    private void affonda() throws OperationsException{
        if(affondata = true) throw new OperationsException();
        if(numColpiSubiti >= tipo.numPosizioni) affondata = true;
        
    }

    public int getNumColpiSubiti(){
        return numColpiSubiti;
    }


    /**
     * 
     * 
     * 
     * @param secondaNave
     * @return true se la secondaNave si sovrappone a this, false altrimenti
     */
    public boolean sovrapposizone(Nave secondaNave){
        if(this.posizione.r <= secondaNave.posizione.r &&
        this.posizione.r + this.tipo.numPosizioni >= secondaNave.posizione.r){
           return true;
        }
        if(this.posizione.c <= secondaNave.posizione.c &&
        this.posizione.c + this.tipo.numPosizioni >= secondaNave.posizione.c){
            return true;
       }
   if(this.posizione.c == secondaNave.posizione.r ||this.posizione.r == secondaNave.posizione.c )
        return true;

    return false;
    }

    @Override
    public String toString() {
        return String.format("nave di tipo: %s, occupa posizione: %s, orientamento: %s,colpi subiti: %d, affondata: %b", tipo.name(),tipo.numPosizioni,orientamento,numColpiSubiti,affondata);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Nave)) return false;
        Nave nave = (Nave) obj;
        if(nave.posizione.equals(posizione) && nave.tipo.equals(tipo) && nave.orientamento.equals(orientamento)) return true;
        return false;
    }

    @Override
    public int hashCode() {
        int result = 31 * orientamento.hashCode();
        result += posizione.hashCode();
        return result;
    }


}
