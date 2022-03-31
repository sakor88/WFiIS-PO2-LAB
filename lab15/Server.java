import java.net.*;
import java.util.ArrayList;
import java.io.*;
import java.util.StringTokenizer;

public class Server{

    public static ArrayList<ClientHandler> CHlist;

    public static void main(String[] args){

    ServerSocket ss;
    Socket cs;

        try{
            CHlist = new ArrayList();
            ss = new ServerSocket(1234);
            int i = 0;
            while(true){
                cs = ss.accept();
                ClientHandler ch = new ClientHandler(cs, "Client " + i);
                ch.start();
                CHlist.add(ch);
                i+=1;
            }
            
            
        }
        catch( IOException e){
            System.out.println("Problem z serwerem");
            e.printStackTrace();
        }
        

    }

}


class ClientHandler extends Thread{

        BufferedReader reader;
        PrintWriter printer;
        BufferedReader stdinReader;
        Socket s;
        String clientName;
        

        ClientHandler(Socket s, String name){
            try{
                this.s = s;
                this.clientName = name;
                reader = new BufferedReader( new InputStreamReader(s.getInputStream()));
                printer = new PrintWriter(s.getOutputStream(), true);
                stdinReader = new BufferedReader(new InputStreamReader( System.in ));
            }
            catch(IOException e){
                e.printStackTrace();
            }
            
        }

        String getClientName(){
            return clientName;
        }

        public void print(String msg){
            this.printer.print(msg);
        }

        @Override
        public void run(){
            try{
                String wholeMsg;
                String msg = "";
                String target;
                while(true){
                    wholeMsg = reader.readLine();
                    StringTokenizer st = new StringTokenizer(msg, "#");
                    msg = st.nextToken();
                    target = st.nextToken();
                    for(int i = 0; i < Server.CHlist.size(); i++){
                        if(Server.CHlist.get(i).getClientName() == clientName){
                            Server.CHlist.get(i).print(msg);
                        }
                    }
                }
            }
            catch(IOException e){
                e.printStackTrace();
            }
            
        }

    }
