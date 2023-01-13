package tde.pianeti;

/**
 * Rappresenta una Stella fissa.
 * 
 * Classe immutabile.
 * 
 * Vale l'invariante definito per la superclasse.
 */
public class Stella extends CorpoCeleste {
    /**
     * Inizializza una Stella con nome n e posizione p.
     * 
     * Se uno dei parametri non rispetta l'invariante della superclasse viene sollevata una eccezione.
     * 
     * @param n Nome.
     * @param p Posizione.
     */
    public Stella(String n, Punto p){
        super(n, p, p.norma(), 0);
    }
}
