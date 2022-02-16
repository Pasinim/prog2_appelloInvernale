
import java.util.*;
public class Directory extends Entryy {
    public Directory(String s, SortedSet<Entryy> path){
        super(s);
        Objects.requireNonNull(path);
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
