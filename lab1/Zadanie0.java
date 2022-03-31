import java.util.Random;

public class Zadanie0{
    public static void main(String args[]){
        if(args.length == 3){
            int n = Integer.parseInt(args[0]);
            int min = Integer.parseInt(args[1]);
            int max = Integer.parseInt(args[2]);
            int[] tab = new int[n];
            
            Random gen = new Random();
            for( int i = 0; i < n; i++){
              tab[i] = gen.nextInt(max) + min;
              System.out.print("" + tab[i] + "");
            }
            
        }
        else{
            System.out.println("Bledna ilosc argumentow");
        }
        
    }
}