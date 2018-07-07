package tasky.repositories;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import tasky.dtos.UpdateTaskDTO;
import tasky.models.Task;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
public class TaskRepository {

    private final List<Task> TASKS = Arrays.asList(
            new Task.Builder()
                    .uuid(generateUUID())
                    .title("Learn Spring Framework")
                    .createdAt(new DateTime(1530916221000L).toString(dateTimeFormatter()))
                    .build(),

            new Task.Builder()
                    .uuid(generateUUID())
                    .title("Do Laundry")
                    .createdAt(new DateTime(1530975621000L).toString(dateTimeFormatter()))
                    .build(),


            new Task.Builder()
                    .uuid(generateUUID())
                    .title("Write Tutorial")
                    .createdAt(new DateTime(1530814521000L).toString(dateTimeFormatter()))
                    .build(),

            new Task.Builder()
                    .uuid(generateUUID())
                    .title("Get some shuteye")
                    .createdAt(new DateTime(1530814521000L).toString(dateTimeFormatter()))
                    .build()


    );

    private UUID generateUUID() {
        return UUID.randomUUID();
    }

    private DateTimeFormatter dateTimeFormatter(){
        return DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
    }

    public List<Task> getAllTasks(){
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

    public Task update(UUID uuid, UpdateTaskDTO updateTaskDTO){
        Task task = getById(uuid);
        task.setCompleted(updateTaskDTO.isCompleted());


        if(task != null){
            return task;
        }

        return null;
    }
}
