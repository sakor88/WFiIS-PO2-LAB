import java.lang.Integer;
import java.util.Random;
import java.util.ArrayList;
import java.util.LinkedList;
import java.lang.Math;
import java.util.TreeMap;
import java.util.HashMap;

public class Main{

  public static void main(String[] args){

    int n=0;
    int m=0;

    if(args.length < 2){
      System.out.println("podaj 2 argumenty wywolania programu n oraz m");
      System.exit(1);
    }
    else{
      n = Integer.parseInt(args[0]);
      m = Integer.parseInt(args[1]);

      if(n <= m){
        System.out.println("n musi byc wieksze od m!");
        System.exit(1);
      }

    }
    
    Random rnd = new Random();

    String[] t1 = new String[n];
    String[] t2 = new String[m];
    String[] t3 = new String[m];

    setupT1T2T3(t1,t2,t3,n,m, rnd);    
    
    //ArrayList
    
    long startTime = System.nanoTime();
    ArrayList<String> t1Array = new ArrayList<String>(n);
    for(int i = 0; i < n; i++){
      t1Array.add(i,t1[i]);
    }
    long elapsedNanos = System.nanoTime() - startTime;
    double elapsedSeconds = elapsedNanos / 1e9;
    System.out.println("Wypelnienie ArrayList elementami t1: " + elapsedSeconds + "sekund");
    
    
    //LinkedList
    
    startTime = System.nanoTime();
    LinkedList<String> t1List = new LinkedList<String>();
    for(int i = 0; i < n; i++){
      t1List.add(i,t1[i]);
    }
    elapsedNanos = System.nanoTime() - startTime;
    elapsedSeconds = elapsedNanos / 1e9;
    System.out.println("Wypelnienie LinkedList elementami t1: " + elapsedSeconds + "sekund");
  
  
    //Treemap
    
    startTime = System.nanoTime();
    TreeMap<String, Integer> t1Tree = new TreeMap<String, Integer>();
    for(int i = 0; i < n; i++){
      t1Tree.put(t1[i],i);
    }
    elapsedNanos = System.nanoTime() - startTime;
    elapsedSeconds = elapsedNanos / 1e9;
    System.out.println("Wypelnienie TreeMap elementami t1: " + elapsedSeconds + "sekund");
    
    //Hashmap
    
    startTime = System.nanoTime();
    HashMap<String, Integer> t1Map = new HashMap<String, Integer>(n);
    for(int i = 0; i < n; i++){
      t1Map.put(t1[i],i);
    }
    elapsedNanos = System.nanoTime() - startTime;
    elapsedSeconds = elapsedNanos / 1e9;
    System.out.println("Wypelnienie HashMap elementami t1: " + elapsedSeconds + "sekund");
  
  }
  
  
  
  
  public static void setupT1T2T3(String[] t1, String[] t2, String[] t3, int n, int m,Random rnd){
  
    int len;
    String res = "";
    String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    //losowanie t1
    for(int i = 0; i < n; i++){
      len = rnd.nextInt()%16+5;
      for(int j = 0; j < len; j++){
        res = res + alphabet.charAt((Math.abs(rnd.nextInt())%alphabet.length()));
      }
      t1[i] = res;
    }
    
    res = "";
    
    //losowanie t2
    for(int i = 0; i < m; i++){
      t2[i] = t1[Math.abs(rnd.nextInt())%n];
    }
    
    //losowanie t3
    int flag = 0;
    for(int i = 0; i < m; i++){
      if(flag == 1){
        i--;
        flag = 0;
      }
    
      len = rnd.nextInt()%16+5;
      for(int j = 0; j < len; j++){
        res = res + alphabet.charAt(Math.abs(rnd.nextInt())%alphabet.length());
      }
      
      
      
      for(int k = 0; k < n; k++){
        if(res.equals(t1[i])){
          flag = 1;
        }
      }
      
      if(flag == 1){
        continue;
      }
      t3[i] = res;
    }
  
  }


}
