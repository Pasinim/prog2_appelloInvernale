package tde.ps2;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * Interprete di comandi per PostScript.
 */
public class Inteprete {
    private final Parser p;
    private final TokenStack s;
    private final TabellaSimboli<Double> costanti;
    private final TabellaSimboli<Consumer<TokenStack>> operatori;

    /**
     * Inizializza un nuovo Interprete su stdin.
     */
    public Inteprete(){
        p = new Parser(System.in);
        s = new TokenStack();
        costanti = new TabellaSimboli<>();
        operatori = new TabellaSimboli<>();

        //Inizializzo tabella operatori
        operatori.aggiungi("add", Operatore.add);
        operatori.aggiungi("sub", Operatore.sub);
        operatori.aggiungi("mul", Operatore.mul);
        operatori.aggiungi("div", Operatore.div);
        operatori.aggiungi("dup", Operatore.dup);
        operatori.aggiungi("pop", Operatore.pop);
    }

    /**
     * Inizia la lettura da stdin.
     */
    public void leggi(){
        Iterator<Token<?>> i = p.tokens();

        while(i.hasNext()){
            Token<?> tkn = i.next();

            //Se é un numero aggiungo alla Stack
            if(tkn.isNumero()){
                s.push(tkn);
            //Altrimenti controllo se é un simbolo o un'operazione
            }else{
                String str = tkn.simbolo();

                try {
                    //Definizione di un simbolo
                    if(str.charAt(0) == '/'){
                        String symbol_name = str.substring(1);

                        s.push(Token.tokenString(symbol_name));
                    }else{
                        switch (str) {
                            case "add":
                                operatori.getValore(str).accept(s);
                                break;
                            case "sub":
                                operatori.getValore(str).accept(s);
                                break;
                            case "pop":
                                operatori.getValore(str).accept(s);
                                break;
                            case "dup":
                                operatori.getValore(str).accept(s);
                                break;
                            case "div":
                                operatori.getValore(str).accept(s);
                                break;
                            case "mul":
                                operatori.getValore(str).accept(s);
                                break;
                            case "def":
                                double symbol_value = s.pop().numero();
                                String symbol_name = s.pop().simbolo();
    
                                costanti.aggiungi(symbol_name, symbol_value);
                                break;
    
                            case "P":
                                System.out.println(s.toString());
                                break;
    
                            default:
                                Double valore = costanti.getValore(str);
                                s.push(Token.tokenDouble(valore));
                                break;
                        }    
                    }
                } catch (IllegalStateException e) {
                    System.out.println("Errore di conversione");
                }

            }
        }
    }

    public static void main(String args[]){
        Inteprete i = new Inteprete();
        i.leggi();
    }

}
