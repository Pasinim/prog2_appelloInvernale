package tde.bancarelle;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Iterator;

/**
 * Classe mutabile Bancarella.
 * 
 * Rappresenta una Bancarella, associata ad un proprietario.
 * Ogni Bancarella é in grado di vendere oggetti in relazione alla propria disponibilitá.
 * 
 * Una tipica istanza di Bancarella puó essere rappresentata tramite la seguente funzione d'astrazione:
 *  AF(c) = perOgni tipologia di Giocattolo g: num. g.quantita  g.toString(), prezzo: g.prezzoUnitario.
 */
public class Bancarella {
    private final String owner;
    private Inventario inventario;
    private Listino listino;
    private int fondi;

    /**
     * Inizializza una Bancarella con proprietario o.
     * 
     * Il nome del proprietario deve essere valido.
     * 
     * @param o Nome proprietario
     */
    public Bancarella(String o){
        if(o.equals("")){
            throw new IllegalArgumentException();
        }

        this.owner = Objects.requireNonNull(o);
        this.fondi = 0;
        this.inventario = new Inventario();
        this.listino = new ListinoStandard();
    }

    /**
     * Ritorna proprietario di this.
     * 
     * @return Proprietario di this
     */
    public String getOwner(){
        return this.owner;
    }

    /**
     * Aggiunge q Giocattoli g alla bancarella aggiornando l'inventario.
     * 
     * Metodo mutazionale.
     * 
     * @param g Tipologia di Giocattolo da aggiungere.
     * @param quantita Quantita.
     */
    public void aggiungiGiocattolo(Giocattolo g, int quantita){
        for(int i = 0; i < quantita; i++){
            inventario.aggiungi(g);
        }
    }

    /**
     * Aggiunge tutti i Giocattoli presenti nella lista g alla Bancarella aggiornando l'inventario.
     * 
     * Metodo mutazionale.
     * 
     * @param g Lista di Giocattoli da aggiungere.
     */
    public void aggiungiGiocattolo(List<Giocattolo> g){
        inventario.aggiungi(g);
    }

    /**
     * Aggiorna il prezzo unitario di g con il nuovo prezzo p.
     * 
     * Se g non é presente viene sollevata una eccezione.
     * 
     * Metodo mutazionale.
     * 
     * @param g Giocattolo di cui aggiornare il prezzo.
     * @param p Nuovo prezzo unitario
     */
    public void aggiornaListino(Giocattolo g, int p){
        listino.aggiungi(g, p);
    }

    /**
     * Vende, in base alla disponibilita, q giocattoli di tipo g.
     * 
     * Se la quantitá non é sufficiente viene sollevata una eccezione.
     * 
     * Metodo mutazionale.
     * 
     * @param g Giocattolo da vendere.
     * @param q Quantita da vendere.
     */
    public void vendi(Giocattolo g, int q){
        try {
            inventario.rimuovi(g, q);
            this.fondi += listino.getPrezzo(g, q);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Quantitá non sufficiente");
        }
    }

    /**
     * Restituisce il prezzo da pagare per q Giocattoli di tipo g
     * 
     * @param g Giocattoli
     * @param q Quantita
     * @return Prezzo relativo
     */
    public int getPrezzo(Giocattolo g, int q){
        return this.listino.getPrezzo(g, q);
    }

    @Override
    /**
     * Ritorna stringa rappresentante stato di this.
     * 
     * @return String AF.
     */
    public String toString(){
        StringBuilder ret = new StringBuilder(String.format("Bancarella di: %s\n", this.owner));
        Iterator<Giocattolo> i = inventario.giocattoli();

        while(i.hasNext()){
            Giocattolo g = i.next();
            ret.append(String.format("num. %d %s, prezzo: %d\n", inventario.getQuantita(g), g.toString(), listino.getPrezzo(g, 1)));
        }

        return ret.toString();
    }
}
