import java.util.*;

public class Solution {
    public static void main (String[] args){

        List<String> orderedList = new ArrayList<>();
        orderedList.add("w1 has uni gry");
        orderedList.add("r1 box ape bit");
        orderedList.add("br8 eat nim did");
        orderedList.add("b4 xi me nu");
        orderedList.add("t2 13 121 98");
        orderedList.add("f3 54 54 31");

        Solution s = new Solution();
        print(s.orderedJunctionBoxes(orderedList.size(), orderedList));
    }

    private static void print(List<String> orderedJunctionBoxes) {

        for(String s : orderedJunctionBoxes){
            System.out.println(s);
        }
    }


    public List<String> orderedJunctionBoxes(int numberOfBoxes, List<String> boxList)
    {
        List<String> orderedList = new ArrayList<>();
        List<String> oldOrderedList = new ArrayList<>();
        List<String> newOrderedList = new ArrayList<>();
        for(String str:boxList){
//            int firstSpace = str.indexOf(' ');
//            String id = str.substring(0,firstSpace);
//            String version = str.substring(firstSpace);
//            convertedVersion = version.replace


            String[] words = str.split(" ");

            // Id
           // words[0];



            if(isNumericVersion(words)){
                newOrderedList.add(str);
            } else {
                oldOrderedList.add(str);
            };

        }


        Comparator<? super String> cmp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

            int firstSpace1 = o1.indexOf(' ');
            String id1 = o1.substring(0,firstSpace1);
            String version1 = o1.substring(firstSpace1+1);

            int firstSpace2 = o2.indexOf(' ');
            String id2 = o2.substring(0,firstSpace2);
            String version2 = o2.substring(firstSpace2+1);

            if(!version2.equals(version1)) {
                return version1.compareTo(version2);

            }
                return id2.compareTo(id1);
            }
        };

        Collections.sort(oldOrderedList,cmp);
        //oldOrderedList.sort(cmp);
        orderedList.addAll(oldOrderedList);
        orderedList.addAll(newOrderedList);
        return orderedList;

    }

    private boolean isNumericVersion(String[] words) {
        if(words.length > 2){
            for(int i =1; i <words.length; i++){
                if(!isInteger(words[i])){
                    return false;
                }
            }
        }

        return true;
    }


    public static boolean isInteger(String s) {
//        try {
//            Integer.parseInt(s);
//        } catch(NumberFormatException e) {
//            return false;
//        } catch(NullPointerException e) {
//            return false;
//        }
        // only got here if we didn't return false
        return s.matches("\\d+");
    }

}
