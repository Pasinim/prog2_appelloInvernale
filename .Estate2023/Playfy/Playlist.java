import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/**
 * Le istanze di questa classe mutabile rappresentano un elenco di brani
 */
public class Playlist implements Iterable<Album> {

    /**
     * IR:
     * AF:
     */

    private final List<Album.Brano> brani;

    public Playlist() {
        this.brani = new ArrayList<Album.Brano>();
    }

    /**
     * Inizializza una nuova playlist partendo da una Lista di brani
     * 
     * @param brani lista di brani
     * @throws NullPointerException se la lista dei brani è nulla
     */
    public Playlist(List<Album.Brano> brani) {
        Objects.requireNonNull(brani, "La lista dei brani non può essere nulla");
        this.brani = new ArrayList<Album.Brano>(brani);
    }

    /*
     * Restituisce tutti brani della playlist
     */
    public List<Album.Brano> getBrani() {
        return brani;
    }

    /**
     * Restituisce i bravi appartententi all'album specificato
     * 
     * @param a album di cui si vogliono i brani
     * @return lista dei brani dell'album
     * @throws NullPointerException se l'album è nullo
     */
    public List<Album.Brano> getBrani(Album a) {
        Objects.requireNonNull(a, "L'album non può essere nullo");
        List<Album.Brano> braniAlbum = new ArrayList<Album.Brano>();
        for (Album.Brano b : brani) {
            if (b.getAlbum().equals(a))
                braniAlbum.add(b);
        }
        return braniAlbum;
    }

    /**
     * Restituisce gli album presenti nella playlist
     * 
     * @return set di album
     */
    public Set<Album> getAlbum() {
        Set<Album> albs = new HashSet<Album>();
        for (Album.Brano b : brani) {
            albs.add(b.getAlbum());
        }
        return albs;
    }

    /**
     * Restituisce una playlist ottenuta dalla fusione di this con p
     * 
     * @param p
     * @return
     */
    public Playlist fondi(Playlist p) {
        Objects.requireNonNull(p, "La playlist non può essere nulla");
        Playlist fusa = new Playlist(List.copyOf(this.brani));
        for (Album.Brano b : p.getBrani()) {
            if (fusa.brani.contains(b))
                continue;
            fusa.brani.add(b);
        }
        return fusa;
    }

    /**
     * Aggiunge un brano alla playlist
     * 
     * @param b brano da aggiungere
     * @throws NullPointerException se il brano è nullo
     */
    public void aggiungi(Album.Brano b) {
        Objects.requireNonNull(b, "Il brano non può essere nullo");
        if (brani.contains(b))
            return;
        brani.add(b);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<Album.Brano> it = brani.iterator();
        while (it.hasNext())
            sb.append(it.next().toString() + "\n");
        return sb.toString();

    }

    @Override
    public Iterator<Album> iterator() {
        return new Iterator<Album>() {
            private final Set<Album> ret     = new HashSet<>();
            private Album next = null;
            Iterator<Album.Brano> it = brani.iterator();

            @Override
            public boolean hasNext() {
                if (next != null)
                    return true;
                while (it.hasNext()) {
                    if (!(ret   .contains(it.next().getAlbum()))) {
                        next = it.next().getAlbum();
                        ret .add(next);
                        return true;
                    }
                }
                next = null;
                return false;
            }

            @Override
            public Album next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                final Album tmp = next;
                next = null;
                return tmp;
            }
        };
    }

    public static void main(String[] args) {

        List<Album> als = new ArrayList<>();
        List<String> b1 = new ArrayList<>();
        List<String> b2 = new ArrayList<>();
        b1.addAll(List.of("Che coppata", "ADORO", "CSHOPPIAMo", "DRIP MEGA"));
        b2.addAll(List.of("TRENTA", "TRENTINI", "MANGIANO", "IL TRUCIOLATO"));
        List<Durata> d1 = new ArrayList<>();
        List<Durata> d2 = new ArrayList<>();
        d1.addAll(
                List.of(new Durata("00:1:22"), new Durata("00:1:04"), new Durata("00:02:49"), new Durata("00:10:01")));
        d2.addAll(List.of(new Durata(122), new Durata(14), new Durata(24), new Durata(1000)));

        als.add(new Album(b1, d1, "FIAT Topolino"));
        als.add(new Album(b2, d2, "SCIGLISSIMI"));
        System.out.println(als.get(0).toString());
        Playlist p = new Playlist();
        p.aggiungi(als.get(0).getBrano(1));
        p.aggiungi(als.get(0).getBrano(3));
        p.aggiungi(als.get(1).getBrano(0));
        p.aggiungi(als.get(1).getBrano(2));
        System.out.println(p.toString());

    };
}
