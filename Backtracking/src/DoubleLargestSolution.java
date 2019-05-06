import CombinationsSum3.Solution;

import java.util.ArrayList;
import java.util.List;

public class DoubleLargestSolution {


    public double largestSumOfAverages(int[] A, int K) {

        if(K > A.length) return 0;

        List<List<Integer>> result = new ArrayList<>();

        backtrackPartiton(result, new ArrayList<>(), K, A.length, 1);

         print(result);

        double score = 0;


            for(List<Integer> a :result ){

                int index =a.get(0);
                double avg = findAvg(A, 0,a.get(0));


                for(int i =1 ; i<a.size(); i++){


                  //  int first = index + a.get(i-1) ;
                    int last = index + a.get(i);
                    avg = avg + findAvg(A, index ,last);

                    index =last;

                }

                if(score < avg) {
                    score = avg;
                }

            }




        return score;

    }

    private double findAvg(int[] a, int i, Integer integer) {
        double sum = 0 ;
        for(int r =i; r<integer; r++) {
           sum = sum + a[r];
        }
        return sum/(integer-i);
    }


    public void backtrackPartiton(List<List<Integer>> result, List<Integer> temp, int k, int n,int start){
        if(temp.size() == k ){
            if(sum(temp)==n){
                result.add(new ArrayList<Integer>(temp));
            }
        } else {

            for(int i = start ; i<=n ; i++){
                temp.add(i);
                backtrackPartiton(result, temp, k,n, start);
                temp.remove(temp.size()-1);

            }
        }
    }


    private int sum(List<Integer> temp) {
        int sum = 0 ;
        for(Integer a : temp) {
            sum = sum + a;
        }
        return sum;
    }



    public static void main (String[] args){
        DoubleLargestSolution s = new DoubleLargestSolution();
        int[] arr ={5296,942,8278,2993,89,1757,515,1021,2511,5733};
        System.out.println( s.largestSumOfAverages(arr, 1));
    }


    private static void print(List<List<Integer>> result) {
        for(List<Integer> a :result ){
            for(Integer b: a){
                System.out.print(b+ ", ");
            }
            System.out.println();
        }

    }

}
