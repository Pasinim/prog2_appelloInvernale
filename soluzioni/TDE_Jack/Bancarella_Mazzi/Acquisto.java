import java.util.Map;
import java.util.Objects;

/**
 * Se più bancarelle offrono lo stesso giocattolo, il compratore che intenda acquistarne una certa quantità,
 *  può comporre il suo acquisto in modi diversi, decidendo di acquistare un diverso numero di giocattoli 
 * dalle varie bancarelle che lo offrono, magari cercando di minimizzare il prezzo totale.

L'acquisto (di un determinato giocattolo) è pertanto caratterizzato da: il giocattolo stesso, 
la quantità acquistata e il prezzo pagato, nonché dall'elenco delle bancarelle, ciascuna accompagnata 
dal numero di giocattoli che ha venduto.

Implementate la classe Acquisto che consenta di gestire tali informazioni. Un esempio di acquisto 
potrebbe essere

Acquisto di: soldatino di stagno, per un costo di: 23, numero: 11 di cui:
10 da Federico
1 da Massimo
 */

/**
 * Le istanze di questa classe rappresentano l'acquisto di un dato giocattolo in una certa quantità.
 * Inoltre tale classe contiene il prezzo pagato per il giocattolo in base alla quantità ed infine
 * l'insieme delle bancarelle, ognuna delle quali ha associato il numero di giocattoli venduti dello tipo
 * definito.
 * Tale classe è immutabile perciò è lecito che i campi siano pubblici.
 */
public class Acquisto {

    /**
     * IR: {@link giocattolo} non è {@code null}, {@link bancarelle} non è {@code null} e non possiede 
     * elementi {@code null}, {@link quantità} è positivo e {@link prezzoGiocattolo} è positivo.
     */

    public final Giocattolo giocattolo;
    public final int quantità;
    public final int prezzoGiocattolo;
    public final Map<Bancarella,Integer> bancarelle;

    /**
     * Inizializza this affinchè rappresenti un acquisto.
     * Solleva un'eccezione di tipo {@link NullPointerException} nel caso in cui {@link giocattolo} sia {@code null}.
     * Solleva un'eccezione di tipo {@link NullPointerException} nel caso in cui {@link bancarelle} sia {@code null}.
     * Solleva un'eccezione di tipo {@link NullPointerException} nel caso in cui {@link bancarelle} abbia un elemento {@code null}.
     * @param giocattolo da acquistare
     * @param quantità da acquistare
     * @param bancarelle da cui acquistare
     */
    public Acquisto(Giocattolo giocattolo,int quantità,Map<Bancarella,Integer> bancarelle){
        Objects.nonNull(giocattolo);
        Objects.nonNull(bancarelle);
        for(Map.Entry<Bancarella,Integer> entry : bancarelle.entrySet()){
            Objects.nonNull(entry);
        }
        if(quantità < 0) throw new IllegalArgumentException("");
        this.giocattolo = giocattolo;
        this.bancarelle = bancarelle;
        this.quantità = quantità;
        PoliticaMoltiplicativa pm = new PoliticaMoltiplicativa();
        this.prezzoGiocattolo = pm.politicaMoltiplicativa(giocattolo, quantità);
    }
/*
    /**
     * Solleva un'eccezione del tipo {@link NullPointerException} nel caso in cui {@link giocattolo} sia null
     * Solleva un'eccezione del tipo {@link IllegalArgumentException} nel caso in cui {@link quantità} sia negativa
     * @param giocattolo da acquistare 
     * @param quantità da acquistare
     
    public void effettuaAcquisto(Giocattolo giocattolo, int quantità){
        Objects.nonNull(giocattolo);
        if(quantità < 0) throw new IllegalArgumentException("");
       
            for(Map.Entry<Bancarella,Integer> entry : bancarelle.entrySet()){
                int daAcquistare =  entry.getKey().getNumberOfGiocattolo(giocattolo);
                if(daAcquistare > 0 && daAcquistare < quantità){
                        entry.getKey().vendiGiocattolo(giocattolo, daAcquistare);
                        quantità = quantità - daAcquistare;
                    }else if(daAcquistare > 0 && daAcquistare >= quantità) {
                        entry.getKey().vendiGiocattolo(giocattolo, quantità);
                        return;
                }
            }
        }
    */

    /**
     * Acquisto di: {@link giocattolo}, per un costo di: {@link prezzoGiocattolo}, numero: {@link quantità} di cui:
     */
    @Override
    public String toString() {
        String s = new String();
        s +=String.format(" Acquisto di: %s, per un costo di: %d, numero: %d di cui:", giocattolo.toString(), prezzoGiocattolo,quantità);
        for(Map.Entry<Bancarella,Integer> entry : bancarelle.entrySet()){
            s+= entry.getValue() +" da " + entry.getKey().proprietario;
            s+= "\n";
        }
        return s;
    }


}
