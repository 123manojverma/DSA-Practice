import java.util.HashMap;

public class HashMapDS {

    public static int[] TwoSumOnePass(int[] nums,int target){
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(target-nums[i])){
                return new int[]{hm.get(target-nums[i]),i};
            }
            hm.put(nums[i],i);
        }
        return new int[]{};
    }

    public static int subarraysum(int[] nums,int k){
        HashMap<Integer,Integer>hm=new HashMap<>();
        hm.put(0,1);
        int sum=0,cnt=0;
        for(int x:nums){
            sum+=x;
            cnt+=hm.getOrDefault(sum-k,0);
            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }
        return cnt;
    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int x:nums){
            hm.put(x,hm.getOrDefault(x,0)+1);
            if(hm.get(x)>nums.length/2)return x;
        }
        return -1;
    }

    public static void main(String[] args) {
//        HashMap<Integer,Integer>map=new HashMap<>();
//        map.put(1,2);
//        map.put(2,3);
//        map.put(3,4);
//        map.put(4,5);
//        System.out.println(map.get(1));
//        System.out.println(map.containsKey(1));
//        System.out.println(map.remove(3));
//        System.out.println(map.size());
//        int[] nums={1,2,3,5,4,6,9,5};
//        System.out.println(Arrays.toString(TwoSumOnePass(nums,19)));
//        System.out.println(subarraysum(nums,20));
        int[] nums={1,1,1,2,2,2,3,5,4,5,5,1,2,2,2,2,2,2,2};
        System.out.println(majorityElement(nums));
    }
}
