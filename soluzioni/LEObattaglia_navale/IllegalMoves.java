package battaglia_navale;
public class IllegalMoves extends RuntimeException {
    public IllegalMoves(){
        super();  
    }

    public IllegalMoves(String s){
        super(s);  
    }
}
