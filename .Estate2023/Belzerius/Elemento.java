import java.util.Objects;

/**
 * Le istanze diu questa classe immutabile rappresentano un elemento chimico
 */
public class Elemento {
    /**
     * 
     */
    public final int numeroAtomico;
    public final String nome;
    public final String simbolo;
    public final double peso;

    /**
     * Inizializza un nuovo elemento chimico.
     * 
     * @param numeroAtomico numeroAtomico dell'elemento
     * @param nome          nome dell'elemento
     * @param simbolo       simbolo dell'elemento
     * @param peso          peso dell'elemento
     * @throws IllegalArgumentException se il numero atomico o il peso è negativo
     * @throws NullPointerException     se il nome è null
     * @throws IllegalArgumentException se il nome è una string vuota
     * @throws IllegalArgumentException se il simbolo non è nel formato corretto
     */
    public Elemento(String nome, String simbolo, double peso, int numeroAtomico) {
        Objects.requireNonNull(nome, "Il nome non può essere null");
        Objects.requireNonNull(simbolo, "Il simbolo non può essere null");
        if (!(Helpers.elementoValido(simbolo)))
            throw new IllegalArgumentException("simbolo non valido");
        if (numeroAtomico < 0)
            throw new IllegalArgumentException("numero atomico negativo");
        if (peso < 0)
            throw new IllegalArgumentException("peso negativo");
        if (nome.length() == 0)
            throw new IllegalArgumentException("nome vuoto");
        this.numeroAtomico = numeroAtomico;
        this.nome = nome;
        this.simbolo = simbolo;
        this.peso = peso;
    }

    

    @Override
    public String toString() {
        return simbolo.toString();
    }



    public int getNumeroAtomico() {
        return numeroAtomico;
    }

}
