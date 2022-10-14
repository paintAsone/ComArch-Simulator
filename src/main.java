package src;

public class main {
    public static void main(String[] args){

        stateStruct state = new stateStruct();

        boolean end = false;
        int counter = 0;

        // simulate จนกว่าจะเจอคำสั่ง halt
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
                // opcode = 000 
                // add instruction
                case "000": {
                    Rtype add = new Rtype(opcodeString,state);
                    add.simulate();
                    break;
                }
                // opcode = 001 
                // and instruction
                case "001": {                    
                    Rtype nand = new Rtype(opcodeString,state);
                    nand.simulate();
                    break;
                }
                // opcode = 010
                // lw instruction
                case "010": {
                    Itype lw = new Itype(opcodeString,state);
                    lw.simulate();
                    break;
                }
                // opcode = 011 
                // sw instruction
                case "011": {
                    Itype sw = new Itype(opcodeString,state);
                    sw.simulate();
                    break;
                }
                // opcode = 100 
                // beq instruction
                case "100": {
                    Itype beq = new Itype(opcodeString,state);
                    beq.simulate();
                    break;
                }
                // opcode = 101 
                // jalr instruction
                case "101": {
                    Jtype jalr = new Jtype(opcodeString,state);
                    jalr.simulate();
                    break;
                }
                // opcode = 110 
                // halt instruction
                case "110": {
                    Otype hault = new Otype(opcodeString,state);
                    hault.simulate();
                    end = true;
                    break;
                }
                // opcode = 111 
                // noop instruction
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
