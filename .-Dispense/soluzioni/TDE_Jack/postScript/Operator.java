package tde.postScript;

import java.util.function.Consumer;

public class Operator {
    /**
     * Implementa l'operazione di add.
     * 
     * @throws IllegalArgumentException Se il consumer viene chiamato su una Stack dove i primi due Token non sono numeri.
     */
    private static final Consumer<TokenStack> add = (s) -> {
        try {
            s.push(Token.createTokenDouble(s.pop().numero() + s.pop().numero()));
        } catch (NotNumberException e) {
            throw new IllegalArgumentException("Uno degli addendi non e' un numero");
        }
    };

    /**
     * Implementa l'operazione di sub.
     * 
     * @throws IllegalArgumentException Se il consumer viene chiamato su una Stack dove i primi due Token non sono numeri.
     */
    private static final Consumer<TokenStack> sub = (s) -> {
        try {
            s.push(Token.createTokenDouble(s.pop().numero() - s.pop().numero()));
        } catch (NotNumberException e) {
            throw new IllegalArgumentException("Uno degli addendi non e' un numero");
        }
    };

    /**
     * Implementa l'operazione di mul.
     * 
     * @throws IllegalArgumentException Se il consumer viene chiamato su una Stack dove i primi due Token non sono numeri.
     */
    private static final Consumer<TokenStack> mul = (s) -> {
        try {
            s.push(Token.createTokenDouble(s.pop().numero() * s.pop().numero()));
        } catch (NotNumberException e) {
            throw new IllegalArgumentException("Uno degli addendi non e' un numero");
        }
    };


    public enum Operators{
        ADD (add),
        SUB (sub),
        MUL (mul);

        private final Consumer<TokenStack> operation;

        private Operators(Consumer<TokenStack> c){
            this.operation = c;
        }

        public void perform(TokenStack s){
            this.operation.accept(s);
        }
    }


    public static void peform_operation(Operators c, TokenStack s){
        c.perform(s);
    }

    public static void main(String[] args){
        Token<Double> t = Token.createTokenDouble(1.0);
        Token<Double> t2 = Token.createTokenDouble(3.0);
        Token<Double> t3 = Token.createTokenDouble(4.0);

        TokenStack s = new TokenStack();
        s.push(t);
        s.push(t2);
        s.push(t3);

        System.out.println("" + t.isNumero() + t);
        System.out.println("" + t2.isSimbolo() + t2);
        System.out.println(s);  
        Operator.peform_operation(Operators.ADD, s);
        Operator.peform_operation(Operators.SUB, s);
        System.out.println(s);        
    }
}
