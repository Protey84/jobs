package com.protey.jobs.repository.inMemory;

import com.protey.jobs.entity.Job;
import com.protey.jobs.entity.Master;
import com.protey.jobs.entity.Task;
import com.protey.jobs.entity.Type;
import com.protey.jobs.repository.TaskRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InMemoryTaskRepository extends InMemoryBaseRepository<Task> implements TaskRepository {

    public void init(){
        map.clear();
        Task task = new Task("2536", LocalDate.of(2021, 8, 3), "Новгородская, 36-15", "8921315670", Master.MASTER_1);
        ArrayList<Job> jobs=new ArrayList<>();

        jobs.add(new Job(Type.LAM_STRAIGHT, 30));
        jobs.add(new Job(Type.LIN_WITH, 10));
        task.setJobs(jobs);
        this.save(task);
        task = new Task("0356", LocalDate.of(2021, 8, 22), "Ленинградская, 2-7", "89113264516", Master.MASTER_2);
        jobs=new ArrayList<>();
        jobs.add(new Job(Type.LAM_STRAIGHT, 10));
        task.setJobs(jobs);
        this.save(task);
    }

    public InMemoryTaskRepository() {
        init();
    }

    @Override
    public List<Task> getByDate(Date date) {
        return getCollection().stream()
                .sorted(Comparator.comparing(Task::getDate))
                .filter(x -> x.getDate().equals(date))
                .collect(Collectors.toList());

    }

    @Override
    public List<Task> getAll() {
        return getCollection().stream()
                .sorted(Comparator.comparing(Task::getDate))
                .collect(Collectors.toList());
    }
}
