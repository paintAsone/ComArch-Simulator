package src;

public class Jtype {

    int regA;
    int regB;
    String opcode;
    stateStruct state;

    Jtype(String instruct,stateStruct state){
        // split instruction into regA regB opcode
        String A = instruct.substring(3,6);
        String B = instruct.substring(6,9);
        opcode = instruct.substring(0,3);

        regA = Integer.parseInt(A,2);
        regB = Integer.parseInt(B,2);
        
        this.state = state;
    }

    public void simulate(){
         /* 
         * jalr instruction(101)
         * store PC+1 in regB which PC is the address of jalr instruction and jump to address that store in regA 
         * if regA and regB is the same register store PC+1  and then jump to PC+1
        */
        if(opcode.equals("101")){
            state.reg[regB] = state.pc+1;
            if(regA != regB){
                state.pc = state.reg[regA];
            }else{
                state.pc = state.pc+1;
            }
            
        }
    }
}
