package Subarray;

public class SubarraySumPositive {

    public static int subarrayequaltok(int[] nums,int k){
        int l=0;
        int sum=0;
        int cnt=0;
        for(int r=0;r<nums.length;r++){
            sum+=nums[r];
            while(sum>k){
                sum-=nums[l];
                l++;
            }
            if(sum==k)cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] arr={1,2,1,1,1};
        int k=3;
        System.out.println(subarrayequaltok(arr,k));
    }
}
