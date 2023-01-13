import java.util.ArrayList;
import java.util.List;
public class Test2 {
    public static void main(String[] args) {
        // List<String> t= new ArrayList<String>();
        // t.add("a");
        // t.add("cane");
        // t.add("blabla");
        // System.out.println(t.indexOf("ce"));

        Simplemap map = new Simplemap();
        map.put("cane", 1);
        map.put("cae", 2);
        map.put("cne", 3);
        map.put("caae", 56);
        System.out.println(map.toString());
        map.put("ciao", 6);
        map.remove("ciao");
        System.out.println(map.toString());

    }
}   
