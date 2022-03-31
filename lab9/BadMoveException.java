public class BadMoveException extends Exception{
    
    BadMoveException(){
        super("Zly ruch");
    }
    
    BadMoveException(String s){
        super(s);
    }
}
