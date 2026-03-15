package Biweekly178;
import java.util.*;

public class FirstUniqueEvenElement {
    public static int firstUniqueEven(int[] nums) {
        HashSet<Integer>hs=new HashSet<>();
        HashSet<Integer>hs1=new HashSet<>();
        int n=nums.length;
        for (int j : nums) {
            if (j % 2 == 0) {
                if (hs1.contains(j)) {
                    hs.remove(j);
                } else {
                    hs.add(j);
                }
                hs1.add(j);
            }
        }
        for (int num : nums) {
            if (hs.contains(num)) {
                return num;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums={3,4,2,5,4,6};
        System.out.println(firstUniqueEven(nums));
    }
}
