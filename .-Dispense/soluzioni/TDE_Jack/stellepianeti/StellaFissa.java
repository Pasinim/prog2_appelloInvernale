package tde.stellepianeti;

import javax.swing.text.Position;

/**
 * Classe StellaFissa, sottoclasse di CorpoCeleste.
 * 
 * Rappresenta una Stella, un CorpoCeleste caratterizzato dal fatto di avere una posizione costante in ogni momento.
 * 
 * La classe e' immutabile.
 * 
 * Una tipica istanza di StellaFissa ha la seguente funzione d'astrazione;
 * 
 * AF(c) = this.nome: [Posizione: this.posizione, U: this.energia_potenziale, K: this.energia_cinetica ]
 */
public class StellaFissa extends CorpoCeleste {
    /**
     * Istanzia una nuova StellaFissa avente nome n, posizione p.
     * 
     * La nuova StellaFissa avra' energia cinetica e potenziale pari a 0.
     * 
     * @param n Nome.
     * @param p Posizione. 
     */
    public StellaFissa(String n, Punto p){
        super(n, p, 0, 0);
    }

    public void interagisci(CorpoCeleste c){
        return;
    }
}
