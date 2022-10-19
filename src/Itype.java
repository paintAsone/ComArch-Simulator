package src;

public class Itype {

    private int regA;
    private int regB;
    private int offSet;
    private String opcode;
    stateStruct state;
    
    Itype(String instruct,stateStruct state){
        // split instruction into regA regB offset opcode
        String A = instruct.substring(3,6);
        String B = instruct.substring(6,9);
        String field = instruct.substring(9,25);
        opcode = instruct.substring(0,3);

        regA = Integer.parseInt(A,2);
        regB = Integer.parseInt(B,2);
        Complement c = new Complement(field);
        offSet = c.complement_2s();
        this.state = state;
    }

    public void simulate(){      

        /* 
         * lw instruction(010)
         * Load regB from memory and memory address which is offsetField + value in regA
        */
        if(opcode.equals("010")){
            int address = offSet + state.reg[regA];
            state.reg[regB] = state.mem[address];
            state.pc++;
        }

        /* 
         * sw instruction(011)
         * Store regB in memory and memory address which is offsetField + value in regA
        */
        else if(opcode.equals("011")){
            int address = offSet + state.reg[regA];
            if(state.numMemory < address+1){
                state.numMemory = address+1;
            }
            state.mem[address] = state.reg[regB]; 
            state.pc++;
        }

        /* 
         * beq instruction (100)
         * if value in regA = value in regB jump to address PC+1+offsetField which PC is the address of beq instruction
        */
        else{
            if(state.reg[regA] == state.reg[regB]){
                state.pc = state.pc + offSet + 1;
            }
            else{
                state.pc++;
            }
        }
    
    }
}
