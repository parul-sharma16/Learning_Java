package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    private int roll;
    private String name;

//    @OneToOne
//    private Laptop laptop;
//
//    public Laptop getLaptop() {
//        return laptop;
//    }
//    public void setLaptop(Laptop laptop) {
//        this.laptop = laptop;
//    }

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    private List<Laptop> laptop=new ArrayList<>();

        public List<Laptop> getLaptop() {
        return laptop;
    }

    public void setLaptop(List<Laptop> laptop) {
        this.laptop = laptop;
    }

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

    @Override
    public String toString() {
        return "[Roll No= " + roll + ", Name= " + name + "]";
    }
}
