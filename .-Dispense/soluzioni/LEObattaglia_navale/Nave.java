package battaglia_navale;

import java.util.*;





public class Nave{
    //OVERVIEW: la classe concreta e mutabile rappresenta una nave di un dato tipo, ha una collezzione di posizioni che rappresentano la sua posizione nell'ambiente di gioco e
    //IR: tipo!=null && !status.isEmpty() && !spazio_occupato.isEmpty() && status!=null && !spazio_occupato!=null
    //AF: AF(Nave)-> tipo.nome for(Posizione posizione:spazio_occupato) posizione.toString();
    
    //Var che rappresenta la posizione della nave all'interno dello spazio di  gioco
    public final Map<Posizione,Boolean> spazio_occupato;   

    //Var che rappresenta il tipo della nave
    public final Tipo tipo;

    //COSTRUTTORE

    //EFFECTS: istanzio una nave di tipo t in posizione p e con orientamento o
    //Se la Invariante di rappresentazione non é rispettato solleva un IllegalArgumentException
    //Se p sia null solleva una NullPointeException
    //Se o!='V' && o!='O'
    public Nave(Tipo t,Posizione p,char o){ 

        if(p==null) throw new IllegalArgumentException("La posizione inserita NON puo essere Null");
        if(o!='V' && o!='O') throw new IllegalArgumentException("L orientamento inserito deve essere V o O");
        tipo=t;
        spazio_occupato=new HashMap<>();
        for(int i=0;i<t.len;i++){
            if(o=='V'){
                spazio_occupato.put(new Posizione(p.colonna, (p.riga+i) ),false );
            }else{
                spazio_occupato.put(new Posizione( (char)(((int) p.colonna)+i) , p.riga), false );
            }
            
        }
      
        if(!repOk()){
            if(tipo==null) throw new IllegalArgumentException("Il tipo della nav e non puo essere nullo");
            throw new IllegalArgumentException("Errore nell'assegnare lo spazio della nave");
       }
    }



    //METODI

    public boolean repOk(){
        if( tipo==null || spazio_occupato.isEmpty() || spazio_occupato==null ) return false;
        return true ;
    }

    //MODIFIES:this.spazio_occupato
    //EFFECTS:Va a fara andare a segno il colpo in p andandone a modificare il valore da false a true
    //Se p non appartiene alla nave solleva una IllegalArgumen Exeption
    public void hit(Posizione p){
        //if(spazio_occupato.containsKey(p)) throw new IllegalArgumentException("Il punto non appartiene alla nave");
        
        spazio_occupato.replace(p,true);
        
    }

   //EFFECTS: se tutte 
   public boolean destroy(){
        for(Map.Entry<Posizione, Boolean> entry : spazio_occupato.entrySet()) {
            if(entry.getValue()!=true) return false;
        }
        return true;
   }



    @Override
    public String toString(){
        String s=""+tipo.nome+"[";
        for(Map.Entry<Posizione, Boolean> entry : spazio_occupato.entrySet()) {
            s+=entry.getKey().toString()+" Status: "+entry.getValue()+", ";
        }
        s+="]";
        return s;

    }
}
