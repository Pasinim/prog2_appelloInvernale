package tde.filesystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Inteprete di comandi per un Filesystem
 */
public class Shell {
    private final Filesystem fs;
    private Directory curDir;

    public Shell(Filesystem f){
        this.fs = f;
        this.curDir = f.getCurDirectory();
    }

    public void read(){
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(is);

        try {
            for(String line = reader.readLine(); line != null; line = reader.readLine()){
                String[] tkn = line.split(" ");
                //Estrapolo comando
                String cmd = tkn[0];

                switch (cmd) {
                    case "ls":
                        if(tkn.length < 2){
                            System.out.println(curDir.getContenuto());
                        }
                        elenca(tkn[1]);

                        break;

                    case "size":

                    case "mkdir":

                    case "mkfile":

                    case "cd":

                    case "pwd":
                
                    default:
                        break;
                }
            }           
        } catch (IOException e) {
            System.out.println("Errore lettura io");
        }
    }

    private void elenca(String path){

    }
}
