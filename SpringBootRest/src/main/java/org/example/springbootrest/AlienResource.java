package org.example.springbootrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AlienResource 
{
    @Autowired
    AlienRepo repo;
    @GetMapping("aliens")
    public List<Alien> getAliens()
    {
        /* Manually creating data
        List<Alien> aliens=new ArrayList<>();
        Alien a1=new Alien();
        a1.setId(101);
        a1.setName("Parul");
        a1.setPoints(70);

        Alien a2 =new Alien();
        a2.setId(102);
        a2.setName("Payal");
        a2.setPoints(65);

        aliens.add(a1);
        aliens.add(a2);
         */

        List<Alien> aliens=(List<Alien>) repo.findAll();

        return aliens;
    }

}
