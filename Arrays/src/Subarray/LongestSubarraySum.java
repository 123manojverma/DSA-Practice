package Subarray;

import java.util.HashMap;

public class LongestSubarraySum {

    public static int Longestsubarraysum(int[] arr,int k){
        HashMap<Integer,Integer>hm=new HashMap<>();
        int sum=0;
        int maxlen=0;
        hm.put(0,-1);

        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(hm.containsKey(sum-k)){
                maxlen=Math.max(maxlen,i-hm.get(sum-k));
            }
            hm.putIfAbsent(sum,i);
        }
        return maxlen;
    }

    public static void main(String[] args) {
        int[] arr={1,-1,5,-2,3};
        int k=3;
        System.out.println(Longestsubarraysum(arr,k));
    }
}
