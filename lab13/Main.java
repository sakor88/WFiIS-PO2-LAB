import java.io.*;
import java.nio.file.*;
import java.lang.Integer;





public class Main{

    public static void main(String[] args){

    try{

        BufferedReader stdin = new BufferedReader(new InputStreamReader( System.in ) );
        System.out.print( "Podaj nazwe pliku z instrukcjami: " );
        String line , f = "";

        if( (line = stdin.readLine()) != null ) {
            f = line;
        } 
        Path path = FileSystems.getDefault().getPath( f);
        while( ! Files.exists(path) ){
            System.out.println("Podaj prawidlowa nazwe pliku: ");
            if( (line = stdin.readLine()) != null ) {
                f = line;
            } 
            path = FileSystems.getDefault().getPath( f);
        }
        BufferedReader fileRdr = Files.newBufferedReader( path );

        //System.out.println(fileRdr.readLine());

        Submarine lodz = new Submarine();

        String curr;
        String[] komenda = new String[2];
        while( (curr = fileRdr.readLine()) != null ){
            komenda = curr.split(" ");
            if(komenda[0].equals("forward")){
                lodz.forward(Integer.parseInt(komenda[1]));
            }
            else if(komenda[0].equals("up")){
                lodz.up(Integer.parseInt(komenda[1]));
            }
            if(komenda[0].equals("down")){
                lodz.down(Integer.parseInt(komenda[1]));
            }
        }

        lodz.printPos();

        String zapis = "", dec = "";
        System.out.print( "Podaj nazwe pliku do zapisu pozycji: " );
        if( (line = stdin.readLine()) != null ) {
            zapis = line;
        } 

        Path pathOut = FileSystems.getDefault().getPath(zapis);
        while(Files.exists(pathOut)){
            System.out.print( "Podany plik juz istnieje, czy nadpisac zawartosc? (tak/nie)" );
            if( (line = stdin.readLine()) != null ) {
                dec = line;
            }

            if(dec.equals("nie")){
                System.out.println("Podaj nowa nazwe pliku:");
                if( (line = stdin.readLine()) != null ) {
                    zapis = line;
                }
            }
            else{
                break;
            }

            pathOut = FileSystems.getDefault().getPath(zapis);

        }

        BufferedWriter fileWrtr = Files.newBufferedWriter(pathOut);

        fileWrtr.write("" + lodz.getPos() + "\n");
        fileWrtr.write("" + lodz.getDepth());
        fileWrtr.close();

    }
        catch(IOException e) {
            System.err.println( "IOException!" );
        }
    }

}