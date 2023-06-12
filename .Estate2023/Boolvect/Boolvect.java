package Boolvect;
/* Interfaccia che stabilice il comportamento coune q atutte le implementazioni di boolvect */

public interface Boolvect {

    /**
     * REstituisce la diemensione del boolvect, ossia 1 più la posizione più
     * grande in cui si trova un valore di verità uguale a vero (o 0 se tutti i
     * valore di verità sono falsi)
     * 
     * @return dimensione
     */
    public int getDimensione();

    /**
     * Restituisce la taglia massima del boolvect, ossia la massima dimensione che
     * esso può raggiungere
     * 
     * @return taglia massima
     */
    public int taglia();

    /**
     * Restituisce il valore di verità in posizione index
     * 
     * @param index indice da cui leggere il valore
     * @return valore[index]
     * @throw illegalArgumentException se index < 0 o index >= dimensione
     */
    public boolean leggi(int index) throws IllegalArgumentException;

    /**
     * Scrive il valore di verità in posizione index
     * 
     * @param valore valore da scrivere
     * @param index  indice in cui scrivere il valore
     * @throw illegalArgumentException se index < 0 o index >= dimensione
     * @throw illegalArgumentException se valore == null
     */
    public void scrivi(boolean valore, int index);
}
