package com.company;

import java.time.LocalTime;

public class Duration{
    private LocalTime totalTime;

    public Duration(LocalTime totalTime) {
        this.totalTime = totalTime;
    }

    public LocalTime getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(LocalTime totalTime) {
        this.totalTime = totalTime;
    }
}
