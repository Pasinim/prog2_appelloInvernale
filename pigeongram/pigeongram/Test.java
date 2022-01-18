package pigeongram;

public class Test {
    public static void main(String[] args) {
        Utente u1 = new Utente("artu", "1");
        Utente u2 = new Utente("merlino", "1"); 
        Conversazione c = u1.inizia(u2);
        u1.invia(u2, "ciao"); //artu -> merlino
        //System.out.println(u1.getInterlocutori());
        //System.out.println(u2.getInterlocutori());    
        System.out.println("MSG tutti: " + c.getTutti().toString()); 
        System.out.println("MSG non letti: " + c.getNonLetti().toString() + "\n________"); 
        u2.invia(u1, "no grazie");
        System.out.println("MSG tutti: " + c.getTutti().toString()); 
        System.out.println("MSG non letti: " + c.getNonLetti().toString() + "\n________"); 
        u1.invia(u2, "grrr");
        System.out.println("MSG tutti: " + c.getTutti().toString()); 
        System.out.println("MSG non letti: " + c.getNonLetti().toString() + "\n________"); 
    }


}
