package com.rosol.employeelist;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.rosol.employeelist.database.AppDatabase;
import com.rosol.employeelist.database.TaskEntry;

public class AddTaskViewModel extends ViewModel {
    private LiveData<TaskEntry> task;

    public AddTaskViewModel(AppDatabase database, int taskId){
        task=database.taskDao().loadTaskById(taskId);
    }

    public LiveData<TaskEntry> getTask(){
        return task;
    }
}
