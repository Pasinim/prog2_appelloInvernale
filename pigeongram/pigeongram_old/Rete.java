package pigeongram_old;
// package pigeongram;
// import java.util.*;

// public class Rete {
//     public final Set<Utente> users;
    
//     /**
//      * Inizializza una nuova rete. Se users è null oppure uno degli elementi
//      * all'interno di esso è null solleva una eccezione di tipo NullPointerException
//      * @param users Utenti della rete
//      */
//     public Rete(HashSet<Utente> users){
//         users = new HashSet();
//         Objects.requireNonNull(users);
//         Iterator<Utente> it = users.iterator();
//         while (it.hasNext())
//             Objects.requireNonNull(it.next());
//         this.users = users;
//     }

//     public Utente sign(String nome, String psw){
//         Objects.requireNonNull(nome);
//         Objects.requireNonNull(psw);
//         if (users.contains(nome))
//             throw new IllegalArgumentException("Utente già presente, effettua il login");
        
//     }
// }
