public class AddString {

    public String addStrings1(String num1, String num2) {

        return  String.valueOf(convetToInt(num1) + convetToInt(num2));
    }

    private int convetToInt(String num1) {
        int number = 0;
        int mult =1;

        for(int i=num1.length()-1; i>=0; i--){
            char ch = num1.charAt(i);
            if(ch < '0' || ch > '9') throw new IllegalArgumentException("Not a number");
            number = number + mult*(ch -'0');
            mult = mult*10;
        }



        return number;
    }

    /*
    "vmokgggqzp"
            [3,5,1]
            ["kg","ggq","mo"]
            ["s","so","bfr"]
            */
    public static void main(String[] args){
        AddString as = new AddString();
        int[] arr2 = {3,5,1};
        String[] arr3 = {"kg","ggq","mo"} ;
        String[] arr4 = {"s","so","bfr"} ;
      System.out.println( as.findReplaceString("abcd", arr2, arr3, arr4));
    }

    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {

        int start =0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< indexes.length; i++){

            String prevSub = S.substring(start,indexes[i] );

            sb.append(prevSub);


            String sourceWord = sources[i];

            String sub = S.substring(indexes[i],indexes[i]+ sourceWord.length());



            if( sub.equals(sourceWord) ) {
              sb.append(targets[i]);
                start =  indexes[i]+ sourceWord.length();
            } else {
                start = indexes[i];
            }
        }

        sb.append(S.substring(start ));

        return sb.toString();

    }


    public String addStrings(String num1, String num2) {

        StringBuilder sb = new StringBuilder();

        int carry = 0;

        int i = num1.length()-1;

        int j = num2.length()-1;
        for(; i>=0 && j>=0; i--,j-- ){

            int add = num1.charAt(i)-'0' + num2.charAt(j)-'0' + carry;

            carry = add/10;
            int toAdd = add%10;

            sb.insert(0,Character.forDigit(toAdd,10));

        }

        while (i>=0){
            int add = num1.charAt(i)-'0' + carry;

            carry = add/10;
            int toAdd = add%10;

            sb.insert(0,Character.forDigit(toAdd,10));
            i--;
        }

        while (j>=0){
            int add = num1.charAt(i)-'0' + carry;

            carry = add/10;
            int toAdd = add%10;

            sb.insert(0,Character.forDigit(toAdd,10));
            j--;
        }



       return sb.toString();

    }
}
