package Biweekly176;

public class House_Robber_V {
    public static long rob(int[] nums, int[] colors) {
        int n=nums.length;
        long[] dp=new long[n+1];
        int j=0;
        dp[0]=0;
        for(int i=0;i<n;i++){
            if(colors[i]!=colors[j]){
                j=i;
                dp[i+1]=dp[i]+nums[i];
            }else if(i-j>=2){
                dp[i+1]=Math.max(dp[i],dp[i-1]+nums[i]);
            }
            else{
                dp[i+1]=Math.max(dp[j]+nums[i],dp[i]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] nums={1,4,3,5};
        int[] colors={1,1,2,2};
        System.out.println(rob(nums,colors));
    }
}
