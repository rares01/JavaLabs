package com.company;

import java.util.List;
import java.util.Map;

public class Problem {
    private Map<Student, List<School>> preferences;
    private Map<School,List<Student>> thisSchools;
    private List<Student> studs;
    private int ok=0;

    public Problem(Map<Student, List<School>> preferences, List<Student> studs) {
        this.preferences = preferences;
        this.studs = studs;
    }

    public Problem(Map<School, List<Student>> thisSchools, List<Student> studs,int ok) {
        this.thisSchools = thisSchools;
        this.studs = studs;
        this.ok=ok;
    }

    public Map<Student, List<School>> getPreferences() {
        return preferences;
    }

    public void setPreferences(Map<Student, List<School>> preferences) {
        this.preferences = preferences;
    }

    public List<Student> getStuds() {
        return studs;
    }

    public Map<School, List<Student>> getThisSchools() {
        return thisSchools;
    }

    public void setThisSchools(Map<School, List<Student>> thisSchools) {
        this.thisSchools = thisSchools;
    }

    public void setStuds(List<Student> studs) {
        this.studs = studs;
    }
}
