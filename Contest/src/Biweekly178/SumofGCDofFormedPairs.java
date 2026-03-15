package Biweekly178;
import java.util.*;

public class SumofGCDofFormedPairs {
    public static int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }

    public static long gcdSum(int[] nums) {
        int max=0;
        int n=nums.length;
        int[] prefixgcd=new int[n];

        for(int i=0;i<n;i++){
            max=Math.max(nums[i],max);
            prefixgcd[i]=gcd(nums[i],max);
        }
        Arrays.sort(prefixgcd);
        long sum=0;
        int i=0,j=n-1;
        while(i<j){
            sum+=gcd(prefixgcd[i],prefixgcd[j]);
            i++;j--;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums={2,6,4};
        System.out.println(gcdSum(nums));
    }
}
