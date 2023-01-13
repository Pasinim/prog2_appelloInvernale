package tde.stellepianeti;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Classe Sistema.
 * 
 * La classe e' mutabile.
 * 
 * Modella un Sistema Astronomico, cosi' definito: Un sistema astronomico è una
 * collezione di pianeti e stelle fisse in grado di eseguire una simulazione per
 * un intervallo di tempo arbitrario.
 * 
 * Un'istanza della classe Sistema garantisce di mantere sempre il seguente
 * invariante: Dato S istanza di Sistema S conterra' almeno un Pianeta ed almeno
 * una StellaFissa
 * 
 * Una tipica istanza di Sistema ha la seguente forma: AF(c) = foreach C
 * (istanza di CorpoCeleste) in Sistema: AF(C)
 */
public class Sistema {
    private final String name;
    private List<CorpoCeleste> sistema;
    
    public Sistema(List<CorpoCeleste> c, String n){
        this.name = n;
        this.sistema = new ArrayList<>(c);
    }   

    /**
     * Aggiunge un Pianeta p al sistema.
     * Se il Pianeta e' gia' presente nel Sistema il metodo ritorna false.
     * 
     * Il metodo modifca this.
     * 
     * @param p Pianeta da aggiungere
     * @return True se l'inserimento va a buon fine, False altrimenti.
     */
    public boolean addPianeta(Pianeta p){
        if(this.sistema.contains(p)){
            return false;
        }

        sistema.add(p);
        return true;
    }

    /**
     * Aggiunge una List di Pianeta p al sistema.
     * Se uno dei Pianeti e' gia' presente nel Sistema this il metodo solleva una eccezione 
     * 
     * @param p List di Pianeta da aggiungere a this.
     */
    public void addPianeta(List<Pianeta> p){
        for (Pianeta pianeta : p) {
            if(! this.addPianeta(pianeta)){
                System.out.println("Errore inserimento");
            }
        }
    }

    /**
     * Aggiunge una StellaFissa s al sistema.
     * Se la StellaFissa e' gia' presente nel Sistema il metodo ritorna false.
     * 
     * @param s StellaFissa da aggiungere a this.
     * @return True se l'inserimento va a buon fine, False altrimenti.
     */
    public boolean addStella(StellaFissa s){
        if(this.sistema.contains(s)){
            return false;
        }

        sistema.add(s);
        return true;
    }

    /**
     * Aggiunge una List di StellaFissa s al sistema.
     * Se uno delle StellaFissa e' gia' presente nel Sistema this il metodo solleva una eccezione 
     * 
     * @param s List di StellaFissa da aggiungere a this.
     */
    public void addStella(List<StellaFissa> s){
        for (StellaFissa stella : s) {
            if(! this.addStella(stella)){
                System.out.println("Errore inserimento");
            }
        }
    }

    /**
     * Aggiunge un CorpoCeleste c al sistema.
     * Se il CorpoCeleste e' gia' presente nel Sistema this il metodo riorna False.
     * 
     * @param c CorpoCeleste da aggiungere a this.
     * @return True se l'inserimento va a buon fine, False altrimenti.
     */
    public boolean addCorpoCeleste(CorpoCeleste c){
        return false;
    }

    /**
     * Aggiunge una List di CorpoCeleste c al sistema.
     * Se uno dei CorpoCeleste e' gia' presente nel Sistema this il metodo solleva una eccezione 
     * 
     * @param c List di CorpoCeleste da aggiungere a this.
     * @return True se l'inserimento va a buon fine, False altrimenti.
     */
    public void addCorpoCeleste(List<? extends CorpoCeleste> c){
        return;
    }   

    public void simula(int time){
        // Computo i interazioni
        for(int i = 0; i < time; i++){
            // Per ogni CorpoCeleste nel sistema
            for (CorpoCeleste corpoCeleste : sistema) {
                if(corpoCeleste instanceof Pianeta){
                    Pianeta p = (Pianeta) corpoCeleste;
                    // Interagisco con ogni altro pianeta nel sistema... O(n^2), posso fare meglio?        
                    for (CorpoCeleste corpoCeleste2 : sistema) {
                        corpoCeleste.interagisci(corpoCeleste2);
                    }    
                }
            }
            for (CorpoCeleste corpoCeleste : sistema) {
                if(corpoCeleste instanceof Pianeta){
                    Pianeta p = (Pianeta) corpoCeleste;
                    p.update_position();
                }
            }
            System.out.println(this);
        }
    }

    @Override
    /**
     * Implementa la funzione d'astrazione
     */
    public String toString(){
        String s = "";
        
        for (CorpoCeleste c : sistema) {
            s += c.toString() + "\n";
        }

        return s;
    }


    public static void main(String args[]){
        Pianeta p1 = new Pianeta("Giove", new Punto(3,0,0), new Punto(0,0,0));
        Pianeta p2 = new Pianeta("Marte", new Punto(5,0,0), new Punto(0,0,0));
        Pianeta p3 = new Pianeta("Saturno", new Punto(5,10,0), new Punto(0,0,0));

        List<CorpoCeleste> p = new ArrayList<>();
        p.add(p1);
        p.add(p2);
        p.add(p3);

        Sistema s = new Sistema(p, "Sistema Solare");
        System.out.println(s);

        s.simula(5);

        System.out.println(s);
    }
}
