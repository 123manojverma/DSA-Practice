public class ProblemSet1 {

    public static int lowerbound(int[] arr,int target) {
        int l=0,h=arr.length;
        int ans=h;
        while(l<h){
            int mid=l+(h-l)/2;
            if(arr[mid]>=target) {
                ans = mid;
                h = mid;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }

    public static int upperbound(int[] arr,int target) {
        int l=0,h=arr.length;
        int ans=h;
        while(l<h){
            int mid=l+(h-l)/2;
            if(arr[mid]>target) {
                ans = mid;
                h = mid;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }

    public static int sqrt(int n){
        int i=1;
        int ans=0;
        int j=n;
        while(i<=j){
            int mid=i+(j-i)/2;
            if(mid*mid<=n){
                ans=mid;
                i=mid+1;
            }else{
                j=mid-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] arr={1,1,1,2,2,2,2,5,5,6,7};
//        int l=lowerbound(arr,10);
//        int r=upperbound(arr,10);
//        System.out.println(r-l);
        System.out.println(sqrt(10));
    }
}
