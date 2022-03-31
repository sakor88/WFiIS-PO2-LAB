import java.util.Arrays;
import java.lang.reflect.*;
import java.lang.Math;

public class Lab10{


    public static void main(String[] args){
        

        Method metoda;
        try{

            String splitted[] = splitArgs(args[0]);

            Class argTab[] = new Class[splitted.length - 1];

            for(int i = 0; i < splitted.length -1 ; i++){
                argTab[i] = double.class;
            }
            if(argTab.length < 1 || argTab.length > 2){
                throw new IllegalArgumentException("Podaj 1 lub 2 argumenty wywolania funkcji");
            }
            
            metoda = java.lang.Math.class.getMethod(splitted[0], argTab);
            Double result;
            result = splitted.length == 2 ? (Double) metoda.invoke(null , Double.parseDouble(splitted[1])): (Double) metoda.invoke(null , Double.parseDouble(splitted[1]), Double.parseDouble(splitted[2]));
            System.out.println("Wynik funkcji " + args[0] + " = " + result);
        }
        catch(NumberFormatException e){
            System.out.println("Argumenty funkcji musza byc liczbami rzeczywistymi");
             System.exit(1);
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.exit(1);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Podaj funkcje oraz jej argumenty");
            System.exit(1);
        }
        catch( NoSuchMethodException e){
            System.out.println("Nie ma takiej metody");
            
        }
        catch( IllegalAccessException e){
            System.out.println("Blad dostepu");
            System.exit(1);
        }
        catch( InvocationTargetException e){
            System.out.println("Blad wywolania");
            System.exit(1);
        }

    }


    public static String[] splitArgs(String arg) {
        return Arrays.stream(arg.split("[\\s+(),]")).filter(w -> w.isEmpty() == false).toArray(String[]::new);
    }

}