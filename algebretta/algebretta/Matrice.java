public interface Matrice {
    public Matrice prodottoScalare(int numb);
    public Matrice sommaMat(Matrice o);
    public Matrice prodMat(Matrice o);
    public Matrice prodMat(Vettore v);
    public int val(final int i, final int j);
    int dim();

    default boolean conforme(final Vettore v) {
        return dim() == v.dim();
    }
    
    default boolean conforme(final Matrice M) {
        return dim() == M.dim();
    }

}
