import java.util.List;
/**
 * OVERVIEW: le istanze di questa classe rappresentano una lista di interi
 *             gli oggetti sono immutabili.
 *              intList è una sequenza [x1, x2, ..., xn]
 */
public abstract class maxMinIntList extends IntList {
    //CAMPI 
    private List<Integer> list;
    private int max, min;

    //COSTRUTTORI
    public maxMinIntList(){
        super();
    }

    //METODI
    public void insert(int x){
        if (size() == 0 || x >= max) max=x;
        if (size() == 0 || x <= min) min=x;
        super.insert(x);
    }

    public int smallest(){
        return this.min;
    }

    public int largest(){
        return this.max;
    }

    @Override
    protected boolean RepOK(){
        if (!super.RepOK()) return false;
        for (int i : this.list )
            if (this.max > i) return false;
        return true;
    };

    @Override
    public String toString(){
       return  super.toString();
    }   

    @Override
    public int hashCode(){
        return super.hashCode();
    }


}