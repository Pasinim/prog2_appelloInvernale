import java.util.*;

public class TestRunner {
    public static void main(String[] args) {
        List<String> t = new ArrayList<>();
        List<Durata> d = new ArrayList<>();
        t.add("ciao");
        t.add("cane super");

        d.add(new Durata(9000));
        d.add(new Durata(400));

        Album a = new Album("cani buffi", t , d);
        //System.out.println(a.toString());
        Album a2 = new Album("mucche nere", t , d);
        Album.Brano b = a.new Brano("pippo", new Durata(90));
        Album.Brano b2 = a2.new Brano("luca", new Durata(90));

        System.out.println(b.toString());
        System.out.println(b.getAlbum().titolo.toString());
        System.out.println(b2.getAlbum().titolo.toString());

        Playlist p = new Playlist("eeeeeee", t, d);
        System.out.println(p.getBrani(a).toString());


    }
}
