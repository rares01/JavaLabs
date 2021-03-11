package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student implements Comparable<Student> {
    private String name;
    List<Student> studs =new ArrayList<>();

    public Student(String name) {
        /*for(int i=0;i<this.studs.size();i++)
            if(this.studs.get(i).getName().compareTo(name)==0){
                System.out.println("Exista acest student!");
                System.exit(-1);
            }
        studs.add(s );*/
        this.name = name;

    }

    public String getName() {
        return name;
    }
    public int compareTo(Student other) {

        if(other==null)
            throw new NullPointerException();
        return this.name.compareTo(other.name);
    }
    public void setName(String name) {
        this.name = name;
    }
}
