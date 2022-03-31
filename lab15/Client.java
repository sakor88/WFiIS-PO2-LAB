import java.net.*;
import java.util.ArrayList;
import java.io.*;
import java.util.StringTokenizer;
import java.util.Scanner;

public class Client{

    

    public static void main(String[] args){

        Thread outThread;
        Thread inThread;
        Socket s = null;

        try{
            s = new Socket("localhost", 1234);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            BufferedReader reader = new BufferedReader( new InputStreamReader(s.getInputStream()));
            PrintWriter printer = new PrintWriter(s.getOutputStream(), true);
        
        


            outThread = new Thread(){
                @Override
                public void run(){
                    String in;
                    while(true){
                        Scanner sc = new Scanner(System.in);
                        String message = sc.nextLine();
                        printer.print(message);
                    }
                }
            };

            inThread = new Thread(){
                @Override
                public void run(){ 
                    try{
                        String out;
                        while(true){
                            if( (out = reader.readLine()) != null){
                                System.out.println(out);
                            }
                        }
                    }
                    catch(IOException e){
                        e.printStackTrace();
                    }
                    
                }
            };
    
        
            outThread.start();
            inThread.start();
        }
        catch(Exception e){
            e.printStackTrace();
        }



    }

}