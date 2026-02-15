package Weekly489;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class First_Element_with_Unique_Frequency {
    public static int firstUniqueFreq(int[] nums) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        HashSet<Integer> hs=new HashSet<>();
        HashSet<Integer>hs1=new HashSet<>();
        for(Map.Entry<Integer,Integer>m:hm.entrySet()){
            if(hs.contains(m.getValue())){
                hs1.add(m.getValue());
            }else{
                hs.add(m.getValue());
            }
        }
        for(int x:nums){
            if(!hs1.contains(hm.get(x))){
                return x;
            }
        }
        return -1;
    }
    public static int firstUniqueFreq1(int[] nums) {
        int max =0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>max)
            {
                max = nums[i];
            }
        }
        int [] freq = new int[max+1];
        for(int i=0;i<nums.length;i++)
        {
            freq[nums[i]]++;
        }
        int [] freqcount = new int[nums.length+1];
        for(int i=0;i<freq.length;i++)
        {
            if(freq[i]>0)
                freqcount[freq[i]]++;
        }
        for(int n : nums)
        {
            if(freqcount[freq[n]] == 1)
            {
                return n;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums={20,10,30,30};
        System.out.println(firstUniqueFreq(nums));
        System.out.println(firstUniqueFreq1(nums));
    }
}
