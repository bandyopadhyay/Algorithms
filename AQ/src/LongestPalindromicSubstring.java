public class LongestPalindromicSubstring {

    public static void main (String[] args){

        LongestPalindromicSubstring l = new LongestPalindromicSubstring();
        System.out.println(l.longestPalindrome("bb"));

    }

    public String longestPalindrome(String s) {

        if(s.length()< 2) return s;
        String result = new StringBuilder( s.charAt(0)).toString();


        for(int i =0; i < s.length(); i++){
            for(int j = i+1; j< s.length() +1; j++){

                String ss = s.substring(i,j);
                if(isPalindrome(ss)){

                    if(j-i > result.length())
                        result = ss;
                }
            }
        }
        return  result ;

    }

    private boolean isPalindrome(String ss) {

        int begin = 0; int end = ss.length() -1;

        while(begin < end){
            if(ss.charAt(begin) != ss.charAt(end)){
                return false;
            }

            begin++;
            end--;
        }
        return true;

    }
}
