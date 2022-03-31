import java.lang.System;
import java.util.Arrays;
import java.util.List;

public class PersonArray{

    Person[] tab;

    PersonArray(){
        this.tab = new Person[1];
        this.tab[0] = null;
    }

    PersonArray(PersonArray p2){
        this.tab = new Person[p2.tab.length];
        System.arraycopy(p2.tab,0,this.tab,0,p2.tab.length);
    }

    void addPerson(Person p){

        if(this.tab[0] == null){
            this.tab[0] = p;
            return;
        }

        List<Person> tempTab = Arrays.asList(this.tab);
        if(tempTab.contains(p)){
            System.out.println("Person is already in the array!");
            return;
        }

        Person[] temp = new Person[this.tab.length];
        System.arraycopy(this.tab,0,temp,0,this.tab.length);
        this.tab = new Person[temp.length+1];
        System.arraycopy(temp,0,this.tab,0,temp.length);
        this.tab[this.tab.length-1] = p;
    }

    void removePerson(Person p){
        List<Person> temp = Arrays.asList(this.tab);
        if(temp.contains(p)){
            int ind = temp.indexOf(p);
            this.tab[ind] = null;
            Person[] tempTab = new Person[this.tab.length-1];
            System.arraycopy(this.tab,0,tempTab,0,ind);
            System.arraycopy(this.tab,ind+1,tempTab,ind,this.tab.length-ind-1);
            this.tab = tempTab;

        }
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

        PersonArray ar = (PersonArray) p2;

        return Arrays.equals(this.tab, ar.tab);        

    }

    public String toString(){
        return Arrays.toString(this.tab);
    }


}
