import java.util.Scanner;

public class Is_It_Prime {

    public static boolean isPrime(int n){
        for(int i=2;i<n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if(n<=1){
            System.out.println("There is no prime number less than 2");
        }
        System.out.println(isPrime(n));
    }
}
