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
        s.reg[destReg] = s.reg[regA] + s.reg[regB];
    }


}
