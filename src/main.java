package src;

public class main {
    public static void main(String[] args){

        stateStruct state = new stateStruct();
        boolean end = false;
        int counter = 0;
        do{
            state.printState();
            int opcode = state.mem[state.pc];
            // แปลง opcode base 10 > base 2
            String opcodeString = Integer.toBinaryString(opcode);

            // ต้องมี 25 ตัว คือ bit ที่ 24-0 ถ้าไม่ถึงให้เติม 0 ข้างหน้าให้ครบ
            if(opcodeString.length() < 25){
                int lengthofZero = 25-opcodeString.length();
            for(int i = 0; i<lengthofZero; i++){
                opcodeString = '0'+opcodeString;
            }
        }
           
        // ถ้ามี 25 bit ครบ (bit ที่ 31-26 ไม่ใช้ *และควรเป็น 0)
        if(opcodeString.length() == 25){
            String[] opcodeBit = opcodeString.split("");
            String first3bits = opcodeBit[0]+opcodeBit[1]+opcodeBit[2];

            switch (first3bits){
                case "000": {
                    Rtype add = new Rtype(opcodeString,state);
                    add.simulate();
                    //instQueue.add(add);
                    break;
                }
                case "001": {
                    Rtype nand = new Rtype(opcodeString,state);
                    nand.simulate();
                    break;
                }
                case "010": {
                    Itype lw = new Itype(opcodeString,state);
                    lw.simulate();
                    break;
                }
                case "011": {
                    Itype sw = new Itype(opcodeString,state);
                    sw.simulate();
                    break;
                }
                case "100": {
                    Itype beq = new Itype(opcodeString,state);
                    beq.simulate();
                    break;
                }
                case "101": {
                    Jtype jalr = new Jtype(opcodeString,state);
                    jalr.simulate();
                    break;
                }
                case "110": {
                    Otype hault = new Otype(opcodeString,state);
                    hault.simulate();
                    end = true;
                    break;
                }
                case "111": {
                    Otype noop = new Otype(opcodeString,state);
                    noop.simulate();
                    break;
                }
            }
        }  
        counter++;
        }while(!end);

        System.out.println("machine halted");
        System.out.println("total of " + counter + " instructions executed");
        System.out.println("final state of machine:");
        state.printState();

    }
}
