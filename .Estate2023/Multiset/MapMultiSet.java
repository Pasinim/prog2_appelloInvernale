package Multiset;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class MapMultiSet implements StringMultiSet {

    private final Map<String, Integer> map;

    public MapMultiSet() {
        map = new HashMap<>();
    }

    @Override
    public Iterator<String> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int remove(String s) {
        Objects.requireNonNull(s, "String cannot be null");
        if (s.isEmpty())
            throw new IllegalArgumentException("String cannot be empty");
        int ret = multiplicity(s);
        if (ret > 0)
            map.put(s, ret - 1);
        else if (ret == 0)
            map.remove(s);
        return ret;
    }

    @Override
    public boolean contains(String s) {
        Objects.requireNonNull(s, "String cannot be null");
        if (s.isEmpty())
            throw new IllegalArgumentException("String cannot be empty");
        return map.containsKey(s);
    }

    @Override
    public int add(String s) {
        Objects.requireNonNull(s, "String cannot be null");
        if (s.isEmpty())
            throw new IllegalArgumentException("String cannot be empty");
        if (!(contains(s)))
            map.put(s, 1);
        else
            map.put(s, map.get(s) + 1);
        return multiplicity(s);
    }

    @Override
    public int multiplicity(String s) {
        Objects.requireNonNull(s, "String cannot be null");
        if (s.isEmpty())
            throw new IllegalArgumentException("String cannot be empty");
        if (map.containsKey(s))
            return map.get(s);
        else
            return 0;
    }

    @Override
    public int size() {
        int sum = 0;
        for (Integer value : map.values()) {
            sum += value;
        }
        return sum;
    }

    @Override
    public StringMultiSet union(StringMultiSet o) throws NullPointerException {
        Objects.requireNonNull(o, "StringMultiSet cannot be null");
        StringMultiSet ret = new MapMultiSet();

        Iterator<String> it = o.iterator();
        while (it.hasNext()) {
            String curr = it.next();
            for (int i = 0; i < o.multiplicity(curr); i++) {
                ret.add(curr);
            }
        }
        it = this.iterator();
        while (it.hasNext()) {
            String curr = it.next();
            for (int i = 0; i < this.multiplicity(curr); i++) {
                ret.add(curr);
            }

        }
        return ret;
    }

    @Override
    public StringMultiSet intersection(StringMultiSet o) throws NullPointerException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'intersection'");
    }

    // 6 {tre: 3, uno: 2, due: 1}
    // 5 {due: 2, tre: 2, quattro: 1}
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(size() + " {");
        Iterator<String> it = this.iterator();
        while (it.hasNext()) {
            String curr = it.next();
            sb.append(curr + " : " + multiplicity(curr) + ", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("}\n");
        return sb.toString();

    }

    // tre uno due uno tre tre
    // quattro due tre tre due
    public static void main(String[] args) {
        List<MapMultiSet> s = new ArrayList<>();

        // MapMultiSet m = new MapMultiSet();
        // m.add("tre");
        // m.add("uno");
        // m.add("due");
        // m.add("uno");
        // System.out.println(m.toString());

        try (Scanner in = new Scanner(new FileInputStream("./.Estate2023/Multiset/input.txt"))) {
            for (int i = 0; in.hasNextLine(); i++) {
                MapMultiSet m = new MapMultiSet();
                String tkns[] = in.nextLine().split(" ");
                for (int j = 0; j < tkns.length; j++) {
                    m.add(tkns[j]);
                }
                s.add(m);
            }
        } catch (Exception ex) {
            System.out.println("Erorre scanner");
            System.err.println(ex);
        }
        for (MapMultiSet m : s)
            System.out.println(m.toString());

        StringMultiSet m = s.get(0);
        StringMultiSet n = s.get(1);
        StringMultiSet z = m.union(n);
        System.out.print(z.toString());
    }

}
