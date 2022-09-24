package src;
public class Rtype_nand {

    stateStruct s;
    int regA;
    int regB;
    int destReg;

    Rtype_nand(String opcodeBits){
        // this.s = s;
        // this.regA = regA;
        // this.regB = regB;
        // this.destReg = destReg;
    }

    public void simulate(){

        /* 
         * Add instruction
         * บวกค่าใน regA ด้วยค่าใน regB และเอาไปเก็บใน destReg
         */
        s.reg[destReg] = s.reg[regA] + s.reg[regB];
        s.pc++;
    }


}
