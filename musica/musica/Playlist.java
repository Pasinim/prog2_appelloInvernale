import java.util.*;
/**
 * 
 */
public class Playlist implements Iterable<Album.Brano>{
    public final String nome;
    private final List<Album.Brano> brani;
    private final List<Durata> durate;

    public Playlist(String n, List<Album.Brano> b, List<Durata> d ){
        if (n.isEmpty()) throw new IllegalArgumentException();
        this.nome = Objects.requireNonNull(n);
        this.brani = Objects.requireNonNull(b);
        this.durate = Objects.requireNonNull(d);
    }

    public List<Album.Brano> getBrani(){
        return this.brani;
    }

    /**
     * Restituisce tutti i brani che appartengono all'album a
     * @param a
     */
    public List<Album.Brano> getBrani(Album a){
        List<Album.Brano> ret = new ArrayList<>();
        Iterator<Album.Brano> it = brani.iterator();
        while (it.hasNext()){
            Album.Brano b = it.next();
            if (a.equals(b.getAlbum()))
                ret.add(b);
        }
        return ret;
    }
    /**
     * Restituisce tutti gli album contenuti in this
     */
    public List<Album> getAlbum(){
        List<Album> ret = new ArrayList<>();
        Iterator<Album.Brano> it = brani.iterator();
        while (it.hasNext()){
            Album.Brano b = it.next();
            if (ret.contains(b.getAlbum())) continue;
            else ret.add(b.getAlbum());
        }
        return ret;
    }

    /**
     * @return Durata totale della playlist
     */
    public Durata getDurata(){
        Iterator<Durata> it = durate.iterator();
        Durata somma = new Durata(0);
        while (it.hasNext())
            somma = it.next().sommaDurata(somma);
        return somma;
    }


    /** Restituisce una nuova playlist ottenuta unendo this con o.
     * L'ordine dei brani è uguale all'ordine in this seguita dai brani (nello stesso ordine)
     * in o. Se dei brani sono già presenti NON vengono reinseriti nuovamente 
     * @param s Titolo della playlist
     * @param o Playlist da fondere
     * @return Playlist fusa
     * @throws NullPointer se o == null
     */
    public Playlist unisci(String s, Playlist o){
        Objects.requireNonNull(o);
        Objects.requireNonNull(s);
        ArrayList<Album.Brano> brani_fusi = new ArrayList<>();
        brani_fusi.addAll(this.brani);

        Iterator<Album.Brano> it = o.iterator();
        while (it.hasNext()){
            Album.Brano b = it.next();
            if (!(brani_fusi.contains(b))) 
            brani_fusi.add(b);
        }
        Durata durata_tot = this.getDurata().sommaDurata(o.getDurata());
        return new Playlist(s, brani_fusi, durata_tot);
    }

    /**
     * è ridondante? Lo ho già in album, devo ridefinirlo
     */
    public Iterator<Album.Brano> iterator() {
        return brani.iterator();
    }

    @Override
    public String toString(){
        String str = "Nome playlist: " + this.nome + "\n";
        Durata somma = new Durata(0);
        Iterator<Album.Brano> it = brani.iterator();
        for (int i = 1; i <= brani.size(); i++){
            Album.Brano curr = it.next();
            str += String.format("%d - %s, (da \"%s\") \n", i, curr.toString(), curr.getAlbum().titolo.toString());
            somma = somma.sommaDurata(curr.durata);
        }
        str += "Durata totale: " + somma.toString() + "\n\n";
        return str;
    }
}
