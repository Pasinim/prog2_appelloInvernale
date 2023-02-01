import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Le istanza di questa classe rappresentano una Scaffalatura, che possiede un numero (progressivo) identificativo id e una lista di pacchi.
 * IR: id >=0 
 *      pacchi != null
 *      per ogni pacco p presente in pacchi: p != null
 * (Nota: eventuali errori nel caso in cui si cerchi di rimuovere un pacco da una pila di pacchi vuota ed errori equivalenti vengono gestiti direttametne
 * dalla linkedlist, quindi in questa classe non e` necessario fare ulteriori controlli)
 * 
 * AF: Per ogni pacco p in pacchi: "| p.toString | \n"
 */

public class Scaffalatura {


        /* Il nome della colonna */
        private final int id; //l' editor da un warning perch`e non sono riuscito ad implementare in tempo l'utilizzo di questo attributo
    
        /* La lista dei pacchi che sono impilati sulla colonna */
        private final LinkedList<Pacco> pacchi;
    
        /**
         * Costruisce una scaffalatura
         * @param id lettera che identifica la colonna
         * @thows IllegalArgumentExpection se 
         */
        public Scaffalatura(int id) {
            if (id < 0) throw new IllegalArgumentException("Il numero dello scaffale deve essere un valore positivo");
            this.id = id;
            this.pacchi = new LinkedList<Pacco>();
        }
    
    
        /**
         * Deposita il pacco p
         * @param p pacco da depositare sulla colonna (this)
         */
        public void deposita(Pacco p) {
            Objects.requireNonNull(p, "Il riferimento al pacco e` null");
            pacchi.addLast(p);
        }
    
        /**
         * Restituisce il pacco che si trova sul fondo della lista
         *  Se la lista e` vuota solleva una eccezione di tipo NoSuchElementException (gestita dal tipo LinkedList)
         *  @return pacco in fondo alla lista
         */
        public Pacco preleva () {
            return pacchi.removeLast();
        }


        @Override
        public String toString() {
            String ret = "";
            Iterator<Pacco> it = pacchi.iterator();
            while (it.hasNext()){
                Pacco next = it.next();
                //TODO: Formattazione da migliorare
                ret += String.format("| %s | \n",  next.toString());
            }        
            return ret;
        }
    
        
    }
    