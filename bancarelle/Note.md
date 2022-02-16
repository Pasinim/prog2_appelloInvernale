# Bancarelle

## Altre osservazioni

- Quando ho una collezione di oggetti che passo al costruttore è necessario fare un ciclo per controllare che la collezione non contenga elementi nulli (oltre a controllare che la collezione stessa non sia un riferimento nullo).
- Da terminale è necessario compilare una cartella "più in alto" altrimenti il package non viene considerato.
- Nei costruttori (o altri metodi) è necessario controllare oltre che il riferimento non sia null, anche che la stringa non sia vuota con il metodo `.isEmpty()`, infatti il riferimento potrebbe essere `!= null` ma la stringa potrebbe essere vuota.

## Giocattolo

## Inventario

Lista o set? 
Il set non contiene elementi duplicati e non è ordinato, è possibile controllare se un elemento è presente con *contains*.
La lista permette di definire la posizione in cui inserire l'elemento ed è possibile restituire la posizione di un certo elemento con il metodo *indexOf*. 
Devo anche tenere in consideranzione la quantità di ciascun elemento, quindi è necessario utilizzare una mappa.

### Iteratore di Inventario

Nell'inventario è necessario implementare `iterable`, anche solamente per eseguire il `toString()` di bancarella, che deve accodare sia il listino che l'inventario. 
Per fare ciò non è necessario implementare sia il metodo `next()` e `hasNext()`, ma è sufficiente utilizzare sull'inventario il metodo `keySet()`, che fornisce un set conentente tutte le chiavi dell'inventario. **`keySet()` possiede già un iteratore, quindi posso sfruttare direttamente i suoi metodi `next()` e `hasNext()`**. La stessa cosa è necessaria implementarla su *Listino*.

Così facendo l'iteratore itera **solamente** sui giocattoli, quindi devo creare un metodo `getQuantita` che permette di associare ad ogni giocattolo la relativa quantità

## Bancarella

*proprietario, inventario, listino*.
Listino: mostra i prezzi di tutti i giocattoli presenti nell'inventario. Il Listino è la mappa presente nella classe inventario.
È necessario anche implementare la vendita, rimuovendo l'oggetto dall'inventario.

## Acquisto

*giocattolo, quantità, prezzo pagato, elenco delle bancarelle*. Nell'elenco di bancarelle devo inserire tutte le bancarelle che hanno venduto un giocattolo, accompagnata dalla quantità venduta.
Per gestire il l'elenco delle bancarelle coi i giocattoli da acquistare/venduti utilizzo una mappa.
Come lo implemento?

## Compratore

Ci deve essere una classe astratta (con diverse strategie)
Il compratore fa un **acquisto**. Deve avere a disposizione *l'elenco delle bancarelle*. Il costruttore deve riceve un parametro del tipo *Set<Barncarelle>* La funzione **compra** restituisce un tipo Acquisto.
Il comprataore può effettuare un'acquisto in due modi differenti:

- Tramite la funzione `public Acquisto compra(final int num, final Giocattolo giocattolo)`
- Tramite una classe che implementi l'interfaccia *listino* con un costruttore che accetti un parametro di tipo `Map<Giocattolo, Integer>` che associ a ciascun giocattolo il suo prezzo unitario

## Listino

La classe concreta che implementa l'interfaccia listino deve avere un costruttore (vedi sopra) e un metodo che permette di ottenere il prezzo totale.
**PROBLEMA:** A cosa serve associare ad ogni giocattolo il suo prezzo unitario? Nell'inventario tengo traccia di quanti giocattoli *g* ci sono, mentre nel listino devo inserire il prezzo di ogni giocattolo *g*.
Analogamente a **Inventario** è necessario implementare l'iteratore, anche qui ottenuto creando una lista dei giocattolo (*tramite keySet*) e creando `next()` e `hasNext()` sul set restituito da `listino.keySet()` 

## Problemi riscontrati

- Nel main, quando veniva chiamato il costruttore per creare l'inventario e il listino, sembrava che (stampandoli) non venissero salvati la metà degli elementi. 
  Questo era causato dal `toString()` nelle classi `Inventario` e `Listino`, in cui veniva stampato il nome utilizzando l'iteratore e facendo `it.next()` si passava direttamente all'elemento successivo, senza stampare quello corrente. Per questo motivo, inoltre, se in input venivano inseriti un numero dispari di elementi, veniva sollevata una eccezione. Per risolvere il problema ho implementato il `toString()` copiando l'elemento iterato in un nuovo `Giocattolo`:
  
  ```java
        while (it.hasNext()){
            Giocattolo g = it.next();
            str += "num. " + this.getQuantita(g) + " " + g.toString() +"\n";
        }
  ```
- ~~La stessa cosa è da fare anche a `Listino`.~~ In `Listino` è sufficiente creare un metodo che dato un giocattolo restituisca il prezzo. In questo modo si può evitare di inserire altri metodi nell'interfaccia.