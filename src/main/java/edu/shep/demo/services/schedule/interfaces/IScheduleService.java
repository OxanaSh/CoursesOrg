package edu.shep.demo.services.schedule.interfaces;

import edu.shep.demo.model.Schedule;

import java.util.List;


public interface IScheduleService {

    List<Schedule> getAll();
    Schedule get(String id);
    Schedule create(Schedule schedule);
    Schedule update(Schedule schedule);
    Schedule delete(String id);


}
