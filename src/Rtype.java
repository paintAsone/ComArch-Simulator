package src;

public class Rtype {

    private int regA;
    private int regB;
    private int destReg;
    private String opcode;
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
            //บรรทัดถัดไป = PC+1
            state.pc++;
        }

        /*
         * nand instruction
         * Nand ค่าใน regA ด้วยค่าใน regB และเอาค่าไปเก็บใน destReg
         */
        else{
            // ค่าใน regA andกับ ค่าใน regB
            int and = state.reg[regA] & state.reg[regB];
            String and_s1 = Integer.toBinaryString(and);
            StringBuilder and_s2 = new StringBuilder(and_s1);

            // not ค่าที่ and มา
            for(int i=0; i<and_s2.length();i++){
                if(and_s2.charAt(i) == '0'){
                    and_s2.setCharAt(i, '1');
                }
                else{
                    and_s2.setCharAt(i, '0');
                }
            }
            and_s1 = and_s2.toString();
            int nand = Integer.parseInt(and_s1);
            state.reg[destReg] = nand;
            state.pc++;
        }
    }
    
}
