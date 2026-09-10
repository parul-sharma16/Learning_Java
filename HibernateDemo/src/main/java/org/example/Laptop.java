package org.example;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Laptop {
    @Id
    private int lid;
    private String lname;
    @ManyToOne
    private Student student;

//    @OneToOne
//    /*
//    (mappedBy = "laptop")
//    mappedBy="<the name of the field in the OTHER class that owns the relationship.>"
//    The other side, whose field is called laptop, owns this relationship.
//    */
//    private Student student;
//
//    public Student getStudent() {
//        return student;
//    }
//    public void setStudent(Student student) {
//        this.student = student;
//    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


    @Override
    public String toString() {
        return "[Laptop id= " + lid + ", Laptop name= " + lname + "]";
    }
}
