import java.lang.reflect.Array;
import java.util.Arrays;

public class range_sum_query {
    public static void main(String[] args) {
        int[] a={1,2,3,4,5};
        int[][] b={{1,4},{2,3}};
//        int[] pre=new int[5];
//        pre[0]=a[0];
//        for(int i=1;i<a.length;i++){
//            pre[i]=a[i]+pre[i-1];
//        }
//        System.out.println(Arrays.toString(pre));
//        int[] res=new int[b.length];
//        for(int i=0;i<b.length;i++){
//            if(b[i][0]==1){
//            res[i]=pre[b[i][1]-1];
//            }
//            else{
//                res[i]=pre[b[i][1]-1]-pre[b[i][0]-2];
//            }
//        }
//        System.out.println(Arrays.toString(res));
        int[] res=new int[b.length];
        int sum=0;
        for(int i=0;i<b.length;i++){
            for(int j=b[i][0]-1;j<b[i][1];j++){
                sum+=a[j];
            }
            res[i]=sum;
        }
        System.out.println(Arrays.toString(res));
    }
}
