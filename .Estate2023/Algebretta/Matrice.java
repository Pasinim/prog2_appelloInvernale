package Algebretta;

public interface Matrice {
    /**
     * Restituisce la dimensione della matrice
     * 
     * @return la dimensione della matrice
     */
    int getDimensione();

    /**
     * Restituisce l'elemento in posizione (riga, colonna)
     * 
     * @param riga
     * @param colonna
     * @return l'elemento in posizione (riga, colonna)
     */
    int getElemento(int riga, int colonna);

    /**
     * Imposta l'elemento in posizione (riga, colonna) al valore dato
     * 
     * @param riga
     * @param colonna
     * @param valore  il valore da impostare
     */
    void setElemento(int riga, int colonna, int valore);

    /**
     * Restituisce il prodotto tra la matrice e lo scalare dato
     * 
     * @param scalare
     * @return il prodotto tra la matrice e lo scalare dato
     */
    Matrice prodottoPerScalare(int scalare);

    /**
     * Restituisce la somma tra la matrice e un'altra matrice
     * 
     * @param altraMatrice
     * @return la somma tra la matrice e un'altra matrice
     * @throws IllegalArgumentException se le due matrici non sono conformi
     * @throws NullPointerException     se altraMatrice è null
     */
    Matrice sommaMatriciale(Matrice altraMatrice);

    /**
     * Restituisce il prodotto tra la matrice e un'altra matrice
     * 
     * @param altraMatrice
     * @return
     * @throws NullPointerException se altraMatrice è null
     */
    Matrice prodottoMatriciale(Matrice altraMatrice);

    /**
     * Restituisce true se la matrice è conforme a this
     * 
     * @param altraMatrice
     * @return true se la matrice è conforme a this, false altrimenti
     */
    public boolean isConforme(Matrice altraMatrice);

}
