package Biweekly180;

public class Minimum_Operations_to_Transform_Array_into_Alternating_Prime {
    public static boolean isPrime(int num){
        if(num<2){
            return false;
        }
        boolean flag=true;
        for(int i=2;i*i<=num;i++){
            if(num%i==0){
                flag=false;
                break;
            }
        }
        return flag;
    }

    public static int minOperations(int[] nums) {
        int n=nums.length;
        int cnt=0;
        for(int i=0;i<n;i++){
            int j=0;
            if(i%2==0){
                while(!isPrime(nums[i]+j)){
                    j++;
                }
            }else{
                while(isPrime(nums[i]+j)){
                    j++;
                }
            }
            cnt+=j;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        System.out.println(minOperations(nums));
    }
}
