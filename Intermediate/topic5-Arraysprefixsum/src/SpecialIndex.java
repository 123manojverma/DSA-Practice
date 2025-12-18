import java.util.Scanner;

public class SpecialIndex {

    public static int specialind(int[] arr,int n) {
        int[] even=new int[n];
        int[] odd=new int[n];
        even[0]=arr[0];
        odd[0]=0;

        for(int i=1;i<n;i++){
            if(i%2==0){
                even[i]=arr[i]+even[i-1];
                odd[i]=odd[i-1];
            }else{
                odd[i]=arr[i]+odd[i-1];
                even[i]=even[i-1];
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(i==0){
                if(even[n-1]-even[i]==odd[n-1]){
                    count++;
                }
            }
            else {
                if(even[i-1]+odd[n-1]-odd[i]==odd[i-1]+even[n-1]-even[i]){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(specialind(arr,n));
    }
}


//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class SpecialIndex {
//    public static int solve(ArrayList<Integer> arr) {
//        int[] psOdd = new int[arr.size()];
//        int[] psEven = new int[arr.size()];
//
//        psEven[0] = arr.get(0);
//        psOdd[0] = 0;
//
//        //create the odd and even prefix sum array
//        for(int i=1; i<arr.size(); i++) {
//            if(i % 2 == 0) {
//                psEven[i] = psEven[i - 1] + arr.get(i);
//                psOdd[i] = psOdd[i - 1];
//            } else {
//                psOdd[i] = psOdd[i-1] + arr.get(i);
//                psEven[i] = psEven[i - 1];
//            }
//        }
//
//        int n = arr.size();
//
//        int oddSum = 0, evenSum = 0, count = 0;
//        for(int i=0; i<arr.size(); i++) {
//            if(i == 0) {
//                oddSum = psEven[n - 1];
//                evenSum = psOdd[n - 1];
//            } else {
//                oddSum = psOdd[i -1] + (psEven[n - 1] - psEven[i]);
//                evenSum = psEven[i - 1] + (psOdd[n - 1] - psOdd[i]);
//            }
//
//            if(oddSum == evenSum) count++;
//        }
//
//        return count;
//
//    }
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int n=sc.nextInt();
//        ArrayList<Integer>arr=new ArrayList<>();
//        for(int i=0;i<n;i++){
//            arr.add(sc.nextInt());
//        }
//        System.out.println(solve(arr));
//    }
//}