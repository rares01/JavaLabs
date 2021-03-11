package com.company;

import javax.xml.stream.Location;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
	// write your code here
        var students = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student("S" + i) )
                .toArray(Student[]::new);
        var schools  = IntStream.rangeClosed(0,2)
                .mapToObj(i-> new School("H" + i,0) )
                .toArray(School[]::new);
        schools[0].setCapacity(1);
        schools[1].setCapacity(2);
        schools[2].setCapacity(2);
        List<Student> studentList =new ArrayList<>();
        studentList.addAll(Arrays.asList(students));
        Collections.sort(studentList,
                ((s1, s2) -> s1.getName().compareTo(s2.getName())));
        for(int i=0;i< studentList.size();i++)
        {
            System.out.println(studentList.get(i).getName()+ " ");
        }
        Set<School> schoolList=new TreeSet<>();
        for(School h: schools)
        {
            schoolList.add(h);
        }

        Map<School,List<Student>> stdSchPref =new HashMap<>();
        Map<Student, List<School>> stdPrefMap = new HashMap<>();
        stdPrefMap.put(students[0], Arrays.asList(schools[0], schools[1], schools[2]));
        stdPrefMap.put(students[3], Arrays.asList(schools[0], schools[2]));
        stdPrefMap.put(students[1], Arrays.asList(schools[0], schools[1], schools[2]));
        stdPrefMap.put(students[2], Arrays.asList(schools[0], schools[1]));

        stdSchPref.put(schools[0],Arrays.asList(students[3],students[0],students[1],students[2]));
        stdSchPref.put(schools[1],Arrays.asList(students[0],students[2],students[1]));
        stdSchPref.put(schools[2],Arrays.asList(students[0],students[1],students[3]));
        for(Map.Entry<Student, List<School>> entry : stdPrefMap.entrySet()) {
            int k=0;
            System.out.print(entry.getKey().getName() + ":  (  ");
            for (School value : entry.getValue()) {
                System.out.print(entry.getValue().get(k).getName() + "  ");
                k++;
            }
            System.out.print(")\n");
        }
        System.out.print('\n');
        for(Map.Entry<School, List<Student>> entry : stdSchPref.entrySet()) {
            int k=0;
            System.out.print(entry.getKey().getName() + ":  (  ");
            for (Student value : entry.getValue()) {
                System.out.print(entry.getValue().get(k).getName() + "  ");
                k++;
            }
            System.out.print(")\n");
        }


    }
}
