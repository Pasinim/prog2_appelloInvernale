import java.util.Objects;

public class Rectangle implements Figure {
//composizione di figure
    private Figure Rectangle;
    public Rectangle( Coord start, int height, int length){
        Objects.requireNonNull(start);
        if (length < 0) throw IllegalArgumentException();
        if (height < 0) throw IllegalArgumentException();
/*      Il rettangolo è rappresentato con 4 segmenti (il numero rappresenta quale segmento è)
            0 3 3 
            0   2        i segmenti veritcali crescono dal alto verso il basso
            0   2        quelli orizzontali da sx a dx
            0   2
            1 1 2
*/

        Rectangle = new FigureComposition(
        List.of(
            new Segment(start, height - 1, true), //segmento 0
            new Segment(new Coord(start.r + height - 1, start.c), length - 1, false),
            new Segment(new Coord(start.r + 1, start.c + length - 1), height - 1, true), //da alto verso basso 
            new Segment(new Coord(start.r, start.c + 1), length - 1, false)
            )
        );
    }

    @Override
    public void draw(Bitmap bitmap){
        rectangle.draw(bitmap);
    }

    
}
