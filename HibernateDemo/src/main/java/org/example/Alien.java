package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Alien {
    @Id
    private int aid;
    private AlienName aname;
    private String colour;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public AlienName getAname() {
        return aname;
    }

    public void setAname(AlienName aname) {
        this.aname = aname;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString()
    {
        return "Alien [aid: "+aid+", fname: "+aname.getFname()+", mname: "+aname.getMname()+", lname: "+aname.getLname()+", colour: "+colour+" ]";
    }
}
