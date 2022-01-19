package piastrelle;
import java.util.*;
/**
 * OVERVIEW: Le istanze di questa classe mutabile rappresentano una pavimentazione, che può essere composta
 * da altre Pavimentazioni oppure da varie piastrelle.
 * AF: la pavi
 * IR:
 *      piastrelle != null
 *      pavimentazioni != null
 *      ogni elemento di piastrelle deve essere != null 
 *      se pavimentazioni.size()>0 ogni suo elemento deve essere !=null
 */
public class Pavimentazione implements Rivestimento {
    public final List<Piastrella> piastrelle;
    public List<Pavimentazione> pavimentazioni;

    @Override
    public String toString(){
        String str = "La pavimentazione è formata dalle seguenti piastrelle:\n\t";
        Iterator<Piastrella> it = piastrelle.iterator();
        while (it.hasNext())
            str += it.toString();
        return str;
    }

    /**
     * Inizializza una nuova pavimentazione costutiuta da una lista di piastrelle ed (eventualmente) da una lista di pavimentazioni
     * @param p Lista di Piastrelle
     * @param pv Lista di Pavimentazioni
     * @throws NullPointerException se p o pv sono NULL
     * @throws NullPointerException se un elemento di p o pv (se non vuota) è NULL
     */
    public Pavimentazione(List<Piastrella> p, List<Pavimentazione> pv){
        this.piastrelle = Objects.requireNonNull(p);
        this.pavimentazioni = Objects.requireNonNull(pv);
        for (Iterator<Piastrella> it = piastrelle.iterator(); it.hasNext(); )
            Objects.requireNonNull(it.next());
        if (!(this.pavimentazioni.isEmpty())){
            for (Iterator<Pavimentazione> it = pavimentazioni.iterator(); it.hasNext(); )
                Objects.requireNonNull(it.next());  
        }
    }

    public Pavimentazione(){
        piastrelle = new ArrayList<Piastrella>();
        pavimentazioni = new ArrayList<Pavimentazione>();
    }

    @Override
    public int getSuperficie() {
        int superficieTotale = 0;
        Iterator<Piastrella> it = piastrelle.iterator();
        while (it.hasNext())
            superficieTotale += it.next().getSuperficie();

        if (pavimentazioni.isEmpty()) return superficieTotale;

        Iterator<Pavimentazione> it_pv = pavimentazioni.iterator();
        while (it_pv.hasNext())
            superficieTotale += it_pv.next().getSuperficie();
        return superficieTotale;
    }

    @Override
    public int getCosto() {
        int costoTotale = 0;
        Iterator<Piastrella> it = piastrelle.iterator();
        while (it.hasNext())
            costoTotale += it.next().getCosto();

        if (pavimentazioni.isEmpty()) return costoTotale;

        Iterator<Pavimentazione> it_pv = pavimentazioni.iterator();
        while (it_pv.hasNext())
            costoTotale += it_pv.next().getCosto();
        return costoTotale;
    }

    public void addPiastrella(Piastrella p){
        Objects.requireNonNull(p);
        piastrelle.add(p);
    }
    
    public void addPavimentazione(Pavimentazione p){
        Objects.requireNonNull(p);
        pavimentazioni.add(p);
    }

}
