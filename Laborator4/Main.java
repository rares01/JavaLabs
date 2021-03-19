package com.company;

import com.github.javafaker.Faker;

import javax.xml.stream.Location;
import java.util.*;
import java.util.stream.Collectors;
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
        Faker names=new Faker();
        schools[0].setCapacity(1);
        schools[1].setCapacity(2);
        schools[2].setCapacity(2);
        students[0].setMark(10);
        students[1].setMark(6);
        students[2].setMark(8);
        students[3].setMark(5);
        /** Folosim Faker pentru a genera nume random pentru studenti si scoli*/
        students[0].setName(names.name().fullName());
        students[1].setName(names.name().fullName());
        students[2].setName(names.name().fullName());
        students[3].setName(names.name().fullName());
        List<Student> studentList =new ArrayList<>();
        schools[0].setName(names.university().name());
        schools[1].setName(names.university().name());
        schools[2].setName(names.university().name());
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
        studentList.stream()
                .filter(std -> stdPrefMap.get(std).contains(schools[0]))
                .forEach(System.out::println);
        List<School> target = Arrays.asList(schools[0], schools[2]);
        List<Student> result = studentList.stream()
                .filter(std -> stdPrefMap.get(std).containsAll(target))
                .collect(Collectors.toList());
        System.out.println(result);
        schoolList.stream().filter(std -> stdSchPref.get(std).get(0).equals(students[0])).forEach(System.out::println);

      /** Partea de optional*/
        List<Student> newSortedList = studentList.stream().sorted(Comparator.comparing(Student::getMark)).collect(Collectors.toList());
        Problem p= new Problem(stdPrefMap,newSortedList);
        Algorithm alg= new Algorithm();

        Solution sol= new Solution(alg.algGreddy(p));
        System.out.println(sol);

        /** Partea de bonus*/
        int ok=0;
        Problem bonus= new Problem(stdSchPref,studentList,ok);
        Algorithm algb=new Algorithm();
        algb.newAlg(bonus);
        for(int i=0;i<studentList.size();i++)
        {
            System.out.println(studentList.get(i).getName()+ "    " + "H" + studentList.get(i).getHisSchool());
        }
    }
}
