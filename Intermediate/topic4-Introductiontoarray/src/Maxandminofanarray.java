public class Maxandminofanarray {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<5;i++){
            min=Math.min(min,arr[i]);
            max=Math.max(max,arr[i]);
        }
        System.out.println(min+" "+max);
    }
}
