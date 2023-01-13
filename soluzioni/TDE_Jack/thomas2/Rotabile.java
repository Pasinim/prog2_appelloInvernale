package tde.thomas2;

import java.util.Iterator;

/**
 * Interfaccia rappresentabile un Rotabile, parte di un Convoglio.
 * 
 * Ogni Rotabile é caratterizzato da un modello, una potenza, e da un peso validi.
 * Un Rotabile puó eventualmente contenere una o piú Dotazioni.
 */
public interface Rotabile {
    
    /**
     * Ritorna il peso del Rotabile.
     * 
     * @return Peso del Rotabile.
     */
    public int peso();

    /**
     * Ritorna il nome del Modello.
     * 
     * @return Nome del Rotabile;
     */
    public String modello();

    /**
     * Ritorna la potenza del Rotabile.
     * 
     * Se il Rotabile non é in grado di trainare e o spingere altri Rotabili tale potenza sará 0.
     * 
     * @return Potenza this.
     */
    public int potenza();

    /**
     * Ritorna un generator che permette di iterare su tutte le dotazioni contenute in this.
     *  
     * @return Generator sulle Dotazioni
     */
    public Iterator<Dotazione> dotazioni();

    @Override
    public String toString();

    /**
     * Controlla l'invariante di rappresentazione.
     * 
     * @return True se l'invariante é rispettato, False altrimenti.
     */
    public boolean repOk();
}
