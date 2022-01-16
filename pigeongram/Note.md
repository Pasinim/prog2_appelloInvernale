# PIGEONGRAM
## Problemi riscontrati
Se una mappa è public final viene esposta la rappresentazione? No, perchè devo utilizzare dei metodi per aggiungere o togliere.

## Messaggio
- *Mittente e destinatario* sono due utenti registrati


### Contenuto
Il contenuto può essere di tipo diverso, per semplicità deve comprendere i tipi testuali e musicali. Faccio ENUM?

## Conversazione
*Quando due utenti A e B decidono di intraprendere uno scambio di messaggi può essere opportuno costruire due conversazioni che condividano il medesimo elenco di messaggi: l'utente A conserverà la conversazione con l'interlocutore B e, viceversa, l'utente B quella con l'interlocutore A. Ciascun utente potrà quindi usare la sua conversazione sia per aggiungere messaggi all'**elenco condiviso** con l'interlocutore, che per tenere correttamente traccia dei messaggi che egli ha già letto.*

- Deve inviare un messaggio al destinatario
- Tenere traccia dei messaggi inviati e ricevuti (nella giusta sequenza), indicando quali sono quelli letti e quali non (cioè quelli nuovi). Inviare un messaggio rende letti tutti gli altri messaggi


## Utente
- *nome + password*
- *iniziare* o *riprendere* uno scambio di messaggi
- conoscere l'insieme dei suoi *interlocutori*
Per riprendere lo scambio di messaggi devo recuperare le conversazioni
Utilizzo una variabile di istanza `Map<Utente, Conversazione>` per tenere traccia delle conversazioni di `this` con `utente`. In questo modo non è necessario creare `Set<Utenti> interlocutori` per `getInterlocutori` ma è sufficiente stampare le chiavi.

## Rete
- mantenere elenco di utenti
- *creazione* delle conversazioni
- *registrazione* e *login*
- Un utente che intenda iniziare un nuovo scambio di messaggi può infine rivolgersi alla rete che predisporrà un **nuovo elenco condiviso di messaggi** adoperandolo per costruire una coppia di conversazioni "simmetriche" di cui darà comunicazione ai due utenti coinvolti.

