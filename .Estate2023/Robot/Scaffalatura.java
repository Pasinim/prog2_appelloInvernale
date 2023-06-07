package Robot;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

// Ogni scaffalatura si comporta come una sorta di colonna (eventualmente vuota) di
// pacchi che vengono *depositati* sulla cima della colonna e *prelevati* dal fondo
// di essa. Altrimenti detto, il primo di una sequenza di pacchi depositati sarà il
// primo ad essere prelevato.

public class Scaffalatura {
    // variabile di istanza che rappresenta i pacchi della scaffalatura. Viene
    // definto come private
    // per non esporre la rappresentazione. Final fa in modo che non si possa
    // cambiare il riferimento alla coda
    private final LinkedList<Pacco> pacchi;

    /**
     * Inizializza una nuova scaffalatura vuota
     */
    public Scaffalatura() {
        this.pacchi = new LinkedList<>();
    }

    /**
     * Aggiunge il pacco specificato in cima a questa scaffalatura
     * 
     * @param pacco il pacco da aggiungere
     * @throws NullPointerException se il pacco specificato è nullo
     */
    public void deposita(final Pacco pacco) {
        Objects.requireNonNull(pacco, "Il pacco da depositare non può essere null");
        pacchi.add(pacco);
    }

    /**
     * Restituisce il pacco in fondo a questa scaffalatura e lo rimuove
     * 
     * @return il pacco in fondo a questa scaffalatura
     * @throws IllegalStateException se la scaffalatura è vuota
     */
    public Pacco preleva() {
        if (pacchi.isEmpty())
            throw new IllegalStateException("La scaffalatura è vuota");
        return pacchi.removeFirst();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = pacchi.size() - 1; i >= 0; i--)
            sb.append("| ")
                    .append(pacchi.get(i).toString() + " ".repeat(19 - pacchi.get(i).articolo.length()) + " |\n");
        return sb.toString();
    }

    public static void main(String[] args) {
        List<Scaffalatura> scaffali = new LinkedList<>();
        Scaffalatura s = new Scaffalatura();

        Pacco y = new Pacco("1", 4);
        Pacco j = new Pacco("2", 6);
        Pacco k = new Pacco("3", 9);

        s.deposita(y);
        s.deposita(j);
        s.deposita(k);
        scaffali.add(s);

        Scaffalatura s1 = new Scaffalatura();

        Pacco y1 = new Pacco("4", 4);
        Pacco j1 = new Pacco("5", 6);
        Pacco k1 = new Pacco("6", 9);

        s.deposita(y1);
        s.deposita(j1);
        s.deposita(k1);
        scaffali.add(s1);
        Magazzino m = new Magazzino(scaffali);
        System.out.println(m.toString());
        m.preleva(0);
        System.out.println(m.toString());

    }

}
