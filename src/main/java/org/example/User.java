package org.example;

public class User {
    String firstName;
    String secondName;
    int age;
    public User(String firstName, String secondName, int age){
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    @Override
    public String toString(){
        return "FirstName: " + firstName +
                "\nSecondName:" + secondName + "\nAge: " + age;
    }

    public String getFirstName() {
        return firstName;
    }
}
