package src;

public class Otype {
    
    String opcode;
    stateStruct state;

    Otype(String instruct,stateStruct state){
        opcode = instruct.substring(0,3);
        this.state = state;
    }

    public void simulate(){
        /* 
         * halt instruction(110)
         * PC = PC+1 like every instruction else, printState again and print out that machine is halting 
        */
        if(opcode.equals("110")){ 
            state.pc++;
        }

        /* 
         * halt instruction(110)
         * PC = PC+1 like every instruction else, printState again and print out that machine is halting 
        */
        if(opcode.equals("111")){
            state.pc++;
        }
    }
}
