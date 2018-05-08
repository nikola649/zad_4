package ada.osc.taskie.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ada.osc.taskie.R;
import ada.osc.taskie.model.Task;

class TaskAdapter extends BaseAdapter {

    List<Task> mTasks;

    public TaskAdapter(){
        mTasks = new ArrayList<>();
    }

    public void refreshData(List<Task> tasks){
        mTasks.clear();
        mTasks.addAll(tasks);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mTasks.size();
    }

    @Override
    public Object getItem(int position) {
        return mTasks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View taskView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_task,parent,false);

        TextView title = taskView.findViewById(R.id.textview_task_title);
        TextView desc = taskView.findViewById(R.id.textview_task_description);
        TextView priority = taskView.findViewById(R.id.textview_task_priority);

        Task task = mTasks.get(position);

        title.setText(task.getTitle());
        desc.setText(task.getDescription());
        priority.setText(String.valueOf(task.getPriority()));

        return taskView;
    }
}
