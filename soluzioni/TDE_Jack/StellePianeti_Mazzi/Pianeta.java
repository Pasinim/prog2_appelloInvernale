import java.util.Objects;



  /**
   * Le istanze di questa classe rappresentano un pianeta.
   * Esso è una sottoclasse della classe corpoceleste, quindi la estende ne implementa i metodi astratti.
   * La classe in questione è mutabile, dal momento che la sua posizione cambia.
   */
public class Pianeta extends CorpoCeleste{

    /**
     * AF: AF_super
     * IR: IR_super, {@link velocità} non null
     * Tale invariante è assicurato dall'unico costruttore e resta vero alla chiamata updateVelocuità(Pianeta pianeta)
     * (unico metodo mutazionale)
     */
    private Punto velocità;

    /**
     * Inizializza this affinchè rappresenti un pianeta
     * @param nome del pianeta
     * @param punto del pianeta
     */
    public Pianeta(String nome, Punto posizione) {
        super(nome, posizione);
        velocità = new Punto(0,0,0);
       
    }

    @Override
    public long EnergiaCinetica(){
        return super.getPosizione().norma();
    }


    /**
     * Aggiorna la velocità di ciascun pianeta, sommando 1 nel caso in cui una o più coordinate di this
     * sia maggiore della corrispondente coordinata di {@link pianeta},opppure sottrae nel caso in cui siano
     * inferiori.
     * Solleva un'eccezione di tipo {@link NullPointerException} nel caso in cui {@link pianeta} sia null
     * Effetti collaterali: modifica velocità e pianeta.velocità
     * @param pianeta con cui interagisce this
     */
    public void updateVelocità(Pianeta pianeta){
        Objects.nonNull(pianeta);

        Punto x = new Punto(1,0,0);
        Punto y = new Punto(0,1,0);
        Punto z = new Punto(0,0,1);
        if(pianeta.getPosizione().x < getPosizione().x){
            velocità = velocità.somma(x);
            pianeta.velocità = pianeta.velocità.sottrai(x);
            
        }else{
            velocità = velocità.sottrai(x);
            pianeta.velocità = pianeta.velocità.somma(x);
        }
        if(pianeta.getPosizione().y < getPosizione().y){
            velocità = velocità.somma(y);
            pianeta.velocità = pianeta.velocità.sottrai(y);
        }else{
            velocità = velocità.sottrai(y);
            pianeta.velocità = pianeta.velocità.somma(y);
        }
        if(pianeta.getPosizione().z < getPosizione().z){
            velocità = velocità.somma(z);
            pianeta.velocità = pianeta.velocità.sottrai(z);
        }else{
            velocità = velocità.sottrai(z);
            pianeta.velocità = pianeta.velocità.somma(z);
        }
        updatePosizione(pianeta);
    }

    /**
     * Pre condizioni: {@link pianeta} non è null
     * Aggiorna la posizione di ciascun pianeta a seguito del cambiamento di velocità.
     * Effetti collaterali: modifica this.posizione e pianeta.posizione
     * @param pianeta
     */
    private void updatePosizione(Pianeta pianeta){
        Punto x = new Punto(1,0,0);
        Punto y = new Punto(0,1,0);
        Punto z = new Punto(0,0,1);

        if(velocità.x > pianeta.velocità.x){
            setPosizione(getPosizione().somma(x));
            pianeta.setPosizione(pianeta.getPosizione().sottrai(x));
        }else{
            setPosizione(getPosizione().sottrai(x));
            pianeta.setPosizione(pianeta.getPosizione().somma(x));
        }
        if(velocità.y > pianeta.velocità.y){
            setPosizione(getPosizione().somma(y));
            pianeta.setPosizione(pianeta.getPosizione().sottrai(y));
        }else{
            setPosizione(getPosizione().sottrai(y));
            pianeta.setPosizione(pianeta.getPosizione().somma(y));
        }
        if(velocità.x > pianeta.velocità.z){
            setPosizione(getPosizione().somma(z));
            pianeta.setPosizione(pianeta.getPosizione().sottrai(z));
        }else{
            setPosizione(getPosizione().sottrai(z));
            pianeta.setPosizione(pianeta.getPosizione().somma(z));
        }
        
    }

    @Override
    public long EnergiaPotenziale() {
        return velocità.norma();
    }
    
    
}
