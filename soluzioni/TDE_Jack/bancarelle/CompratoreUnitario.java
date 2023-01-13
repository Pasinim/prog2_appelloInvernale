package tde.bancarelle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class CompratoreUnitario extends Compratore {

    /**
     * Inizializza un Compratore in grado di comprare dal Set b di bancarelle.
     * 
     * @param b Set di bancarelle
     */
    public CompratoreUnitario(Set<Bancarella> b){
        super(b);
    }


    @Override
    /**
     * Effettua un acquisto di num giocattoli di tipo Giocattolo.
     * Restituisce un Acquisto che descrive la transazione effettuata.
     * 
     * Solleva un'eccezione se la quantitá totale di giocattolo presente nelle bancarelle non raggiunge
     * quella indicata in num
     * 
     * L'acquisto viene effettuato la bancarella che esibisce il minor prezzo unitario, se tale bancarella
     * non puó soddisfare la quantitá richiesta, vengono effettuati acquisti dalla bancarella avente il secondo
     * minor prezzo unitario e cosi via.
     * 
     * @param num Numero di Giocattoli da comprare
     * @param giocattolo Giocattolo da comprare.
     * @return Acquisto relativo alla transazione.
     */
    public Acquisto compra(int num, Giocattolo giocattolo) {
        Iterator<Bancarella> i = super.bancarelle();
        Bancarella min = null;
        Map<Bancarella, Integer> bi = new HashMap<>();
        Acquisto a;

        while(i.hasNext()){
            Bancarella b = i.next();

            if(Objects.isNull(min)){
                min = b;
            }else{
                if(b.getPrezzo(giocattolo, num) < min.getPrezzo(giocattolo, num)){
                    min = b;
                }
            }
        }   

        bi.put(min, num);

        try {
            min.vendi(giocattolo, num);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Qta non disponibile nella bancarella con prezzo migliore");
        }

        a = new Acquisto(bi, giocattolo, num, min.getPrezzo(giocattolo, num));
        return a;
    }


    public static void main(String args[]){
        Bancarella b = new Bancarella("Giacomo");
        Bancarella b2 = new Bancarella("Skandre");

        Set<Bancarella> set = new HashSet<>();

        Scanner s = new Scanner(System.in);

        while(s.hasNext()){
            int n = s.nextInt();
            String g = s.next();
            String m = s.next();
            int p = s.nextInt();

            Giocattolo gi = new Giocattolo(g, m);
            b.aggiungiGiocattolo(gi, n);
            b.aggiornaListino(gi, p);
        }
        s.close();
        b2.aggiungiGiocattolo(new Giocattolo("bilia", "metallo"), 210);
        b2.aggiornaListino(new Giocattolo("bilia", "metallo"), 10);

        set.add(b);
        set.add(b2);
        Compratore c = new CompratoreUnitario(set);

        System.out.println(c.compra(10, new Giocattolo("bilia", "metallo")));
    }
    
}
