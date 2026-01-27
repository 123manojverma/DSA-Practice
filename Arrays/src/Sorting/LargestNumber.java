package Sorting;

import java.util.Arrays;

public class LargestNumber {

    public static String largestNumber(int[] nums) {
        Integer[] arr= Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(arr,(a,b)->(""+b+a).compareTo(""+a+b));

        if(arr[0]==0)return "0";
        StringBuilder sb=new StringBuilder();
        for(int x:arr){
            sb.append(x);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums={3,30,34,6,9};
        System.out.println(largestNumber(nums));
    }
}
