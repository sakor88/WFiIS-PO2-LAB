public class StudentWFiIS3 extends Student {
    private StudentUSOS stud;

    /* IMPLEMETACJA METOD: */
    StudentWFiIS3(String name, String surname, int id, int year, String course1, double grade1, String course2, double grade2, String course3, double grade3){
        super(name, surname, id, grade1, grade2, grade3);
        String[] przedmioty = new String[3];
        
        przedmioty[0] = course1;
        przedmioty[1] = course2;
        przedmioty[2] = course3;

        this.stud = new StudentUSOS(){
            @Override
            public String toString(){
                return "[" + year + "] ";
            }

            @Override
            public double srednia(){
                return average();
            }

            @Override
            public void listaPrzedmiotow(){
                String ret = "";
                int j;
                for(int i = 0; i < 3; i++){
                    j = i+1;
                    ret += "\t" + j  + ". " + przedmioty[i] + ": " + getGrade(i) + "\n";
                }
                System.out.print(ret);
            }
        };

         
    }

    @Override
    public String toString(){
        return this.stud.toString() + super.toString();
    }


    public double srednia(){
        return this.stud.srednia();
    }


    public void listaPrzedmiotow(){
        this.stud.listaPrzedmiotow();
    }


}