package ada.osc.taskie.persistance;

import java.util.ArrayList;
import java.util.List;

import ada.osc.taskie.model.Task;

public class FakeDatabase {

    List<Task> mTasks = new ArrayList<>();

    public void insert(Task task){
        mTasks.add(task);
    }

    public void delete(Task task){
        mTasks.remove(task);
    }

    public List<Task> getTasks() {
        return new ArrayList<>(mTasks);
    }
}
