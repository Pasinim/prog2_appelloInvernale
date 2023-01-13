package tde.excel;

import java.util.List;
import java.util.Objects;

/**
 * Classe che rappresenta una Cella,
 * 
 * Ogni Cella é caratterizzata da un Contenuto.
 * 
 * Classe immutabile.
 * 
 * La funzione d'astrazione di Cella puó essere definita come: AF(c) =
 * contenuto.toString()
 * 
 * Ogni Cella ha un Contenuto non nullo, di consegueza: rep_inv = this.contenuto
 * not null
 */
public class Cella {    
    private Contenuto contenuto;
    //Lista Formule interessate al contenuto di this ed ai suo eventuali aggiornamenti
    private List<Formula> formule;

    /**
     * Inizializza una Cella avente contenuto c
     * 
     * @param c Contenuto
     */
    public Cella(Contenuto c){
        this.contenuto = c;

        if(!repOk()){
            throw new IllegalArgumentException();
        }
    }

    /**
     * Aggiunge la Formula f alla lista delle Formule interessate al contenuto di this e ad un suo eventuale
     * cambiamento.
     * 
     * Se la Formula é giá presente in this il metodo ritorna false e l'aggiunta viene ignorata.
     * 
     * @param f Formula da aggiungere
     * @return True se l'inserimento va a buon fine, False altrimenti
     */
    public boolean aggiungiFormula(Formula f){
        if(formule.contains(f)){
            return false;
        }

        formule.add(f);
        return true;
    }

    /**
     * Rimuove la Formula f dalla lista di formule interessate al cambiamento del contenuto di this.
     * 
     * Se f non é presente in this il metodo ritorna false.
     * 
     * @param f Formula da rimuovere
     * @return True se la rimozione é andata a buon fine, false altrimenti
     */
    public boolean rimuoviFormula(Formula f){
        if(formule.contains(f)){
            formule.remove(f);
            return true;
        }

        return false;
    }

    /**
     * Aggiorna tutte le Formule f interessate del cambiamento del contenuto di this
     */
    private void aggiornaFormule(){
        for (Formula formula : formule) {
            formula.aggiornaCache(this, this.contenuto.getValore());
        }
    }

    /**
     * Ritorna il valore di this, calcolato sulla base del suo Contenuto.
     * 
     * @return Valore di this.
     */
    public int getValore(){
        return contenuto.getValore();
    }

    /**
     * Setta il contenuto di this a c.
     */
    public void setValore(Contenuto c){
        this.contenuto = c;

        //Avviso tutte le formule interessate
        this.aggiornaFormule();
    }

    @Override
    public String toString(){
        String ret = contenuto.toString();
        return ret;
    }

    /**
     * Controlla l'invariante della classe.
     * 
     * @return True se l'invariante é rispettato, False altrimenti.
     */
    public boolean repOk(){
        if(Objects.isNull(this.contenuto)){
            return false;
        }
        return true;
    }
}
