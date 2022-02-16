# Metodi

- `hashCode`: 
  
  ```java`return Objects.hash(nome, quantita);`
  return Objects.hash(nome, quantita);
  
  ```
  
  ```

- ```java
      public boolean equals(Object o){
          Objects.requireNonNull(o);
          if (!(o instanceof Dotazione)) return false;
          final Dotazione obj = (Dotazione) o;
          return obj.nome.equals(this.nome) && obj.quantita == this.quantita;
  
      }
  ```

- Quando creo una classe con all'interno una variabile di istanza (di tipo primitivo) con `final` non espongo la rappresentazione. Infatti con una implementazione di questo tipo
  
  ```java
   public class Dotazione implements Comparable<Dotazione> {
      public final String nome;
      public int quantita;
  }
  ```

       potrei creare una `Dotazione d = new Dotazione("p", 10)` e poi fare `d.quantita++` modificando l'istanza. Non è una classe immutabile.

- Controllare se negli elementi di una collezione è presente un riferimento nullo: `Arrays.asList(myArray).contains(null)`

- One line statement: 
  
  ```java
  booleanExpression ? value1 : value2
  ```

- Meglio non passare Collezioni nel costruttore, ma creare la collezione vuota e aggiungere gli elementi uno alla volta
