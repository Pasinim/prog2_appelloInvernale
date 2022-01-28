import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> titoli_canzoni = new ArrayList<>();
        List<Durata> durate_canzoni = new ArrayList<>();
        List<Album> albums = new ArrayList<>();
        String titolo, titoloPlaylist = "";
        
        while (input.hasNext()){
            String line = input.nextLine();
            if (line.charAt(0) == '.'){
                Album a = new Album(titolo, titoli_canzoni, durate_canzoni);
                albums.add(a);
                break;
            } 
            String cmd[] = line.split(" ", 2); //aggiungendo 2 lo fa solo una volta, creando un array lungo 2
            if (cmd[0].equals("ALBUM")){
                titolo = cmd[1];
                continue;
            }

            if (cmd[0].equals("PLAYLIST")){
                titolo = cmd[1];
                continue;
            }

            String song[] = line.split(" - ");
            String durata = song[0]; //.replace(" ", ""); //per ignorare tutti i whitespaces prima della durata
            durate_canzoni.add(new Durata(durata));
            titoli_canzoni.add(song[1]);
    }
        input.close();
        Iterator<Album> it = albums.iterator();
        while (it.hasNext()){
            System.out.println(it.next().toString());
        }
    }
}
