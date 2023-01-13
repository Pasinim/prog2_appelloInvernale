package tde.thomas2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

/**
 * Classe immutabile rappresentante le dotazioni di un Vagone.
 * 
 * Una Dotazione é caratterizzata da un nome ed una quantitá validi,
 * Ha quindi una funzione d'astrazione:
 *  AF(c) = this.nome = this.quantita
 * Ed un invariante:
 *  rep_inv = this.nome not null && this.quantita > 0
 * 
 */
public class Dotazione implements Comparable<Dotazione> {
    private final String nome;
    private final int quantita;

    /**
     * Inizializza una Dotazione con Nome n e quantitá q.
     * 
     * @param n Nome della Dotazione.
     * @param q Quantitá della Dotazione.
     */
    public Dotazione(String n, int q){
        this.nome = n;
        this.quantita = q;

        if(!repOk()){
            throw new IllegalArgumentException();
        }
    }

    /**
     * Ritorna il nome della Dotazione.
     * 
     * @return Nome di this.
     */
    public String nome(){
        return this.nome;
    }

    /**
     * Ritorna la quantita della Dotazione.
     * 
     * @return Quantita di this.
     */
    public int quantita(){
        return this.quantita;   
    }

    @Override
    public String toString(){
        String ret = String.format("%s = %d", this.nome, this.quantita);
        return ret;
    }

    @Override 
    public boolean equals(Object o){
        if(!(o instanceof Dotazione)){
            return false;
        }

        if(o == this){
            return true;
        }

        Dotazione d = (Dotazione) o;

        if(this.nome.equals(d.nome)){
            return true;
        }

        return false;

    }

    @Override
    public int hashCode(){
        return this.nome.hashCode();
    }


	@Override
	public int compareTo(Dotazione o) {
        Integer q = this.quantita;
        return q.compareTo(o.quantita);
	}

    /**
     * Controlla l'invariante di rappresentazione.
     * 
     * @return True se l'invariante é rispettato, False altrimenti.
     */
    public boolean repOk(){
        if(Objects.isNull(this.nome) || this.quantita <= 0){
            return false;
        }
        return true;
    }
    
    public static void main(String args[]){
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(is);

        Dotazione d = new Dotazione("Ciao", 100);
        try {
            for(String line = reader.readLine(); line != null; line = reader.readLine()){
                String[] tkns = line.split(" ");
    
                Dotazione dot = new Dotazione(tkns[0], Integer.parseInt(tkns[1]));
                System.out.println(dot);
                System.out.println(d.equals(dot));
                System.out.println(d.compareTo(dot));
            }           
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

}
