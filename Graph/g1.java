import java.util.*;

public class g1{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int v,e;
        v=sc.nextInt();
        e=sc.nextInt();
        // int[][] A=new int[v][v];
        // int a,b;
        // for(int i=0;i<e;i++){
        //     a=sc.nextInt();
        //     b=sc.nextInt();
        //     A[a][b]=1;
        //     A[b][a]=1;
        // }

        ArrayList<ArrayList<Integer>>B=new ArrayList<>(v);
        int a,b;
        for(int i=0;i<e;i++){
            a=sc.nextInt();
            b=sc.nextInt();
            ArrayList<Integer>arr=B.get(a);
            ArrayList<Integer>arr1=B.get(b);
            arr.add(b);
            arr1.add(a);
            B.set(a,arr);
            B.set(b,arr1);
        }
    }
}