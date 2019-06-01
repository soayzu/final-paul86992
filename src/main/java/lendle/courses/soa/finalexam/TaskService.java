/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lendle.courses.soa.finalexam;

import java.util.List;

/**
 *
 * @author lendle
 */
public interface TaskService {
    public List<Task> getTasks();
    public List<Task> getTasksBySubject(String subject);
    public List<Task> getTasksByDate(String date);
    public Task getTask(int id);
    public void addTask(Task task);
    public void updateTask(Task task);
    public void deleteTask(int id);
}
