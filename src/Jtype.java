package src;

public class Jtype {

    int regA;
    int regB;
    String opcode;
    stateStruct state;

    Jtype(String instruct,stateStruct state){
        String A = instruct.substring(3,6);
        String B = instruct.substring(6,9);
        opcode = instruct.substring(0,3);

        regA = Integer.parseInt(A,2);
        regB = Integer.parseInt(B,2);
        
        this.state = state;
    }

    public void simulate(){
        /* 
         * jalr instruction(101)
         * เก็บค่า PC+1 ไว้ใน regB ซึ่ง PC คือ address ของ jalr instruction และกระโดดไปที่ address ที่ถูกเก็บไว้ใน regA 
         * แต่ถ้า regA และ regB คือ register ตัวเดียวกัน ให้เก็บ PC+1 ก่อน และค่อยกระโดดไปที่ PC+1
        */
        if(opcode.equals("101")){
            state.reg[regB] = state.pc+1;
            if(regA != regB){
                state.pc = state.reg[regA];
            }else{
                state.pc = state.pc+1;
            }
            
        }
    }
}
