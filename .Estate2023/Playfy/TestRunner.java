
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestRunner {
    public static void main(String[] args) {
        List<String> brani = new ArrayList<>();
        List<Durata> durate = new ArrayList<>();
        List<Album> albums = new ArrayList<>();
        try (Scanner in = new Scanner(new FileInputStream("./input.txt"))) {
            String firstLine = in.nextLine();
            // System.out.println(firstLine);
            String[] tkns = firstLine.split("ALBUM");
            String titAlbum = tkns[1].trim();
            while (in.hasNextLine()) {
                String line = in.nextLine();
                if (line.equals("."))
                    break;
                String brano[] = line.split("-");
                String durataString[] = brano[0].trim().split(":");
                Durata d = new Durata(Integer.parseInt(durataString[0]) * 60 + Integer.parseInt(durataString[1]));
                durate.add(d);
                brani.add(brano[1].trim());

            }

            Album a = new Album(brani, durate, titAlbum);
            albums.add(a);
            
        } catch (Exception ex) {
            System.out.println("Erorre scanner");
            System.err.println(ex);
        }

    }
}
