import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

/**
 * Le istanze di questa classe immutabile rappresentano una tavola periodica
 */

public class TavolaPeriodica {
    /**
     * AF: per ogni elemento i presente in tp: i.simbolo, i.peso
     * RI: tp.keySet() != null && tp.values() != null
     * && tp.keySet().size() == tp.values().size()
     */

    // Varaibile di istanza che associa ad ogni simbolo il corrispettivo elemento
    private final Map<String, Elemento> tp;

    /**
     * Inizializza una nuova tavola periodica prendendo come input una lista di
     * elementi.
     * Se l'elemento è già presente nella tavola periodica viene sollevata
     * un'eccezione.
     * 
     * @param elementi elementi della tavola periodica
     * @throws NullPointerException     se elementi è null
     * @throws NullPointerException     se elementi contiene elementi null
     * @throws IllegalArgumentException se elementi contiene simboli duplicati
     */
    public TavolaPeriodica(List<Elemento> elementi) {
        Objects.requireNonNull(elementi, "La lista non può essere null");
        tp = new HashMap<>();
        for (int i = 0; i < elementi.size(); i++) {
            Objects.requireNonNull(elementi.get(i), "L'elemento " + i + " non può essere null");
            if (tp.containsKey(elementi.get(i).simbolo))
                throw new IllegalArgumentException("L'elemento " + i + " è già presente nella tavola periodica");
            tp.put(elementi.get(i).simbolo, elementi.get(i));
        }
    }

    /**
     * Restituisce l'elemento con il simbolo specificato.
     * 
     * @param s il simbolo
     * @return Elemento con il simbolo s
     * @throws NullPointerException          se s è null
     * @throws IllegalArgumentException      se s è vuota
     * @throws UnsupportedOperationException se s non è presente nella tavola
     *                                       periodica
     */
    public Elemento getElemento(String s) {
        Objects.requireNonNull(s, "Il simbolo non può essere null");
        if (s.length() == 0)
            throw new IllegalArgumentException("Il simbolo non può essere vuoto");
        if (!tp.containsKey(s))
            throw new UnsupportedOperationException("Il simbolo non è presente nella tavola periodica");
        return tp.get(s);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Elemento> entry : tp.entrySet()) {
            sb.append(entry.getValue().toString() + ", " + entry.getValue().peso);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        List<Elemento> elementi = new ArrayList<>();
        try (Scanner in = new Scanner(new FileInputStream("./input.txt"))) {
            for (int i = 0; in.hasNextLine(); i++) {
                String tkns[] = in.nextLine().split(" ");
                // System.out.println(tkns.toString());
                Elemento e = new Elemento(tkns[0], tkns[1], Double.parseDouble(tkns[2]), i);
                elementi.add(e);
            }
        } catch (Exception ex) {
            System.out.println("Erorre scanner");
            System.err.println(ex);
        }

        System.out.println(new TavolaPeriodica(elementi));
    }

}
