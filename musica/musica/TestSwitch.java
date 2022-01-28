import java.util.*;
public class TestSwitch {
    public static void main(String[] args) {
        List<String> titoli_canzoni = new ArrayList<>();
        List<Durata> durate_canzoni = new ArrayList<>();
        List<Album> albums = new ArrayList<>();
        List<Playlist> plays = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()){
            //System.out.println("Ciclo principale:");
            String line = input.nextLine();
            String cmd[] = line.split(" ", 2);
            switch (cmd[0]){
                case "ALBUM":{
                    String titolo = cmd[1];
                    
                    while (input.hasNextLine() ){
                        line = input.nextLine();
                        //System.out.println("\t\t" + line.charAt(0));
                        if (line.charAt(0) == '.') break;
                        String canzone[] = line.split(" - ");
                        Durata durata = new Durata(canzone[0]);
                        durate_canzoni.add(durata);
                        titoli_canzoni.add(canzone[1]);
                        
                    }
                    Album a = new Album(titolo, titoli_canzoni, durate_canzoni);
                    albums.add(a);
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
                        Album a = albums.get(numero_album - 1);
                        brani_playlist.add(a.getBrano(numero_canzone - 1));

                    }
                    Playlist p = new Playlist(titolo, brani_playlist, durate_canzoni);
                    plays.add(p);
                    break;

                }
                default:{

                }

            }
        }
        input.close();
        Iterator<Playlist> it = plays.iterator();
        while (it.hasNext())
            System.out.print(it.next().toString());
    }
}
