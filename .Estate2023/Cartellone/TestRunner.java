import java.io.FileInputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRunner {
    public static void main(String[] args) {

        System.out.println("Test");
        System.out.println("" + args[0] + args[1]);
        Cartellone c = new Cartellone(args[0], Integer.parseInt(args[1]));

        final Pattern PATTERN = Pattern
                .compile("\"(?<titolo>[^\"]+)\" (?<primo>\\d+)( (?<tipo>R|P)? (?<secondo>\\d+))?");
        try (Scanner in = new Scanner(new FileInputStream("./input-1.txt"))) {

            while (in.hasNextLine()) {
                String linea = in.nextLine();
                Matcher matcher = PATTERN.matcher(linea);
                if (!matcher.matches())
                    throw new IllegalArgumentException("Input in formato non corretto");
                String titolo = matcher.group("titolo");
                String tipo = matcher.group("tipo");
                int primo = Integer.parseInt(matcher.group("primo"));
                int secondo = tipo != null ? Integer.parseInt(matcher.group("secondo")) : -1;
                if (secondo == -1) {
                    ProgrammazioneAbs p = new ProgrammazioneSingola(titolo, primo, secondo);
                    c.aggiungiProiezione(titolo, p);
                } else if (tipo.equals("R")) {
                    ProgrammazioneAbs p = new ProgrammazioneRepliche(titolo, c.durata, primo, secondo);
                    c.aggiungiProiezione(titolo, p);
                } else if (tipo.equals("P")) {
                    ProgrammazioneAbs p = new ProgrammazionePeriodica(titolo, c.durata, primo, secondo);
                    c.aggiungiProiezione(titolo, p);
                } else {
                    throw new IllegalArgumentException("Tipo non valido");
                }
            }

        } catch (Exception ex) {
            System.out.println("Erorre scanner");
            System.err.println(ex);
        }
        System.out.println(c.toString());
    }
}
