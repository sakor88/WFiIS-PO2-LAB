import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;


public class Labirynt{

    public static void main(String[] args){
        
        int nx = 1;
        while(true){
            try{
                System.out.println("Podaj rozmiar planszy:");
                nx = SystemInWrapper.sc.nextInt();
                if(nx <2 ){
                    throw new ArithmeticException("BLAD: Podaj wartosc wieksza od 2!");
                }
                break;
            }
            catch( InputMismatchException e)
            {
                SystemInWrapper.sc.nextLine();
            }
            catch( ArithmeticException e)
            {
                System.out.println(e);
                SystemInWrapper.sc.nextLine();
            }
            catch( Exception e){
                System.out.println(e +  "BLAD:" + "Wystapil niezidentyfikowany problem");
                SystemInWrapper.sc.nextLine();
            }
        }

        char[][] board = new char[nx][nx]; 

        for(var o: Option.values()){
            System.out.println(o);
        }

        int oPosY = nx-2;
        int oPosX = 1;

        System.out.println("\nPlansza:\n");

        boardReset(board, nx);
        printBoard(board, nx);
        
        char z; 
        while(true){
            z = SystemInWrapper.sc.next().charAt(0);
            Direction dir;
            try{    
                switch(z){
                    case 'a': dir = Direction.LEFT; 
                        updateBoard(board, oPosX, oPosY, dir);
                        oPosX += dir.getX();
                        oPosY += dir.getY();
                    break;

                    case 's': dir = Direction.DOWN; 
                        updateBoard(board, oPosX, oPosY, dir);
                        oPosX += dir.getX();
                        oPosY += dir.getY();
                    break;

                    case 'd': dir = Direction.RIGHT; 
                        updateBoard(board, oPosX, oPosY, dir);
                        oPosX += dir.getX();
                        oPosY += dir.getY();
                    break;

                    case 'w': dir = Direction.UP; 
                        updateBoard(board, oPosX, oPosY, dir);
                        oPosX += dir.getX();
                        oPosY += dir.getY();
                    break;

                    case 'q': System.exit(1);
                    break;

                    case 'r': boardReset(board, nx);
                    break;

                    default:
                    throw new OptionNotRecognizedException("Nierozpoznana opcja!");

                }
            }
            catch( OptionNotRecognizedException e){
                System.out.println(e.getMessage());
                SystemInWrapper.sc.nextLine();
            }
            catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Nie wolno wychodzic poza plansze");
                SystemInWrapper.sc.nextLine();
            }
            catch(BadMoveException e){
                System.out.println(e.getMessage());
                SystemInWrapper.sc.nextLine();
            }
            printBoard(board, nx);
        }
    }

    public static void printBoard(char[][] board, int nx){
        for(int i = 0; i < nx; i++){
            for(int j = 0; j < nx; j++){
                System.out.print( board[i][j] );
            }
            System.out.print("\n");
        }
    }

    public static void boardReset(char[][] board, int nx){
        Random random = new Random();
        for(int i = 0; i < nx; i++){
            for(int j = 0; j < nx; j++){
                
                if(i == nx-2 && j == 1){
                    board[i][j] = 'o';
                }
                else{
                    if(random.nextDouble() < 0.3){
                        board[i][j] = 'X';
                    }
                    else{
                        board[i][j] = ' ';
                    }
                }
                
            }
        }
    }

    static boolean updateBoard(char[][] board, int oPosX, int oPosY, Direction dir) throws ArrayIndexOutOfBoundsException, BadMoveException{
        try{
            if(board[oPosY + dir.getY()][oPosX +  dir.getX()] == 'X'){
                throw new BadMoveException();
            }
            else{
                board[oPosY][oPosX] = ' ';
                board[oPosY + dir.getY()][oPosX + dir.getX()] = 'o';
                return false;
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            throw e;
        }
        catch(BadMoveException e){
            throw e;
        }
    }

}