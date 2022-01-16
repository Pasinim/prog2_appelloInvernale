package bancarelle;

import java.util.*;

/**
 * Le istanze di questa classe permettono di rappresentare un 
 * giocattolo, identificato da un nome e da un materiale.
 * AF(nome, materiale): this.nome + " di " + this.materiale
 * RI: nome != NULL,  materiale != null
 */
public class Giocattolo {
    public final String nome, materiale;
    /** Inizializza un giocattolo con un dato nome e materiale.
     *  Se nome o materiale sono nulli solleva una eccezione.
     * @param nome nome del giocattolo
     * @param materiale materiale del giocattolo
    */
    public Giocattolo (String nome, String materiale){
        Objects.requireNonNull(nome);
        Objects.requireNonNull(materiale);
        this.nome = nome;
        this.materiale = materiale;
    }

    /**
     * Dato che le due variabili di instanza sono private è necessario fornire un metodo
     * per permettere a equals di effettuare un confronto tra materiali e nomi.
     * @return nome / materiale
     */
    public String getNome(){
        return this.nome;
    }
    public String getMateriale(){
        return this.materiale;
    }

    @Override
    public String toString(){
        String str = "";
        str += this.nome + " di " + this.materiale;
        return str;
    }

    @Override
    public boolean equals(Object o){
        if (!(o instanceof Giocattolo)) return false;
        Giocattolo obj = (Giocattolo) o;
        if (!(this.nome.equals(obj.getNome()))) return false;
        if (!(this.materiale.equals(obj.getMateriale()))) return false;
        return true;
    }

    @Override
    //È necessario fare l'Override di hashcode perchè altrimenti il confronto delle chiavi nella mappa non funzionerebbe correttametne.
    //Il confronto delle chiavi non viene fatto con equals ma con hashcode
    public int hashCode(){
        int result;
        result = Integer.hashCode(this.nome.hashCode());
        result += 37 * Integer.hashCode(this.materiale.hashCode());
        return result;
    }

    public static void main(String[] args) {
        final Map<Giocattolo, Integer> giochi  = new HashMap<Giocattolo, Integer>();

        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            String line = input.nextLine();
            String tkns[] = line.split(" ");
            Giocattolo g = new Giocattolo(tkns[0], tkns[1]);
            //se il giocattolo è già presente aumento la quantità
            if (giochi.containsKey(g)) {
                System.out.println("Giocattolo già presente, inserisco la nuova quantità\n");
                giochi.replace(g, giochi.get(g)+1);
            }else{
                giochi.put(g, 1);
            } 
        }
        input.close();

//stampo
        String str = "";
            for (Map.Entry<Giocattolo, Integer> entry : giochi.entrySet())
                str += entry.getKey().toString() + ": " + entry.getValue() + "\n";
            
        System.out.println(str);

    }
    
}
