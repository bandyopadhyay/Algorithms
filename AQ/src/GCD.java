public class GCD {

    public int generalizedGCD(int num, int[] arr)
    {
        int result = arr[0];
        for(int i = 1; i < arr.length; i++){
            result = gcd(result, arr[i]);
        }
        return result;
    }

    int gcd (int num1, int num2){
        int gcd =1;
        for(int i = 1; i <= num1 && i <= num2; i++)
        {
            if(num1%i==0 && num2%i==0)
                gcd = i;
        }
        return gcd;
    }
}
