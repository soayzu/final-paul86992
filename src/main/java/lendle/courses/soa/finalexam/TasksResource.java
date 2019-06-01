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

/**
 *
 * @author lendle
 */
@Path("tasks")
public class TasksResource {
    @Autowired
    private TaskService taskService=null;

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Task> getTasks(){
        System.out.println("456");
        return taskService.getTasks();
    }
    
    @GET
    @Path("subject/{subject}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Task> getTasksBySubject(@PathParam("subject") String subject){
        return taskService.getTasksBySubject(subject);
    }
    
    @GET
    @Path("date/{date}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Task> getTasksByDate(@PathParam("date") String date){
        return taskService.getTasksByDate(date);
    }
}
