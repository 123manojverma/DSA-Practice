package Biweekly181;

public class Compare_Sums_of_Bitonic_Parts {
    public static int compareBitonicSums(int[] nums) {
        int n=nums.length;
        int i=0;
        long l=0,r=0;
        while(i<n-1 && nums[i]<nums[i+1]){
            l+=nums[i];
            i++;
        }
        l+=nums[i];
        while(i<n){
            r+=nums[i];
            i++;
        }
        if(l==r){
            return -1;
        }else if(l<r){
            return 1;
        }else{
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] nums={2,4,5,2};
        System.out.println(compareBitonicSums(nums));
    }
}
