package src;
public class Rtype_add {

    stateStruct s;
    int regA;
    int regB;
    int destReg;

    /* กุเขียนไว้แต่มันน่าจะมาใช้ในนี้มากกว่า <3
        * R-type instructions (add, nand)
        * Bits 24-22 opcode
        * Bits 21-19 reg A (rs)
        * Bits 18-16 res B (rt)
        * Bits 15-3 ไม่ใช้ (ควรตั้งไว้ที่ 0)
        * Bits 2-0  destReg (rd)
                     
        String rs = opcodeBit[20]+opcodeBit[size-5]+opcodeBit[size-4]; //Bits 21-19 reg A (rs)
        String rt = opcodeBit[size-9]+opcodeBit[size-8]+opcodeBit[size-7]; //Bits 18-16 res B (rt)
        String rd = opcodeBit[size-size+2]+opcodeBit[size-size+1]+opcodeBit[size-size]; //Bits 2-0  destReg (rd)

        System.out.println("rs = " + rs + "rt = " + rt + "rd = " + rd);
    */

    Rtype_add(String opcodeBits){
        // this.s = s;
        // this.regA = regA;
        // this.regB = regB;
        // this.destReg = destReg;
    }

    public void simulate(){

        /*
         * nana instruction
         * Nand ค่าใน regA ด้วยค่าใน regB และเอาค่าไปเก็บใน destReg
         */
        
    }


}
