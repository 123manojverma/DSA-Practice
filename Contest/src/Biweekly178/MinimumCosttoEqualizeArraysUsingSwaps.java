package Biweekly178;
import java.util.*;

public class MinimumCosttoEqualizeArraysUsingSwaps {
    public static int minCost(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        HashMap<Integer,Integer>hm1=new HashMap<>();
        int n=nums1.length;
        for(int i=0;i<n;i++){
            hm.put(nums1[i],hm.getOrDefault(nums1[i],0)+1);
            hm1.put(nums2[i],hm1.getOrDefault(nums2[i],0)+1);
        }
        if(hm.equals(hm1)){
            return 0;
        }
        for(Map.Entry<Integer,Integer>m:hm.entrySet()){
            if(hm1.containsKey(m.getKey())){
                if(hm1.get(m.getKey())>0 && m.getValue()>0){
                    int min=Math.min(m.getValue(),hm1.get(m.getKey()));
                    hm.put(m.getKey(),hm.get(m.getKey())-min);
                    hm1.put(m.getKey(),hm1.get(m.getKey())-min);
                }
            }
        }
        boolean flag=true;
        int op1=0;
        for(Map.Entry<Integer,Integer>m:hm.entrySet()){
            if(m.getValue()%2==0){
                op1+=m.getValue()/2;
            }else{
                flag=false;
                break;
            }
        }
        if(!flag){
            return -1;
        }
        int op2=0;
        for(Map.Entry<Integer,Integer>m:hm1.entrySet()){
            if(m.getValue()%2==0){
                op2+=m.getValue()/2;
            }else{
                flag=false;
                break;
            }
        }
        if(!flag){
            return -1;
        }
        if(op1==op2){
            return op1;
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] nums1={10,20};
        int[] nums2={20,10};
        System.out.println(minCost(nums1,nums2));
    }
}
