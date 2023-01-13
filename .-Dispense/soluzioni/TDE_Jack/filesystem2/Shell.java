package tde.filesystem2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Objects;

/**
* Interprete di comandi per un Filesystem
*/
public class Shell {
    private final Filesystem f;
    private final Directory root;
    
    /**
    * Inizializza shell su filesystem vuoto con root di nome n.
    * 
    * @param n Nome root.
    */
    public Shell(String n){
        if(Objects.isNull(n)){
            throw new IllegalArgumentException();
        }
        this.root = new Directory(n);
        this.f = new Filesystem(root);
    }
    
    /**
    * Si mette in attesa di input da parte dell'utente su stind ed esegue di conseguenza.
    */
    public void read(){
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(is);
        
        try {
            for(String line = reader.readLine(); line != null; line = reader.readLine()){
                String[] tkns = line.split(" ");
                String cmd = tkns[0];
                
                switch (cmd) {
                    case "ls":
                        if(tkns.length <= 1){
                            this.ls(new Path(":"));
                            break;
                        }
                        this.ls(new Path(tkns[1]));
                    break;
                    case "size":
                        this.size(new Path(tkns[1]));
                    break;
                    
                    case "mkdir":
                        this.mkdir(new Path(tkns[1]), tkns[2]);
                    break;
                    
                    case "mkfile":
                        this.mkfile(new Path(tkns[1]), tkns[2], Integer.parseInt(tkns[3]));
                    break;
                    
                    case "cd":
                        this.cd(new Path(tkns[1]));
                    break;
                    
                    case "pwd":
                        this.pwd();
                    break;
                    
                    default:
                    break;
                }
            }
        } catch (IOException e) {
            //TODO: handle exception
        } catch (IndexOutOfBoundsException e){
            
        }
    }

    private void ls(Path p){
        StringBuilder str = new StringBuilder();
        Iterator<Entry> i = f.contenuto(p);

        if(Objects.nonNull(i)){
            while(i.hasNext()){
                Entry e = i.next();
                str.append(String.format("%s, ", e));
            }
            System.out.println(str.toString());
        }

        return;
    }

    private void size(Path p){
        System.out.println(f.dimensione(p));
    }

    private void mkdir(Path p, String name){
        f.createDir(name, p);
    }

    private void cd(Path p){
        f.cd(p);
    }

    private void pwd(){
        f.curDirectory();
    }
    private void mkfile(Path p, String name, int dim){
        f.createFile(name, dim, p);
    }

    public static void main (String[] args){
        Shell s = new Shell("Ciao");
        s.read();
    }
    
    
}
