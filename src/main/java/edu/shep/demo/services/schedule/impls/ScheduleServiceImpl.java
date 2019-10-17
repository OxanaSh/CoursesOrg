package edu.shep.demo.services.schedule.impls;

import edu.shep.demo.model.Schedule;
import edu.shep.demo.repository.ScheduleRepository;
import edu.shep.demo.services.schedule.interfaces.IScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ScheduleServiceImpl implements IScheduleService {
    @Autowired
    ScheduleRepository repository;


    @Override
    public List<Schedule> getAll() {
        return repository.findAll();
    }

    @Override
    public Schedule get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Schedule create(Schedule schedule) {
        return repository.save(schedule);
    }

    @Override
    public Schedule update(Schedule schedule) {
        return repository.save(schedule);
    }

    @Override
    public Schedule delete(String id) {

        Schedule schedule = this.get(id);
        repository.deleteById(id);
        return schedule;
    }
}
