/**
 * Le istanze di questa classe rappresentano una stella fissa.
 * Tale classe è un sottotipo della classe corpoceleste, ergo la estende ed implementa i suoi metodi astratti.
 * Tale classe è immutabile perciò è lecito avere i suoi campi pubblici.
 */

public class StellaFissa extends CorpoCeleste{

    /**
     * AF: AF_super
     * IR: IR_super
     * Tale invariante è assicurato dall'unico costruttore.
     */
    public final Punto punto;

    public StellaFissa(String nome, Punto punto) {
        super(nome, punto);
        this.punto = punto;
    }

    @Override
    public long EnergiaPotenziale() {
        return 0;
    }

    @Override
    public long EnergiaCinetica() {
        return 0;
    }
    
}
