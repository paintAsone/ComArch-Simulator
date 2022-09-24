package src;

public class Rtype {

    int regA;
    int regB;
    int destReg;
    String opcode;
    stateStruct state;

    Rtype(String instruct,stateStruct state){
        String A = instruct.substring(3,6);
        String B = instruct.substring(6,9);
        String Dest = instruct.substring(22,25);
        opcode = instruct.substring(0,3);

        regA = Integer.parseInt(A,2);
        regB = Integer.parseInt(B,2);
        destReg = Integer.parseInt(Dest,2);
        this.state = state;
    }

    public void simulate(){
        /* 
         * Add instruction
         * บวกค่าใน regA ด้วยค่าใน regB และเอาไปเก็บใน destReg
         */
        if(opcode.equals("000")){
            state.reg[destReg] = state.reg[regA] + state.reg[regB];
            state.pc++;
        }

        /*
         * nand instruction
         * Nand ค่าใน regA ด้วยค่าใน regB และเอาค่าไปเก็บใน destReg
         */
        else{
            state.pc++;
        }
    }
    
}
