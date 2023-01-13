package tde.treni;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe mutabile Convoglio.
 * 
 * Rappresenta un Convoglio, caratterizzato da un nome, da una sequenza di
 * Rotabili e da una potenza. Una istanza di Convoglio deve contenere almeno un
 * Rotabile.
 * 
 * Dato il primo Rotabile del Convoglio come testa e l'ultimo, se presente,
 * coda, definisco la potenza del Convoglio come: - 0 Se la testa non e' un
 * Locomotore - Testa.Potenza + Coda.Potenza/2 se sono entrambi Locomotori
 * 
 * Una tipica istanza di Convoglio puo' essere rappresentata con la seguente
 * funzione d'astrazione: 
 *  AF(c) =
 * 
 * Ogni istanza di Convoglio rispetta inoltre il seguente invariante:
 *  Convoglio.NumeroRotabili >= 0 && this.nome != null && this.nome != " "
 * 
 */
public class Convoglio {
    private final String nome;
    private int peso;
    private int potenza;
    private final List<Rotabile> rotabili;
    private final List<Dotazione> dotazioni;

    /**
     * Inizializza un Convoglio a partire dalla Stringa s e dalla lista di Rotabile r.
     * La Stringa s in input deve avere il seguente formato:
     *  Nome Rotabile Rotabile Rotabile ...
     * Il metodo assume che il formato venga rispettato, in caso contrario potrebbero avvenire assegnamenti
     * incosistenti.
     * 
     * I Rotabili vengono estratti dalla Lista r a seconda di cio' che viene esplicitato in s ed inseriti nel Convoglio a seconda dell'ordine in cui
     * sono inseriti nella lista.
     * Se il Rotabile r estratto dalla List e' un Vagone, le sue eventuali Dotazioni vengono aggiunte a quelle del Convoglio.
     * 
     * R deve contere almeno un elemento, in caso contrario viene sollevata una FailureException.
     * Se un Rotabile r inserito in String non e' presente nella lista R viene sollevata una FailureException.
     * 
     * Il Convoglio this ha inoltre un peso calcolato come:
     *  foreach Rotore r in s: this.peso += r.peso
     * 
     * @param s String con cui inizializzo il Convoglio.
     * @param r Lista dei possibili Rotori.
     */
    public Convoglio (final String s, final List<Rotabile> r) throws FailureException{
        String[] tokens = s.split(" ");

        if(tokens[0] == null || tokens[0] == " "){
            throw new FailureException("Nome invalido");
        }
        this.nome = tokens[0];

        this.rotabili = new ArrayList<>();
        this.dotazioni = new ArrayList<>();
        this.peso = 0;
        this.potenza = 0;

        for (int i = 1; i < tokens.length; i++) {
            String tkn = tokens[i];
            boolean found = false;

            for (Rotabile rotabile : r) {
                if(rotabile.getModello().equals(tkn)){
                    found = true;
                    // Espongo rappresentazione?
                    this.peso += rotabile.getPeso();
                    if(rotabile instanceof Vagone){
                        this.aggiungiVagone((Vagone) rotabile);
                    }else{
                        this.rotabili.add(rotabile);
                    }
                }
            }

            if(!found){
                throw new FailureException("Rotabile non presente nella Lista");
            }
        }

        this.potenza = calcolaPotenza();
    }

    /**
     * Aggiunge r al Convoglio this.
     * 
     * Il metodo modifica this.
     * 
     * @param r Rotabile da aggiungere
     * @return True se l'inserimento e' andato a buon fine, False altrimenti.
     */
    public boolean aggiungiRotabile(Rotabile r){
        return false;
    }


    /**
     * Rimuove il Rotabile r da this.
     * 
     * Se r e' un Vagone eventuali Dotazioni verrano sottratte da this.
     * 
     * Se r non e' presente in this il metodo ritorna False.
     * 
     * Il metodo modifica this.
     * @param r Rotabile da rimuovere
     * @return True se la rimozione e' andata a buon fine, False altrimenti.
     */
    public boolean rimuoviRotabile(Rotabile r){
        return false;
    }

    public boolean aggiungiVagone(Vagone v){
        // Espongo rappresentazione?
        this.rotabili.add(v);

        for (Dotazione dotazione : v.getDotazioni()) {
            int index = 0;
            if((index = dotazioni.indexOf(dotazione)) != -1){
                Dotazione d2 = dotazioni.get(index);
                d2 = new Dotazione(d2.nome, d2.quant + dotazione.quant);
                dotazioni.set(index, d2);
            }else{
                dotazioni.add(dotazione);
            }
        }

        return true;
    }

    /**
     * Ritorna, se presente, la coda di this, altrimenti solleva un'eccezione.
     * 
     * @return Coda di this.
     */
    public Rotabile getCoda(){
        Rotabile r;
        try {
            r = this.rotabili.get(0);
        } catch (IndexOutOfBoundsException e) {
            // Da cambiare tipo eccezione.
            throw new IndexOutOfBoundsException();
        }
        return r;
    }

    /**
     * Ritorna la testa di this.
     * @return
     */
    public Rotabile getTesta(){
        return this.rotabili.get(0);
    }

    private int calcolaPotenza(){
        int pow = 0;

        if(getTesta() instanceof Locomotore){
            Locomotore testa = (Locomotore) this.getTesta();

            if(getCoda() instanceof Locomotore){
                Locomotore coda = (Locomotore) this.getCoda();

                pow+= testa.getPotenza() + coda.getPotenza()/2;
            }else{
                pow += testa.getPotenza();
            }
        }

        return pow;
    }

    /**
     * Ritorna True se this e' valido.
     * 
     * Un Convoglio c e' valido se c.potenza >= c.peso
     * 
     * @return True se il Convogio e' valido
     */
    public boolean isValido(){
        return this.potenza >= this.peso;
    }

    @Override
    /**
     * Implementa la funzione d'astrazione.
     */
    public String toString(){
        String s = String.format("Convoglio: nome = %s, peso = %d, potenza = %d, dotazioni = %s" , this.nome, this.peso, this.potenza, this.dotazioni.toString());
        return s;
    }


    public static void main(String args[]){
        Locomotore l = new Locomotore("L Calimero 100 1000");
        Vagone v = new Vagone("V Bisarca 500 auto 20 furgoni 7 auto 5");

        List<Rotabile> r = new ArrayList<>();
        r.add(l);
        r.add(v);
        System.out.println(v);
        System.out.println(l);
        Convoglio c = new Convoglio("Thomas Calimero Bisarca Bisarca Calimero", r);
        System.out.println(v);
        System.out.println(l);
        System.out.println(c);
    }
}
