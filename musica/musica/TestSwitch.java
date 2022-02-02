import java.util.*;

public class TestSwitch {
    public static void main(String[] args) {
        List<String> titoli_canzoni = new ArrayList<>();
        List<Durata> durate_canzoni = new ArrayList<>();
        List<Album> albums = new ArrayList<>();
        List<Immutabile_Playlist> plays = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()){
            //System.out.println("Ciclo principale:");
            String line = input.nextLine();
            String cmd[] = line.split(" ", 2);
            switch (cmd[0]){
                case "ALBUM":{
                    String titolo = cmd[1];
                    //System.out.println("\tAGGIUNGO ALBUM " + titolo.toString() + "\n");
                    while (input.hasNextLine() ){
                        line = input.nextLine();
                        if (line.charAt(0) == '.') break;
                        String canzone[] = line.split(" - ");
                        Durata durata = Durata.str_to_Durata(canzone[0]);
                        durate_canzoni.add(durata);
                        titoli_canzoni.add(canzone[1]);  
                    }
                    Album a = new Album(titolo, titoli_canzoni, durate_canzoni);
                    albums.add(a);
                    //devo svuotare le liste altrimenti le aggiunge anche all'album seguente
                    titoli_canzoni.clear();
                    durate_canzoni.clear();
                    break;
                }

                case "PLAYLIST":{     
                    List <Album.Brano> brani_playlist = new ArrayList<>();
                    String titolo = cmd[1];    
                    while (input.hasNextLine() ){
                        line = input.nextLine();
                        //System.out.println("\t\t" + line.charAt(0));
                        if (line.charAt(0) == '.') break;
                        String nums[] = line.split(" ");
                        int numero_album = Integer.parseInt(nums[0]);
                        int numero_canzone = Integer.parseInt(nums[1]);
                        //System.out.println(String.format("\tAggiungo alla playlist \"%s\", la traccia %d dell'album %d, ossia %s di %s\n",
                         //                   titolo.toString(), numero_canzone, numero_album, albums.get(numero_album-1).getBrano(numero_canzone - 1), albums.get(numero_album - 1).titolo.toString()));
                        Album a = albums.get(numero_album - 1);
                        brani_playlist.add(a.getBrano(numero_canzone - 1));  
                    }
                    Immutabile_Playlist p = new Immutabile_Playlist(titolo, brani_playlist);
                    plays.add(p);
                    break;

                }
                default:{

                }

            }
        }
        input.close();
        Iterator<Immutabile_Playlist> it = plays.iterator();
        while (it.hasNext())
            System.out.print(it.next().toString());
        //
        //System.out.println("\tAAAAAAAAAAAAAAAAAA " + albums.get(1).getBrano(0).toString() + "\n");
        //System.out.println("________" + albums.get(1).toString() + "\n\n");
        List<Album> test = plays.get(0).getAlbum();
        Iterator<Album> ita = test.iterator();
        while (ita.hasNext())
            System.out.println("________" + ita.next().titolo.toString() + "\n\n");
    }

}
