import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ComplexTest{


    @Test
    public void complexDefaultConstructorTest(){
        Complex com = new Complex();
        assertEquals( "(0.0+0.0i)", com.toString());
    }

    @Test
    public void complexReConstructorTest1(){
        double Re = 4;
        Complex com = new Complex(Re);
        assertEquals( "(4.0+0.0i)", com.toString());
    }

    @Test
    public void complexReConstructorTest2(){
        double Re = -5;
        Complex com = new Complex(Re);
        assertEquals("(-5.0+0.0i)", com.toString());
    }


    @Test
    public void complexFullConstructorTest1(){
        double Re = 6;
        double Im = 2;
        Complex com = new Complex(Re, Im);
        assertEquals( "(6.0+2.0i)", com.toString());
    }

    @Test
    public void complexFullConstructorTest2(){
        double Re = -5;
        double Im = -7;
        Complex com = new Complex(Re, Im);
        assertEquals("(-5.0-7.0i)",com.toString());
    }


    @Test
    public void setTest1(){
        double Re = 1;
        double Im = 2;
        Complex com = new Complex();
        com.set(Re,Im);
        assertEquals("(1.0+2.0i)",com.toString());
    }

    @Test
    public void setTest2(){
        double Re = -1;
        double Im = -2;
        Complex com = new Complex();
        com.set(Re,Im);
        assertEquals("(-1.0-2.0i)",com.toString());
    }


    @Test
    public void setReTest1(){
        double Re = -1;
        Complex com = new Complex();
        com.setRe(Re);
        assertEquals("(-1.0+0.0i)",com.toString());
    }

    @Test
    public void setReTest2(){
        double Re = 2;
        Complex com = new Complex();
        com.setRe(Re);
        assertEquals("(2.0+0.0i)", com.toString());
    }

    @Test
    public void setImTest1(){
        double Im = -1;
        Complex com = new Complex();
        com.setIm(Im);
        assertEquals("(0.0-1.0i)", com.toString());
    }

    @Test
    public void setImTest2(){
        double Im = 5;
        Complex com = new Complex();
        com.setIm(Im);
        assertEquals("(0.0+5.0i)", com.toString());
    }

    @Test
    public void getReTest1(){
        double Re = -1;
        Complex com = new Complex();
        com.setRe(Re);
        assertEquals( -1.0, com.getRe(), 1e-4);
    }

    @Test
    public void getReTest2(){
        double Re = 10;
        Complex com = new Complex();
        com.setRe(Re);
        assertEquals(10.0, com.getRe(), 1e-4);
    }

    @Test
    public void getImTest1(){
        double Im = -5;
        Complex com = new Complex();
        com.setIm(Im);
        assertEquals( -5.0, com.getIm(), 1e-4);
    }

    @Test
    public void getImTest2(){
        double Im = 16;
        Complex com = new Complex();
        com.setIm(Im);
        assertEquals(16.0, com.getIm(),  1e-4);
    }

    @Test
    public void modTest1(){
        double Im = 4;
        double Re = 3;
        Complex com = new Complex(Re,Im);
        assertEquals(5.0, com.mod(),  1e-4);
    }

    @Test
    public void modTest2(){
        double Im = -4;
        double Re = -3;
        Complex com = new Complex(Re,Im);
        assertEquals(5.0, com.mod(),  1e-4);
    }


    @Test
    public void conjugateTest1(){
        double Re = 3;
        double Im = 4;

        Complex com = new Complex(Re,Im);
        com.conjugate();
        assertEquals("(3.0-4.0i)", com.toString());
    }

    @Test
    public void conjugateTest2(){
        double Re = -3;
        double Im = -4;
        Complex com = new Complex(Re,Im);
        com.conjugate();
        assertEquals("(-3.0+4.0i)",com.toString());
    }

    @Test
    public void oppositeTest1(){
        double Re = 2;
        double Im = 6;
        Complex com = new Complex(Re,Im);
        com.opposite();
        assertEquals("(-2.0-6.0i)",com.toString());
    }

    @Test
    public void oppositeTest2(){
        double Re = -1;
        double Im = -7;
        Complex com = new Complex(Re,Im);
        com.opposite();
        assertEquals("(1.0+7.0i)", com.toString());
    }

    @Test
    public void addComTest1(){
        Complex com1 = new Complex(1,2);
        Complex com2 = new Complex(2,3);
        Complex com3 = Complex.addCom(com1, com2);
        assertEquals("(3.0+5.0i)", com3.toString());
    }

    @Test
    public void addComTest2(){
        Complex com1 = new Complex(-2,3);
        Complex com2 = new Complex(4,-5);
        Complex com3 = Complex.addCom(com1, com2);
        assertEquals("(2.0-2.0i)", com3.toString());
    }

    @Test
    public void subComTest1(){
        Complex com1 = new Complex(1,2);
        Complex com2 = new Complex(2,3);
        Complex com3 = Complex.subCom(com1, com2);
        assertEquals("(-1.0-1.0i)", com3.toString());
    }

    @Test
    public void subComTest2(){
        Complex com1 = new Complex(-2,3);
        Complex com2 = new Complex(4,-5);
        Complex com3 = Complex.subCom(com1, com2);
        assertEquals("(-6.0+8.0i)", com3.toString());
    }

    @Test
    public void multiComTest1(){
        Complex com1 = new Complex(1,2);
        Complex com2 = new Complex(2,3);
        Complex com3 = Complex.multiCom(com1, com2);
        assertEquals("(-4.0+7.0i)", com3.toString());
    }

    @Test
    public void multiComTest2(){
        Complex com1 = new Complex(-2,3);
        Complex com2 = new Complex(4,-5);
        Complex com3 = Complex.multiCom(com1, com2);
        assertEquals("(7.0+22.0i)", com3.toString());
    }

    @Test
    public void divComTest1(){
        Complex com1 = new Complex(1,2);
        Complex com2 = new Complex(2,3);
        Complex com3 = Complex.divCom(com1, com2);
        assertEquals(0.07692307692, com3.getIm(), 1e-5);
        assertEquals(0.61538461538, com3.getRe(), 1e-5);
    }





}