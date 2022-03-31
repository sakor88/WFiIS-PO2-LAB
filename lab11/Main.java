public class Main{

    public static void main(String[] args){

        try{
            Stack<Double> stos = new Stack<>(3, Double[].class); 
            stos.push(3.5);
            stos.push(6.7);
            stos.push(3.867);
            stos.push(3.867);
            double es = stos.pop();
            System.out.println(es);
            System.out.println(stos.getCurrentSize());
            System.out.println(stos.getMaxSize());
            StackUtils.swap(stos,0,1);

            Stack<Integer> stos1 = new Stack<>(3, Integer[].class); 
            Stack<Integer> stos2 = new Stack<>(3, Integer[].class); 

            stos1.push(3);
            stos2.push(2);

            if( StackUtils.compare(stos1,stos2)){
                System.out.println("Stosy rowne");
            }
            else{
                System.out.println("Stosy rozne");
            }

            System.out.println(StackUtils.toString(stos));

        }
        catch( StackOverflowException e){
            System.out.println(e.getMessage());
        }
        catch( StackUnderflowException e){
            System.out.println(e.getMessage());
        }
        catch( ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        
    }

}