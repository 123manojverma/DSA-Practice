import java.util.Scanner;

public class Closest_MinMax {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
            min=Math.min(a[i],min);
            max=Math.max(a[i],max);
        }
        int len=Integer.MAX_VALUE;
//        for(int i=0;i<n;i++){
//            for(int j=i;j<n;j++){
//                int s=0,m=0;
//                for(int k=i;k<=j;k++){
//                    if(a[k]==min){
//                        s=1;
//                    }
//                    if(a[k]==max){
//                        m=1;
//                    }
//                }
//                if(s==1 && m==1){
//                    len=Math.min(j-i+1,len);
//                }
//            }
//        }
//        System.out.println(len);

        int s=Integer.MIN_VALUE,e=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(a[i]==min){
                s=i;
            }
            if(a[i]==max){
                e=i;
            }
            if(s>=0 && e>=0){
                len=Math.min(len,Math.abs(e-s)+1);
            }
        }
        System.out.println(len);
    }
}
