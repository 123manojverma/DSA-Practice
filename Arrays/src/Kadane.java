public class Kadane {

    public static int KadaneMax(int[] nums){
        int maxsum=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i< nums.length;i++){
            sum+=nums[i];
            maxsum=Math.max(maxsum,sum);
            if(sum<0)sum=0;
        }
        return maxsum;
    }

    public static int CircularKadane(int[] nums){
        int normalmax=KadaneMax(nums);
        int total=0;
        for(int i=0;i<nums.length;i++){
            total+=nums[i];
            nums[i]=-nums[i];  //Invert
        }
        int minsum=KadaneMax(nums);
        int CircularMax=total+minsum;
        if(CircularMax==0)return normalmax;
        return Math.max(CircularMax,normalmax);
    }

    public static void main(String[] args) {
//        int[] nums={1,2,3,6,45,-20,5,-8,52,-6};
        int[] nums={5,-3,5};
//        System.out.println(KadaneMax(nums));
        System.out.println(CircularKadane(nums));
    }
}
