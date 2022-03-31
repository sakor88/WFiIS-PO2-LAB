import java.util.Random;
import java.util.Scanner;


public class Labirynt{

    public static void main(String[] args){
        if (args.length != 3){
            System.out.println("Podano zla ilosc argumentow");
        } 
        int nx = Integer.valueOf(args[0]);
        int ny = Integer.valueOf(args[1]);
        double p = Double.parseDouble(args[2]);

        char[][] board = new char[nx][ny]; 

        for(var o: Option.values()){
            System.out.println(o);
        }

        int oPosY = ny-2;
        int oPosX = 1;

        System.out.println("\nPlansza:\n");

        boardReset(board, nx, ny, p);
        printBoard(board, nx, ny);
        
        Scanner sc = new Scanner(System.in);
        char z; 
        while(true){
            z = sc.next().charAt(0);
            Direction dir;
            switch(z){
                case 'a': dir = Direction.LEFT; updateBoard(board, oPosX, oPosY, dir);
                break;

                case 's': dir = Direction.DOWN; updateBoard(board, oPosX, oPosY, dir);
                break;

                case 'd': dir = Direction.RIGHT; updateBoard(board, oPosX, oPosY, dir);
                break;

                case 'w': dir = Direction.UP; updateBoard(board, oPosX, oPosY, dir);
                break;

                case 'q': System.exit(1);
                break;

                case 'r': boardReset(board, nx, ny, p);
                break;
            }
            
            if(board[nx/2][0] == 'o'){
                System.out.println("Wygrales!!!");
                break;
            }
            boardReset(board, nx, ny, p);
        }
        sc.close();
        

        
    }

    public static void printBoard(char[][] board, int nx, int ny){
        for(int i = 0; i < nx; i++){
            for(int j = 0; j < ny; j++){
                System.out.print( board[i][j] );
            }
            System.out.print("\n");
        }
    }

    public static void boardReset(char[][] board, int nx, int ny, double p){
        Random random = new Random();
        for(int i = 0; i < ny; i++){
            for(int j = 0; j < nx; j++){
                
                if(i==0 || i == ny-1 || j==0 || j == nx-1){
                    if( j == nx/2 && i == 0){
                        board[i][j] = ' ';
                    }
                    else{
                        board[i][j] = 'X';
                    }
                }
                else if(i == ny-2 && j == 1){
                    board[i][j] = 'o';
                }
                else{
                    if(random.nextDouble() < p){
                        board[i][j] = 'X';
                    }
                    else{
                        board[i][j] = ' ';
                    }
                }
                
            }
        }
    }

    public static void updateBoard(char[][] board, int oPosX, int oPosY, Direction dir){
        if(board[oPosX + dir.getX()][oPosY +  dir.getY()] == 'X'){
            System.out.println("zly ruch!");
        }
        else{
            board[oPosX][oPosY] = ' ';
            board[oPosX + dir.getX()][oPosY + dir.getX()] = ' ';
            oPosX += dir.getX();
            oPosY += dir.getY();
        }
    }

}