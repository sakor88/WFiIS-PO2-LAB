public class StackOverflowException extends Exception{

    StackOverflowException(){
        super("Stack overflow!");
    }
    

    StackOverflowException(String message){
        super(message);
    }

}