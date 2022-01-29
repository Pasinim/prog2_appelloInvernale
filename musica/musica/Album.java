import java.util.*;
/**
 * OVERVIEW: Le istanze di questa classe rappresentano un album, identificato da un titolo, da un insieme di brani e da un insieme di corrispondenti durate.
 *           Le istanze di questa classe sono immutabili, per questo motivo viene controllato IR solamente nel costruttore.
 * AF
 * IR: 
 *      titolo != NULL, titolo non vuoto
 *      brani != NULL, durate != NULL
 *      durata complessiva > 0 (viene però controllato quando sommo tutte le durate)
 */

public class Album implements Iterable<Album.Brano> {
    public final String titolo;
    //Le liste sono dichiarate come private dato che la rappresentazione non deve essere esposta
    //e un utente non può aggiungere/rimuovere brani a piacimento dall'album
    private final List<Album.Brano> brani = new ArrayList<>();
    private final Durata durata_complessiva;


    /**
     * Inizializza un nuovo album contenente i titoli dei brani con le corrispondenti durate
     * @param t Titolo dell'album
     * @param titoli Titoli delle canzoni che compongono l'album
     * @param d Durate delle canzoni che compongono l'album
     * @throws NullPointerException se titoli o d sono nulll 
     *                              un elemento all'interno di titoli o d è null
     *                              un elemento di titoli è una stringa vuota
     *                              se titolo è null o è una stringa vuota
     * @throws IllegalArgument se titoli e d hanno due lunghezze differenti
     */

    public Album (String t, List<String> titoli, List<Durata> d){
        this.titolo = Objects.requireNonNull(t);
        Objects.requireNonNull(d);
        Objects.requireNonNull(titoli);
        Durata d_totale = new Durata(0);
        if (titoli.size() != d.size()) throw new IllegalArgumentException("Titoli e durate dei brani devono avere la stessa dimensione");
        for(int i=0; i < d.size(); i++){
            if ((d.get(i)) == null || titoli.get(i) == null || titoli.get(i).isEmpty())
                throw new NullPointerException();
            brani.add(new Brano(titoli.get(i), d.get(i)));
            d_totale = d_totale.sommaDurata(d.get(i));
        }
        durata_complessiva = d_totale;
    }

    /**
     * @param idx indice
     * @return brano di indice idx all'interno di this
     * @throws IllegalArgumentException se idx > brani.size o se idx < 0
     */
    public Album.Brano getBrano(int idx){
        if (idx > brani.size() || idx < 0) throw new IllegalArgumentException("Errore nell'indice");
        return this.brani.get(idx);
    }
        
    @Override
    public String toString(){
        String str = "";
        str += String.format("Titolo album: %s\n", this.titolo.toString());
        Iterator<Brano> it = brani.iterator();
            for (int i = 1; it.hasNext(); i++)
                str += String.format("%d - %s \n", i, it.next().toString());
        str += "Durata totale: " + durata_complessiva.toString() + "\n";
        return str;
    }

    /**
     * Restituisce un iteratore che itera sui brani dell'album
     * @return iteratore
     */
    @Override
    public Iterator<Album.Brano> iterator() {
      return brani.iterator();
    }
      
    /**
     * Le istanze di questa classe interna rappresentano un brano. Creando questa classe come interna è possibile creare un brano solamente
     * se viene "associato" ad un album. Ogni brano è identificato da un titolo e da una durata
     * AF:
     * IR:  
     *      titolo != NULL, titolo non vuoto
     *      durata != null
     */
    class Brano {
        public final String titolo;
        public final Durata durata;
        /**
         * Inizializza un nuovo brano contenuto appartenente a this
         * @param t titolo del brano
         * @param d durata del brano
         * @throws NullPointerException se d o t sono null
         * @throws IllealArgumentExc se t è vuota
         */
        public Brano(String t, Durata d){
            this.titolo = Objects.requireNonNull(t);
            this.durata = Objects.requireNonNull(d);
            if (t.isEmpty()) throw new IllegalArgumentException();
        }
        /**
         * Restituisce l'album di this
         * @return Album.this
         */
        public Album getAlbum(){
            return Album.this;
        }

        @Override
        public String toString(){
            String str = String.format("\"%s\" (%s)", titolo.toString(), this.durata.toString());
            return str;
        }
    }

}
