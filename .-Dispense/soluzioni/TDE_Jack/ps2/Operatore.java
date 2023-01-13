package tde.ps2;

import java.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Raccolta di Operatori lavoranti su una TokenStack.
 */
public class Operatore{

    private Operatore(){
        throw new AssertionError();
    }

    /**
     * Implementa addizione.
     */
    public static Consumer<TokenStack> add = stack ->
    {
        try {
            Token<?> t1 = stack.pop();
            Token<?> t2 = stack.pop();
            
            double n1 = t1.numero();
            double n2 = t2.numero();

            stack.push(Token.tokenDouble(n2+n1));
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    };

    /**
     * Implementa l'operazione di Sottrazione, 
     * Notare come l'operazione venga eseguita come n2-n1 dove n1 é l'ultimo Token inserito sulla Stack mentre n2 é il penultimo.
     */
    public static Consumer<TokenStack> sub = stack ->
    {
        try {
            Token<?> t1 = stack.pop();
            Token<?> t2 = stack.pop();
            
            double n1 = t1.numero();
            double n2 = t2.numero();

            stack.push(Token.tokenDouble(n2-n1));
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    };

    public static Consumer<TokenStack> mul = stack ->
    {
        try {
            Token<?> t1 = stack.pop();
            Token<?> t2 = stack.pop();
            
            double n1 = t1.numero();
            double n2 = t2.numero();

            stack.push(Token.tokenDouble(n2*n1));
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    };

    public static Consumer<TokenStack> div = stack ->
    {
        try {
            Token<?> t1 = stack.pop();
            Token<?> t2 = stack.pop();
            
            double n1 = t1.numero();
            double n2 = t2.numero();
            System.out.println(String.format("%.2f / %.2f", n2, n1));
            stack.push(Token.tokenDouble(n2/n1));
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    };

    /**
     * Implementa operazione di pop.
     */
    public static Consumer<TokenStack> pop = stack ->
    {
        try {
            stack.pop();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    };

    /**
     * Implementa operazione di dup.
     */
    public static Consumer<TokenStack> dup = stack ->
    {
        Token<?> t = stack.peek();
        stack.push(t);
    };



    public static void main(String args[]){
        TokenStack t = new TokenStack();
        Parser p = new Parser(System.in);
        Iterator<Token<?>> i = p.tokens();

        int count = 0;

        while(i.hasNext()){
            Token<?> tkn = i.next();
            t.push(tkn);
            count++;  
            
            if(count == 3){
                t.pop();
                String symb = tkn.simbolo();
                count = 0;
                switch (symb) {
                    case "add":
                        Operatore.add.accept(t);
                        break;
                    case "sub":
                        Operatore.sub.accept(t);                     
                        break; 
                    case "dup":
                        Operatore.dup.accept(t);                 
                        break;           
                    default:
                        break;
                }
            }

            System.out.println(t);
        }
    }
}
