public class interestingarray {
    public static void main(String[] args) {
        int[]  arr={1,8,9,12};
        int a=arr[0];
        for(int i=1;i<arr.length;i++){
            a^=arr[i];
        }
        if(a%2==0){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
