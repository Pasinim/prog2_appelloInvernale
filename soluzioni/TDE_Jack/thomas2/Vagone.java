package tde.thomas2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Rotabile capabile di contenere zero, una o piú Dotazioni.
 * 
 * Classe immutabile.
 * 
 * Un Vagone ha la seguente funzione d'astrazione: AF(c) = "Vagone: " +
 * super.toString() + ", dotazioni: [per ogni Dotazione d d.toString()]" Ed il
 * seguente invariante: rep_inv = super.repOk()
 */
public class Vagone extends AbstractRotabile {
    private final List<Dotazione> dotazioni;

    /**
     * Inizializza un Vagone senza Dotazioni di modello m e peso p.
     * 
     * @param m Modello.
     * @param p Peso.
     */
    public Vagone(String m, int p) {
        super(m, p);
        this.dotazioni = new ArrayList<>();

        if(!(repOk())){
            throw new IllegalArgumentException();
        }
    }

    /**
     * Inizializza un Vagone senza Dotazioni di modello m e peso p e contenente le dotazioni indicate in d.
     * 
     * @param m Modello.
     * @param p Peso.
     * @param d Lista di dotazioni
     */
    public Vagone(String m, int p, List<Dotazione> d) {
        super(m, p);
        this.dotazioni = new ArrayList<>();

        //Popolo this.dotazioni
        for (Dotazione dotazione : d) {
            //Se la Dotazione non é giá presente
            if(!dotazioni.contains(dotazione)){
                dotazioni.add(dotazione);
            //Se la Dotazione é gia presente
            }else{
                //Quantita di dotazioni giá presenti
                int quantita = dotazioni.get(dotazioni.indexOf(dotazione)).quantita();
                dotazioni.set(dotazioni.indexOf(dotazione), new Dotazione(dotazione.nome(), dotazione.quantita() + quantita));
            }
        }

        if(!(repOk())){
            throw new IllegalArgumentException();
        }
    }

	@Override
	public int potenza() {
		return 0;
	}

    @Override
    public Iterator<Dotazione> dotazioni() {
        return new dotazioniGenerator(this.dotazioni);
    }

    /**
     * Generatore che restituisce, nell'ordine in cui sono inserite nella Collection, le Dotazioni di this.
     * Lavorando su una classe immutabile eventuali modifiche alle istanze della collezioni su cui sto iterando
     * non modificano il comportamento del generatore.
     */
    private class dotazioniGenerator implements Iterator<Dotazione>{
        private int pos;
        private final List<Dotazione> dotazioni;

        /**
         * Inizializza un Generatore che produce Dotazioni iterando sulla lista this.dotazioni.
         * Non modifica il contenuto di dotazioni.
         */
        public dotazioniGenerator(List<Dotazione> d){
            this.pos = 0;
            this.dotazioni = d;
        }

        @Override
        public boolean hasNext() {
            if(pos < this.dotazioni.size()){
                return true;
            }
            return false;
        }

        @Override
        public Dotazione next() {
            Dotazione d = this.dotazioni.get(pos);
            pos += 1;

            return d;
        }
        
    }

    @Override 
    public String toString(){
        String ret = String.format("Vagone: %s, dotazioni: %s", super.toString(), dotazioni.toString());
        return ret;
    }
}
