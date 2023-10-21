package ao.co.isptec.aplm.gestortarefas;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

        private EditText taskEditText;
    private TaskAdapter taskAdapter;
        private final List<Task> taskList = new ArrayList<>();

        @SuppressLint("NotifyDataSetChanged")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            taskEditText = findViewById(R.id.taskEditText);
            Button addTaskButton = findViewById(R.id.addTaskButton);
            RecyclerView taskRecyclerView = findViewById(R.id.taskRecyclerView);

            // Configurar o RecyclerView
            taskAdapter = new TaskAdapter(taskList);
            taskRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            taskRecyclerView.setAdapter(taskAdapter);

            addTaskButton.setOnClickListener(view -> {
                String taskText = taskEditText.getText().toString();
                if (!taskText.isEmpty()) {
                    Task task = new Task(taskText) {
                    };
                    taskList.add(task);
                    taskAdapter.notifyDataSetChanged();
                    taskEditText.setText("");
                }
            });
        }

}