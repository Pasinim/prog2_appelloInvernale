import java.io.FileInputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRunner {
    public static void main(String[] args) {
        // Programmazione p = new ProgrammazioneSingola(1);
        String aa = "x Cartellone 30";
        String[] ts = aa.split(" ");
        // String titolo = args[1];
        // int durata = Integer.parseInt(args[2]);
        Cartellone c = new Cartellone(ts[1], Integer.parseInt(ts[2]));
        try (Scanner in = new Scanner(new FileInputStream("./input-1.txt"))) {
            for (int i = 0; in.hasNextLine(); i++) {

                final Pattern PATTERN = Pattern
                        .compile("\"(?<titolo>[^\"]+)\" (?<primo>\\d+)( (?<tipo>R|P)? (?<secondo>\\d+))?");

                Matcher matcher = PATTERN.matcher(in.nextLine());
                if (!matcher.matches())
                    throw new IllegalArgumentException("Input in formato non corretto");
                String titolo = matcher.group("titolo");
                String tipo = matcher.group("tipo");
                int primo = Integer.parseInt(matcher.group("primo"));
                int secondo = tipo != null ? Integer.parseInt(matcher.group("secondo")) : -1;
                if (secondo == -1) {
                    Programmazione p = new ProgrammazioneSingola(primo);
                    Cartellone.Proiezione pc = c.new Proiezione(titolo, p);
                    c.aggiungi(pc, primo);
                } else if (tipo.equals("R")) {
                    Programmazione x = new ProgrammazioneRepliche(primo, secondo);
                    Cartellone.Proiezione pc = c.new Proiezione(titolo, x);
                    c.aggiungi(pc, primo);

                } else if (tipo.equals("P")) {
                    Programmazione y = new ProgrammazionePeriodica(primo, secondo);
                    Cartellone.Proiezione pc = c.new Proiezione(titolo, y);
                    c.aggiungi(pc, primo);
                }
            }
            System.out.println(c.toString());
            System.out.println(c.getProiezioniOrdineGiorno().toString());
            System.out.println(c.getProiezioniOrdineGiorno().toString());
        } catch (Exception ex) {
            System.out.println("Erorre scanner");
            System.err.println(ex);
        }
    }
}
