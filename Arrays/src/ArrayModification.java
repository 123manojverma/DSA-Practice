import java.util.ArrayList;
import java.util.Arrays;

public class ArrayModification {
    public static void main(String[] args) {
        ArrayList<Integer>arr=new ArrayList<>(Arrays.asList(1,2,3,5,9,4,4,5,5));
//        Insert in end
        arr.add(1);

//        Insert at Beginning
        arr.add(0,3);

//        Insert at any position
        arr.add(1,5);

//        Delete Element from Start
        arr.remove(0);
        arr.removeFirst();

//        Delete Element from last
        arr.remove(arr.size()-1);
        arr.removeLast();

//        Delete by Index
        arr.remove(1);

//        Delete by Value(First Occurrence)
        arr.remove(Integer.valueOf(9));

//        Delete by Value(All Occurrence)
        arr.removeIf(num->num==1);

//        Update at index
        arr.set(4,1000);

//        Update the value
        for(int i=0;i<arr.size();i++){
            if(arr.get(i)==1000){
                arr.set(i,4);
            }
        }

        for(int i=0;i<arr.size();i++){
            System.out.print(arr.get(i)+" ");
        }
    }
}