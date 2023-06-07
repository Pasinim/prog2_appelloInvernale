import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

/**
 * Le istanze di questa classe immutabile rappresentano una molecola.
 */

public class Molecola {

    /**
     * IR: elementiMolecola != null && tp != null
     * AF: Formula molecola, peso della molecola, "Semplice" o "Composta"
     */

    /**
     * Varaibili di instanza, vengono dichiarate final per garantire l'immutabilità
     */
    private final Map<Elemento, Integer> elementiMolecola;
    public final TavolaPeriodica tp;

    /**
     * Inizializza una nuova molecola.
     * 
     * @param formula formula della molecola
     * @throws IllegalArgumentException se la formula non è nel formato corretto
     * @throws NullPointerException     se la formula è null
     * @throws NullPointerException     se tavola è null
     */
    public Molecola(TavolaPeriodica tavola, String formula) {
        Objects.requireNonNull(formula);
        Objects.requireNonNull(tavola, "La tavola periodica non può essere null");
        String[] els = Helpers.parseFormula(formula);
        tp = tavola;
        elementiMolecola = new HashMap<Elemento, Integer>();
        for (int i = 0; i < els.length; i += 2) {
            Elemento e = tp.getElemento(els[i]);
            int n = Integer.parseInt(els[i + 1]);
            elementiMolecola.put(e, n);
        }
    }

    /**
     * Restituisce il peso della molecola.
     * @return peso della molecola
     */
    public double getPeso() {
        double peso = 0;
        for (Map.Entry<Elemento, Integer> entry : elementiMolecola.entrySet()) {
            Elemento e = entry.getKey();
            peso += e.peso * entry.getValue();
        }
        return peso;
    }

    /**
     * Restituisce true se la molecola è semplice, false altrimenti.
     * @return true se la molecola è semplice, false altrimenti
     */
    public boolean isSemplice() {
        return elementiMolecola.size() == 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Elemento, Integer> entry : elementiMolecola.entrySet()) {
            Elemento e = entry.getKey();
            if (entry.getValue() > 1)
                sb.append(e.toString() + entry.getValue());
            else
                sb.append(e.toString());
        }
        sb.append(", " + getPeso() + ", ");
        sb.append(isSemplice() ? "Semplice" : "Composta");
        sb.append(System.lineSeparator());
        return sb.toString();
    }

    public static void main(String[] args) {
        List<Elemento> elementi = new ArrayList<>();
        try (Scanner in = new Scanner(new FileInputStream("./Belzerius/input.txt"))) {
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
        TavolaPeriodica tp = new TavolaPeriodica(elementi);
        System.out.println(tp);
        System.out.println("________________");
        Molecola m = new Molecola(tp, "NaCl");
        System.out.println(m.toString());
    }

}
