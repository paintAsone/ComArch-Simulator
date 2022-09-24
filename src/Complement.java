package src;

public class Complement {

    String offset;

    Complement(String offset){
        this.offset = offset;
    }

    public int complement_2s(){
        System.out.println("0 : " + offset.charAt(0));

        if(offset.charAt(0) == '0'){
            String s = offset.substring(2, 16);
            System.out.println("s : " + s);
            return Integer.parseInt(s,2);
        }

        else{
            String s = offset.substring(2, 16);
            StringBuilder str = new StringBuilder(s);
            for(int i=0 ; i<str.length() ; i++){
                if(str.charAt(i) == '0'){
                    str.setCharAt(i, '1');
                }
                else{
                    str.setCharAt(i, '0');
                }
            }
            return -Integer.parseInt(str.toString(),2);
        }
    }
}
