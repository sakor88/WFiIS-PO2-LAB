import java.util.ArrayList;

public class StudentManagementService{
    public void addStudent( Student student){
        for(int i = 0; i < studentTab.size(); i++){
            if(student.equals(studentTab.get(i))){
                System.out.println("Student is already in database!");
                return;
            }
        }
        studentTab.add(student);
    }

    public void printAllStudents(){

        System.out.println("*** Students ***");

        for(int i = 0; i < this.studentTab.size(); i++){
            System.out.println(studentTab.get(i));
        }
    }

    public void removeStudent(Student student){
        for(int i = 0; i < studentTab.size(); i++){
            if(student.equals(studentTab.get(i))){
                studentTab.remove(i);
                return;
            }
        }
        System.out.println("Student is not exist in database!");
    }

    public Student findStudentWithTheHighestAverage(){
        double bestAverage = 0;
        int indeks = 0;
        for(int i = 0; i < studentTab.size(); i++){
            if(studentTab.get(i).getAverage() > bestAverage){
                indeks = i;
            }
        }
        return studentTab.get(indeks);
    }

    public ArrayList<Student> studentTab = new ArrayList<Student>();
}