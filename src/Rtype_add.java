package src;
public class Rtype_add {

    stateStruct s;
    int regA;
    int regB;
    int destReg;

    Rtype_add(stateStruct s, byte regA, byte regB, byte destReg){
        this.s = s;
        this.regA = regA;
        this.regB = regB;
        this.destReg = destReg;
    }

    public void simulate(){

        /*
         * nana instruction
         * Nand ค่าใน regA ด้วยค่าใน regB และเอาค่าไปเก็บใน destReg
         */
        
    }


}
