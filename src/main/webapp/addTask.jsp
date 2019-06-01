<%-- 
    Document   : addTask
    Created on : Jun 1, 2019, 8:37:38 PM
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
            var v = null;
            $(document).ready(function () {
                v = new Vue({
                    el: "#task",
                    data: {
                        task: {
                            id: -1,
                            dueDate: "",
                            subject: "",
                            content: ""
                        }
                    },
                    methods: {
                        save: function (task) {
                            $.ajax("webapi/task", {
                                type: "POST",
                                contentType: "application/json",
                                data: JSON.stringify(task),
                                success: function () {
                                    window.location.href = "list.jsp";
                                },
                                error: function () {
                                    alert("fail!");
                                }
                            });
                        }
                    }
                });
                
            });
        </script>
    </head>
    <body>
        <div id="task">
            Due Date: <input type="text" v-model="task.dueDate"/><br/>
            Subject: <input type="text" v-model="task.subject"/><br/>
            Content:<br/>
            <textarea v-model="task.content"></textarea>
            <button v-on:click="save(task);">SAVE</button>
        </div>
    </body>
</html>

