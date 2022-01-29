import java.util.*;
/**
 * OVERVIEW: Le istanze di questa classe rappresentano una playlist, identificata da un nome
 * da un insieme di brani e da una durata complessiva, ottenuta dalla somma di tutti i brani che la
 * compongono
 * AF
 * IR:
 *      nome != null, nome non vuoto.
 *      brani != null
 *      durata totale >= 0
 */
public class Immutabile_Playlist implements Iterable<Album.Brano>{
    /**
     * VARIABILI DI ISTANZA:
     * La classe è immutabile, per questo motivo sia brani che durata_totale
     * vengono dichaiarate come private final. Final impedisce che il rigerimento alla varabile
     * cambi mentre private impedisce ad un utente di aggiungere elementi alla lista oppure
     * di sommare altre durate a durata_totale.
     */
    public final String nome;
    private final List<Album.Brano> brani;
    private final Durata durata_totale;

    
    public Immutabile_Playlist(String n, List<Album.Brano> b){
        if (n.isEmpty()) throw new IllegalArgumentException();
        this.nome = Objects.requireNonNull(n);
        this.brani = Objects.requireNonNull(b);
        Iterator<Album.Brano> it = b.iterator();
        Durata sum = new Durata(0);
        while (it.hasNext())
            sum = sum.sommaDurata(it.next().durata);
        durata_totale = sum;
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
        return this.durata_totale;
    }


    /** Restituisce una nuova playlist ottenuta unendo this con o.
     * L'ordine dei brani è uguale all'ordine in this seguita dai brani (nello stesso ordine)
     * in o. Se dei brani sono già presenti NON vengono reinseriti nuovamente 
     * @param s Titolo della playlist
     * @param o Playlist da fondere
     * @return Playlist fusa
     * @throws NullPointer se o == null
     */
    public Immutabile_Playlist unisci(String s, Immutabile_Playlist o){
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
        return new Immutabile_Playlist(s, brani_fusi) ;
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
