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
            //System.out.println("opcode = " + opcode);
            System.out.println("opcode = " + opcodeString + " #bits = " + opcodeString.length());
        

            // ต้องมี 25 ตัว คือ bit ที่ 24-0 ถ้าไม่ถึงให้เติม 0 ข้างหน้าให้ครบ
            if(opcodeString.length() < 25){
                int lengthofZero = 25-opcodeString.length();
                System.out.println(lengthofZero);
            for(int i = 0; i<lengthofZero; i++){
                opcodeString = '0'+opcodeString;
            }
        }
           
        // ถ้ามี 25 bit ครบ (bit ที่ 31-26 ไม่ใช้ *และควรเป็น 0)
        if(opcodeString.length() == 25){
            System.out.println("*25 bits* opcode = " + opcodeString + " #bits = " + opcodeString.length());
            String[] opcodeBit = opcodeString.split("");
            String first3bits = opcodeBit[0]+opcodeBit[1]+opcodeBit[2];
            System.out.print(first3bits + ' ');

            switch (first3bits){
                case "000": {
                    System.out.println("ADD Inst.");
                    Rtype add = new Rtype(opcodeString,state);
                    add.simulate();
                    //instQueue.add(add);
                    break;
                }
                case "001": {
                    System.out.println("NAND Inst.");
                    Rtype nand = new Rtype(opcodeString,state);
                    nand.simulate();
                    //instQueue.add(nand);
                    break;
                }
                case "010": {
                    System.out.println("LW Inst.");
                    Itype lw = new Itype(opcodeString,state);
                    lw.simulate();
                    //instQueue.add(lw);
                    break;
                }
                case "011": {
                    System.out.println("SW Inst.");
                    Itype sw = new Itype(opcodeString,state);
                    sw.simulate();
                    //instQueue.add(sw);
                    break;
                }
                case "100": {
                    System.out.println("BEQ Inst.");
                    Itype beq = new Itype(opcodeString,state);
                    beq.simulate();
                    //instQueue.add(beq);
                    break;
                }
                case "101": {
                    System.out.println("JALR Inst.");
                    Jtype jalr = new Jtype(opcodeString,state);
                    jalr.simulate();
                    //instQueue.add(jalr);
                    break;
                }
                case "110": {
                    System.out.println("HAULT Inst.");
                    Otype hault = new Otype(opcodeString,state);
                    hault.simulate();
                    end = true;
                    //instQueue.add(hault);
                    break;
                }
                case "111": {
                    System.out.println("NOOP Inst.");
                    Otype noop = new Otype(opcodeString,state);
                    noop.simulate();
                    //instQueue.add(noop);
                    break;
                }
            }
        }  
            counter++;
        }while(!end);

    }
}
