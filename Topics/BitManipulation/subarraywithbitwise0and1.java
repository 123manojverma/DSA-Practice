import java.util.*;

public class subarraywithbitwise0and1 {
    public static void main(String[] args) {
        int[] arr={1,0};
        int cnt=0;
        int n=arr.length;
        int f=-1,l=-1;
        for(int i=0;i<n;i++){
            if(arr[i]==1){
                f=i;
                break;
            }
        }
        for(int i=n-1;i>=0;i--){
            if(arr[i]==1){
                l=i;
                break;
            }
        }
        for(int i=0;i<n;i++){
            if(arr[i]==1){
                cnt+=n-i;
            }else{
                if(i<l){
                    cnt+=n-l;
                }
            }
        }
        System.out.println(cnt);
    }
}
