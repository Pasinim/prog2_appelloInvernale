import java.util.Objects;
import java.util.Set;

/**
 * Finalmente è arrivato il momento di occuparsi del compratore. Questo, 
 * una volta noto l'insieme di bancarelle da cui fare acquisti, 
 * può comprare un certo numero di giocattoli di un dato tipo seguendo diverse strategie: 
 * comprando dalla bancarella che esibisce il minor prezzo unitario, 
 * o dalle bancarelle che hanno maggior disponibilità del giocattolo,
 *  o scegliendo a caso da quali bancarelle comprare.

Potrebbe aver senso raccogliere alcune competenze comuni a tutti i compratori in una classe astratta 
fornendo poi delle implementazioni concrete che realizzino in modo diverso le varie strategie d'acquisto.

In ogni modo, la classe concreta dovrà avere almeno un costruttore che riceva un parametro di
 tipo Set<Bancarella> e un metodo di segnatura

public Acquisto compra(final int num, final Giocattolo giocattolo)
che sarà usata per effettuare l'acquisto.

Se così non fosse, aggiungete ad almeno una classe che implementa l'interfaccia Listino un costruttore che accetti un parametro di tipo Map<Giocattolo,
Integer> che associ a ciascun giocattolo il suo prezzo unitario — più eventualmente altri parametri utili a descrivere la politica di prezzo.
 */


/**
 * Le istanze di questa classe rappresentano un compratore ed è definita come una classe astratta.
 * Essa inoltre è la cima della gerarchia dei compratori, che hanno tutti dei comportamenti in comune quale 
 * il metodo compra e il costruttore.
 * Le istanze di questa classe sono mutabili.
 */
public abstract class Compratore {

    /**
     * IR: {@link bancarelle} non è {@code null} e non contiene elementi {@code null}
     */
    private Set<Bancarella> bancarelle;

    public Compratore(Set<Bancarella> bancarelle){
        Objects.nonNull(bancarelle);
        for(Bancarella b : bancarelle){
            Objects.nonNull(b);
        }
        this.bancarelle = bancarelle;
    }

    public abstract Acquisto compra(final int num, final Giocattolo giocattolo); 

    public Set<Bancarella> getBancarelle() {
        return bancarelle;
    }
}
