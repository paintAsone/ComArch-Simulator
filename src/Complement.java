package src;

public class Complement {

    String offset;

    Complement(String offset){
        this.offset = offset;
    }

    /*
     * 2's Complement convert
     * Binary to Decimal
     */
    public int complement_2s(){

        // Positive case
        if(offset.charAt(0) == '0'){
            String s = offset.substring(2, 16);
            return Integer.parseInt(s,2);
        }

        // Negative case
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
            int newOffset = Integer.parseInt(str.toString(),2) + 1;
            return -newOffset;
        }
    }
}
