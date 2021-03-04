package com.company;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        City city = new City();

        Hotel v1= new Hotel();
        v1.setName("V1");
        v1.setRank(4);

        Museum v2 = new Museum();
        v2.setName("V2");
        v2.setOpeningTime(LocalTime.of(9,30));
        v2.setClosingTime(LocalTime.parse("17:00"));
        v2.setPrice(40);

        Museum v3 = new Museum();
        v3.setName("V3");
        v3.setOpeningTime(LocalTime.of(10,30));
        v3.setClosingTime(LocalTime.parse("16:00"));
        v3.setPrice(25);

        Church v4 = new Church();
        v4.setName("V4");
        v4.setOpeningTime(LocalTime.parse("07:00"));
        v4.setClosingTime(LocalTime.of(19,00));

        Church v5 = new Church();
        v5.setName("V5");
        v5.setOpeningTime(LocalTime.parse("09:00"));
        v5.setClosingTime(LocalTime.of(15,30));

        Restaurant v6 = new Restaurant();
        v6.setName("V6");
        v6.setRank(1);
        v6.setOpeningTime(LocalTime.of(12,0));
        v6.setClosingTime(LocalTime.parse("22:30"));

        v1.setCost(v2,10);
        v1.setCost(v3,50);
        v2.setCost(v3,20);
        v2.setCost(v4,20);
        v2.setCost(v5,10);
        v3.setCost(v4,20);
        v4.setCost(v5,30);
        v4.setCost(v6,10);
        v5.setCost(v6,20);

        city.addLocation(v1);
        city.addLocation(v2);
        city.addLocation(v3);
        city.addLocation(v4);
        city.addLocation(v5);
        city.addLocation(v6);

        System.out.println(city);
    }
}
