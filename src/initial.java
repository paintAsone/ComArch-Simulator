package src;

public class initial{
    
    public static void main(String[] args){
        // int counter = 0;

        // stateStruct a = new stateStruct();
        // a.printState();

        // //Test add instruction
        // byte rs1 = 0b001;
        // byte rs2 = 0b010;
        // byte rd = 0b011;
        // Rtype_add r = new Rtype_add(a, rs1, rs2, rd);
        // r.simulate();
        // a.printState();

        //Test 2s complement
        int b = 3;
        System.out.println("binary string : "+Integer.toBinaryString(b));
        String s =  Integer.toBinaryString(b);
        System.out.println("string : "+s);
        System.out.println(Integer.parseInt(s,2));
        // Complement c = new Complement(b);
        // System.out.println(c.newoffSet());
        // System.out.println(Integer.toBinaryString(c.newoffSet()));
    }
}
