package battaglia_navale;

import java.util.*;
public class Tipo {
    //OVERVIEW:classe concreata e immutabile rappresenta un tipo di nave tra le possibili definite dalla collezzione presente nella classe
    //IR: tipi_possibili.contaiKey(nome) && len==tipi_possibili.get(nome);
    //AF: AF(Tipo)-> nome len

    public final char nome;
    public final int len;
    private static final Map<Character,Integer> tipi_possibili= new HashMap<Character,Integer>(){{
        put('P',8);
        put('C',2);
        put('S',5);
        put('F',7);

    }};

    //COSTRUTTORI

    //EFFECTS:istanzia una variabile Tipo del tipo c
    //Se l'invariante di rappresentanza non é rispettato solleva IllegalArgumetnException;
    public Tipo(char c){
        nome=c;
        len=tipi_possibili.get((Character) c);
        if(!repOk()){
            if(tipi_possibili.containsKey((Character)nome)==false) throw new IllegalArgumentException("Il tipo selezionato non é corretto");
            if( len!=tipi_possibili.get(( Character)nome)) throw new TypeLenException("Errore nell'istanziamento del tipo");
        }
    }


    //METODI

    public boolean repOk(){
        if( (tipi_possibili.containsKey((Character)nome)==false) || ( len!=tipi_possibili.get(( Character)nome)) )return false;
        return true;
    }

    @Override
    public String toString(){
        String s="tipo:"+ nome +"lunghezza:"+len;
        return s;
    }
}
