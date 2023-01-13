import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Le istanze di questa classe rappresentano un compratore randomizzato.
 * Nel senso che prendere il primo stronzo ogni volta è una sorta di randomizazione, fidati.
 * Le istanze di queste classe estenono il supertipo compratore, che è una classe astratta.
 * Tale classe permette di effettuare un'acquisto dato un giocattolo e un numero di questi da comprare.
 */
public class CompratoreRandomizzato extends Compratore{

    /**
     * IR: IR_super
     * @param bancarelle
     */
    public CompratoreRandomizzato(Set<Bancarella> bancarelle) {
        super(bancarelle);
    }

    /**
     * Post condizioni: effettua un'acquisto 
     * Solleva un'eccezione di tipo {@link IllegalArgumentException} nel caso in cui la {@link num} di giocattoli
     * da comprare sia negativa.
     * Solleva un'eccezione di tipo {@link NullPointerException} nel caso in cui {@link giocattolo} sia {@code null}
     * @param giocattolo da acquistare
     * @param num di giocattoli da acquistare
     */
    @Override
    public Acquisto compra(int num, Giocattolo giocattolo) {
        Objects.nonNull(giocattolo);
        if(num < 0) throw new IllegalArgumentException("");
        Map<Bancarella,Integer> bancarelle = new HashMap<>();

        for(Bancarella bancarella : super.getBancarelle()){
            try{
                if(bancarella.getNumberOfGiocattolo(giocattolo) > 0)
                    bancarella.vendiGiocattolo(giocattolo, num);
                    bancarelle.put(bancarella,num);
                    break;
            }catch(IllegalArgumentException e){
                    bancarella.vendiGiocattolo(giocattolo, bancarella.getNumberOfGiocattolo(giocattolo));
                    bancarelle.put(bancarella,bancarella.getNumberOfGiocattolo(giocattolo));
                    num = num -  bancarella.getNumberOfGiocattolo(giocattolo);
            }
        }
        Acquisto acquisto = new Acquisto(giocattolo, num, bancarelle);
        return acquisto;
    }
    
}
