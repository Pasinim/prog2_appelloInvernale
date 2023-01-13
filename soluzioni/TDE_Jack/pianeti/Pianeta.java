package tde.pianeti;

/**
 * Rappresenta un Pianeta.
 * 
 * Classe mutabile.
 * 
 * Vale l'invariante della sua superclasse.
 */
public class Pianeta extends CorpoCeleste {
    private Punto vel;

    /**
     * Inizializza un Pianeta con relativo nome posizione e velocitá.
     * 
     * Se uno dei parametri in input non rispetta l'invariante definito dall superclasse viene
     * solleva una eccezione.
     * 
     * @param nome Nome.
     * @param posizione Posizione.
     * @param vel Velocitá.
     */
    public Pianeta(String nome, Punto posizione, Punto vel){
        super(nome, posizione, posizione.norma(), vel.norma()); 
        this.vel = vel;
    }

    /**
     * Copy constructor.
     * 
     * @param p Pianeta
     * @return Deep Copy di p.
     */
    public Pianeta(Pianeta p){
        super(p);
        this.vel = p.vel;
    }

    /**
     * Ritorna la velocitá di this.
     * 
     * @return Velocitá di this.
     */
    public Punto getVel(){
        return this.vel;
    }

    /**
     * Setta una nuova vel per this.
     * 
     * @param p Vel di this
     */
    public void setVel(Punto p){
        this.vel = p;
    }


    @Override
    public String toString(){
        String ret = super.toString();

        ret += String.format(" Velocitá: %s", this.vel.toString());
        
        return ret;
    }

    public static void main(String args[]){
        CorpoCeleste c = new Pianeta("Marte", new Punto(1, 0, 0), new Punto(4, 0, 0));
        System.out.println(c);
    }
}
