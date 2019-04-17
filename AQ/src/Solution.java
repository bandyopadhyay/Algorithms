// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
import java.util.ArrayList;
import java.util.List;
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<Integer> cellCompete(int[] states, int days)
    {
        List<Integer> result = new ArrayList<>();

        for(int i =0; i<days; i++){


            for(int j= 0; j<states.length; j++){
                if(j==0){
                    if(states[j+1]==0){
                        result.add(0);
                    } else {
                        result.add(1);
                    }
                } else if (j==states.length-1) {
                    if(states[j-1]==0){
                        result.add(0);
                    } else {
                        result.add(1);
                    }
                } else{
                    if((states[j-1]==0 && states[j+1]==0) || states[j-1]==1 && states[j+1]==1 ){
                        result.add(0);
                    } else {
                        result.add(1);
                    }
                }
            }

            for(int r =0 ; r< states.length; r++){
                states[r]= result.get(r);
            }

            result= new ArrayList<>();


        }


        return result;
    }

}