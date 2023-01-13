import java.util.Objects;

/**
 * Per semplicità assumeremo che ciascun giocattolo abbia un nome (rappresentato con una stringa) 
 * e sia fatto di un dato materiale (anch'esso rappresentato da una stringa); ad esempio,
 *  una bambola di pezza, una bilia di vetro e una bilia di marmo sono tre giocattoli gli ultimi due 
 * differiscono nel materiale, ma non nel nome. Due giocattoli sono uguali se e solo se hanno lo stesso 
 * nome e sono fatti dello stesso materiale.
 */

 /**
  * Le istanze di questa classe rappresentano un giocattolo. Ogni giocattolo è dato da un nome (una stringa)
  * e da un materiale (anch'esso una stringa) e possiamo dire che due giocattoli sono uguali se e solo se
  * hanno lo stesso nome e lo stesso materiale.
  * Le istanze di questa classe sono immutabili e perciò è ragionevole avere i campi pubblici.
  */
public class Giocattolo {

    /**
     * IR: {@link nome} non può essere {@code null}, {@link prezzo} non può essere negativo e {@link materiale} non può essere null {@code null}
     * Tale invariante è sempre assicurato dal suo unico costruttore.
     */
    public final String nome;
    public final String materiale;
    public final int prezzo;


    /**
     * Solleva un'eccezione {@link NullPointerException} nel caso in cui {@link nome} o {@link materiale} 
     * sono {@code null}
     * Solleva un'eccezione del tipo  {@link IllegalArgumentException} nel caso in cui il {@link prezzo} sia negativo
     * @param nome del giocattolo 
     * @param materiale del giocattolo
     */
    public Giocattolo(String nome,  String materiale,int prezzo){
        Objects.nonNull(nome);
        Objects.nonNull(materiale);
        if(prezzo < 0) throw new IllegalArgumentException("il prezzo non può essere negativo");
        this.materiale = materiale;
        this.nome = nome;
        this.prezzo = prezzo;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Giocattolo)) return false;
        Giocattolo g = (Giocattolo) obj;
        if(g.materiale.equals(materiale) && g.nome.equals(nome)) return true;
        return false;
    }

    @Override
    public int hashCode() {
        int result = 31*materiale.hashCode();
        result +=  nome.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s di %s", nome,materiale);
    }
}
