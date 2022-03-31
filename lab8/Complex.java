import java.lang.Math;

public class Complex{

    private double im;
    private double re;

    Complex(){
        this.re = 0;
        this.im = 0;
    }

    Complex(double Re){
        this.re = Re;
        this.im = 0;
    }

    Complex(double Re, double Im){
        this.re = Re;
        this.im = Im;
    }

    public String toString() {
        if(im < 0){
            return "(" + this.re + this.im + "i)";
        }
        else{
            return "(" + this.re + "+" + this.im + "i)";
        }
    }

    public void set(double Re, double Im){
        this.re = Re;
        this.im = Im;
    }

    public void setRe(double Re){
        this.re = Re;
    }   

    public double getRe(){
        return this.re;
    }

    public void setIm(double Im){
        this.im = Im;
    }

    public double getIm(){
        return this.im;
    }


    public double mod(){
        return Math.sqrt( this.im * this.im + this.re * this.re );
    }

    public void conjugate(){
        this.im = -this.im;
    }
    
    public void opposite(){
        this.im = -this.im;
        this.re = -this.re;
    }


    public static Complex addCom(Complex com1, Complex com2){
        return new Complex(com1.re + com2.re, com1.im + com2.im);
    }

    public static Complex subCom(Complex com1, Complex com2){
        return new Complex(com1.re - com2.re, com1.im - com2.im);
    }

    public static Complex multiCom(Complex com1, Complex com2){
        return new Complex(com1.re * com2.re - com1.im * com2.im, com1.re * com2.im + com1.im * com2.re);
    }

    public static Complex divCom(Complex com1, Complex com2){
        double Re = (com1.re * com2.re + com1.im * com2.im) / (Math.pow(com2.re,2) + Math.pow(com2.im,2));
        double Im = (com1.im * com2.re - com1.re * com2.im) / (Math.pow(com2.re,2) + Math.pow(com2.im,2));
        return new Complex(Re,Im);
    }

    public static Complex addComDouble(Complex com1, double num){
        return new Complex(com1.re + num , com1.im);
    }

    public static Complex addDoubleCom(double num, Complex com1){
        return new Complex(com1.re + num , com1.im);
    }

    public static Complex subComDouble(Complex com1, double num){
        return new Complex(com1.re - num , com1.im);
    }

    public static Complex subDoubleCom(double num, Complex com1){
        return new Complex(num - com1.re , -com1.im);
    }

    public static Complex multiComDouble(Complex com1, double num){
        return new Complex(com1.re * num , com1.im * num);
    }

    public static Complex multiDoubleCom(double num, Complex com1 ){
        return new Complex(com1.re * num , com1.im * num);
    }

    public static Complex divComDouble(Complex com1, double num){
        return new Complex(com1.re / num , com1.im / num);
    }

    public static Complex divDoubleCom(double num,Complex com1 ){
        double Re = (num * com1.re) / (Math.pow(com1.re,2) + Math.pow(com1.im,2));
        double Im = (- num * com1.im) / (Math.pow(com1.re,2) + Math.pow(com1.im,2));
        return new Complex(Re, Im );
    }


}