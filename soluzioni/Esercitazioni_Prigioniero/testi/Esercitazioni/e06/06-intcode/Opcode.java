import Memory.Location;

public enum Opcode {
    ADD(1, 3) { //Op, numero di parametri
        @Override
        Instruction toInstruction(Location[] parameters, Registers registers) {
            // TODO Auto-generated method stub
            return new Add(parameters);
        }
    }, 
    MULTIPLY(1, 3),
    HALT(1, 3);


    public final int op;
    public final int params;
    //privato perchè sono costanti
    private Opcode(int op, int params){
        this.op = op;
        this.params = params;
    }
    //a partire da opcode restituisco l'operazione
    public static Opcode fromOp(int op){
        for (Opcode o : values()){ //itero su tutte le costanti definite
            if (o.op == op) return op;
        } 
        throw new IllegalArgumentException("Invalid opcode: " + m);
    }

    //ogni opcode istanzia una classe differente, quindi per forzare ciascuna costante ad implementare questo metodo
    //uso quindi una classe astratta
    abstract Instruction toInstruction(Memory.Location[] parameters, Registers registers){
        
    }
}
