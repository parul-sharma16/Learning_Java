package org.example.servlets;

//USED FOR JSTL
public class Student {
    int roll;
    String name;
    //getters and setters are required by default to access the variables of Student

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(int roll, String name){
        this.roll=roll;
        this.name=name;
    }

    @Override
    public String toString(){
        return "Student [rollno= "+roll+", name= "+name+"]";
    }

}
