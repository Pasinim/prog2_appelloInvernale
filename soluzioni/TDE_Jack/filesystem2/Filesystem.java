package tde.filesystem2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Rappresenta un Filesystem, caratterizzato da una Directory radice ed in
 * grado, tramite una struttura ad albero, di contenere una o piú Entry figlie.
 * 
 * Classe mutabile.
 * 
 * Un Filesystem ha la seguente funzione d'astrazione: 
 * AF(c) = 
 * Ed il seguente invariante: 
 *  rep_inv: this.radice not null
 */
public class Filesystem {
    private final Directory root;
    private Directory curDir;

    /**
     * Inizializza un Filesystem con radice una Directory di nome n.
     * 
     * @param n Nome della root.
     */
    public Filesystem(String n){
        this.root = new Directory(n);
        this.curDir = root;
    }

    /**
     * Inizializza un Filesystem con radice una Directory root.
     * 
     * @param root Radice del Filesystem.
     */
    public Filesystem(Directory root){
        this.root = root;
        this.curDir = this.root;
    }

    /**
     * Naviga verso, se presente, la Directory di nome n.
     *  
     * Modifica lo stato di this.
     * 
     * @throws NoSuchElementException Se la Directory non esiste é.
     * @param n Nome della Directory
     */
    public void naviga(String n){
        Directory d = new Directory(n);

        Iterator<Entry> entries = this.curDir.contenuto();

        if(Objects.isNull(entries) || !(entries.hasNext())){
            throw new NoSuchElementException();
        }

        while(entries.hasNext()){
            Entry next = entries.next();
            
            if(next.equals(d)){
                
                this.curDir = (Directory) next;
                return;
            }
        }

        throw new NoSuchElementException();
    }

    /**
     * Crea una nuova Directory di nome n  alla posizione indicata da p.
     * 
     * Modifica lo stato di this.
     * 
     * @throws IllegalArgumentExcetpion Se la Path indicata é invalida
     * @param s nome della Directory.
     * @param p Path assoluta
     */
    public void createDir(String n, Path p){
        this.cd(p);

        //Sono certo sia una directory
        this.curDir.aggiungiEntry(new Directory(n));
    }

    /**
     * Crea una nuova File di nome n e dimensione d alla posizione indicata da p.
     * 
     * Modifica lo stato di this.
     * 
     * @throws IllegalArgumentException Se la Path é invalida.
     * @param s nome del File.
     * @param d dimensione del File.
     * @param p Path assoluta
     */
    public void createFile(String n, int dim, Path p){
        this.cd(p);

        //Sono certo sia una directory
        Directory d = (Directory) this.curDir;
        d.aggiungiEntry(new File(n, dim));
    }

    /**
     * Ritorna, se presente, la Entry in posizione indicata da p.
     * 
     * @throws IllegalArgumentException Se la Path é invalida.
     * @param p Path assoluta
     * @return Entry presente in p.
     */
    public Entry getEntry(Path p){
        //Studio la path partendo da root
        this.curDir = root;
        //Copio la p in input
        Path path = new Path(p);
        String str;

        do {
            str = path.pop();

            try {
                this.naviga(str);
            } catch (NoSuchElementException e) {
                throw new IllegalArgumentException("Path invalida");
            }
        } while (str != null);

        //Sono certo sia una directory
        Directory d = (Directory) this.curDir;
        
        return d.getEntry(str);
    }

    /**
     * Ritorna, se presente, un iteratore sulle entry contenute nella directory in posizione p.
     * 
     * Eventuali modifiche alle Entry mutabili ritornate dall'iteratore modificheranno inevitabilmente anche lo stato di thi.
     * 
     * @param p Path assouluto
     * @return Iteratore sulle entry in d.
     */
    public Iterator<Entry> contenuto(Path p){
        this.cd(p);

        return this.curDir.contenuto();
    }

    public void cd(Path p){
        //Studio la path partendo da root
        this.curDir = root;
        //Copio la p in input
        Path path = new Path(p);
        String str = path.pop();

        while(str != null){
            try {
                this.naviga(str);
            } catch (NoSuchElementException e) {
                throw new IllegalArgumentException("Path invalida");
            }           
            str = path.pop();
        }  
    }

    /**
     * Riorna la dimensione della Entry presente alla relativa Path p.
     * 
     * @param p Path assoluta.
     * @return Dimensione della Entry in p.
     */
    public int dimensione(Path p){
        return this.curDir.dimensione();
    }

    @Override
    public String toString(){
        return null;
    }

    public boolean repOk(){
        return true;
    }

    public void curDirectory(){
        System.out.println(curDir.nome());
    }
}
