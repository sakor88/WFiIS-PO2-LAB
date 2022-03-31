public class OptionNotRecognizedException extends Exception{
    
    OptionNotRecognizedException(){
        super("Wybrano nieodpowiednia opcje!" );
    }
    
    OptionNotRecognizedException(String s){
        super(s);
    }
}