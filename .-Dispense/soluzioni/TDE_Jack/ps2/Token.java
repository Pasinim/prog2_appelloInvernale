package tde.ps2;

import java.util.Objects;

/**
 * Rappresenta un Token caratterizzato da un valore intero o stringa.
 * 
 * Classe immutabile.
 * 
 * Un Token ha la seguente funzione d'astrazione:
 *  AF(c) = this.valore
 * 
 * Un Token deve avere un valore valido, quindi:
 *  rep_inv = this.valore not null
 */
public class Token<T> {
    private final T valore;

    //Rendo classe non istanziabile
    private Token(T v){
        this.valore = v;

        if(!repOk()){
            throw new IllegalArgumentException();
        }
    }

    /**
     * Crea un Token di tipo Stringa.
     * 
     * @param s Valore del Token
     * @return Istanza di Token<String> avente valore pari ad s.
     */
    public static Token<String> tokenString(String s){
        Token<String> t = new Token<String>(s);

        return t;
    }

    /**
     * Crea un Token di tipo Double.
     * 
     * @param d Valore del Token.
     * @return Istanza di Token<Double> avente valore pari a d.
     */
    public static Token<Double> tokenDouble(double d){
        Token<Double> t = new Token<Double>(d);

        return t;
    }

    /**
     * Ritorna True se this é un simbolo, False altrimenti.
     * 
     * @return True se this é un simbolo, False altrimenti.
     */
    public boolean isSimbolo(){
        if(this.valore instanceof String){
            return true;
        }
        return false;
    }

    /**
     * Ritorna True se this é un numero, False altrimenti.
     * 
     * @return True se this é un numero, False altriment.
     */
    public boolean isNumero(){
        if(this.valore instanceof Double){
            return true;
        }
        return false;
    }

    /**
     * Ritorna il valore di this, se this é un simbolo, altrimenti solleva una eccezione.
     * 
     * @return Valore di this.
     * @throws IllegalStateException Se this non é un simbolo.
     */
    public String simbolo() throws IllegalStateException{
        if(!isSimbolo()){
            throw new IllegalStateException();
        }
        return (String) this.valore;       
    }

    /**
     * Ritorna il valore di this, se this é un numero, altrimenti solleva una eccezione.
     * 
     * @return Valore di this.
     * @throws IllegalStateException Se this non é un numero
     */
    public double numero() throws IllegalStateException{
        if(!isNumero()){
            throw new IllegalStateException();
        }
        return (Double) this.valore;
    }

    @Override
    public String toString(){
        String ret = String.format("%s", valore);

        return ret;
    }

    /**
     * Controlla l'invariante di rappresentazione.
     * 
     * @return True se l'invariante é rispettato, False altrimenti.
     */
    public boolean repOk(){
        if(Objects.isNull(valore)){
            return false;
        }

        return true;
    }
}
