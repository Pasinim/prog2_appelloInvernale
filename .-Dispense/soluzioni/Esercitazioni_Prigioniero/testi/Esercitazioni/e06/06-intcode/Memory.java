public class Memory {
    private List<Integer> memoryCells;

    public Memory(List<Integer> program){
        memoryCells = new ArrayList<>(program);
    }
    private void set (int index, int value){
        memoryCells.set(index, value);
    }

    private int get(int index){
        return memoryCells.get(index);
    }

    public class Location{
        private final Mode mode;
        private final int memoryIndex;
        private final int relativeBasePointer;

        public Location (Mode mode, int memoryIndex, int relativeBasePointer){
           this.mode = mode;
           this.memoryIndex = memoryIndex;
           this.relativeBasePointer = relativeBasePointer;   
        }
        void write(int v){
            //prima controllo la mode 
            //Per la write ci può essere solo indirizzamento diretto e relativo
            if (mode == Mode.Immediate) throw new IllegalStateException("Can't write in IMMEDIATE mode");
            int address = memoryIndex;
            if (mode == Mode.RELATIVE) address += relativeBasePointer;
            set(memoryIndex, v);
        }
        int read(){

        }
    }
}
