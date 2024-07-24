package com.goldenconsultingci.erp.juridique.composite;

import java.util.ArrayList;
import java.util.List;

public class TaskList implements Task{

    private List<Task> taskList;

    public TaskList() {
        super();
        this.setTaskList(new ArrayList<>(0));
    }

    private void setTaskList(ArrayList<Task> aTasks) {
        this.taskList =   aTasks;
    }

    @Override
    public String title() {
        return null;
    }

    @Override
    public void setTitle(String aTitle) {

    }

    @Override
    public String display() {
        return null;
    }

    public List<Task> tasks() {
        return this.taskList;
    }

    void addTask(Task aTask) {
        this.tasks().add(aTask);
    }
}
