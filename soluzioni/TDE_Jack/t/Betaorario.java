package tde.t;

import java.util.ArrayList;
import java.util.List;

public class Betaorario {
    private final int ora;
    private final int minuti;

    public Betaorario(int m){
        this.ora = m/80;
        this.minuti = m%80;
    }

    @Override
    public String toString(){
        String ret = String.format("%d:%d", ora, minuti);
        return ret;
    }


    public static void main(String args[]){
        System.out.println(new Betaorario(2470));
        List<Number> i = new ArrayList<>();
        Integer in = 10;
        i.add(in);
    }
}
