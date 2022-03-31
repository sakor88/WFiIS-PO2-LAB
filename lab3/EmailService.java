public class EmailService{
    public static void generateEmailForStudent(Student student, String faculty){
        student.setMail(student.getImie() + "." + student.getNazwisko() + "@" + faculty + ".pl");
    }
}