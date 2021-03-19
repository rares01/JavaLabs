package com.company;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Algorithm {
    Problem problem;
    String sol="";
    public Algorithm() {
    }




    public String algGreddy(Problem problem)
    {
        int k=-1;
        int maxim=0;
        int poziStud=-1;
        Map<Student,List<School>> finals = problem.getPreferences();
        /**Iteram prin studentii ordonati dupa note descrescator */
        for(int i=problem.getStuds().size()-1;i>=0;i--) {
            /** Iteram prin mapa de studenti cu scolile la care isi doresc sa intre */
            for (Map.Entry<Student, List<School>> entry : finals.entrySet()) {
                if (problem.getStuds().get(i).getName() == entry.getKey().getName()) {
                    /**Iteram prin scoli si vedem in ordinea pusa de acesta care e prima scoala care mai are capacitatea sa il primeasca */
                    for (int j = 0; j < entry.getValue().size(); j++) {
                        if (entry.getValue().get(j).getCapacity() != 0) {
                            /**Scadem capacitatea si in sol avem solutia */
                            entry.getValue().get(j).setCapacity(entry.getValue().get(j).getCapacity() - 1);
                            sol=sol+problem.getStuds().get(i).getName()+" "+entry.getValue().get(j).getName()+'\n';
                            break;
                        }
                    }
                }

            }
        }
        return sol;
    }
    /** Functie pentru a vedea cati studenti nu au inca o scoala*/
    public int freeStuds(Problem problem)
    {
        int k=0;
        for(int i=0;i<problem.getStuds().size();i++)
        {
            if(problem.getStuds().get(i).getHasSchool()==0)
            {
                k++;
            }
        }
        return k;
    }
    public void newAlg(Problem problem)
    {
        Map<School,List<Student>> finals = problem.getThisSchools();
        /**Cat timp avem studenti care nu au scoala */
        while(freeStuds(problem)!=0) {
            int k=-1;
            /**Iteram prin mapa de scoli cu elevii pe care ii prefera*/
            for (Map.Entry<School, List<Student>> entry : finals.entrySet()) {
                k++;
                for(int i=0;i<entry.getValue().size();i++){
                    /**Daca scoala are capacitate sa il primeasca pe student , il primeste */
                    if(entry.getValue().get(i).getHasSchool()==0 && entry.getKey().getCapacity()!=0)
                    {
                        entry.getValue().get(i).setHasSchool(1);
                        entry.getValue().get(i).setHisSchool(k);
                        entry.getKey().setCapacity(entry.getKey().getCapacity()-1);
                    }
                    /** Altfel exista un alt student la acea scoala */
                    else{
                        /**Vedem ce elev este la acea scoala din lista elevilor preferati de scoala */
                        for(int j=0;j<entry.getValue().size();j++) {
                            if (entry.getValue().get(j).getHisSchool() == k) {
                                /** Daca pozitia studentului actual 'i' este mai mic ca a studentului  'j' ( adica scoala il prefera mai mult) */
                                if (i < j) {
                                    /**Setam scoala studentul 'i' si scoatem studentul 'j' din scoala*/
                                    entry.getValue().get(j).setHisSchool(-1);
                                    entry.getValue().get(j).setHasSchool(0);
                                    entry.getValue().get(i).setHasSchool(1);
                                    entry.getValue().get(i).setHisSchool(k);
                                }
                            }
                        }
                    }
                }
            }

        }
    }
}
