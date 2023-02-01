import java.util.Objects;

/** Le istanze di questa classe concerta rappresentano un pacco, identificato da una stringa non vuota
     * AF: prodotto != null 
     *      altezza > 0
     * RI: prodotto.toString() + altezza
     */
    public class Pacco {
        
        public final String prodotto;
        public final int altezza;

        /**
         * Costruisce un pacco
         * @param s il prodotto del pacco
         * @throws IllegalArgumentException se il la stringa è vuota o se è null oppure se l'altezza e` <= 0
         */
        public Pacco(String s, int h) {
            Objects.requireNonNull(s);
            if (s.isEmpty()) throw new IllegalArgumentException("Impossibile instanziare un pacco da una stringa vuota");
            if (h <= 0) throw new IllegalArgumentException("l' altezz del pacco deve essere un numero positivo");
            prodotto = s;
            altezza = h;
        }

        @Override
        public String toString() {
            return String.format("%s[%d]", prodotto.toString(), altezza);
        }
    }