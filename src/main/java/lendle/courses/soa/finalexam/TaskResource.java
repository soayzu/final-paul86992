/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lendle.courses.soa.finalexam;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author lendle
 */
@Path("task")
public class TaskResource {
    @Autowired
    private TaskService taskService=null;

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Task getTask(@PathParam("id") int id){
        return taskService.getTask(id);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addTask(Task task){
        taskService.addTask(task);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateTask(Task task){
        taskService.updateTask(task);
    }
    
    @DELETE
    @Path("{id}")
    public void deleteTask(@PathParam("id") int id){
        taskService.deleteTask(id);
    }
}
