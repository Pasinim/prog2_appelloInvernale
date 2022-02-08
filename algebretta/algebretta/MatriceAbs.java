import java.util.*;
/**
 * OVERVIEW: Classe astratta che raggruppa i comportamenti comuni
 * a tutti i tipi di matrice.
 * RI: Per ogni elemento i della matrice (da 0 a mtx.dim()):
 *      [mtx[0], mtx[1], ..., mtx[this.dim() - 1], mtx[this.dim()]]
 */
public abstract class MatriceAbs implements Matrice {

    //utilizzo val nellínterfaccia per andare a creare la stringa
    @Override
    public String toString(){
        String str = "[";
        for (int i = 0; i < (int)Math.sqrt(this.dim()); i++){
            for (int j = 0; j < (int)Math.sqrt(this.dim()); j++){   
                str += val(i, j);
                if (j - dim() != 1) str += ",";
                else str += ";";
           }
        }
        return str + "]";
    }
}

