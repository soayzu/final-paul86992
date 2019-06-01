<%-- 
    Document   : list
    Created on : Jun 1, 2019, 3:18:36 PM
    Author     : lendle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script
            src="https://code.jquery.com/jquery-3.3.1.js"
        ></script>
        <script src="https://cdn.jsdelivr.net/npm/vue@2.6.7/dist/vue.js"></script>
        <script>
            var v=null;
            $(document).ready(function(){
                $.ajax("webapi/tasks", {
                    success: function(tasks){
                        v=new Vue({
                            el: "#tasks",
                            data: {
                                "tasks": tasks
                            },
                            methods:{
                                edit: function(task){
                                    window.location.href="editTask.jsp?id="+task.id;
                                },
                                remove: function(task){
                                    $.ajax("webapi/task/"+task.id, {
                                        type: "DELETE",
                                        success: function(){
                                            window.location.href="list.jsp";
                                        },
                                        error: function(){
                                            alert("failed");
                                        }
                                    });
                                }
                            }
                        });
                    }
                });
            });
            function addTask(){
                window.location.href="addTask.jsp";
            }
        </script>
    </head>
    <body>
        <button onclick="addTask();">NEW</button>
        <div id="tasks">
            <table border="1" style="width: 90%">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Due Date</th>
                        <th>Subject</th>
                        <th>Content</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="task in tasks">
                        <td>{{task.id}}</td>
                        <td>{{task.dueDate}}</td>
                        <td>{{task.subject}}</td>
                        <td>{{task.content}}</td>
                        <td><button v-on:click="edit(task);">EDIT</button>
                            <button v-on:click="remove(task);">DELETE</button></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </body>
</html>
