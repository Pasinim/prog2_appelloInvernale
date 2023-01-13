/**
 * Le istanza di questa classe rappresentano gli anagrammi di una parola, ovvero tutte le parole che
 * hanno una stessa firma. Le istanze di questa classe sono mutabili
 */
public class Anagramma {
    //variabile d'istanza che contiene tutte le parole che sono anagrammi tra loro
    private Set<String> words;
    //variabile d'istanza che rappresenta la firma delle parole.
    private Firma sign;

    
    private String getSignature (String s){
        char sChar[] = s.toCharArray();
        Arrays.sort(sChar);
        String sign = new String(sChar);
        return sign;
    }


}
