import java.util.Scanner;

public class Bulbs {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
//        brute
//        int flag=0,op=0;
//        for(int i=0;i<n;i++){
//            if(flag==0){
//                if(a[i]==1){
//                    continue;
//                }else {
//                    flag=1;
//                    op++;
//                }
//            }else {
//                if(a[i]==1){
//                    flag=0;
//                    op++;
//                }else {
//                    continue;
//                }
//            }
//        }
//        System.out.println(op);

        int op=0;
        boolean rs=false;
        for(int i=0;i<n;i++){
            if(a[i]==0 && !rs){
                op++;
                rs=true;
            }
            if(a[i]==1 && rs){
                op++;
                rs=false;
            }
        }
        System.out.println(op);
    }
}
