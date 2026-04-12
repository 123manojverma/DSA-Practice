package Biweekly180;

public class Count_Digit_Appearances {
    public static int countDigitOccurrences(int[] nums, int digit) {
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            int val=nums[i];
            while(val>0){
                if((val%10)==digit){
                    cnt++;
                }
                val/=10;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums={12,32,22,50};
        int digit=2;
        System.out.println(countDigitOccurrences(nums,digit));
    }
}
