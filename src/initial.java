package src;

public class initial{
    
    public static void main(String[] args){
        // int counter = 0;

        stateStruct a = new stateStruct();
        a.printState();

        // //Test add instruction
        // byte rs1 = 0b001;
        // byte rs2 = 0b010;
        // byte rd = 0b011;
        // Rtype_add r = new Rtype_add(a, rs1, rs2, rd);
        // r.simulate();
        // a.printState();


        // Test 2s complement
        // Complement c = new Complement("0000000000000111");
        // System.out.println("flip bit : " + c.complement_2s());


        // Rtype r = new Rtype("0010010100000000000000001", a);
        // r.simulator();
        // a.printState();
        Itype i = new Itype("0110000010000000000000111", a);
        i.simulate();
        a.printState();
    }
}
