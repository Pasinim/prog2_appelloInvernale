import java.util.*;
/**
 * 
 */
public class Playlist {
    public final String nome;
    public final List<Album.Brano> brani;
    public final List<Durata> durate;

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
            if (ret.contains(b)) continue;
            else ret.add(b.getAlbum());
        }
        return ret;
    }
}
