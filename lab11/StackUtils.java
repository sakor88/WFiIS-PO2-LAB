import java.lang.ArrayIndexOutOfBoundsException;

public class StackUtils{
    public static<T> String toString(Stack<T>  a){
        return a.toString();
    }

    public static<T> boolean compare(Stack<T> a, Stack<T> b){
        return a.equals(b);
    }

    public static<T> void swap(Stack<T>  a, int i, int j) throws ArrayIndexOutOfBoundsException{
        if(i >= a.getCurrentSize()|| j >= a.getCurrentSize()|| j < 0 || i < 0){
            throw new ArrayIndexOutOfBoundsException("podano zle indeksy do zamiany");
        }

    }

}