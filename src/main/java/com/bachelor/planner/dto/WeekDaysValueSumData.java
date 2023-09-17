package com.bachelor.planner.dto;

import java.time.LocalDate;
public class WeekDaysValueSumData {

    private int weekDaysValueSum;
    private LocalDate completeDate;

    public WeekDaysValueSumData(int weekDaysValueSum, LocalDate completeDate) {
        this.weekDaysValueSum = weekDaysValueSum;
        this.completeDate = completeDate;
    }

    public int getWeekDaysValueSum() {
        return weekDaysValueSum;
    }

    public LocalDate getCompleteDate() {
        return completeDate;
    }
}
