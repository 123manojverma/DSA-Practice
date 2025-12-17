import java.util.Scanner;

public class littleponnyandmaximumelement {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int b=sc.nextInt();
        int op=0,present=0;
        for(int i=0;i<n;i++){
            if(arr[i]==b){
                present=1;
            }
            if(arr[i]>b){
                op++;
            }
        }
        if(present==1){
            System.out.println(op);
        }else{
            System.out.println(-1);
        }
    }
}
