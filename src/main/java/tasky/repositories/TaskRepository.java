package tasky.repositories;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import tasky.dtos.CreateTaskDTO;
import tasky.dtos.UpdateTaskDTO;
import tasky.models.Task;

import java.util.*;

@Component
public class TaskRepository {

    private List<Task> TASKS = new ArrayList<>(Arrays.asList(
            new Task.Builder()
                    .uuid(generateUUID())
                    .title("Learn Spring Framework")
                    .createdAt(new DateTime(1530916221000L).toString())
                    .build(),

            new Task.Builder()
                    .uuid(generateUUID())
                    .title("Do Laundry")
                    .createdAt(new DateTime(1530975621000L).toString())
                    .build(),


            new Task.Builder()
                    .uuid(generateUUID())
                    .title("Write Tutorial")
                    .createdAt(new DateTime(1530814521000L).toString())
                    .build(),

            new Task.Builder()
                    .uuid(generateUUID())
                    .title("Get some shuteye")
                    .createdAt(new DateTime(1530814521000L).toString())
                    .build()


    ));

    private UUID generateUUID() {
        return UUID.randomUUID();
    }


    public List<Task> getAllTasks(){
        Collections.sort(TASKS, new Comparator<Task>() {
            @Override
            public int compare(Task first, Task second) {
                return new DateTime(first.getCreatedAt()).compareTo(new DateTime(second.getCreatedAt()));
            }
        });
        return TASKS;
    }

    public Task getById(UUID uuid){
        for(Task task : TASKS){
            if(task.getUuid().equals(uuid)){
                return task;
            }
        }
        return null;
    }

    public Task create(CreateTaskDTO createTaskDTO){
        Task task = new Task.Builder()
                .uuid(generateUUID())
                .title(createTaskDTO.getTitle())
                .createdAt(new DateTime(System.currentTimeMillis()).toString())
                .build();

        TASKS.add(task);
        return task;
    }

    public Task update(UUID uuid, UpdateTaskDTO updateTaskDTO){
        Task task = getById(uuid);
        task.setCompleted(updateTaskDTO.isCompleted());
        return task;
    }

    public void delete(UUID uuid){
        Task task = getById(uuid);
        TASKS.remove(task);
    }
}
