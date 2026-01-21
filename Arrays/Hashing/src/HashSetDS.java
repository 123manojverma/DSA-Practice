import java.util.HashSet;

public class HashSetDS {

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer>hs=new HashSet<>();
        for(int x:nums){
            if(hs.contains(x)){
                return true;
            }
            hs.add(x);
        }
        return false;
    }

    public static int lengthofLongestSubstring(String s){
        HashSet<Character>hs=new HashSet<>();
        int l=0;
        int maxlen=0;
        for(int i=0;i<s.length();i++){
            while(hs.contains(s.charAt(i))){
                hs.remove(s.charAt(l));
                l++;
            }
            hs.add(s.charAt(i));
            maxlen=Math.max(i-l+1,maxlen);
        }
        return maxlen;
    }

    public static void main(String[] args) {
        int[] nums={1,1,2,9,5,2,2,5,6,4,5,8};
        System.out.println(containsDuplicate(nums));
        System.out.println(lengthofLongestSubstring("hello"));
    }
}
