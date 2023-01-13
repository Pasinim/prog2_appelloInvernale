package tde.pianeti;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Rappresenta un sistema astronomico.
 * 
 * Classe mutabile.
 * 
 * L'invariante é sempre vero.
 */
public class Sistema {
    private List<Pianeta> pianeti;
    private List<Stella> stelle;
    private final String nome;

    /**
     * Inizializza un nuovo sistema vuoto.
     */
    public Sistema(String n){
        this.pianeti = new ArrayList<>();
        this.stelle = new ArrayList<>();
        this.nome = Objects.requireNonNull(n);
    }

    /**
     * Aggiunge il CorpoCeleste c al sistema.
     * 
     * Solleva un'eccezione se c é nullo.
     * 
     * Il metodo modifica this.
     * 
     * @param c CorpoCeleste da aggiungere.
     */
    public void aggiungiPianeta(Pianeta p){
        pianeti.add(new Pianeta(p));
    }

    /**
     * Aggiunge il CorpoCeleste c al sistema.
     * 
     * Solleva un'eccezione se c é nullo.
     * 
     * Il metodo modifica this.
     * 
     * @param c CorpoCeleste da aggiungere.
     */
    public void aggiungiStella(Stella s){
        stelle.add(s);
    }

    /**
     * Aggiunge la lista di CorpoCeleste c al sistema.
     * 
     * Solleva un'eccezione se c é nullo.
     * 
     * Il metodo modifica this.
     * 
     * @param c CorpoCeleste da aggiungere.
     */
    public void aggiungiPianeta(List<Pianeta> c){
        pianeti.addAll(c);
    }

    /**
     * Aggiunge la lista di CorpoCeleste c al sistema.
     * 
     * Solleva un'eccezione se c é nullo.
     * 
     * Il metodo modifica this.
     * 
     * @param c CorpoCeleste da aggiungere.
     */
    public void aggiungiStella(List<Stella> s){
        stelle.addAll(s);
    }

    /**
     * Rimuove il CorpoCeleste c dal sistema.
     * 
     * Solleva un'eccezione se c non é presente.
     * 
     * Il metodo modifica this.
     * 
     * @param c CorpoCeleste da aggiungere.
     */
    public void rimuoviPianeta(Pianeta c){
        boolean res = pianeti.remove(c);

        if(!res){
            throw new IllegalArgumentException();
        }
    }

    /**
     * Rimuove il CorpoCeleste c dal sistema.
     * 
     * Solleva un'eccezione se c non é presente.
     * 
     * Il metodo modifica this.
     * 
     * @param c CorpoCeleste da aggiungere.
     */
    public void rimuoviPianeta(Stella s){
        boolean res = stelle.remove(s);

        if(!res){
            throw new IllegalArgumentException();
        }
    }

    /**
     * Simula un'interazione tra tutti i CorpiCelesti del sistema in una unitá di tempo.
     * 
     * Il metodo modifica this.
     */
    public void interazione(){
        //Eseguo la simulazione tra ogni coppia di corpi celesti.
        List<Pianeta> p = new ArrayList<>(pianeti);

        for (Pianeta p1 : p) {
            for (Pianeta p2 : p) {
                Punto p1Coor = p1.getPosizione();
                Punto p2Coor = p2.getPosizione();

                //Aggiorno velocitá 
                //Uso somma
                if(p1Coor.getX() > p2Coor.getX()){
                    p1.setVel(p1Coor.somma(new Punto(1,0,0)));
                    p2.setVel(p2Coor.somma(new Punto(-1,0,0)));
                }else if(p1Coor.getX() < p2Coor.getX()){
                    p1.setVel(p1Coor.somma(new Punto(-1,0,0)));
                    p2.setVel(p2Coor.somma(new Punto(1,0,0)));
                }

                if(p1Coor.getY() > p2Coor.getY()){
                    p1.setVel(p1Coor.somma(new Punto(0,1,0)));
                    p2.setVel(p2Coor.somma(new Punto(0,-1,0)));
                }else if(p1Coor.getY() < p2Coor.getY()){
                    p1.setVel(p1Coor.somma(new Punto(0,-1,0)));
                    p2.setVel(p2Coor.somma(new Punto(0,1,0)));
                }

                if(p1Coor.getZ() > p2Coor.getZ()){
                    p1.setVel(p1Coor.somma(new Punto(0,0,1)));
                    p2.setVel(p2Coor.somma(new Punto(0,0,-1)));
                }else if(p1Coor.getZ() < p2Coor.getZ()){
                    p1.setVel(p1Coor.somma(new Punto(0,0,-1)));
                    p2.setVel(p2Coor.somma(new Punto(0,0,1)));
                }
            }
            p.remove(p1);
            System.out.println(p.size());
        }

        //Aggiorno posizione
        for (Pianeta pianeta : pianeti) {
            Punto curpos = pianeta.getPosizione();
            Punto vel = pianeta.getVel();

            pianeta.setPos(curpos.somma(vel));
        }
    }

    /**
     * Esegue una simulazione delle interazioni tra i CorpiCelesti in un tempo arbitrario t.
     * 
     * Il metodo modifica this.
     * 
     * @param t Tempo della simulazione.
     */
    public void simula(int t){
        for(int i = 0; i < t; i++){
            this.interazione();
        }
    }

    @Override
    public String toString(){
        StringBuilder ret = new StringBuilder(String.format("Sistema %s\n", this.nome));

        for (Pianeta pianeta : pianeti) {
            ret.append(String.format("%s \n", pianeta.toString()));
        }

        for (Stella stella : stelle) {
            ret.append(String.format("%s \n", stella.toString()));            
        }

        return ret.toString();
    }

    public static void main(String args[]){
        Pianeta p1 = new Pianeta("Marte", new Punto(3, 0, 0), new Punto(0,0,0));
        Pianeta p2 = new Pianeta("Giove", new Punto(5, 0, 0), new Punto(0,0,0));    
        
        Sistema s = new Sistema("Cringe");
        s.aggiungiPianeta(p1);
        s.aggiungiPianeta(p2);

        System.out.println(s);

        s.simula(1);

        System.out.println(s);
    }
}
