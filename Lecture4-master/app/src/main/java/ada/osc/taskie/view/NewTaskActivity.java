package ada.osc.taskie.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ada.osc.taskie.R;
import ada.osc.taskie.model.Task;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewTaskActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "message";

    @BindView(R.id.textview_newtask_title) TextView mMessage;
    @BindView(R.id.edittext_newtask_description) EditText mDescription;
    @BindView(R.id.edittext_newtask_title) EditText mTitle;

    @BindView(R.id.edittext_newtask_priority) EditText mPriority;

    @BindView(R.id.edittext_newtask_date) EditText mDate;
    @BindView(R.id.button_newtask_create) Button mCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
        ButterKnife.bind(this);

        Intent startingIntent = this.getIntent();
        if(startingIntent.hasExtra(EXTRA_MESSAGE)){
            String title = startingIntent.getStringExtra(EXTRA_MESSAGE);
            mMessage.setText(title);
        }
    }

    @OnClick(R.id.button_newtask_create)
    public void returnNewTask(){

        String title = mTitle.getText().toString();
        String description = mDescription.getText().toString();
        String priorityEntry = mPriority.getText().toString();

        int priority = Integer.parseInt(priorityEntry);
        String date = mDate.getText().toString();


        Task task = new Task(title, description, priority, date);

        Intent resultIntent = new Intent();
        resultIntent.putExtra(TasksActivity.EXTRA_TASK, task);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
