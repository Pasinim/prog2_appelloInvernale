package tde.filesystem;

import java.util.Currency;
import java.util.List;
import java.util.Objects;

/**
 * Rappresenta un Filesystem, oggetto in grado di contenere e navigare una collezione di Entry organizzate
 * secondo una data gerarchia.
 * 
 * Un Filesystem ha quindi una Directory come root che potrá contenere una o piú sottodirectory dando vita ad
 * una struttura ad albero.
 * 
 * Classe mutabile.
 * 
 * Filesystem ha la seguente funzione d'astrazione:
 *  AF(c) = 
 * 
 * 
 * 
 */
public class Filesystem {
    private Directory root;
    //Mantiene una Path aggiornata del Filesystem
    private Path path;
    //Puntatore alla Directory corrente
    private Directory curDirectory;

    /**
     * Inizializza un Filesystem avente una root di nome n.
     * 
     * @param n Nome della root
     */
    public Filesystem(String n){
        this.root = new Directory(n);
        this.path = new Path(n);
        this.curDirectory = this.root;
    }

    /**
     * Aggiunge la Entry e ai contenuti della Directory corrente.
     * 
     * @param e Entry da inserire in e.
     */
    public void aggiungiEntry(Entry e){
        // Aggiorno anche la root
        this.curDirectory.aggiungiEntry(e);
    }

    /**
     * Rimuove la Entry e dai contenuti della Directory corrente.
     * 
     * Se la Entry e non é presente viene sollevata una eccezione.
     * 
     * @param e Entry 
     */
    public void rimuoviEntry(Entry e){

    }

    /**
     * Naviga verso la Directory e se presente.
     * 
     * @param e Entry
     */
    public void naviga(String e){
        List<Entry> contenuo = curDirectory.getContenuto();

        if(curDirectory.getContenuto().contains(new Directory(e))){
            int index = contenuo.indexOf(new Directory(e));
            //Safe?
            curDirectory =  (Directory) contenuo.get(index);
            //Aggiorno la path
            path.push(curDirectory.getNome());
        }else{
            throw new IllegalArgumentException();
        }
    }

    /**
     * Ritorna il nome della Directory in cui mi trovo in un dato momento.
     * 
     * @return Nome della Directory corrente
     */
    public String getCurName(){
        return curDirectory.getNome();
    }

    public Directory getCurDirectory(){
        return curDirectory;
    }

    /**
     * Stampa la Path assoluta (Dalla root) della directory corrente.
     */
    public void printPath(){
        System.out.println(this.path.toString());
    }

    @Override
    public String toString(){
        StringBuilder ret = new StringBuilder();
        ret = buildString(root, ret, 0);

        return ret.toString();
    }

    private StringBuilder buildString(Directory d, StringBuilder str, int depth){
        //DFS
        Directory curDir = d;
        List<Entry> curCont = curDir.getContenuto();

        //Stampo la root
        if(depth == 0){
            str.append(String.format("+%s\n", curDir.getNome()));
            depth += 1;
        }

        if(curCont.size() <= 0){
            return str;
        }

        for (Entry e: curCont) {
            try {
                String spacing = new String("---").repeat(depth);
                String s;
                s = String.format("+%s", e.toString());

                str.append(String.format("%s%s\n", spacing, s));

                buildString((Directory) e, str, depth+1);
            } catch (ClassCastException ec) {
                
                continue;
            }
        }

        return str;
    }

    public static void main(String args[]){
        Filesystem f = new Filesystem("Giacomo");
        f.aggiungiEntry(new File("Ciao", 10));
        f.aggiungiEntry(new Directory("Lol"));
        f.aggiungiEntry(new Directory("XD"));
        f.aggiungiEntry(new Directory("KING"));

        f.naviga("Lol");
        f.aggiungiEntry(new File("ooo", 20));
        System.out.println(f.getCurDir());
        System.out.println(f.toString());
    }
}
