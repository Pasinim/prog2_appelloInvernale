

public class test {
    // + agg, - remove 
    public static void main(String[] args) {
        SimpleMap m = new SimpleMap();
        m.put("cane", 1);
        m.put("cia", 12);
        m.put("cane", 10);

        SimpleMap p = new SimpleMap();
        p.put("cane", 1);
        p.put("cia", 12);
        p.put("cane", 10);
        System.out.println(m.toString());
        System.out.println(p.toString());
        System.out.println(m.equals(p));
        
    }
}
