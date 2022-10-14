package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class stateStruct {
    int pc;
    int[] mem = new int[65536];
    int[] reg = new int[8];
    int numMemory;

    /*
     * กำหนดค่า state เริ่มต้น 
     * set pc = 0
     * read in the entire machine-code file into memory
     * initialize registers
     * numMemory = number of machine-code
    */
    stateStruct(){
         /* เริ่มต้นค่า pc = 0 */
        pc = 0;

        /* read in the entire machine-code file into memory */
        try {
            File myObj = new File("src/test.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              mem[numMemory] = Integer.parseInt(data);
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

    }

      /*
      * printState function
      */
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

   
}
