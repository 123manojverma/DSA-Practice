package Biweekly180;

public class Traffic_Signal_Color {
    public static String trafficSignal(int timer) {
        if(timer==0){
            return "Green";
        }else if(timer==30){
            return "Orange";
        }else if(timer>30 && timer<=90){
            return "Red";
        }
        return "Invalid";
    }

    public static void main(String[] args) {
        int timer=40;
        System.out.println(trafficSignal(timer));
    }
}
