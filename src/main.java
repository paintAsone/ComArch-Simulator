package src;

public class main {
    public static void main(String[] args){

        stateStruct state = new stateStruct();

        boolean end = false;
        int counter = 0;

        // simulate until halt
        do{
            state.printState();
            int instructionDeci = state.mem[state.pc];
            // convert opcode base 10 to base 2
            String instruction = Integer.toBinaryString(instructionDeci);

            // must have 25 bit, bit 24-0 should be all 0
            if(instruction.length() < 25){
                int lengthofZero = 25-instruction.length();
                for(int i = 0; i<lengthofZero; i++){
                    instruction = '0' + instruction;
                }
            }

            if(instruction.length() > 25){
                System.out.print("Wrong Instruction at mem[" + state.pc + "]");
                System.exit(0); 
            }
           
            // if opcode already have 25 bits (we don't care about bit 31-26 and it should be all 0)
            if(instruction.length() == 25){
                String[] opcodeBit = instruction.split("");
                String first3bits = opcodeBit[0]+opcodeBit[1]+opcodeBit[2];

                switch (first3bits){
                    // opcode = 000 
                    // add instruction
                    case "000": {
                        Rtype add = new Rtype(instruction,state);
                        add.simulate();
                        break;
                    }
                    // opcode = 001 
                    // and instruction
                    case "001": {                    
                        Rtype nand = new Rtype(instruction,state);
                        nand.simulate();
                        break;
                    }
                    // opcode = 010
                    // lw instruction
                    case "010": {
                        Itype lw = new Itype(instruction,state);
                        lw.simulate();
                        break;
                    }
                    // opcode = 011 
                    // sw instruction
                    case "011": {
                        Itype sw = new Itype(instruction,state);
                        sw.simulate();
                        break;
                    }
                    // opcode = 100 
                    // beq instruction
                    case "100": {
                        Itype beq = new Itype(instruction,state);
                        beq.simulate();
                        break;
                    }
                    // opcode = 101 
                    // jalr instruction
                    case "101": {
                        Jtype jalr = new Jtype(instruction,state);
                        jalr.simulate();
                        break;
                    }
                    // opcode = 110 
                    // halt instruction
                    case "110": {
                        Otype hault = new Otype(instruction,state);
                        hault.simulate();
                        end = true;
                        break;
                    }
                    // opcode = 111 
                    // noop instruction
                    case "111": {
                        Otype noop = new Otype(instruction,state);
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
