package Robot;

public interface Robot {
    /**
     * Deposita il pacco dalla scaffalatura start alla scaffalatura end.
     * 
     * @param pacco il numero di pacchi da depositare
     * @param start Scaffalatura da cui prelevare il pacco
     * @param end   Scaffalatura in cui depositare il pacco
     */
    public void deposita(int numeroPacchi, int start, int end);

}
