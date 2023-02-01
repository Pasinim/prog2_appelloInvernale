import java.util.HashSet;

import java.util.Set;


/**
 * Le istanze di questa classe rappresentano un Magazzino logistico, che possiede un insieme di scaffalature
 * AF: magazzino != null, ogni scaffale s presente in *magazzino*: s != null
 * RI: per ogni scaffale s nel magazzino: s[i].toString() + s[i+1].toString() +.....;
 */
public class MagazzinoLogistico {

    private final Set<Scaffalatura> magazzino;
    public MagazzinoLogistico() {
        magazzino = new HashSet<Scaffalatura>();
    }

    /**
     * Aggiunge una scaffalatura al magazzino
     * @param s Scaffalatura da aggiungere
     * @throws Exception solleva un'eccezione se s `e null
     */
    public void add(final Scaffalatura s){
        try {
            magazzino.add(s); 
            /**
             * Questo catch non ha senso, viene tutto gestito dalla scaffalatura.
             * L'unica eccezione di cui avrebbe senso eseguire il catch sono quelle che potrebbe
             * sollevare il metodo add ma che non gestisce già la Scaffalatura
             */
        } catch (Exception e) {
            /**
             * Sbagliato questo approccio, è grave fare il print di un eccezione dato che 
             * interromperebbe il flusso di esecuzione in modo brusco.
             * Un'approccio più sensato sarebbe fare il log e stamparlo con System.err 
             */
             System.out.println(e.getMessage());

        }
    }

    @Override
    public String toString() {
        /**
         * TODO: implementare la stampa dell'id delle scaffalature
         */
        String str = "";
        for (Scaffalatura s : magazzino) {
            str += s.toString();
        }
        return str += String.format("----------\n");
    }

    
    


}
