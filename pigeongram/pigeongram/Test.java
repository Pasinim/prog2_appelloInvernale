package pigeongram;

public class Test {    
    public static void main(String[] args) {
    //PROVA A CREARAE TUTTO, MAPPA E VEDERE SE STAMPA
    Utente u = new Utente("pippo", "1");
    Utente u2 = new Utente("puppa", "2");
    Conversazione c = u.inizia(u2);
    c.send("ciao");
    c.send("puppa");
    //ricevuti è vuoto perchè non la popolo mai
    System.out.println(u2.getRicevuti(u).toString());
    System.out.println(u.getInviati(u2).toString());
    System.out.println(u2.getUnread(u).toString());
    }
}
