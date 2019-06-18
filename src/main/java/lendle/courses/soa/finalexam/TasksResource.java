/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lendle.courses.soa.finalexam;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author lendle
 */
@Path("tasks")
public class TasksResource {
    /**
     * question 4 (10%):
     * add DI for taskService
     */
    @Autowired
    @Qualifier("jdbcTaskService")
    private TaskService taskService=null;

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Task> getTasks(){
        return taskService.getTasks();
    }
    
    /*
     * question 5 (10%):
       implement a GET service
       using sub path
       subject/xxxxxx
       
       for example, webapi/tasks/subject/abc
       should connect to this web service, and abc is the subject value
     */
    @GET
    @Path("subject/{subject}")
    
    public List<Task> getTasksBySubject(String subject){
        return taskService.getTasksBySubject(subject);
    }
    
    @GET
    @Path("date/{date}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Task> getTasksByDate(@PathParam("date") String date){
        return taskService.getTasksByDate(date);
    }
}
