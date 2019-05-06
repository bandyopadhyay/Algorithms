import java.util.ArrayList;
import java.util.List;

public class StringPermutations {


    public static void main(String[] args){
        StringPermutations s = new StringPermutations();
        List<String> r = s.permuteS("ab");
        for(String str : r){
            System.out.println(str);
        }
    }


    public List<String> permuteS(String s){
        List<String> result = new ArrayList<>();
        permute("", s, result);
        return  result;
    }

    private void permute(String prefix, String suffix, List<String> result) {

        if(suffix.length()==0){
            result.add(prefix);
        } else {
            for(int i=0; i<suffix.length(); i++) {
                permute(prefix+suffix.charAt(i),suffix.substring(0,i)+suffix.substring(i+1),result);
            }
        }
    }
}
