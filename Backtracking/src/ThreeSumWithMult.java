public class ThreeSumWithMult {


    public static void main(String[] args){
        int[] arr = {1,1,2,2,2,2};
        ThreeSumWithMult tswm = new ThreeSumWithMult();

       System.out.println( tswm.threeSumMulti(arr, 5));

    }
    public int threeSumMulti(int[] A, int target) {


        int cnt = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {

                if (exists(A, j, target - A[i] - A[j])) {

                }
            }


        }
        return cnt;
    }
        private boolean exists ( int[] a, int j, int search){


        return false;
        }
    }
