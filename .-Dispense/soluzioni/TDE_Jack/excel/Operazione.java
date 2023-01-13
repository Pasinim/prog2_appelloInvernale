package tde.excel;

import java.util.List;
import java.util.Objects;

/**
 * Enum contenente Operazioni.
 */
public enum Operazione {
    SOTR("-"){
        @Override
        public int calcola(List<Integer> operatori) {
            if(Objects.isNull(operatori)){
                throw new IllegalArgumentException();
            }

            int ret = operatori.get(0);
            for(int i = 1; i < operatori.size(); i++){
                ret -= operatori.get(i);
            }
            return ret;
        }
    },

    MUL("*"){
        @Override
        public int calcola(List<Integer> operatori) {
            if(Objects.isNull(operatori)){
                throw new IllegalArgumentException();
            }

            int ret = operatori.get(0);
            for(int i = 1; i < operatori.size(); i++){
                ret *= operatori.get(i);
            }
            return ret;
        }
    },

    ADD("+"){
        @Override
        public int calcola(List<Integer> operatori) {
            if(Objects.isNull(operatori)){
                throw new IllegalArgumentException();
            }

            int ret = operatori.get(0);
            for(int i = 1; i < operatori.size(); i++){
                ret += operatori.get(i);
            }
            return ret;
        }
    },

    MAX("M"){
        @Override
        public int calcola(List<Integer> operatori) {
            if(Objects.isNull(operatori)){
                throw new IllegalArgumentException();
            }

            int ret = Integer.MIN_VALUE;
            for(int i = 0; i < operatori.size(); i++){
                int n = operatori.get(i);

                if(n > ret ){
                    ret = n;
                }
            }
            return ret;
        }
    };

    private final String symbol;

    /**
     * Inizializza una Operazione con simbolo s
     * 
     * @param s Simbolo dell'operazione
     */
    private Operazione(String s){
        this.symbol = s;
    }

    /**
     * Inizializza una operazione eseguita sulla lista di interi l.
     * 
     * @param l Lista di interi su cui eseguire l'operazione.
     */
    public abstract int calcola(List<Integer> operatori);

    @Override
    public String toString(){
        return this.symbol;
    }
}
