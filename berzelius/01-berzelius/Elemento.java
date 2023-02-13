import java.util.Objects;

/**
 * Le istanze di questa classe rappresentano un elemento chimico, identificato da un nome, 
 * un simbolo e un peso.
 * IR: nome non puo' essere una stringa vuota e != null
        simbolo  non puo' essere una stringa vuota e != null
 *      simbolo deve soddisfare l'espressione regolare ELEMENT_PATTERN nella classe Helpers
 *      peso > 0
 *  
 * AF: simbolo.toString()
 */
public class Elemento {
    /** Le seguenti variabili di istanza sono pubbliche in quanto final */
    public final String nome;
    public final String simbolo;
    /**VI che rappresenta il peso dell'elemento */
    private float peso;

    /**
     * Istanzia un nuovo elemento
     * @param nome Nome dell'elemento
     * @param simbolo Simbolo dell'elemento
     * @param peso peso dell'elemento
     * @throws NullPointerExc se nome o simbolo sono null
     * @throws IllegalArgumentExc se nome o simbolo sono sitringhe vuote 
     *                              se il simbolo non e' corretto
     *                              se il peso e\ minore di 1
     */
    public Elemento(String nome, String simbolo, float peso) {
        Objects.requireNonNull(nome, "il nome dell elemento non puo essere null" );
        Objects.requireNonNull(simbolo, "il simbolo dell elemento non puo essere null" );
        if (nome.isEmpty()) throw new IllegalArgumentException("Il nome dell' elemento non puo' essere una stringa vuota");
        if (simbolo.isEmpty()) throw new IllegalArgumentException("Il simbolo dell' elemento non puo' essere una stringa vuota");
        if (!Helpers.elementoValido(simbolo)) throw new IllegalArgumentException("Il simbolo dell' elemento non e' valido");
        if (peso <= 0) throw new IllegalArgumentException("Il peso di un elemento non puo' essere <= 0 ");

        this.nome = nome;
        this.simbolo = simbolo;
        this.peso = peso;
    }

    /**
     * Restiuisce il peso atomico di this
     * @return this.peso
     */
    public float getPeso(){
        return this.peso;
    }

    @Override
    public String toString() {
        return simbolo.toString();
    }

    



    



     
}
