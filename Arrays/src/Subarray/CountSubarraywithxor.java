package Subarray;

import java.util.HashMap;

public class CountSubarraywithxor {

    public static int subarrayXor(int[] arr,int k){
        HashMap<Integer,Integer>hm=new HashMap<>();
        hm.put(0,1);
        int sum=0;
        int cnt=0;
        for(int i=0;i< arr.length;i++){
            sum^=arr[i];
            if(hm.containsKey(sum^k)){
                cnt+=hm.get(sum^k);
            }
            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] arr={1,3,7,9,8,7};
        int k=12;
        System.out.println(subarrayXor(arr,k));
    }
}
