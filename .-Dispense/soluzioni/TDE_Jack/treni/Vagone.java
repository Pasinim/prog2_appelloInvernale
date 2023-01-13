package tde.treni;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe mutabile Vagone.
 * 
 * Rappresenta un particolare tipo di Rotabile caratterizzato da un insieme di
 * Dotazioni.
 * 
 * Una tipica istanza di Vagone e': AF(C) =
 * 
 * La classe Vagone inoltre garantisce il seguente invariante:
 * 
 */
public class Vagone extends Rotabile {
    private List<Dotazione> dotazioni;

    /**
     * Inizializza un Vagone dalla Stringa s.
     * 
     * La String s deve avere il seguente formato:
     *  V Modello Peso Dotazione Qta Dotazione Qta ...
     * Notare come sia possibile inserire piu' volte la stessa Dotazione, in tale caso le loro quantita verrano sommate.
     * 
     * Il metodo lavora assumendo che il formato di s sia rispettato, se cio' non e' vero l'assegnamento potrebbe risultare incosistente.
     *
     * @param s Stringa del Vagone.
     */
    public Vagone(String s) throws FailureException{
        super(s);

        this.dotazioni = new ArrayList<>();
        String[] tokens = s.split(" ");

        // Inserisco le eventuali dotazioni.
        for(int i = 3; i < tokens.length; i+=2){
            String nome = tokens[i];
            
            try {
                int qta = Integer.parseInt(tokens[i+1]); 
                Dotazione d1 = new Dotazione(nome, qta);

                int index;
                // Se d e' gia presente sommo le quantita
                if((index = dotazioni.indexOf(d1)) != -1){
                    Dotazione d2 = dotazioni.get(index);
                    d2 = new Dotazione(d2.nome, d2.quant + d1.quant);
                    dotazioni.set(index, d2);
                }else{
                    dotazioni.add(d1);
                }

            } catch (Exception e) {
                throw new FailureException();
            }  
        }

        if(!repOk()){
            throw new FailureException();
        }
    }

    /**
     * Ritorna una List contenente le Dotazioni di this.
     * 
     * @return List contenente Dotazioni di this.
     */
    public List<Dotazione> getDotazioni() {
        // Deep copy
        return new ArrayList<>(dotazioni);
    }

    @Override
    public String toString(){
        String s = String.format("Vagone: modello = %s, peso %d, dotazioni: %s", this.getModello(), this.getPeso(), this.dotazioni.toString());
        return s;
    }

}
