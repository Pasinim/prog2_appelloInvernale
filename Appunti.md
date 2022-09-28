# Metodi

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

5. One line statement:  

6. Meglio non passare Collezioni nel costruttore, ma creare la collezione vuota e aggiungere gli elementi uno alla volta

7. Quando nel costruttore (o in altri metodi) viene passata una lista è necessario prima copiarla per non esporre la rappresentazione (dato che la lista viene passata per riferimento). In questo modo anche se l'utente invoca il metodo `add` sulla lista che ha passato al metodo, quella che ha generato il costruttore resterà invariata dato che ho creato una copia. 

8. Il costruttore quando istanzia un oggetto con un altro costruttore della classe deve avere nella prima riga línvocazione a quel costruttore

9. Le classi interne (*inner class*) sono lo strumento linguistico offerto da Java
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

4. Per contare la posizione da destra (esercizio bool=vect)
   
   ```java
      for (int i = 0; i < len; i++) 
         scrivi(i, vals.charAt(len - i - 1) == 'V');
   ```

____

1. Metodo `clone`

{% note %}

Osservate l’uso del metodo clone che ha l’obiettivo di costruire una copia dell’array passato come argomento; questo accorgimento serve ad evitare che chi ha invocato li costruttore possa mantenere un riferimento all’array che costituisce la rappresentazione del vettore.

{% endnote %}
