import java.util.*;
/**
 * OVERVIEW:
 */
public class Durata {
    public final int s, m, h;

    public Durata(int tot){
        if (tot < 0) throw new IllegalArgumentException("La durata non può essere negativa");
        this.s = tot % 60;
        this.m = (tot / 60)%60;
        this.h = (tot/60)/60;
        repOK();
    }

    public Durata(String str){
        //DEVO DIRE COSA DEVO FARE NEL CASO IN CUI NON CI SIANO INDICATE LE ORE
        String tkns[] = str.split(":");
        if (tkns.length > 3 || tkns.length <= 0) throw new IllegalArgumentException("La lunghezza deve essere > 3 e <= 0. Trovato: " + tkns.length);
        if (tkns.length == 2) {
            this.s = Integer.valueOf(tkns[1]);
            this.m = Integer.valueOf(tkns[0]);
            this.h = 0;    
        }else{
            this.s = Integer.valueOf(tkns[2]);
            this.m = Integer.valueOf(tkns[1]);
            this.h = Integer.valueOf(tkns[0]);
        }
        
        repOK();
    }

    public Durata sommaDurata(Durata d){
        Objects.requireNonNull(d);
        int somma = this.s + this.m * 60 + this.h * 3600;
        somma += d.s + d.m * 60 + d.h * 3600;
        return new Durata(somma);
        
    }

    @Override
    public String toString(){
        String str = "";
        str += String.format("%02d:%02d:%02d", h, m, s);
        return str;
    }

    private boolean repOK(){
        return (
            this.h >= 0 &&
            this.m >= 0 &&
            this.m < 60 &&
            this.s >= 0 &&
            this.s < 60
        );
    }


    public static void main(String[] args) {
        Durata d = new Durata ("2:01:35");
        // Durata d2 = new Durata (210);
        System.out.println(d.toString());
        // System.out.println(d2.toString());
        // Durata d3 = d.sommaDurata(d2);
        // System.out.println(d3.toString());

    }

}
