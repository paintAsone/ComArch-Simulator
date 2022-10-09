package src;

public class Jtype {

    int regA;
    int regB;
    String opcode;
    stateStruct state;

    Jtype(String instruct,stateStruct state){
        String A = instruct.substring(3,6);
        String B = instruct.substring(6,9);
        opcode = instruct.substring(0,3);

        regA = Integer.parseInt(A,2);
        regB = Integer.parseInt(B,2);
        
        this.state = state;
    }

    public void simulate(){
        if(opcode.equals("101")){ // jalr
            System.out.println("JALR");
            state.reg[regB] = state.pc+1;
            if(regA != regB){
                state.pc = state.reg[regA];
            }else{
                state.pc = state.pc+1;
            }
            
        }
    }
}
