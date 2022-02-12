import java.util.*;
public class TestRunner {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String line = in.nextLine();
            String tokens[] = line.split(" ");
            switch (tokens[0]){
                case "S":
                    break;
                case "G":
                    break;
                case "&":
                    break;
                case "|":
                    break;
                case "^":
                    break;
                default:
                    break;
            }
        }
        in.close();
    }
}
