package src;

public class Rtype {

    private int regA;
    private int regB;
    private int destReg;
    private String opcode;
    stateStruct state;

    Rtype(String instruct,stateStruct state){
        // แบ่ง instruction เพื่อหา regA regB destReg opcode
        String A = instruct.substring(3,6);
        String B = instruct.substring(6,9);
        String Dest = instruct.substring(22,25);
        opcode = instruct.substring(0,3);

        regA = Integer.parseInt(A,2);
        regB = Integer.parseInt(B,2);
        destReg = Integer.parseInt(Dest,2);
        this.state = state;
    }

    public void simulate(){

        /* 
         * Add instruction
         * บวกค่าใน regA ด้วยค่าใน regB และเอาไปเก็บใน destReg
         */
        if(opcode.equals("000")){
            state.reg[destReg] = state.reg[regA] + state.reg[regB];
            state.pc++;
        }

        /*
         * nand instruction
         * Nand ค่าใน regA ด้วยค่าใน regB และเอาค่าไปเก็บใน destReg
         */
        else{
            
        String abase2 = toBinaryString(state.reg[regA]);
        String bbase2 = toBinaryString(state.reg[regB]);

        String allOne = fillBits("1","1",16);
        
        String filledA = fillBits("0",abase2,16);
        String filledB = fillBits("0",bbase2,16);

        String faand = "";
        String fband = "";

        for(int i = 0 ; i < 16; ++i){
            if(allOne.charAt(i) == filledA.charAt(i)){
                faand += "1";
            }else{
                faand += "0";
            }
            if(allOne.charAt(i) == filledB.charAt(i)){
                fband += "1";
            }else{
                fband += "0";
            }
        }   

        StringBuilder sb = new StringBuilder("");

        for(int i = 0; i<16; i++){
            String aa = faand.charAt(i)+"";
            String bb = fband.charAt(i)+"";

            String result = "0";
            if(aa.equals(bb) && aa.equals("1")){
                result = "1";
            }

            result = flip(result);

            sb.append(result);
        }
        String sbtoString = fillBits("0", sb.toString(), 32);
        int nand = toDecimal(sbtoString);
        state.reg[destReg] = nand;
        state.pc++;
        }
    }


    public static String fillBits(String filler, String base, int length) {
        StringBuilder sb = new StringBuilder("");

        while (base.length() + sb.length() < length) {
            sb = sb.append(filler);
        }
        sb = sb.append(base);

        return sb.toString();
    }

    public static String toBinaryString(int dec) {

        StringBuilder bin = new StringBuilder("");

        if (dec == 0 || dec == 1) {
            bin.append(dec);
            return bin.toString();
        }

        while (dec > 0) {
            bin.append(dec % 2);
            dec /= 2;
        }

        bin.reverse();
        return bin.toString();
    }

    public static String flip(String c) {
        if (c.equals("0")) {
            return "1";
        }
        return "0";
    }

    public static int toInteger(String token) {
        return Integer.parseInt(token);
    }

    public static String twosCompliment(String bin) {
        String twos = "", ones = "";

        for (int i = 0; i < bin.length(); i++) {
            ones += flip(bin.charAt(i)+"");
        }
        StringBuilder builder = new StringBuilder(ones);

        for (int i = ones.length() - 1; i > 0; i--) {
            if (ones.charAt(i) == '1') {
                builder.setCharAt(i, '0');
            } else {
                builder.setCharAt(i, '1');
                break;
            }
        }
        twos = builder.toString();

        return twos;
    }

    public static int toDecimal (String bin) {

        int dec = 0;
        int power = 0;

        if (bin.charAt(0) == '0') {
            for (int i = bin.length() - 1; i >= 0; i--) {
                dec += toInteger(bin.charAt(i) + "") * Math.pow(2, power);
                power++;
            }
        } else {
            bin = twosCompliment(bin);
            for (int i = bin.length() - 1; i >= 0; i--) {
                dec += toInteger(bin.charAt(i) + "") * Math.pow(2, power);
                power++;
            }
            dec = -dec;
        }

        return dec;
    }
    
}
