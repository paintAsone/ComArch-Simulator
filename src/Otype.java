package src;

public class Otype {
    
    String opcode;
    stateStruct state;

    Otype(String instruct,stateStruct state){
        opcode = instruct.substring(0,3);
        this.state = state;
    }

    public void simulate(){
        if(opcode.equals("110")){ // halt
            state.pc++;
            state.printState();

        }

        if(opcode.equals("111")){ // no-op
            // no-op
        }
    }
}
