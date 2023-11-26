package com.bachelor.planner.services;

import com.bachelor.planner.exeptions.IdNotFoundExeption;
import com.bachelor.planner.model.Project;
import com.bachelor.planner.repository.ProjectRepository;
import com.bachelor.planner.dto.WeekDaysValueSumData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import org.apache.commons.lang3.tuple.Pair;


@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public List<Project> listProjects() {
        List<Project> projects = projectRepository.findAll();
        return projects;
    }

   public Project getProjectById(Long id) {
        if(projectRepository.findById(id).isEmpty())
           // throw new IdNotFoundExeption("Bla bla");

        throw new IdNotFoundExeption(id);
        return projectRepository.findById(id).get();
    }
 //   public Project getProjectById(Long id){return projectRepository.findById(id).get();}


    public void addProject(Project project) {
        projectRepository.save(project);
    }

    public void updateProject(Project project) {
        projectRepository.save(project);
    }

    public void deleteProject(Long projectId) {
        projectRepository.deleteById(projectId);
    }

    public DayOfWeek getWeekDay(Long id) {
        Project project = projectRepository.findById(id).orElse(null);

        if (project != null && project.getStartDate() != null) {
            LocalDate startDate = project.getStartDate();
            // Gauti savaitės dieną
            return startDate.getDayOfWeek();
        }
        return null;
    }

    public int getWeekDayValue(Long id, LocalDate date) {
        Project project = projectRepository.findById(id).orElse(null);

        if (project != null) {
            int dayValue = 0;
            DayOfWeek weekday = date.getDayOfWeek();
            switch (weekday) {
                case MONDAY -> {
                    dayValue = project.getMonday();
                    break;
                }
                case TUESDAY -> {
                    dayValue = project.getTuesday();
                    break;
                }
                case WEDNESDAY -> {
                    dayValue = project.getWednesday();
                    break;
                }
                case THURSDAY -> {
                    dayValue = project.getThursday();
                    break;
                }
                case FRIDAY -> {
                    dayValue = project.getFriday();
                    break;
                }
                case SATURDAY -> {
                    dayValue = project.getSaturday();
                    break;
                }
                case SUNDAY -> {
                    dayValue = project.getSunday();
                    break;
                }
            }

            return dayValue;
        }
        return 0;
    }

 /*   public Pair<Integer, LocalDate> getWeekDaysValueSum(Long id) {
        Project project = projectRepository.findById(id).orElse(null);
        LocalDate startDate = project.getStartDate();
        LocalDate endDate = project.getEndDate();
        int duration = project.getProjectDuration();
        int weekDaysValueSum=0;
        LocalDate completeDate=null;

        if (project != null ) {
            for(LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)  ){
                weekDaysValueSum += getWeekDayValue(id,date);
                if(weekDaysValueSum>=duration && completeDate==null){
                    completeDate=date;
                }
            }
            return Pair.of(weekDaysValueSum, completeDate);
        }
        return null;
    }  */

    public WeekDaysValueSumData getWeekDaysValueSumWithDate(Long id) {
        Project project = projectRepository.findById(id).orElse(null);
        LocalDate startDate = project.getStartDate();
        LocalDate endDate = project.getEndDate();
        int duration = project.getProjectDuration();
        int weekDaysValueSum = 0;
        LocalDate completeDate = null;

        if (project != null) {
            for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
                weekDaysValueSum += getWeekDayValue(id, date);
                if (weekDaysValueSum >= duration && completeDate == null) {
                    completeDate = date;
                }
            }

            return new WeekDaysValueSumData(weekDaysValueSum, completeDate);
        }
        return null;
    }
}