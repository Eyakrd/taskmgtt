package controllers;

import Service.TaskService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.taskmanagement.Task;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/task")
@CrossOrigin("*")
@AllArgsConstructor
public class Controller {
    private final TaskService taskService;
    @GetMapping("/all")
    public List<Task> getTask(){
        return taskService.getTasks();
    }
    @PostMapping("/add")
    public Task addTask(@RequestBody Task task){
        return taskService.save(task);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> addTask(@RequestBody Task taskPara, @PathVariable Long id) {
        if (taskService.existById(id)) {
            Task task=taskService.getTaskById(id).orElseThrow(()->new EntityNotFoundException("Requested Task not found"));
            task.setTitle(taskPara.getTitle());
            task.setTdueDate(taskPara.getTdueDate());
            task.setType(taskPara.getType());
            task.setDescription(taskPara.getDescription());
            taskService.save(task);
            return ResponseEntity.ok().body(task);
        }
        else{
            HashMap<String,String>message=new HashMap<>();
            message.put("message",id+"task not found or matched ");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
}
