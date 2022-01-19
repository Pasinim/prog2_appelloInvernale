package pigeongram;
import java.util.*;

/**
 * Appare evidente che è necessario mantenere un elenco di utenti, così come essere in grado di gestire la costruzione 
 * delle conversazioni (azione che, coinvolgendo due utenti, non può essere competenza esclusiva di nessuno dei due). 
 * Per queste ragioni, per il suo funzionamento, il sistema si avvale della rete che è in grado di gestire tali funzionalità.

 * Riguardo alla prima, la rete può registrare un utente dato il suo nome (ammesso che non corrisponda a quello di un utente già registrato)
 *  e password, così come consentire l'autenticazione (login) di un utente precedentemente registrato 
 *(a patto che la password fornita per l'autenticazione corrisponda a quella comunicata durante la registrazione).

 *Un utente che intenda iniziare un nuovo scambio di messaggi può infine rivolgersi alla rete che predisporrà
 *un nuovo elenco condiviso di messaggi adoperandolo per costruire una coppia di conversazioni "simmetriche" di cui darà comunicazione ai due utenti coinvolti.
 */

// public class Rete{
//     public final List<Utente> utenti;


    
// }