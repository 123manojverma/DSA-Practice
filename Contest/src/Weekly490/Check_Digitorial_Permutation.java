package Weekly490;
import java.util.*;

public class Check_Digitorial_Permutation {
    public static int fact(int a){
        if(a==0)return 1;
        return a*fact(a-1);
    }

    public static boolean isDigitorialPermutation(int n) {
        int sum=0;
        int val=n;
        ArrayList<Integer>arr=new ArrayList<>();
        while(val>0){
            int a=val%10;
            int f=fact(a);
            sum+=f;
            arr.add(a);
            val/=10;
        }
        val=sum;
        ArrayList<Integer>arr1=new ArrayList<>();
        while(val>0){
            int a=val%10;
            arr1.add(a);
            val/=10;
        }
        Collections.sort(arr);
        Collections.sort(arr1);
        if(arr.size()!=arr1.size()){
            return false;
        }
        int i=0;
        while(i<arr.size()){
            if(arr.get(i)!=arr1.get(i)){
                return false;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        int n=145;
        System.out.println(isDigitorialPermutation(n));
    }
}
