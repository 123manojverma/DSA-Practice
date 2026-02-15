package Biweekly176;

import java.util.HashMap;
import java.util.Map;

public class Number_of_prefix_connected_groups {
    public static int prefixConnected(String[] words, int k) {
        HashMap<String,Integer> hm=new HashMap<>();
        for(int i=0;i<words.length;i++){
            if(words[i].length()<k)continue;
            hm.put(words[i].substring(0,k),hm.getOrDefault(words[i].substring(0,k),0)+1);
        }
        int cnt=0;
        for(Map.Entry<String,Integer>m:hm.entrySet()){
            if(m.getValue()>=2){
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        String[] words={"apple","apply","banana","bandit"};
        int k=2;
        System.out.println(prefixConnected(words,k));
    }
}
