# Cosa ho sbagliato nell'esame?
1. Avere un metodo parziale può avere senso, ma non ha senso avere un costruttore parziale dato che, se l'utente viola le precondizioni, viene creato comunque un oggetto che non soddisfa IR. Devo quindi **sempre** rendere il costruttore totale, lanciando *eccezioni*.
2. Le *eccezioni* devono essere riportate al **livello di astrazione** del chiamante, come dice la Liskov.
3. Se in un metodo chiamo un costruttore ha senso controllare **prima** della sua invocazione se IR è rispettata. In questo modo mi rendo conto di un eventuale errore nella porzione di codice in cui viene effettivamente sollevata l'eccezione, altrimenti si solleverebbe nel costruttore e non avrei chiaro dove si trova il problema.
4. Il costruttore deve verificare le condizioni -> catturo le eccezioni e eventualmente spiego dove è l'errore. In questo modo le eccezioni sono leggibili dall'utente, devo ragionare a **livello dell'utente finale**. Se ho molte condizioni da verificare ha senso utilizzare il `try-catch` in  modo da catturare tutte le eccezioni.
5. Ha senso sviluppare bene e con i dovuti riguardi *prima* le classi più piccole, in modo da far capire che si ha chiaro il ragionamento, per le classi più avanzate posso segnalare al docente la scarsità di tempo.
6. Quando nel costruttore viene passata una lista devo prima **copiarla**. Così facendo l'utente è impossibilitato ad aggiungere elementi alla lista e non viene esposta la rappresentazione. Esempio:
    - Creo una `List<String> str` da passare al costruttore:
    ```
    str ==> [ciao, mamma, aggiungo]
    ```
    - Passo `str` al costruttore:
    ```
    jshell> Costruttore_Lista l = new Costruttore_Lista(str)
    l ==> [ciao, mamma]
    ```
    - Aggiungo una stringa alla lista che ho passato al costruttore
    ```
    jshell> str.add("aggiungo")
    str ==> [ciao, mamma, aggiungo]
    ```
    - Anche a `l`, che era già stato instanziato e dovrebbe essere immutabile, viene aggiunta la stringa *"aggiungo"*:
    ```    
    l ==> [ciao, mamma, aggiungo]
    ```
    - Per evitare questo problema si deve utilizzare il metodo `List.copyOf(obj)`:
    ```java
        public Costruttore_Lista(List<String> s){
        this.str = List.copyOf(s);
        }
    ```