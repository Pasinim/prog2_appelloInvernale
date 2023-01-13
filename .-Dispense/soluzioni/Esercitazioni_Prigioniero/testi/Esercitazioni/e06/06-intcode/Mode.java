public enum Mode {
    //valori che associo alle costanti
    POSITION(0),
    IMMEDIATE(1),
    RELATIVE(2);

    public final int code;
    private Mode(int code){
        this.code=code;
    }

    //metodo di fabbricazione, restituisce un modo
    //parte dal codice e restituisce un modo
    public static Mode fromCode(int code){
        for (Mode m : values()){ //itero su tutte le costanti definite
            if (m.code == m) return m;
        } 
        throw new IllegalArgumentException("Invalid mode: " + m);
    }
}
