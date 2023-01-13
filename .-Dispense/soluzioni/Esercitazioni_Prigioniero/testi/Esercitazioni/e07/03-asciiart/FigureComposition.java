import java.util.Objects;

//OVERVIEW

public class FigureComposition implements Figure{

    public List<Figure> figures;

    public FigureComposition (final List<Figure> figures){
        //figures = new ArrayList<List> 
        (Objects.requireNonNull(figures));
        for (Figure f : figures) 
            Objects.requireNonNull(f);
        this.figures = new ArrayList<Figure>(figures);
    }
    @Override
    public void draw(final Bitmap bitmap){
        for (figure f : figures) f.draw(bitmap); 
    }
}
