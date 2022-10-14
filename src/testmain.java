// package src;

// import java.io.FileWriter;
// import java.io.IOException;
// import java.io.PrintWriter;

// public class testmain {
//     public static void main(String[] args) throws IOException{

//         stateStruct state = new stateStruct();
        
//         String fileName = "result.txt";
//         //String fileName = "result_multi.txt";
//         FileWriter fileWriter = new FileWriter(fileName);
//         PrintWriter printWriter = new PrintWriter(fileWriter);

//         boolean end = false;
//         int counter = 0;
//         // for(int p=0;p<20;p++){
//         do{
//             state.printState();
//             // printWriter.print(state.printState());
//             int opcode = state.mem[state.pc];
//             // แปลง opcode base 10 > base 2
//             String opcodeString = Integer.toBinaryString(opcode);

//             // ต้องมี 25 ตัว คือ bit ที่ 24-0 ถ้าไม่ถึงให้เติม 0 ข้างหน้าให้ครบ
//             if(opcodeString.length() < 25){
//                 int lengthofZero = 25-opcodeString.length();
//             for(int i = 0; i<lengthofZero; i++){
//                 opcodeString = '0'+opcodeString;
//             }
//         }
           
//         // ถ้ามี 25 bit ครบ (bit ที่ 31-26 ไม่ใช้ *และควรเป็น 0)
//         if(opcodeString.length() == 25){
//             String[] opcodeBit = opcodeString.split("");
//             String first3bits = opcodeBit[0]+opcodeBit[1]+opcodeBit[2];

//             switch (first3bits){
//                 case "000": {
//                     // printWriter.print("ADD \n");
//                     Rtype add = new Rtype(opcodeString,state);
//                     add.simulate();
//                     //instQueue.add(add);
//                     break;
//                 }
//                 case "001": {
//                     // printWriter.print("NAND \n");
//                     Rtype nand = new Rtype(opcodeString,state);
//                     nand.simulate();
//                     break;
//                 }
//                 case "010": {
//                     // printWriter.print("LW \n");
//                     Itype lw = new Itype(opcodeString,state);
//                     lw.simulate();
//                     break;
//                 }
//                 case "011": {
//                     // printWriter.print("SW \n");
//                     Itype sw = new Itype(opcodeString,state);
//                     sw.simulate();
//                     break;
//                 }
//                 case "100": {
//                     // printWriter.print("BEQ \n");
//                     Itype beq = new Itype(opcodeString,state);
//                     beq.simulate();
//                     break;
//                 }
//                 case "101": {
//                     // printWriter.print("JALR \n");
//                     Jtype jalr = new Jtype(opcodeString,state);
//                     jalr.simulate();
//                     break;
//                 }
//                 case "110": {
//                     // printWriter.print("HAULT \n");
//                     Otype hault = new Otype(opcodeString,state);
//                     hault.simulate();
//                     end = true;
//                     break;
//                 }
//                 case "111": {
//                     // printWriter.print("NO-OP \n");
//                     Otype noop = new Otype(opcodeString,state);
//                     noop.simulate();
//                     break;
//                 }
//             }
//         }  
//         counter++;
//         }while(!end);

//         printWriter.close();

//         System.out.println("machine halted");
//         System.out.println("total of " + counter + " instructions executed");
//         System.out.println("final state of machine:");
//         state.printState();

//     }
// }
