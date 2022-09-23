package src;

import java.util.ArrayList;

public class stateStruct {
    int pc;
    ArrayList<Integer> mem;
    ArrayList<Integer> reg;
    int numMemory;

    /*กำหนดค่า state เริ่มต้น 
     * pc = 0
     * mem เ
     * register ทั้ง 9 ตัว = 0
     * numMemory = 0
    */
    stateStruct(){
        pc = 0;
        mem = new ArrayList<>();
        reg = new ArrayList<>();
        for(int i = 0;i<8;i++){
            reg.add(0);
        }
        numMemory = 0;
    }

    public void printState(){
        System.out.println("state : ");
        System.out.println("\tpc " + pc);

        System.out.println("\tmemmory : ");
        for(int i = 0;i<mem.size();i++){
            System.out.println("\t\tmem["+i+"] "+mem.get(i));
        }

        System.out.println("\tregister : ");
        for(int i = 0;i<reg.size();i++){
            System.out.println("\t\t reg["+i+"] "+reg.get(i));
        }

        System.out.println("endstate\n");
    }

}
