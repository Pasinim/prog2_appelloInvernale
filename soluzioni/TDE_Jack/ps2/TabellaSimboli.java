package tde.ps2;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Tabella che permette di conservare un'associazione tra una Stringa ed il suo
 * Valore di tipo generico T.
 * 
 * La Classe é mutabile.
 * 
 * Una TabellaSimboli ha la seguente funzione d'astrazione: AF(c) = Per ogni
 * Simbolo s: s.toString(): s.getValore.toString()
 */
public class TabellaSimboli<T>{
    private final Map<String, T> symbolToValue;
    
    /**
     * Inizializza una Tabella di Simboli vuota.
     */
    public TabellaSimboli(){
        symbolToValue = new HashMap<>();
    }

    /**
     * Aggiunge l'associazione (s,t) nella Table.
     * 
     * Se il Simbolo t é giá presente il valore viene rimpiazzato.
     * 
     * @param s Simbolo
     * @param t Valore
     */
    public void aggiungi(String s, T t){
        if(Objects.isNull(s) || Objects.isNull(t)){
            throw new IllegalArgumentException();
        }

        symbolToValue.put(s, t);
    }

    /**
     * Rimuove il Simbolo t dalla tabella.
     * 
     * La tabella rimane invariata se il valore t non é presente
     * 
     * @param t Simbolo da rimuovere.
     */
    public void rimuovi(String t){
        symbolToValue.remove(t);
    }  

    /**
     * Ritorna, se presente, il valore associato a t.
     * 
     * @param t Simbolo
     * @return Valore associato a t.
     */
    public T getValore(String t){
        T ret = symbolToValue.get(t);

        if(Objects.isNull(ret)){
            throw new IllegalArgumentException();
        }

        return ret;
    }


    @Override
    public String toString(){
        return this.symbolToValue.toString();
    }
}
