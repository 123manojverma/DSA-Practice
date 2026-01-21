import java.util.HashMap;

public class PrefixSumHashMap {

    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int cnt=0;
        hm.put(0,1);
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(hm.containsKey(sum-k)){
                cnt+=hm.get(sum-k);
            }
            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }
        return cnt;
    }

//    public int longestSubarray(int[] nums, int limit) {
//
//    }

    public static int longestSubarraySum(int[] arr,int k){
        HashMap<Integer,Integer>hm=new HashMap<>();
        int maxlen=0;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum==k){
                maxlen=i+1;
            }
            if(hm.containsKey(sum-k)){
                maxlen=Math.max(maxlen,i-hm.get(sum-k));
            }
            if(!hm.containsKey(sum)){
                hm.put(sum,i);
            }
        }
        return maxlen;
    }

    public static int pivotIndex(int[] nums){
        int totalsum=0;
        for(int x:nums){
            totalsum+=x;
        }
        int leftsum=0;
        for(int i=0;i<nums.length;i++){
            totalsum-=nums[i];
            if(totalsum==leftsum)return i;
            leftsum+=nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3};
        System.out.println(subarraySum(nums,3));
        int[] arr={10,5,2,7,1,-10};
        System.out.println(longestSubarraySum(arr,15));
        int[] nums1={1,7,3,6,5,6};
        System.out.println(pivotIndex(nums1));
    }
}
