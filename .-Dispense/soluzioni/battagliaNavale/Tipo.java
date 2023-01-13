/**
 * Le istanze di questa classe rappresentano i diversi tipo di nave che possiamo avere:
 * Portaerei,Sottomarino,Fregata e Cacciamine con il numero di posizioni che ciascuna di esse occupa.
 * 
 */

public enum Tipo {
    P(8),
    S(7),
    F(5),
    C(2);
    
    int numPosizioni;

    Tipo(int numPosizioni){
        this.numPosizioni = numPosizioni;
    }

}
