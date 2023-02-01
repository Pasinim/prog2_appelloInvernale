
/**
 * le istanze di questa classe concreta estendono la classe astratta Robot.
 * Un microRobot e` in grado di spostare solamente un pacco alla volta
 */

public class RobotMicro extends Robot {

    public RobotMicro(Scaffalatura partenza, Scaffalatura arrivo) {
        super(1, partenza, arrivo);
    }
    
}
