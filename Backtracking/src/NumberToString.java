import java.util.List;

public class NumberToString {

    public static void main(String[] args){
        NumberToString s = new NumberToString();
        String a = s.numberToString(1234);
       // System.out.println(a);

        System.out.println(s.myAtoi("    0000000000000   "));
    }

     String numberToString(int i) {
        StringBuilder sb = new StringBuilder();
        int div = i;
        int rem = i;
        while(div > 0){
            rem = div%10;
            div =div/10;
            sb.insert(0, (char)('0'+rem));
        }
//
//        System.out.println("Integer.MAX_VALUE : " + Integer.MAX_VALUE);
//
//         System.out.println("Integer.MIN_VALUE : " +Integer.MIN_VALUE);
        return sb.toString();
    }

    public int myAtoi(String str) {
        if(str == null || str.length()==0) return 0;

        boolean neg = false;
        int number = 0;

        int startIndex =0;
        int endIndex = str.length();



        for(int i =0 ; i < str.length() ; i++ ) {
            if( str.charAt(i) == 32 || str.charAt(i) == '0' ) {
                startIndex++;
                continue;
            } else if(str.charAt(i)!='-' && str.charAt(i)!='+' && (str.charAt(i) < '0' || str.charAt(i)  > '9')){
                return 0;
            }

            startIndex = i;
            break;

        }

        if(startIndex==str.length())return 0;


        if(str.charAt(startIndex)== '-'){
            neg = true;
            startIndex++;
        } else if(str.charAt(startIndex)== '+'){
            startIndex++;
        }




        for(int i = startIndex+1 ; i < str.length() ; i++){
            if( str.charAt(i) < '0' || str.charAt(i)  > '9') {
                endIndex = i;
                break;
            }
        }



        if(endIndex-startIndex>10){
            return  neg ?  Integer.MIN_VALUE : Integer.MAX_VALUE;
        } else if(endIndex-startIndex==10){
            if (str.charAt(startIndex) > '2') {
                return  neg ?  Integer.MIN_VALUE : Integer.MAX_VALUE;

            }
        }

        int mult =1;

        for(int i = endIndex -1 ; i >=startIndex ; i--){

            number = number + (str.charAt(i)-'0')*mult;
            if(number<0) {
                return  neg ?  Integer.MIN_VALUE : Integer.MAX_VALUE;
            };
            mult = mult*10;



        }

        if(neg) return -number;


        return number;

    }

}
