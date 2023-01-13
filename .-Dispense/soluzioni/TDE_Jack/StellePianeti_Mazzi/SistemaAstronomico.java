import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


/**
 * Le istanze di questa classe rappresentano un sistema astronomico.
 * Esso rappresenta un insieme di pianeti e stelle disse ed è in grado di simulare per un certo intervallo di tempo
 * un sistema astronomico ed è in grado di calcolare l'energia totale nel sistema.
 * Le istanze di questa classe sono mutabili.
 */
public class SistemaAstronomico {

    /**
     * AF:
     * IR: tempo > 0, {@link sistema} non può essere null,non può contenere elementi null ed ognuno di questi
     * è univoco.
     * Tale invariante è sempre assicurato dal suo unico costruttore e rimane valido alle chiamate del
     * metodo aggiungiCorpoCeleste(CorpoCeleste).
     */
    public final int tempo;
    private List<CorpoCeleste> sistema;

    public SistemaAstronomico(int tempo){
        if(tempo < 0) throw new IllegalArgumentException("il tempo non può essere negativo");
        this.tempo = tempo;
        sistema = new ArrayList<>();
    }

    /**
     * Aggiunge un corpo celeste al sistema
     * Solleva un'eccezione del tipo {@link NullPointerException} nel caso in cui {@link corpoceleste} sia null
     * Solleva un'eccezione del tipo {@link IllegalArgumentException} nel caso in cui {@link corpoceleste} sia già all'interno del sistema
     * @param corpoCeleste da aggiungere al sistema
     */
    public void aggiungiCorpoCeleste(CorpoCeleste corpoCeleste){
        Objects.nonNull(corpoCeleste);
        if(sistema.contains(corpoCeleste)) throw new IllegalArgumentException("Il corpo celeste è già all'interno del sistema");
        sistema.add(corpoCeleste);
        Collections.sort(sistema);
        assert repOk();
    }

    /**
     * Calcola l'energia totale del sistema
     */
    public long calcolaEnergiaTotale(){
        long energiaTotale = 0;
        //per ogni istante di tempo
        for(int i = 0; i < tempo;i++){
            //per ogni corpo celeste i
            for(CorpoCeleste c : sistema){
                //il corpoceleste è un pianeta
                if(c instanceof Pianeta){
                    Pianeta p = new Pianeta(c.nome,c.getPosizione());
                    //per ogni altro corpoceleste j
                    for(CorpoCeleste c2 : sistema){
                        //per ogni j != i
                        if(!c2.equals(c)){
                            //trasformo corpoceleste in pianeta
                            if(c2 instanceof Pianeta){
                                Pianeta p2 = new Pianeta(c.nome,c.getPosizione());
                                p.updateVelocità(p2);
                            }
                        }
                    }
                }
                energiaTotale += c.EnergiaCinetica();
                energiaTotale += c.EnergiaPotenziale();
            }
        }
        return energiaTotale;
    }

    public boolean repOk(){
        if(tempo < 0) return false;
        if(Objects.isNull(sistema)) return false;
        for(CorpoCeleste c : sistema){
            if(Objects.isNull(c)) return false;
            if(sistema.indexOf(c) != sistema.lastIndexOf(c)) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String s = new String();
        for(CorpoCeleste c : sistema){
            s += c.toString();
            s += "\n";
        }
        return s;
    }
}
