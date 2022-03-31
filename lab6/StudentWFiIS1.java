public class StudentWFiIS1 extends Student implements StudentUSOS {
    private String[] przedmioty;
    private int rok;

    /* IMPLEMETACJA METOD: */

    StudentWFiIS1(String name, String surname, int id, int year, String course1, double grade1, String course2, double grade2, String course3, double grade3){
        super(name, surname, id, grade1, grade2, grade3);
        this.rok = year;
        this.przedmioty = new String[3];
        this.przedmioty[0] = course1;
        this.przedmioty[1] = course2;
        this.przedmioty[2] = course3;
    }

    @Override
    public String toString(){
        return "[" + this.rok + "] " + super.toString();
    }

    @Override
    public double srednia(){
        return super.average();
    }

    @Override
    public void listaPrzedmiotow(){
        String ret = "";
        int j;
        for(int i = 0; i < 3; i++){
            j = i+1;
            ret += "\t" + j + ". " + this.przedmioty[i] + ": " + getGrade(i) + "\n";
        }
        System.out.print(ret);
    }

}
