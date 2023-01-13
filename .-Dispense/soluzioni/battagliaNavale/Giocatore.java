import java.util.Objects;

/**
 * Le istanze di questa classe rappresentano un giocatore e le mosse che può effettuare, quali scegli nave e 
 * spara.
 * Questa è una classe mutabile dal momento che sia la griglia del giocatore che quella strategica evolvono durante il gioco.
 */

public class Giocatore {

    /**
     * Il giocatore è rappresentano attraverso la griglia della sua flotta e la griglia strategica.
     * Entrambe devono essere non null e quella della flotta non deve contenere oggetti null.
     * L'invariante di rappresentazione è valido dal momento che lo è sempre nel costruttore e 
     * le navi che vengono aggiunte non sono mai null.
     */

    private GrigliaFlotta grigliaFlotta;
    private GrigliaStrategica grigliaStrategica;

    public Giocatore(){
        this.grigliaFlotta = new GrigliaFlotta();
        this.grigliaStrategica  = new GrigliaStrategica();
    }

    /**
     * Effetti collaterali: modifica la grigliaStrategica andando ad aggiungere un elemento in uno dei suoi insiemi
     * @param riga
     * @param colonna
     */
    public void spara(int riga, char colonna){
        Posizione p = new Posizione(riga, colonna);
        grigliaStrategica.colpisci(p, grigliaFlotta);
    }

    /**
     * PostCondizioni: permette la scelta di una nava da parte dell'utente e la inserisce
     * 
     * @param tipo di nave 
     * @param orientamento (verticale/orizzontale)
     * @param p posizione della nave
     * @return la nave scelta
     */
    public void scegliNave(String tipo, String orientamento, Posizione p){
        Objects.nonNull(tipo);
        Objects.nonNull(orientamento);
        Objects.nonNull(p);

        Tipo tipoNave = null;
        switch(tipo){
            case "P":
                tipoNave = Tipo.P;
            case "S":
                tipoNave = Tipo.S;
            case "C":
                tipoNave = Tipo.C;
            case "F":
                tipoNave = Tipo.F;
        }
        Nave nave = new Nave(tipoNave,orientamento,p);
        aggiungiNaveAFlotta(nave);
    }

    /**
     * Pre condizioni: la nave non deve essere null
     * Effetti collaterali: aggiunge una nave alla flotta delle navi
     * @param nave
     */
    private void aggiungiNaveAFlotta(Nave nave){
        grigliaFlotta.aggiungiNaveNellaGriglia(nave);
    }
}
