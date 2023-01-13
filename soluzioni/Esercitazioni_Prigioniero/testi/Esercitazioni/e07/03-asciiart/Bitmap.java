public class Bitmap {
    private int b;
    private int h;
    private boolean[][] bitmap;

    public Bitmap (int b, int h){
        if (b < 0 || h < 0) throw new IllegalArgumentException();
        this.b = b;
        this.h = h;
        this.bitmap = new boolean[b][h];
    }

    public void turnOn(Coord coord){
        if (coord.r > h || coord.r < 0 || coord.c > b || coord.c < 0) throw new IllegalArgumentException();
        this.bitmap[coord.r][coord.c] = true;
    }

    public void turnOff(Coord coord){
        if (coord.r > h || coord.r < 0 || coord.c > b || coord.c < 0) throw new IllegalArgumentException();
        this.bitmap[coord.r][coord.c] = false;
    }
    


}
