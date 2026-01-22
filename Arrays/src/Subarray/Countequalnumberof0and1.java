package Subarray;

import java.util.HashMap;

public class Countequalnumberof0and1 {

    public static int equal0and1(int[] nums){
        HashMap<Integer,Integer>hm=new HashMap<>();
        int n=nums.length;
        int sum=0;
        int cnt=0;
        hm.put(0,1);
        for(int i=0;i<n;i++){
            sum+=nums[i]==0?-1:1;
            cnt+=hm.getOrDefault(sum,0);
            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums={1,1,0,0,1,1,1,1,0,0,0};
        System.out.println(equal0and1(nums));
    }
}
