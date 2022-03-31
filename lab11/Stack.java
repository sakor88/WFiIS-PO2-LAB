import java.lang.reflect.*;

public class Stack<T>{

    private int currSize;
    private int maxSize; 
    private T[] stack; 

    Stack(int max, Class<T[]> classT){
        this.maxSize = max;
        this.stack = classT.cast(Array.newInstance(classT.getComponentType(), max));
        this.currSize = 0;
    }

    public boolean isEmpty(){
        return this.currSize == 0;
    }

    public boolean isFull(){
        return this.currSize == this.maxSize;
    }

    public void push(T x) throws StackOverflowException{


        if(this.isFull()){
            throw new StackOverflowException("Przepelnienie stosu!");
        }
        this.stack[currSize] = x;
        this.currSize++;

    }

    public T pop() throws StackUnderflowException{
        if(this.isEmpty()){
            throw new StackUnderflowException("Stos jest pusty!");
        }
        T temp = this.stack[getCurrentSize() - 1];
        this.stack[currSize-1] = null;
        this.currSize--;
        return temp;
    }

    public int getCurrentSize(){
        return this.currSize;
    }

    public int getMaxSize(){
        return this.maxSize;
    }

    public String toString(){
        String ret = "Elementy stosu: [";
        for(int i = 0; i < this.getMaxSize(); i++){
            ret += "" + this.stack[i] + ", ";
        }
        ret += "]";
        return ret;
    }
    
    public boolean equals(Stack<T> b){

        if( this.getCurrentSize() != b.getCurrentSize() ){
            return false;
        }

        for(int i = 0; i < this.getCurrentSize(); i++){
            if(this.stack[i] != b.stack[i]){
                return false;
            }
        }

        return true;

    }

}