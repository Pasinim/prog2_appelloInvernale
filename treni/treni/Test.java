public class Test {
    public static void main(String[] args) {
        Dotazione f = new Dotazione("Finestra", 2);
        Vagone v = new Vagone("uno", 100);
        System.out.println(v.toString());
        v.add_dotazione(f);
        System.out.println(v.toString());
    }
}
