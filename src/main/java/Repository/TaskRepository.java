package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.taskmanagement.Task;

public interface TaskRepository extends JpaRepository<Task,Long> {

}
