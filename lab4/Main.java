import java.util.Arrays;

class Main {

	public static void main(String[] args) 
	{
        Person personAdam = new Person.Builder()
            .firstName("Adam")
            .lastName("Abacki")
            .age(35)
            .weight(78.0)
            .height(179)
            .build();

        System.out.println(personAdam);

        // Person person = new Person(); //nie powinno się skompilować
        // Person person = new Person("Tomasz", "Babacki", 22, 82.5, 190); //nie powinno się skompilować

        Person personJacek = new Person.Builder()
            .firstName("Jacek")
            .lastName("Cacki")
            .age(22)
            .weight(84.0)
            .height(183)
            .build();

        System.out.println(personJacek);

        Person personAntoni = new Person.Builder()
            .firstName("Antoni")
            .age(75)
            .weight(123.5)
            .height(173)
            .build();

        Person personJacek2 = new Person.Builder()
            .firstName("Jacek")
            .lastName("Cacki")
            .age(22)
            .weight(84.0)
            .height(183)
            .build();

        System.out.println("personJacek == personJacek2: " + (personJacek == personJacek2));
        System.out.println("personJacek.equals(personJacek2): " + personJacek.equals(personJacek2));

        Person personTomek = new Person.Builder()
            .firstName("Tomek")
            .lastName("Ecki")
            .age(46)
            .weight(99.0)
            .height(199)
            .build();

        PersonArray personArray = new PersonArray();
        personArray.addPerson(personAdam);
        personArray.addPerson(personJacek);
        personArray.addPerson(personJacek); //nie powinno dodać dwa razy tej samej osoby
        personArray.addPerson(personTomek);
        personArray.addPerson(personAntoni); //nie powinno dodać, bo to null
        System.out.println(personArray);
        personArray.removePerson(personJacek);
        System.out.println(personArray);

        PersonArray personArray2 = new PersonArray(personArray);
        PersonArray personArray3 = new PersonArray();
        personArray3.addPerson(personAdam);
        personArray3.addPerson(personJacek);
        System.out.println("personList.equals(personList2): " + personArray.equals(personArray2));
        System.out.println("personList.equals(personList3): " + personArray.equals(personArray3));
        System.out.println();
    }
}
