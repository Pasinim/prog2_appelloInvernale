/**
 * le istanze di questa classe concreta estendono la classe astratta Robot.
 * Un robotCauto possiede una altezza massima, ed `e in grado di
  spostare più di un pacco se e solo se (oltre al primo pacco che è sempre in
  grado di spostare a prescindere dall'altezza), la somma delle altezze dei
  pacchi accumulati sulla sua superficie di carico non eccede mai l'altezza
  massima consentita;

 */

public class RobotCauto  extends Robot{

    public final int altezzaMax;

    public RobotCauto(int numero, Scaffalatura partenza, Scaffalatura arrivo, int hMax) {
        super(numero, partenza, arrivo);
        if (hMax <= 0) throw new IllegalArgumentException("L'altezza massima deve essere un valore >=0");
        altezzaMax = hMax;

    }


    @Override
    /**
     * Sovrascrive il metodo della superclasse. Solleva una eccezione nel caso in cui this non riesca a spostare
     * tutti i pacchi a causa della loro altezza cumulata troppo elevata.
     */
    public void sposta() {
        /** TODO */

        super.sposta();
    }

    
    
}
