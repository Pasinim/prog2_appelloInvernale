package tde.thomas2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
* Classe rappresentabile un Convoglio, caratterizzato da un nome, un peso, una
* potenza e capace di contenere una sequenza ORDINATA e non vuota di Rotabili.
* 
* Classe mutabile
* 
* Il peso di un Convoglio é la somma dei pesi dei Rotabili che lo compongono.
* La potenza di un Convoglio é 0 se la sua testa (Ovvero il primo Rotabile) non
* é un Locomotore, altrimenti viene calcolata come metá della potenza della
* testa piú meta della potenza della coda, se anche questa é un Locomotore.
* 
* Un Convoglio ha la seguente funzione d'astrazione: 
*  AF(c) = Convoglio: nome = this.nome, peso = this.peso, potenza = this.potenza, dotazioni: [per ogni Dotazione d d.toString()] 
*/
public class Convoglio {
    private final String nome;
    private final List<Rotabile> rotabili;
    private final List<Dotazione> dotazioni;
    private int peso;
    
    
    /**
    * Inizializza un Convoglio di nome n composto dai Rotabili indicati in r nello stesso ordine in cui compaiono in tale List.
    * 
    * @param n Nome del Convoglio.
    * @param r Rotabili del Convoglio.
    */
    public Convoglio(String n, List<Rotabile> r){
        this.nome = Objects.requireNonNull(n);
        this.rotabili = new ArrayList<>(r);
        this.dotazioni = new ArrayList<>();

        for (Rotabile rotabile : rotabili) {
            peso += rotabile.peso();
            aggiornaDotazioni(rotabile);
        }
    }
    
    /**
    * Aggiorna il valore di this.dotazioni sulla base di r
    */
    private void aggiornaDotazioni(Rotabile r){
        try {
            Iterator<Dotazione> i = r.dotazioni();
            
            while(i.hasNext()){
                Dotazione d = i.next();
                if(this.dotazioni.contains(d)){
                    int quantita = dotazioni.get(dotazioni.indexOf(d)).quantita();
                    dotazioni.set(dotazioni.indexOf(d), new Dotazione(d.nome(), d.quantita() + quantita));
                }else{
                    this.dotazioni.add(d);
                }
            }
            
        } catch (UnsupportedOperationException e) {
            return;
        }
    }
    
    /**
    * Aggiunge un Rotabile r in coda al Convoglio.
    *
    * Modifica il valore di this.
    * 
    * @param r Rotabile da aggiungere
    */
    public void aggiungiRotabile(Rotabile r){
        rotabili.add(r);
        aggiornaDotazioni(r);
    }

    /**
     * Concatena il convolgio c a this.
     * 
     * Modifica lo stato di this.
     * 
     * @param c Convoglio.
     */
    public void concatena(Convoglio c){
        for (Rotabile r : c.rotabili) {
            peso += r.peso();
            aggiungiRotabile(r);
        }
    }
    
    /**
    * Ritorna il nome del Convoglio
    * 
    * @return Nome di this.
    */
    public String nome(){
        return this.nome;
    }
    
    /**
    * Ritorna il peso del Convoglio.
    * 
    * @return Peso di this.
    */
    public int peso(){
        return this.peso;
    }
    
    /**
    * Ritorna la potenza del Convoglio.
    * 
    * @return Potenza di this.
    */
    public int potenza(){
        int p1 = rotabili.get(0).potenza();
        int p2 = rotabili.get(rotabili.size() - 1).potenza();

        if(p1 > 0){
            return p1/2 + p2/2;
        }else{
            return 0;
        }
    }
    
    /**
    * Controlla validitá del Convoglio,
    * un Convoglio é valido sse this.potenza > this.peso
    * @return
    */
    public boolean isValido(){
        return this.potenza() > this.peso();
    }
    
    @Override
    public String toString(){
        String ret = String.format("Convoglio: nome = %s, peso = %d, potenza %d, dotazioni: %s, %s", this.nome, this.peso, this.potenza(), this.dotazioni.toString(), isValido() ? "valido" : "non valido");
        return ret;
    }   

    public static void main(String args[]){
        List<Dotazione> d1 = new ArrayList<>();
        d1.add(new Dotazione("Carne", 1000));
        d1.add(new Dotazione("Pesce", 200));

        List<Dotazione> d2 = new ArrayList<>();
        d2.add(new Dotazione("RTX 3080", 1000));
        d2.add(new Dotazione("Pesce", 200));
        d2.add(new Dotazione("RTX 3090", 1000));
        d2.add(new Dotazione("RTX 3080", 200));


        Rotabile l1 = new Locomotore("Thomas", 1000, 20);
        Rotabile v1 = new Vagone("Vagone", 100, d1);
        Rotabile v2 = new Vagone("Vagone", 2000, d2);

        List<Rotabile> r1 = new ArrayList<>();
        r1.add(l1);
        r1.add(v1);
        r1.add(v2);

        Convoglio c = new Convoglio("Ciao", r1);
        r1.add(l1);
        Convoglio c2 = new Convoglio("Thomas", r1);

        c.aggiungiRotabile(l1);
        c.aggiungiRotabile(v1);
        System.out.println(c);
        System.out.println(c2);
        c.concatena(c2);
        System.out.println(c);
    }
}
