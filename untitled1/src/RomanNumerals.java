import java.util.HashMap;
import java.util.Map;

public class RomanNumerals {
    public static void main(String[] args) {

        String[] s = {"flower","flow","flight"};
      //  System.out.println(romanToInt("MDCCXXXII"));
    }

    /**
     * Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     */

    static Map<Character, Integer> symbolByValue = new HashMap();

    static {
        symbolByValue.put('I',1);
        symbolByValue.put('V',5);
        symbolByValue.put('X',10);
        symbolByValue.put('L',50);
        symbolByValue.put('C',100);
        symbolByValue.put('D',500);
        symbolByValue.put('M',1000);


        
    }

    public static int romanToInt(String s) {
        if(s== null || s.isEmpty()) return 0;
        
        char[] romans = s.toCharArray();

        int number = symbolByValue.get(romans[0]);

        for(int i = 1; i < romans.length ; i++) {

            number = number + symbolByValue.get(romans[i]);


            /**
             I can be placed before V (5) and X (10) to make 4 and 9.
             X can be placed before L (50) and C (100) to make 40 and 90.
             C can be placed before D (500) and M (1000) to make 400 and 900.
             */

            if (romans[i - 1] == 'I') {
                if (romans[i] == 'V' || romans[i] == 'X') {
                    number = number - 1 - 1;
                }

            } else if (romans[i - 1] == 'X') {
                if (romans[i] == 'L' || romans[i] == 'C') {
                    number = number - 10 - 10;
                }
            } else if (romans[i - 1] == 'C') {
                if (romans[i] == 'D' || romans[i] == 'M') {
                    number = number - 100 -100;
                }

            }

        }


        return number;
    }
}
