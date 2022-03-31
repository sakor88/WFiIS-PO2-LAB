public class Person{
    String imie;
    String nazwisko;
    int wiek;
    double waga;
    int wzrost;

    public String toString(){
        return this.imie + " " + this.nazwisko + ": age=" + this.wiek + ", weight = " + this.waga + ", height=" + this.wzrost; 
    }

    private Person(String im,  String na, int wi, double wa, int wz){
        this.imie = im;
        this.nazwisko = na;
        this.wiek = wi;
        this.waga = wa;
        this.wzrost = wz;
    }

    @Override
    public boolean equals(Object p2){

        if(p2 == null){
            return false;
        }
        
        if(p2 == this){
            return true;
        }

        if(!p2.getClass().equals(this.getClass())){
            return false;
        }

        Person pers = (Person) p2;

        if((this.imie.equals(pers.imie)) && (this.nazwisko.equals(pers.nazwisko)) && (this.wiek == pers.wiek) && (this.waga - pers.waga < 0.001) && (this.wzrost == pers.wzrost)){
            return true;
        }
        return false;
    }

    public static class Builder{

        String fn;
        String ln;
        int ag;
        double wg;
        int hg;
        int flag =  0;


        public Builder firstName(String inImie){
            this.fn = inImie;
            return this;
        }

        public Builder lastName(String inNazwisko){
            this.ln = inNazwisko;
            return this;
        }

        public Builder age(int inWiek){
            this.ag = inWiek;
            return this;
        }

        public Builder weight(double inWaga){
            this.wg = inWaga;
            return this;
        }

        public Builder height(int inWzrost){
            this.hg = inWzrost;
            return this;
        }

        public Person build(){
            if(this.hg == 0){
                System.out.println("Height required!");
                return null;
            }
            if(this.wg == 0.0){
                System.out.println("Weight required!");
                return null;
            }
            if(this.ag == 0){
                System.out.println("Age required!");
                return null;
            }
            if(this.fn == null){
                System.out.println("First name required!");
                return null;
            }
            if(this.ln == null){
                System.out.println("Last name required!");
                return null;
            }

            return new Person(this.fn, this.ln, this.ag, this.wg, this.hg);
            
        }
    }


}
