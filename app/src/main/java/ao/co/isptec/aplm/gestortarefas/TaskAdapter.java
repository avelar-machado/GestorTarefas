package ao.co.isptec.aplm.gestortarefas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    private final List<Task> taskList;

    public TaskAdapter(List<Task> taskList) {
        this.taskList = taskList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView taskTextView;
        public CheckBox taskCheckBox;

        public ViewHolder(View itemView) {
            super(itemView);
            taskTextView = itemView.findViewById(R.id.taskTextView);
            taskCheckBox = itemView.findViewById(R.id.taskCheckBox);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View taskView = inflater.inflate(R.layout.item_task, parent, false);
        return new ViewHolder(taskView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Task task = taskList.get(position);
        TextView taskTextView = holder.taskTextView;
        taskTextView.setText(task.getDescription());

        CheckBox taskCheckBox = holder.taskCheckBox;
        taskCheckBox.setChecked(task.isCompleted());
        taskCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> task.setCompleted(isChecked));
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }
}

