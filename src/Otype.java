// package src;

public class Otype {
    
    String opcode;
    stateStruct state;

    Otype(String instruct,stateStruct state){
        opcode = instruct.substring(0,3);
        this.state = state;
    }

    public void simulate(){
        if(opcode.equals("110")){ // halt
            state.printState();
            state.pc++;
            // System.out.println("machine halted");
            // System.out.println("total of " + counter + " instructions executed");
            // System.out.println("final state of machine:");
            // state.printState();

        }

        if(opcode.equals("111")){ // no-op
            // no-op
            state.pc++;
        }
    }
}
