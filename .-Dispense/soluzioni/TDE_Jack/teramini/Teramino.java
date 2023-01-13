package tde.teramini;

import java.util.Set;

public interface Teramino {
    public char nome();
    
    public Set<Coordinata> coordinate();
    
    Teramino ruota();

    Rettangolo boundingBox();
}
