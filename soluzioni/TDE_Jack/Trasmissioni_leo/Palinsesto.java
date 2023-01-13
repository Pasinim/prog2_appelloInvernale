package trasmissioni;
import java.util.*;
public class Palinsesto {
    //OVERVIEW:La classe concreta e mutabile raccoglie le trasmissioni giornagliere di un emittente radiofonica in ordine di inizio, non vi possono essere trasmissioni sovrapposte
    //IR: Pal!=null 
    //AF: AF(Palinsesto): 
    
    Set<Trasmissione> pal;

    //COSTRUTTORE
    public Palinsesto(){
        pal=new HashSet<>();
        if(!repOk()){
            throw new NullPointerException("Il palinesento non puo essere Null");
        }
    }

    //MODIFIES: Pal
    //EFFECTS: Aggiunge a Pal la trasmissione t,se t é null solleva un IllegalArgumentException, se non rispetta l'ir Solleva un IllegalArgumentException
    public void add(Trasmissione d){
        if(d==null) throw new NullPointerException("la trasmissione d non puo esser Null");
        if(check(d)) return;
        pal.add(d);
        if(!repOk()){
            throw new NullPointerException("Il palinesento non puo essere Null");
        }
    }

    //EFFECTS: vado a controllare che la trasmissione t non si intersechi con le trasmissioni gia presenti nel palinsesto, se il palinsesto é vuoto ritorno false
    private boolean check(Trasmissione t){
        if(pal.isEmpty()) return false;
        for(Trasmissione trasmissione:pal){
            if(trasmissione.Intersaction(t)) {
                System.out.println("Intersezione");
                return true;
            }
        }
        return false;
    }

    public boolean repOk(){
        if(pal==null) return false;
        return true;
    }

   
    @Override
    public String toString(){
        Map<FasciaBetaoraria,String> trasmissioni=createMap();
        List<FasciaBetaoraria> sorted_trasmissioni= new ArrayList<>(trasmissioni.keySet());
        Collections.sort(sorted_trasmissioni);
        String s="";
        for(FasciaBetaoraria fascia:sorted_trasmissioni){
            s+=fascia.start.toString()+" - "+trasmissioni.get(fascia)+"\n";
        }
        return s;
    }

     //EFFECTS:creo una 
    private Map<FasciaBetaoraria,String> createMap(){
         Map<FasciaBetaoraria,String> orari_prog=new HashMap<>();
        for(Trasmissione trasmissione:pal){
            if(trasmissione instanceof TrasmissioneSemplice) {
                orari_prog.put(((TrasmissioneSemplice)trasmissione).fascia,trasmissione.title);    
            }
            else if(trasmissione instanceof TrasmissionePeriodica) {
                TrasmissionePeriodica tp=(TrasmissionePeriodica) trasmissione;
                for(FasciaBetaoraria value:tp.orari){
                     orari_prog.put(value,trasmissione.title);
                }
                   
            }
            else if(trasmissione instanceof RadioGiornale) {
               RadioGiornale rg=(RadioGiornale) trasmissione;
                for(FasciaBetaoraria value:rg.orari){
                     orari_prog.put(value,trasmissione.title);
                }    
            }
        }
        return orari_prog;

    }
}
