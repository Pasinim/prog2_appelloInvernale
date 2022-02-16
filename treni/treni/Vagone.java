import java.util.*;

public class Vagone extends Rotabile{

    /**
     * datazioni è una lista ma non deve conternere elementi
     */
    private final List<Dotazione> dotazioni;
    public Vagone(final String modello, final int peso){
        super(modello, peso);
        this.dotazioni = new ArrayList<Dotazione>();
    }

    /**
     * dotazioni è una lista ma non deve conternere elementi duplicati.
     * Per questo motivo viene controllato se la dotazione è già presente e, in caso
     * positivo, procede ad aggiungere la quantità della dotazione d 
     * a quelle già presenti nella lista
     */
    public void add_dotazione(final Dotazione d){
        Objects.requireNonNull(d);
        if (dotazioni.contains(d)){
            int idx = dotazioni.indexOf(d);
            int q = dotazioni.get(idx).quantita;
            Dotazione tmp = new Dotazione(d.nome, d.quantita + q);
            dotazioni.set(idx, tmp);
        }else{
            dotazioni.add(d);
        }
    }

    public String toString(){
        String str = String.format("Vagone: modello = %s, peso = %d, dotazioni = [", getModello(), getPeso());
        return str;
        // Iterator<Dotazione> it = dotazioni.Iterator();
        // while (it.hasNext())
        //     str += it.toString();
        // return str + "]";
    }

    
    
}
