package polysparse;

//OVERVIEW: classe immutabile che rappresenta un polinomio sparso mediante due array. Il grado presente in posizione i nell'array deg,
//          é associato al ceofficiente in posizione i dell'array coeff. Quindi se ho un polinomio: 4x^3 avremo deg[0] = 3 e coeff[0] = 4.
public class PolySparse{
    //Variabile d'istanza che rappresenta i gradi dei singoli monomi del polinomio sparso.
    private int[] deg;
    //Variabile d'istanza che rappresenta l'insieme dei coefficienti del polinomio sparso.
    private int[] coeff;

    //Costruttori
    //EFFECTS: instanzia un nuovo polinomio sparso zero.
    public PolySparse(){
        this.deg = new int[1];
        this.coeff = new int[1];
    }

    //EFFECTS: instanzia un monomio cx^n. Nel caso in cui n<0 solleva un'eccezione di tipo NegativeExponentException.
    public PolySparse(int c, int n){
        if(n<0) throw new NegativeExponentException("Il grado del monomio non puo' essere negativo.");
        this.deg = new int[1];
        this.deg[0] = n;
        this.coeff = new int[1];
        this.coeff[0] = c;
    }

    //EFFECTS: instanzia un polinomio sparso avente una dimensione n. Ovvero puó contenere al massimo n elementi.
    private PolySparse(int n){
        this.deg = new int[n];
        this.coeff = new int[n];
    }

    //Metodi
    //EFFECTS: restituisce un nuovo polinomio sparso dato dalla somma di this e q.
    public PolySparse add(PolySparse q){
        PolySparse new_Poly = new PolySparse(this.deg.length);
        for(int i=0; i<this.deg.length; i++){
            for(int j=0; j<q.getLength(); j++){
                if(this.deg[i] == q.degree(j)){
                    if(new_Poly.isFull()) //Nel caso in cui sia pieno, aggiungo un nuovo spazio.
                        new_Poly = new_Poly.addSpace();
                    new_Poly.deg[i] = this.deg[i];
                    new_Poly.coeff[i] = this.coeff[i] + q.coeff(j);
                }
                else if(j+1 == q.getLength()){
                    if(new_Poly.isFull()) //Nel caso in cui sia pieno, aggiungo un nuovo spazio.
                        new_Poly = new_Poly.addSpace();
                    new_Poly.deg[i] = this.deg[i];
                    new_Poly.coeff[i] = this.coeff[i];
                }
            }
        }
        for(int i=0; i<q.getLength(); i++){
            if(!new_Poly.contains(q.degree(i))){
                if(new_Poly.isFull()) //Nel caso in cui sia pieno, aggiungo un nuovo spazio.
                    new_Poly = new_Poly.addSpace();
                new_Poly.deg[deg.length] = q.degree(i);
                new_Poly.coeff[coeff.length] = q.coeff(i);
            }
        }
        return new_Poly;
    }

    //EFFECTS: restituisce un nuovo polinomio dato dalla sottrazione di this e q.
    public PolySparse sub(PolySparse q){
        return this.add(q.minus());
    }

    //EFFECTS: restituisce un nuovo polinomio dato dalla moltiplicazione di this e q.
    public PolySparse mul(PolySparse q){
        PolySparse new_Poly = new PolySparse(this.deg.length);
            for(int i=0; i<this.deg.length; i++){
                for(int j=0; j<q.getLength(); j++){
                    if(!new_Poly.contains(this.deg[i] + q.degree(j))){
                        if(new_Poly.isFull()) //Nel caso in cui sia pieno, aggiungo un nuovo spazio.
                            new_Poly = new_Poly.addSpace();
                        new_Poly.coeff[i] = this.coeff[i] * q.coeff(j);
                        new_Poly.deg[i] = this.deg[i] + q.degree(j);
                    }
                    else{
                        for(int k=0; k<new_Poly.deg.length; k++){
                            if(new_Poly.deg[k] == this.deg[i] + q.degree(j))
                                new_Poly.coeff[k] += this.coeff[i] * q.coeff(j);
                        }
                    }
                }
            }
        return new_Poly;
    }

    //EFFECTS: restituisce un nuovo polinomio sparso che é l'opposto di this.
    public PolySparse minus(){
        PolySparse new_Poly = new PolySparse(this.deg.length);
        for(int i=0; i<this.deg.length; i++){
            new_Poly.deg[i] = this.deg[i];
            new_Poly.coeff[i] = -this.coeff[i];
        }
        return new_Poly;
    }

    //EFFECTS: restituisce un nuovo polinomio sparso, dato dal contneuto di p con l'aggiunta di un nuovo spazio.
    public PolySparse addSpace(){
        PolySparse new_Poly = new PolySparse(this.deg.length + 1);
        for(int i=0; i<this.deg.length; i++){
            new_Poly.deg[i] = this.deg[i];
            new_Poly.coeff[i] = this.coeff[i];
        }
        return new_Poly;
    }

    //EFFECTS: restituisce true se n é contenuto all'interno dell'array dei gradi del polinomio sparso. Nel caso in cui non lo contenga o
    //         l'array é vuoto restituisce false.
    public boolean contains(int n){
        for(int i=0; i<this.deg.length; i++){
            if(this.deg[i] == n)
                return true;
        }
        return false;
    }

    //EFFECTS: restituisce true se il polinomio sparso non puó piú contenere elementi, altrimenti restitusice false. Nel caso in cui il
    //         polinomio sparso sia vuoto, solleva un'eccezione di tipo EmptyException.
    public boolean isFull(){
        if(this.deg.length == 0) throw new EmptyException("Il polinomio non contiene nessun elemento.");
        if(this.deg[this.deg.length - 1] != 0)
            return true;
        return false;
    }

    //EFFECTS: restituisce il grado dell'elemento in posizione n. Nel caso in cui n<0 solleva un'eccezione di tipo NegativeExponentException.
    public int degree(int n){
        if(n<0) throw new NegativeExponentException("Il grado del polinomio non puo' essere negativo.");
        return this.deg[n];
    }

    //EFFECTS: restituisce il numero di elementi presenti in this.
    public int getLength(){
        return this.deg.length;
    }

    //EFFECTS: restituisce il coefficiente di this di grado n. Nel caso in cui n<0 solleva un'eccezione di tipo NegativeExponentException.
    public int coeff(int n){
        if(n<0) throw new NegativeExponentException("Il grado del polinomio non puo' essere negativo.");
        return this.coeff[n];
    }

    @Override
    //EFFECTS: restituisce una stringa che rappresenta il contenuto di this.
    public String toString(){
        String s = "";
        for(int i=0; i<this.deg.length; i++){
            if(this.coeff[i] > 0) s+="+";
            s += "" + this.coeff[i];
            if(this.deg[i] == 1) s += "x";
            else if(this.deg[i] != 0) s+= "x^" + this.deg[i];
        }
        return s;
    }
}