import javax.swing.RowFilter.Entry;

import java.util.*;
public class File extends Entryy {
    private final Set<Entryy> path;
    private int size;

    public File(String s, SortedSet<Entryy> e, int size){
        super(s);
        Objects.requireNonNull(e);
        if (Arrays.asList(e).contains(null)) 
            throw new NullPointerException("Una entryy è null");
        if (size < 0) throw new IllegalArgumentException("La dimensione deve essere positiva");
        path = new SortedSet<Entryy>() {
            
        };

    }
    @Override
    public int dim() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String[] path_assoluto() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String[] path_relativo() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isDir() {
        // TODO Auto-generated method stub
        return false;
    }
    
}
