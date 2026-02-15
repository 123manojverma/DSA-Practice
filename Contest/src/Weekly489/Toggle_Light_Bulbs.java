package Weekly489;

import java.util.*;

public class Toggle_Light_Bulbs {
    public static List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<bulbs.size();i++){
            if(hs.contains(bulbs.get(i))){
                hs.remove(bulbs.get(i));
            }else{
                hs.add(bulbs.get(i));
            }
        }
        List<Integer>res=new ArrayList<>();
        for(int x:hs){
            res.add(x);
        }
        Collections.sort(res);
        return res;
    }

    public static List<Integer> toggleLightBulbs1(List<Integer> bulbs) {
        boolean[] arr=new boolean[101];
        for(int i=0;i<bulbs.size();i++){
            arr[bulbs.get(i)]=!arr[bulbs.get(i)];
        }
        List<Integer>res=new ArrayList<>();
        for(int i=1;i<101;i++){
            if(arr[i]){
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer>bulbs=new ArrayList<>(Arrays.asList(10,30,20,10));
//        System.out.println(toggleLightBulbs(bulbs).toString());
        System.out.println(toggleLightBulbs1(bulbs).toString());
    }
}
