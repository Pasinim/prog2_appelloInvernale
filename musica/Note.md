# Musica
## Osservazioni
- Per rimuovere tutti i whitespaces posso fare `String str = str.replace(" ", "");`
- Guarda come fa il prof nel costruttore di `Durata(String str)` e come gestisce il formato corretto di `str` -> non crea un costruttore per creare una `Durata` da una stringa ma crea un metodo **statico** in modo da utilizzare il metodo anche se nessuna `Durata` è ancora stata istanziata.
- **- All'interno di `Durata` il metodo `str_to_Durata` è da dichiarare statico, in modo da poterlo chiamare anche senza aver instanziato una variabile `Durata`**
- In album **non** dovrei essere in grado di aggiungere nuovi brani all'album, giusto? Se posso aggiungere brani all'album la classe sarebbe mutabile. Essendo una lista deve essere quindi dichiarata come `private final` dato che non devo esporre la rappresentazione ed impedire ad un utente di aggiungere/rimuovere brani.
- È necessario creare un metodo `iterator` all'interno di `Playlist` che permette di iterare su `<Album.Brano>`
- Ha senso mettere la lista di durate in playlist? In `album` non ha senso dato che ogni brano ha una propria durata quindi posso ricavare la durata dal brano. *In album tengo solamente la durata complessiva*
- Anche nella `Playlist` avrebbe senso tenere la durata complessiva, tuttavia devo tenere traccia anche delle singole durate di chiascun brano. Per fare ciò basta accedere al campo `durata` di `Album.Brano`. **Come faccio ad accedere alla durata??**
- La `Playlist`, come indicato nel testo, **è mutabile quindi si crea una playlist vuota** e man mano si aggiungono gli elementu

## Album
**Titolo + Brani + Durata complessiva**.
Elenco ordinato, non vuoto e senza ripetizioni -> `List` ammette ripetizioni, quindi devo controllare che non venga inserito un elemento duplicato. `Set` non va bene perchè l'elenco deve essere *ordinato*.
Devo implementare un *iteratore* per iterare sulle canzoni.

## Brano 
**Titolo + Durata**
Il brano è da implementare come `inner class` di Album, in modo che un brano venga associato direttamente ad un album in quanto un brano potrebbe essere contenuto in album diversi.
*Visto che `Brano` è una classe interna di `Album`, quest'ultimo non può avere un costruttore che contenga dei brani, deve invece ricevere elenco di titoli e uno di corrispondenti durate.*

## Durata

## Playlist
Elenco ordinato di brani (di album diversi).
**Brani + nome + durata complessiva**.
Deve essere mutabile infatti devo aggiungere o rimuovere dei brani.
Deve essere in grado di *enumerare*.
**L'implementazione con le mappe non garantisce che l'ordine rimanga quello, quindi utilizzo due liste parallele.**
Per restituire tutti i brani di uno stesso alvum `a` devo creare un metodo all'interno dell'inner che restituisce l'album di this.

