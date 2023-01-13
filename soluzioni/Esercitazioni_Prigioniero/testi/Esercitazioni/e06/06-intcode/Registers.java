import jdk.vm.ci.code.Register;

public class Registers {
    protected int instructionPointer; //voglio circostanziarlo al package
    protected int relativeBasePointer;

    protected Registers(){
        instructionPointer = 0;
        relativeBasePointer = 0;
    }
}
