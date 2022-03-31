public class StudentWFiIS2 implements StudentUSOS {
    private String[] przedmioty;
    private int rok;
    private Student stud;

    /* IMPLEMETACJA METOD: */
    StudentWFiIS2(String name, String surname, int id, int year, String course1, double grade1, String course2, double grade2, String course3, double grade3){
        this.stud = new Student(name, surname, id, grade1, grade2, grade3);
        this.rok = year;
        this.przedmioty = new String[3];
        this.przedmioty[0] = course1;
        this.przedmioty[1] = course2;
        this.przedmioty[2] = course3; 
    }

     @Override
    public String toString(){
        return "[" + this.rok + "] " + this.stud.toString();
    }

    @Override
    public double srednia(){
        return this.stud.average();
    }

    @Override
    public void listaPrzedmiotow(){
        String ret = "";
        int j;
        for(int i = 0; i < 3; i++){
            j = i+1;
            ret += "\t" + j + ". " + this.przedmioty[i] + ": " + this.stud.getGrade(i) + "\n";
        }
        System.out.print(ret);
    }

}
