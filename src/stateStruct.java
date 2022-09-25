package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class stateStruct {
    int pc;
    int[] mem = new int[65536];
    int[] reg = new int[8];
    int numMemory;
      // สร้าง list ของ inst ไว้ ตอนสุดท้ายก็ลูปละวนให้ simulate ทีเดียว (ยังไม่ได้เขียน)
    Queue<Object> instQueue = new LinkedList<Object>();

    /*กำหนดค่า state เริ่มต้น 
     * set pc = 0
     * read in the entire machine-code file into memory
     * initialize registers
     * numMemory = number of machine-code
    */
    stateStruct(){
        pc = 0;

        /* read in the entire machine-code file into memory */
        try {
            File myObj = new File("src/test.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              mem[numMemory] = Integer.parseInt(data);
              System.out.println("memory["+numMemory+"]="+mem[numMemory]);
              numMemory++;
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }

        /* initialize registers */
        for(int i = 0;i<8;i++){
            reg[i] = 0;
        }

        //test เฉยๆ
        reg[1] = 2;
        reg[2] = 5;

        simulate();
    }

    public void printState(){
        System.out.println("\n@@@\nstate:");
        System.out.println("\tpc " + pc);

        System.out.println("\tmemmory : ");
        for(int i = 0; i<numMemory; i++){
            System.out.println("\t\tmem["+i+"] " + mem[i]);
        }

        System.out.println("\tregister : ");
        for(int i = 0; i<reg.length ;i++){
            System.out.println("\t\t reg["+i+"] " + reg[i]);
        }

        System.out.println("endstate\n");
    }

    public void splitOpcode(int opcode){

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
                    Rtype add = new Rtype(opcodeString,this);
                    instQueue.add(add);
                    break;
                }
                case "001": {
                    System.out.println("NAND Inst.");
                    Rtype nand = new Rtype(opcodeString,this);
                    instQueue.add(nand);
                    break;
                }
                case "010": {
                    System.out.println("LW Inst.");
                    Itype lw = new Itype(opcodeString,this);
                    instQueue.add(lw);
                    break;
                }
                case "011": {
                    System.out.println("SW Inst.");
                    Itype sw = new Itype(opcodeString,this);
                    instQueue.add(sw);
                    break;
                }
                case "100": {
                    System.out.println("BEQ Inst.");
                    Itype beq = new Itype(opcodeString,this);
                    instQueue.add(beq);
                    break;
                }
                case "101": {
                    System.out.println("JALR Inst.");
                    Jtype jalr = new Jtype(opcodeString,this);
                    instQueue.add(jalr);
                    break;
                }
                case "110": {
                    System.out.println("HAULT Inst.");
                    Otype hault = new Otype(opcodeString,this);
                    instQueue.add(hault);
                    break;
                }
                case "111": {
                    System.out.println("NOOP Inst.");
                    Otype noop = new Otype(opcodeString,this);
                    instQueue.add(noop);
                    break;
                }
            }
        }  
    }

    public void simulate(){
        for(int i = 0; i<numMemory; i++){
            splitOpcode(mem[i]);
        }
    }
}
