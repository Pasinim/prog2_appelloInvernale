# Metodi

___

## Revisione esame Gennaio - Robot/Scalo

- Attribuire ad ogni classe le proprie competenze al giusto livello di astrazione. Ciò signfica specialmente che se definisco una classe con dei metodi che fanno inserire delle informazioni devo avere **sempre** dei metodi che mi fanno prelevare tali informazioni.

- Nell'AF è anche utile specificare l'ordine in cui vengono stampati gli oggeti, chi è in posizione 0 e chi in posizione *n-1*

- Attenzione a riferisi correttamente alle **strutture dati** dell'implementazione: *insieme != lista != pila != ....*

- Sempre approccio **top-down**, questo permette di specificare i metodi delle classi più in alto nella gerarchia 

- Attenzione a specificare **tutte le eccezioni** che vengono sollevate (nel senso specificare `NullPointerException se è Object è null`, `IllegalArgumentException se n < 0`, ecc...)

- Non aggiungere metodi o informazioni ridondanti (ad esempio id in `Scaffalatura`)

- Se implemento con un `Set` è necessario che la classe abbia un metodo `hashCode()` implementato correttamente. Ad esempio in `Scaffalatura` dovrei avere un `hashCode()` che prende id e nome, in modo da avere un HashCode univoco per ogni istanza.
  
  > Sarebbe stato meglio implementare le `Scaffalature` all'interno del magazzino con una struttura dati diversa dal `Set` proprio per questo motivo.

- Gli attributi di `Robot` non hanno senso perchè passo il numero di pacchi da spostare nel costruttore, ciò significa che una volta instanziato non posso spostare più dei pacchi che ho definito in fase di creazione dell'istanza.

## Revisione esame Febbraio - Berzelius

- Nella `overview` devo specificare se la classe è **immutabile** o **mutabile**. Nella OV non devo però indicare come è implementata la classe (es: non devo dire che la tavola periodica è implementata con una lista).

- AF e RI li specifico all'interno della classe, non fuori nell'overview

> Prima decido come fare l'astrazione poi identifico la rappresentazione più corretta e infine specifico l'invariante, indicando come tutto deve funzionare, le eccezioni lanciate $\rightarrow $ <mark>devo sempre chiedermi che cosa può andare storto</mark>. Scelgo la rappresentazione più adeguata e poi mi difendo di consegnuenza, rendendo il metodo totale.
> 
> **AF e IR devo farle prima del codice e bene**, il codice lo faccio dopo seguendo AF e IR alla lettera

- La tavola periodica deve essere immutabile, altrimenti poi diventa difficoltoso gestire tutte le altre classi; ad esempio se inserisco una molecola che non è nella tavola periodica, poi aggiungo l'elemento che doveva esserci in quella molecola come mi devo comportare?

- Nella specifica devo scrivere **anche le eccezioni** sollevate dalle API di Java, un utente esterno deve potere essere in grado di visualizzare le specifiche della mia classe e di sapere tutte le eccezioni che vengono lanciate. Ad esempio se ho implementato una classe con una `Map` devo specificare comunque la `NullPointerException`, anche se non la sollevo io ma il metodo `put` della mappa

- Il peso atomico è un attributo dell'elemento, in questo TDE era definito tramite il numero di riga in fase di lettura della tavola periodica, avrei dovuto specificare questo comportamento nella classe `TavolaPeriodica`.

- Quando mi serve fare una ricerca l'implementazione migliore è una `Mappa`, specialmente nelle mappe è necessario prestare attenzione quali eccezioni lanciare dato che è un tipo che può contenere di tutto

- Nella tavola periodica devo garantire che non esistano elementi duplicati, NON devo farlo con un `equals` in Elemento dato che non posso farlo. 
  Esempio stupido: come fa una persona a sapere che il proprio codice fiscale è univoco? Non può farlo, ma lo deve fare il "contenitore" dei codici fiscali, ossia l'anagrafe, che nel caso di doppioni attuerà una soluzione adeguata.

___

1. `hashCode`: 
   
   ```java
   return Objects.hash(nome, quantita);
   ```

2. ```java
       public boolean equals(Object o){
           Objects.requireNonNull(o);
           if (!(o instanceof Dotazione)) return false;
           final Dotazione obj = (Dotazione) o;
           return obj.nome.equals(this.nome) && obj.quantita == this.quantita;
   
       }
   ```

3. Quando creo una classe con all'interno una variabile di istanza (di tipo primitivo) con `final` non espongo la rappresentazione. Infatti con una implementazione di questo tipo
   
   ```java
    public class Dotazione implements Comparable<Dotazione> {
       public final String nome;
       public int quantita;
   }
   ```

       potrei creare una `Dotazione d = new Dotazione("p", 10)` e poi fare
       `d.quantita++` modificando l'istanza. Non è una classe immutabile.

4. Controllare se negli elementi di una collezione è presente un riferimento nullo: `Arrays.asList(myArray).contains(null)`

5. One line statement:  `return elem2mult.containsKey(o) ? elem2mult.get(o) : 0;`

6. for corto: `for (E e : this) size += multeplicity`

7. Meglio non passare Collezioni nel costruttore, ma creare la collezione vuota e aggiungere gli elementi uno alla volta

8. Quando nel costruttore (o in altri metodi) viene passata una lista è necessario prima copiarla per non esporre la rappresentazione (dato che la lista viene passata per riferimento). In questo modo anche se l'utente invoca il metodo `add` sulla lista che ha passato al metodo, quella che ha generato il costruttore resterà invariata dato che ho creato una copia. 

9. Il costruttore quando istanzia un oggetto con un altro costruttore della classe deve avere nella prima riga línvocazione a quel costruttore

10. Le classi interne (*inner class*) sono lo strumento linguistico offerto da Java
    per modellare esattamente la circostanza in cui ci troviamo: quella di un
    oggetto (il brano) che ha senso solo se legato all’istanza di un altro
    (l’album).

### Metodi utili (pt2)

1. Cerca il titolo del brano passato come parametro
   
   ```java
   for (final Brano b : brani) if (b.titolo.equals(titolo)) return b;
   ```

2. Iteratore:
   Il codice dell'iteratore deve essere scritto all'interno della classe (che nell'intestazione deve avere `implements Iterable<T>`), come se fosse un normale metodo.
   
   ```java
   public Iterator<Album.Brano> brani(final Album album) {
           Objects.requireNonNull(album);
           return new Iterator<Album.Brano>(){
   
               private final Iterator<Album.Brano> it = iterator();
   
               private Album.Brano next = null;
   
               @Override
               public boolean hasNext(){
                   if (next != null) return true;
                   //è necessario scandire l’iteratore di tutti i brani della playlist fino a trovarne uno dell’album dato
                   while (it.hasNext()){
                       next = it.next();
                       if (next.getAlbum().equals(album)) return true;
                   }
                   next = null;
                   return false;
               }
   
               @Override
               public Album.Brano next() {
                   if (!it.hasNext()) throw new NoSuchElementException();
                   final Album.Brano ret = next;
                   next = null; //invalido next per fare funzionare correttamente hasNext()
                   return ret;
               }
           };
       }
   ```

3. Trovo il primo 1 partendo da sx
   
   ```java
   Integer.numberOfLeadingZeros(i)Iteger.numberOfLeadingZeros(
   ```

4. Per contare la posizione da destra (esercizio boolvect)
   
   ```java
      for (int i = 0; i < len; i++) 
         scrivi(i, vals.charAt(len - i - 1) == 'V');
   ```

____

1. Metodo `clone`

{% note %}

**Note:** Osservate l’uso del metodo clone che ha l’obiettivo di costruire una copia dell’array passato come argomento; questo accorgimento serve ad evitare che chi ha invocato li costruttore possa mantenere un riferimento all’array che costituisce la rappresentazione del vettore.

{% endnote %}
