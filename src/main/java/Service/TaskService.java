package Service;

import Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.getarrays.taskmanagement.Task;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    @Autowired
    @Transactional(readOnly=true)
    public List<Task> getTasks(){
        return taskRepository.findAll();
    }
    @Transactional
    public Task save(Task task) {
        return taskRepository.saveAndFlush(task);
    }
    @Transactional(readOnly = true)
    public boolean existById(Long id){
        return taskRepository.existsById(id);
    }
    @Transactional(readOnly = true)
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }
}
