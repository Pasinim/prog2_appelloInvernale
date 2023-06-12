package Algebretta;

public class MatriceNulla extends MatriceQuadrata {
    public MatriceNulla(int dimensione) {
        super(dimensione);
        for (int i = 0; i < dimensione; i++) {
            for (int j = 0; j < dimensione; j++) {
                setElemento(i, j, 0);
            }
        }
    }
}