public class StackUnderflowException extends Exception{

    StackUnderflowException(){
        super("Stack underflow!");
    }

    StackUnderflowException(String message){
        super(message);
    }

}