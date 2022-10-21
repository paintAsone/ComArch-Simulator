package src;

public class Rtype {

    private int regA;
    private int regB;
    private int destReg;
    private String opcode;
    stateStruct state;

    Rtype(String instruct,stateStruct state){
        // split instruction into regA regB destReg opcode
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
         * add instruction
         * value in regA + value in regB and store the result in destReg
         */
        if(opcode.equals("000")){
            state.reg[destReg] = state.reg[regA] + state.reg[regB];
            state.pc++;
        }

        /*
         * nand instruction
         * nand value in regA with value in regB and store the result in destReg
         */
        else{
        
            String bi_A = Integer.toBinaryString(state.reg[regA]);
            String bi_B = Integer.toBinaryString(state.reg[regB]);
            StringBuilder nand_St = new StringBuilder();
    
            if(bi_A.length() > bi_B.length()){
                int lengthofZero = bi_A.length() - bi_B.length();
                    for(int i = 0; i<lengthofZero; i++){
                        bi_B = '0' + bi_B;
                    }
            }
            
            if(bi_A.length() < bi_B.length()){
                int lengthofZero = bi_B.length() - bi_A.length();
                    for(int i = 0; i<lengthofZero; i++){
                        bi_A = '0' + bi_A;
                    }
            }
    
                nand_St = new StringBuilder(bi_A);
                for(int i=0; i<bi_A.length() ;i++){
                    if(bi_A.charAt(i) == '1' && bi_B.charAt(i)=='1'){
                            nand_St.setCharAt(i, '0');
                        }
                        else{
                            nand_St.setCharAt(i, '1');     
                        }
                    }

            int nand = Integer.parseInt(nand_St.toString(),2);
            state.reg[destReg] = nand;
            state.pc++;
        }
    }
    
}
