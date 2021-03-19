package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student implements Comparable<Student> {
    private String name;
    private int mark;
    private int hasSchool=0;
    private int hisSchool=-1;
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

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getHasSchool() {
        return hasSchool;
    }

    public void setHasSchool(int hasSchool) {
        this.hasSchool = hasSchool;
    }

    public int getHisSchool() {
        return hisSchool;
    }

    public void setHisSchool(int hisSchool) {
        this.hisSchool = hisSchool;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
