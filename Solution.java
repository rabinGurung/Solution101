import java.util.Timer;
import java.util.TimerTask;
class Solution {
    private final static int[] Given_Number = {50,51,52,53,54};
    private static int n = 0;
    public static void main(String[] args){
        final int[] Dashboard_values = {Given_Number[0],Given_Number[1],Given_Number[2],Given_Number[3],Given_Number[1]};
        if(n == 0){
            for(int x = 0; x<25; x+=1){
                System.out.print("*");
            }
            System.out.println("\n First Values");
            print_All(Dashboard_values);
            for(int x = 0; x<25; x+=1){
                System.out.print("*");
            }
        }
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(n!= 0){
                    System.out.println("\n At "+n*5+" seconds");
                    if(n > 23){
                        System.out.println(" \n Terminating System || 2 mins over");
                        timer.cancel();
                        timer.purge();
                        return;
                    }
                    Dashboard_values[0]+= 1;
                    Dashboard_values[1]-= 1;
                    Dashboard_values[2]+= 2;
                    Dashboard_values[3]-= 2;
                    Dashboard_values[4]+= 3;
                    print_All(Dashboard_values);
                    print_Alert_Values_IF_Exist(Dashboard_values);
                    for(int x = 0; x<25; x+=1){
                        System.out.print("*");
                    }    
                    
                }
                n+=1;
            }
         }, 0, 5000);
    }

    private static void print_Alert_Values_IF_Exist(int[] arr){
        for(int i = 0;i<arr.length; i++){
            if(arr[i] < 15 || arr[i] > 35){
                System.out.println("\n Alert at value position "+arr[i]);
                for(int x = 0; x<25; x+=1){
                    System.out.print("*");
                }    
            }
        }
    }
    private static void print_All(int[] arr){
        for(int i = 0;i<arr.length; i++){
            System.out.println("\n "+arr[i]);
        }
    }
}