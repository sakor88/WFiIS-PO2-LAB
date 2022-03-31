public class WallException extends Exception{
    
    WallException(){
        super("Nie wolno przekraczac granic planszy!");
    }
    
    OptionNotRecognizedException(String s){
        super(s);
    }
}