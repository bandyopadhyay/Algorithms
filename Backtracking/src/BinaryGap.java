
public class BinaryGap {


    public static void main(String[] args){
        BinaryGap s = new BinaryGap();
        System.out.println(s.solution(32));
    }


    public int solution(int N) {

        int maxLength =0;
        int currLength =0;

        String s = Integer.toBinaryString(N);

        for(int i = 0; i< s.length(); i++){
            if(s.charAt(i)=='0'){
                currLength++;
            } else{
                if(currLength>maxLength){
                    maxLength =currLength;

                }
                currLength =0;
            }

        }

        return  maxLength;
    }
}
