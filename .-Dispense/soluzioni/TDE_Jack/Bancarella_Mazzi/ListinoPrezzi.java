/**
 * Il gestore di ogni bancarella può decidere diverse politiche di prezzo per ciascun giocattolo:
 *  ad esempio, può fissare un prezzo unitario U per un dato giocattolo e stabilire che il prezzo di
 *  N giocattoli identici a esso sia dato moltiplicativamente da U * N, oppure applicare degli sconti 
 * (per esempio, se N supera la decina, applicare un 15% di sconto sulle unità eccedenti la decina, 
 * in modo che il prezzo finale sia 10 * U + (N - 10) * U * 85 / 100), o vendere "tre giocattoli al prezzo 
 * di due", e così via.

Un modo ragionevole di rappresentare queste politiche è definire un listino che, dato un giocattolo e 
la quantità da acquistare, restituisca il prezzo complessivo; più precisamente, descrivete una interfaccia
 Listino e almeno una classe che la implementi (ad esempio, quella che descriva la semplice politica
  moltiplicativa).
 */


 /**
  * Le istanze di questa classe rappresentano un'interfaccia che descrive le politiche di prezzo
  * di un venditore dato  un giocattolo
  * e un numero di questi da acquistare, restituendo il prezzo totale.
  * 
  */
public interface ListinoPrezzi {
    
    public int politicaMoltiplicativa(Giocattolo g, int quantità);
}
