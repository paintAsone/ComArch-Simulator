package src;

public class Itype {

    private int regA;
    private int regB;
    private int offSet;
    private String opcode;
    stateStruct state;
    String filename = "result_multi.txt";

    Itype(String instruct,stateStruct state){
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
         * Load regB จาก memory และ memory address หาได้จากการเอา offsetField บวกกับค่าใน regA
        */
        if(opcode.equals("010")){
            System.out.println("LW");
            int address = offSet + state.reg[regA];
            state.reg[regB] = state.mem[address];
            state.pc++;
        }

        /* 
         * sw instruction(011)
         * Store regB ใน memory และ memory address หาได้จากการเอา offsetField บวกกับค่าใน regA
        */
        else if(opcode.equals("011")){
            System.out.println("SW");
            int address = offSet + state.reg[regA];
            // System.out.println("add : "+ address);
            if(state.numMemory < address+1){
                state.numMemory = address+1;
            }
            state.mem[address] = state.reg[regB]; 
            // System.out.println("mem[7] : "+ state.mem[7]);
            state.pc++;
            // System.out.println("numMem: "+ state.numMemory);
        }

        /* 
         * beq instruction (100)
         * ถ้า ค่าใน regA เท่ากับค่าใน regB ให้กระโดดไปที่ address PC+1+offsetField ซึ่ง PC คือ address ของ beq instruction
        */
        else{
            System.out.println("BEQ");
            if(state.reg[regA] == state.reg[regB]){
                state.pc = state.pc + offSet + 1;
            }
            else{
                state.pc++;
            }
        }
    
    }
}
