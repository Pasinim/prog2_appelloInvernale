
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;


/**
 * Le istanze di questa classe rappresentano una Tavola periodica, costituita da una mappa
 * che contiene il nome dell'elemento ed il corrispondente numero atomico
 * IR: numeroAtomico > 0 
 * AF: Per ogni elemento i: tavola.getKey(i) + tavola.getValue(i)
 */
public class TavolaPeriodica {
    
    private Map<Elemento, Integer> tavola;

    /**
     * Istanzia una nuova tavola periodica vuota
     */
    public TavolaPeriodica() {
        tavola = new LinkedHashMap<Elemento, Integer>();
    }
    
    /**
     * Aggiunge un nuovo elemento in this.tavola
     * @param e Elemento da aggiungere
     * @param numeroAtomico numero atomico dell'elemento e
     */
    public void aggiungi (Elemento e, Integer numeroAtomico) {
        if (numeroAtomico < 1) throw new IllegalArgumentException("Il numeroAtomico di un elemento non puo' essere un numero <=0");
        tavola.put(e, numeroAtomico);
    }
     
    /**
     * Restituisce il numeroAtomico atomico dell' elemento e
     * @param e Elemento chimico
     * @return numeroAtomico di e
     * @throws IllegalArgumentException se e non e' presente in this.tavola
     */
    public int getNumeroAtomico(Elemento e){
        if (tavola.get(e) == null) throw new IllegalArgumentException(String.format("Elemento %s non presente nella tavola", e.nome));
        return tavola.get(e);
    }



   
    /**
     * Restituisce l'elemento dato il nome dell'elemento
     * @param nomeElemento nome dell'elemento da cercare in this.tavolla
     * @return elemento e tale che   e.nome = nomeElemento
     * @throws NoSuchElementExcepotion se non esiste un elemento avente come nome 'nomeElemento'
     */
    public Elemento getElementoFromNome(String nomeElemento){
        for (Elemento e: tavola.keySet()) {
            // System.out.println("tavola keyset: " + e.toString());
            if (e.nome.toLowerCase().equals(nomeElemento.toLowerCase()))
                 return e; 
            }
        throw new NoSuchElementException(String.format("nome %s non presente nella tavola periodica", nomeElemento));
        /** NB: devo implementare correttamente il metodo equals dato che mi serve in questo metodo e 
         * in getPeso, non ho tempo per implementare
         */
    }

    public Elemento getElemento (String simbolo){
        Iterator<Elemento> it = tavola.keySet().iterator();
        while (it.hasNext()){
            Elemento curr = it.next();
            if (curr.simbolo.equals(simbolo)) return curr;
        }
        throw new IllegalArgumentException("Simbolo"+ simbolo.toString() + " non presente nella tavola periodica");
    }


    //* Test per jshell, non per il TDE */
    public static TavolaPeriodica costruisci(){
        TavolaPeriodica tp = new TavolaPeriodica();
        try (Scanner in = new Scanner(new FileInputStream("./input-0.txt"))) {
            //aggiungo la tavola periodica degli elementi dal file di input
            for (int i = 1; in.hasNextLine(); i++) {
                String tkns[] = in.nextLine().split("\\s+");
                if (tkns.length > 3 || tkns.length < 1) throw new IllegalArgumentException("Errore lettura input");
                Elemento e = new Elemento(tkns[0], tkns[1], Double.parseDouble(tkns[2]));
                tp.aggiungi(e, i);
            }
        } catch (Exception ex) {
            System.out.println("Erorre scanner");
            System.err.println(ex);
        }
        return tp;
    }


    /**
     * ToDO, simile al metodo sopra
     * @param e
     * @return
     */
    public double getPeso(Elemento e){
    
        /** troppo dispendioso, devo riguardarlo se ho tempo */
        for (Elemento curr: tavola.keySet()) {
            if (curr.equals(e))  //dovrei implementare correttamente il metodo equals di ELemento
                return curr.getPeso();
        }
        throw new NoSuchElementException("nome non presnete nella tavola periodica");
    }

    @Override
    public String toString(){
        String ret = "";
        for (Elemento e: tavola.keySet()) {
            String key = e.toString();
            String value = tavola.get(e).toString();
            System.out.println(key + " " + value);
            ret += key + " " + value + "\n";     
        }
        return ret;

    }
}
