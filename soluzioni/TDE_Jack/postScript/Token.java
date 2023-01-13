package tde.postScript;


/**
 * Classe immutabile Token.
 * 
 * Rappresenta un'unita' del linguaggio PostScript.
 * 
 * Una tipica istanza di Token puo' essere rappresentata come:
 *  AF(c) = this.valore
 * 
 * Ogni istanza di Token rispetta inoltre il seguente invariante:
 *  this.valore != null && il Token e' unitario.
 */
public class Token<T> {
    private final T valore;

    private Token(T v){
        this.valore = v;
    }

    /**
     * Inizializza un nuovo Token Stringa.
     * 
     * Il token non puo' essere vuoto e puo' contere una sola parola.
     * Se questa proprieta' non viene rispettata viene sollevata una FailureException.
     * 
     * @param s Stringa da assegnare al Token.
     * @return Token di tipo String.
     * @throws FailureException Se l'inizializzazione non va a buon fine.
     */
    public static Token<String> createTokenStr(String s) throws FailureException{
        if(s == null || s == ""){
            throw new FailureException("String invalida");
        }

        String[] token = s.split(" ");
        if(token.length > 1){
            throw new FailureException("String contiene piu di un token");
        } 

        return new Token<String>(s);
    }

    /**
     * Inizializza un nuovo Token Double.
     * 
     * @param d Double da assegnare al Token
     * @return Token di tipo Double.
     */
    public static Token<Double> createTokenDouble(Double d){
        return new Token<Double>(d);
    }

    /**
     * Ritorna True se il Token e' un simbolo.
     * 
     * @return True se this e' un simbolo.
     */
    public boolean isSimbolo(){
        return this.valore instanceof String;
    }

    /**
     * Ritorna True se il Token e' un numero.
     * 
     * @return True se this e' un numero.
     */
    public boolean isNumero(){
        return this.valore instanceof Double;
    }

    /**
     * Ritorna il valore di this se e' un simbolo, solleva un'eccezione altrimenti.
     * 
     * @return Valore di this.
     */
    public String simbolo(){
        if(isSimbolo()){
            return (String) this.valore;
        }
        throw new FailureException();
    }

    /**
     * Ritorna il valore di this se e' un numero, solleva un'eccezione altrimenti.
     * 
     * @throws NotNumberException Se il metodo viene invocato su un Token di tipo String.
     * @return Valore di this.
     */
    public double numero(){
        if(isNumero()){
            return (Double) this.valore;
        }
        throw new NotNumberException("Il Token non e' un numero");
    }

    @Override 
    /**
     * Implementa la funzione d'astrazione.
     */
    public String toString(){
        String ret = "";
        ret += this.valore;

        return ret;
    }
}
