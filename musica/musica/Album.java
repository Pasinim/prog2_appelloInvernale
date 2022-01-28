import java.util.*;
/**
 * OVERVIEW:
 */

public class Album {
    public final String titolo;
    public final List<Album.Brano> brani = new ArrayList<>();
    public final List<Durata> durate;

    public Album (String t, List<String> titoli, List<Durata> d){
        this.titolo = Objects.requireNonNull(t);
        this.durate = Objects.requireNonNull(d);
        Objects.requireNonNull(titoli);
        if (titoli.size() != d.size()) throw new IllegalArgumentException("Titoli e durate dei brani devono avere la stessa dimensione");
        for(int i=0; i < d.size(); i++){
            if ((d.get(i)) == null || titoli.get(i) == null || titoli.get(i).isEmpty())
                throw new NullPointerException();
            brani.add(new Brano(titoli.get(i), d.get(i)));
        }
    }

    public Album.Brano getBrano(int idx){
        return this.brani.get(idx);
    }
        
    @Override
    public String toString(){
        String str = "Titolo album: ";
        str += this.titolo.toString() + "\n";
        Durata somma = new Durata(0);
        Iterator<Brano> it = brani.iterator();
        for (int i = 1; i <= brani.size(); i++){
            Album.Brano curr = it.next();
            //if (!(it.hasNext())) throw new IllegalAccessError();
            str += String.format("%d - %s \n", i, curr.toString());
            somma = somma.sommaDurata(curr.durata);
        }
        str += "Durata totale: " + somma.toString() + "\n";
        return str;
    }
    

    class Brano {
        public final String titolo;
        public final Durata durata;

        /**
         * Inizializza un nuovo brano contenuto in this
         * @param t
         * @param d
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
