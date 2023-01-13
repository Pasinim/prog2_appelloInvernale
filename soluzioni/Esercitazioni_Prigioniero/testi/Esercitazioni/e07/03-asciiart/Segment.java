import java.util.Objects; 
public class Segment implements Figure {
    
    private final  Coord start;
    private final  int length;
    private final  boolean isVertical;
    
    //COSTRUTTORI
    public Segment( final Coord start,  final int length,  final boolean isVertical){
        if (start == null) throw new IllegalArgumentException();
        this.start = start;
        if (length < 0) throw new IllegalArgumentException();
        this.length = length;
        this.isVertical = isVertical;
    }

    @Override
    public void draw( final Bitmap bitmap){
        int r = start.r, c = start.c;
        if (isVertical) 
            for (int i = 0; i < length; i++) bitmap.turnOn(new Coord(r + i, c)));
        else 
            for (int i = 0; i < length; i++) bitmap.turnOn(new Coord(r, c + i)));
    }
}
