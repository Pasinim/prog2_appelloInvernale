public class Coord {

    // The representation invariant is always true: any pair of integers is a valid
    // coordinate
    public final int r, c;
  
    public Coord(final int r, final int c) {
      this.r = r;
      this.c = c;
    }