package tde.stellepianeti;

import java.util.List;

import javax.swing.Painter;

/**
 * Classe Pianeta, sottoclasse di CorpoCeleste.
 * 
 * Rappresenta un Pianeta, un CorpoCeleste caratterizzato da una velocita', ed
 * una posizione che varia in funzione di essa.
 * 
 * La classe e' mutabile.
 * 
 * Una tipica istanza di Pianeta ha la seguente funzione d'astrazione: AF(c) =
 * this.nome: [Posizione: this.posizione, U: this.energia_potenziale, K:
 * this.energia_cinetica ]
 * 
 * La classe ha inoltre il seguente invariante: this.nome != ""
 */
public class Pianeta extends CorpoCeleste {
    private Punto vel;

    /**
     * Inizializza un Pianeta avente nome s, posizione p e velocita' v.
     * 
     * Il Pianeta avra' inoltre un'energia cinetica e potenziale cosi' calcolate;
     * - Cinetica: Pari alla norma della sua posizione.
     * - Potenziale: Pari alla norma della sua velocita'.
     * 
     * Con norma = somma in modulo dei valori del vettore.
     * 
     * @param s Nome.
     * @param p Posizione.
     * @param v Velocita'.
     */
    public Pianeta(String s, Punto p, Punto v){
        super(s, p, 0, 0);

        super.set_k(calcolo_k(p));
        super.set_u(calcolo_u(v));

        this.vel = v;
    }

    /**
     * Calcola energia cinetica.
     * 
     * @return Energia cinetica
     */
    private int calcolo_k(Punto p){
        return p.norma();
    }

    /**
     * Calcolo energia potenziale
     * 
     * @return Energia potenziale
     */
    private int calcolo_u(Punto v){
        return v.norma();
    }

    /**
     * Calcola i nuovi parametri di this e di p in base tra i due Pianeti.
     * Il metodo e' mutazionale, importante notare come il metodo modifichi solo lo stato di this, per ottenere una simulazione veritiera e' necessario invocare il metodo specularmente su p!
     * 
     * L'interazione tra i due Pianeta avviene nel modo seguente:
     * Dati due Pianeta A e B con coor_a = (x,y,z) e coor_b = (x', y', z') con velocita' iniziale pari per entrambi a (0,0,0)
     * In una interazione hanno luogo i seguenti cambiamenti:
     * 
     *  1 - Cambia la velocità di ciascun pianeta in base alla seguente formula:
     *
     *  se x > x', l'ascissa della velocità di A aumenta di 1;
     *  se x < x', l'ascissa della velocità di A diminuisce di 1.
     *  Lo stesso dicasi per le altre coordinate delle posizioni: le ordinate influenzano l'ordinata della velocità, le quote influenzano la quota della velocità.
     * 
     *  2 - Cambia la posizione di ciascun pianeta in base alla sua velocità: se, dopo la variazione di velocità descritta prima, quella di A è diventata (1, 0, 0) e quella di B (-1, 0, 0), 
     *  le posizioni risultanti saranno rispettivamente (x + 1, y, z) e (x' - 1, y', z').
     * 
     *  3 - Energia cinetica e potenziale dei Pianeti cambieranno in accordo con i cambiamenti di velocita' e posizione
     * 
     * @param p Pianeta con cui this interagisce.
     */
    public void interagisci(CorpoCeleste c){
        if(c instanceof Pianeta){
            Pianeta p = (Pianeta) c;
            Punto coor_A = this.get_Position();
            Punto coor_B = p.get_Position();
            Punto vel_A = this.vel;
    
            // Coordinata x
            if(coor_A.getX() > coor_B.getX()){
                this.vel = vel_A.somma(new Punto (1,0,0));
            }
            else if(coor_A.getX() < coor_B.getX()){
                this.vel = vel_A.somma(new Punto (-1,0,0));
            }
    
            // Coordinata y
            if(coor_A.getY() > coor_B.getY()){
                this.vel = vel_A.somma(new Punto (0,1,0));
            }
            else if(coor_A.getY() < coor_B.getY()){
                this.vel = vel_A.somma(new Punto (0,-1,0));
            }
    
            // Coordinata z
            if(coor_A.getZ() > coor_B.getZ()){
                this.vel = vel_A.somma(new Punto (0,0,1));
            }
            else if(coor_A.getZ() < coor_B.getZ()){
                this.vel = vel_A.somma(new Punto (0,0,-1));
            }
        }
    }

    public void update_position(){
        this.set_Position(this.get_Position().somma(this.vel));
    }


    @Override 
    /**
     * Rappresenta la funzione d'astrazione AF
     */
    public String toString(){
        String r = super.toString() + "V: " + this.vel;
        return r;
    }
}
