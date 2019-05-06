import java.util.ArrayList;
import java.util.List;

public class ArrayPermutations {

    public static void main(String[] args){
        ArrayPermutations s = new ArrayPermutations();
        int[] arr = {1,2,3,4};

        List<int[]> r = s.permuteA(arr);
        for(int[] str : r){

            for(int i: str) {

                System.out.print(i+ ", ");

            }
            System.out.println();
        }
    }

    private List<int[]> permuteA(int[] arr) {
        List<int[]> result = new ArrayList<>();

        permute(arr,0, result);

        return result;

    }

    private void permute(int[] arr, int start, List<int[]> result) {

        if(start== arr.length){
            result.add(arr.clone());
        } else {
            for(int i = start; i< arr.length; i++){
                swap( arr, start, i);
                permute(arr, start+1, result);
                swap( arr, start, i);
            }
        }
    }

    private void swap(int[] arr, int start, int i) {
        int temp = arr[start];
        arr[start] = arr[i];
        arr[i]= temp;
    }

}
