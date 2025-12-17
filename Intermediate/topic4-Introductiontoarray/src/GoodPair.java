import java.util.HashMap;

public class GoodPair {
    public static void main(String[] args) {
        int target=7;
        int[] arr={1,2,3,4};
        int flag=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<4;i++){
            if(hm.containsKey(target-arr[i])){
                flag=1;
                break;
            }
            hm.put(arr[i],i);
        }
        System.out.println(flag);
    }
}
