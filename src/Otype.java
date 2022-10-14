package src;

public class Otype {
    
    String opcode;
    stateStruct state;

    Otype(String instruct,stateStruct state){
        opcode = instruct.substring(0,3);
        this.state = state;
    }

    public void simulate(){
        /* 
         * halt instruction(110)
         * เพิ่มค่า PC เหมือน instructions อื่นๆ และ halt เครื่อง นั่นคือให้ simulator รู้ว่าเครื่องมีการ halted เกิดขึ้น
        */
        if(opcode.equals("110")){ 
            System.out.println("HAULT");
            state.printState();
            state.pc++;
        }

        /* 
         * noop instruction(111)
         * เพิ่มค่า PC เหมือน instructions อื่นๆ และ ไม่ทำอะไรเลย
        */
        if(opcode.equals("111")){
            System.out.println("NO-OP");
            state.pc++;
        }
    }
}
