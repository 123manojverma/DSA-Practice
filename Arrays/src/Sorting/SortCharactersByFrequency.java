package Sorting;

import java.util.Arrays;
import java.util.Collections;

public class SortCharactersByFrequency {

    public static String frequencySort(String s) {
        int[] freq=new int[128];

        for(char c:s.toCharArray()){
            freq[c]++;
        }

        StringBuilder[] bucket=new StringBuilder[s.length()+1];

        for(int i=0;i<128;i++){
            if(freq[i]>0){
                int f=freq[i];
                if(bucket[f]==null){
                    bucket[f]=new StringBuilder();
                }
                bucket[f].append((char)i);
            }
        }
        StringBuilder result=new StringBuilder();
        for(int i=s.length();i>=0;i--){
            if(bucket[i]!=null){
                for(char c:bucket[i].toString().toCharArray()){
                    for(int j=0;j<i;j++){
                        result.append(c);
                    }
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("feksakaak"));
    }

}
