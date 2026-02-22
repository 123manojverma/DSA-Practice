package Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class TeamForming{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        Arrays.sort(nums);
        int ans=0;
        for(int i=0;i<n;i+=2){
            ans+=nums[i+1]-nums[i];
        }
        System.out.println(ans);
    }
}