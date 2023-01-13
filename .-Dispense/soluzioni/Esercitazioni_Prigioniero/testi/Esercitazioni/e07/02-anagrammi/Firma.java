import java.util.Arrays;

/**
 * Le istanze di questa classe rappresentano la firma di un gruppo di parole (che hanno lo stesso anagramma).
 * Le istanze sono immutabili
 */
public class Firma implements Anagramma{
    
    final private String sign; 

    private Firma (String s){
        this.sign = super.getSignature(s);
    }
}
