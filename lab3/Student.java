import java.util.ArrayList;

public class Student{

    Student(int numer_indeksu, String imie, String nazwisko){
        this.oceny = new ArrayList<Double>(0);
        this.numerIndeksu = numer_indeksu;
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public void addGrade(double ocena){
        this.oceny.add(ocena);
    }

    public String getImie(){
        return this.imie;
    }

    public String getNazwisko(){
        return this.nazwisko;
    }

    public String getEmail(){
        return this.email;
    }

    public void setMail(String mail){
        this.email = mail;
    }

    public int getIndeks(){
        return this.numerIndeksu;
    }

    public double getAverage(){
        double srednia = 0;
        for(int i = 0; i < oceny.size(); i++){
            srednia += oceny.get(i);
        }
        srednia /= oceny.size();

        return srednia;
    }

    @Override
    public String toString(){
        if(this.oceny.size() == 0){
            return this.getImie() + " " + this.getNazwisko() + " (" + this.getIndeks() +")";
        }
        else{
            String ocenyString  = "";
            for(int i = 0; i < oceny.size(); i++){
                ocenyString += oceny.get(i).toString() + " ";
            }
            return this.getImie() + " " + this.getNazwisko() + " (" + this.getIndeks() +")" + " - " + ocenyString ;
        }
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        
        if(obj == this){
            return true;
        }

        if(!obj.getClass().equals(this.getClass())){
            return false;
        }

        Student stud = (Student) obj;

        if(!this.getImie().equals(stud.getImie())){
            return false;
        }

        if(!this.getNazwisko().equals(stud.getNazwisko())){
            return false;
        }

        if(this.getIndeks() != stud.getIndeks()){
            return false;
        }

        if(!this.getEmail().equals(stud.getEmail())){
            return false;
        }

        if(!this.oceny.equals(stud.oceny)){
            return false;
        }

        return true;
    }

    private String imie;
    private String nazwisko;
    private int numerIndeksu;
    private String email;
    private ArrayList<Double> oceny = new ArrayList<Double>();
}