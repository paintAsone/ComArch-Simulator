package src;

public class Complement {

    byte b;

    Complement(byte b){
        this.b = b;
    }

    public byte newoffSet(){
        byte ans;
        ans = (byte) ~b;
        ans += 0b1;
        return ans;
    }
}
