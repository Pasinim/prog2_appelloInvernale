package pigeongram;

public class Test {
    public static void main(String[] args) {
        Utente u1 = new Utente("artu", "1");
        Utente u2 = new Utente("merlino", "1"); 
        Conversazione c = u1.inizia(u2);
        u1.invia(u2, "wo");
        System.out.println("Non letti di B: " + u2.riprendi(u1).nonLetti(u1).toString());
        u2.invia(u1, "aaaa");
        System.out.println("Non letti di A: " + u1.riprendi(u2).nonLetti(u2).toString());
        u1.invia(u2, "adadda");
        u1.invia(u2, "wwwwwwww");
        System.out.println("Tutti msg: " + c.toString());

       

    }


}
