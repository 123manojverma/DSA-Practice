import java.util.Scanner;

public class secondlargest {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int[] arr=new int[size];
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        int max=0;
        int smax=0;
        for(int i=0;i<size;i++){
            if(arr[i]>=arr[max]) {
                smax = max;
                max = i;
            }else{
                if(arr[i]>arr[smax]){
                    smax=i;
                }
            }
        }
        System.out.println(arr[smax]);
    }
}
