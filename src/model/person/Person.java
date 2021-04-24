package model.person;

import java.io.Serializable;

public class Person implements Serializable {
    //Properties--------------------------------------------------------------------------------------------------------
    private long id = 0;
    private String name;
    private int age;
    private char gender;
    private String state;
    private char[] password;

    //Handing over properties via Constructor---------------------------------------------------------------------------
    public Person(long id, String name, int age, char gender, String state, char[] password) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.state = state;
        this.password = password;
    }

    //Getters/Setters Methods-------------------------------------------------------------------------------------------
    public void setId(long id) { this.id = id; }

    public String getName() { return name; }

    public char getGender() { return gender; }

    public int getAge() {
        if ( age < 0 || age >= 120){
        throw new IllegalArgumentException("Age can not be negative or more than 120"); }
        return age;
    }

    //toString Method---------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "------------------Person------------------" +
                "\nID: " + id +
                "\nName: " + name +
                "\nAge: " + age +
                "\nGender: " + gender +
                "\nState: " + state +
                "\nPassword: " + String.valueOf(password); }
}

