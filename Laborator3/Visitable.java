package com.company;

import java.time.Duration;
import java.time.LocalTime;

public interface Visitable {
     LocalTime getOpeningTime();
     LocalTime getClosingTime();
     void setOpeningTime(LocalTime openingTime);
     void setClosingTime(LocalTime closingTime);
     default void opening(){
        this.setOpeningTime(LocalTime.of(9,30));
     }
     default void closing(){
           this.setClosingTime(LocalTime.of(20,00));
     }
      static Duration getVisitingDuration(Location loc){
          if(loc instanceof Visitable )
               return Duration.between(((Visitable) loc).getOpeningTime(),((Visitable) loc).getClosingTime());
          else
              return Duration.ZERO;

     }
}
