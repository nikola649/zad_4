package ada.osc.taskie.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;

import ada.osc.taskie.R;
import ada.osc.taskie.TaskRepository;
import ada.osc.taskie.model.Task;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TasksActivity extends AppCompatActivity {

    private static final String TAG = "Bruno";
    private static final int REQUEST_NEW_TASK = 10;
    public static final String EXTRA_TASK = "newTask";

    TaskRepository mTaskRepository = TaskRepository.getInstance();
    TaskAdapter mTaskAdapter;

    @BindView(R.id.button_tasks_createNew) Button mCreateNewTask;
    @BindView(R.id.listview_tasks) ListView mTasksListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
        ButterKnife.bind(this);

        setUpListView();
    }

    private void setUpListView() {
        mTaskAdapter = new TaskAdapter();
        mTasksListView.setAdapter(mTaskAdapter);
    }

    @OnClick(R.id.button_tasks_createNew)
    public void startCreateTaskActivity(){

        Intent newTaskIntent = new Intent(this, NewTaskActivity.class);

        newTaskIntent.putExtra(NewTaskActivity.EXTRA_MESSAGE, "Bok ada osc");

        startActivityForResult(newTaskIntent, REQUEST_NEW_TASK);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_NEW_TASK){
            if(resultCode == RESULT_OK){
                if (data.hasExtra(EXTRA_TASK)){
                    Task task = (Task) data.getSerializableExtra(EXTRA_TASK);
                    Log.d(TAG, task.getTitle());
                    mTaskRepository.save(task);
                    mTaskAdapter.refreshData(mTaskRepository.getTasks());
                }
            }
        }
    }
}
